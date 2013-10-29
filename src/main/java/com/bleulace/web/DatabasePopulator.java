package com.bleulace.web;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.bleulace.domain.crm.infrastructure.AccountDAO;
import com.bleulace.domain.crm.model.Account;
import com.bleulace.domain.crm.model.ContactInformation;
import com.bleulace.domain.management.model.ManagementAssignment;
import com.bleulace.domain.management.model.ManagementLevel;
import com.bleulace.domain.management.model.Project;
import com.bleulace.domain.resource.model.TestResource;
import com.bleulace.utils.SystemProfiles;

/**
 * 
 * @author Arleigh Dickerson
 * 
 */
@Component
@Profile(SystemProfiles.DEV)
class DatabasePopulator implements ApplicationListener<ContextRefreshedEvent>
{
	@PersistenceContext
	private EntityManager em;

	@Autowired
	private AccountDAO dao;

	@Override
	@Transactional
	public void onApplicationEvent(ContextRefreshedEvent event)
	{
		try
		{
			Account me = new Account();
			me.setUsername("arleighdickerson@frugalu.com");
			me.setPassword("password");

			ContactInformation myInfo = new ContactInformation("Arleigh",
					"Dickerson", "arleighdickerson@frugalu.com",
					"Marshall University", "Something", "Somewhere");
			me.setContactInformation(myInfo);

			em.persist(me);

			for (int i = 0; i < 5; i++)
			{
				Account a = new Account();
				a.setUsername(RandomStringUtils.random(20, true, true)
						+ "@frugalu.com");
				a.setPassword("password");

				ContactInformation aInfo = new ContactInformation(
						RandomStringUtils.random(5, true, false),
						RandomStringUtils.random(5, true, false),
						a.getUsername(), "Marshall University", "Something",
						"Somewhere");
				a.setContactInformation(aInfo);
				a.getFriends().add(me);
				em.persist(a);
				me.getFriends().add(a);
				me = em.merge(me);
			}

			Project project = new Project();
			project.setTitle("World Domination");
			project.addChild(new ManagementAssignment(me, ManagementLevel.OWN));
			em.persist(project);

			Project bundle = new Project();
			bundle.setTitle("Antarctic Domination");
			bundle.addChild(new ManagementAssignment(me, ManagementLevel.OWN));
			project.addChild(bundle);
			em.persist(bundle);

			TestResource resource = new TestResource();
			em.persist(resource);

			for (int i = 0; i < 4; i++)
			{
				TestResource other = new TestResource();
				resource.addChild(other);
				resource = other;
				em.persist(resource);
			}

			em.persist(project);
			em.flush();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}