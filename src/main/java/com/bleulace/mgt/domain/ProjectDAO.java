package com.bleulace.mgt.domain;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bleulace.utils.jpa.ReadOnlyDAO;

public interface ProjectDAO extends ReadOnlyDAO<Project, String>
{
	@Query("SELECT p.project FROM JPAManagementPermission p "
			+ "WHERE p.account.id=:accountId "
			+ "AND p.assignment=:assignment AND TYPE(p.project)=:clazz")
	public <T extends Project> List<T> findByAssignment(
			@Param("accountId") String accountId,
			@Param("assignment") ManagementAssignment assignment,
			@Param("clazz") Class<T> clazz);

	@Query("SELECT p.project FROM JPAManagementPermission p "
			+ "WHERE p.account.id=:accountId AND TYPE(p.project)=:clazz")
	public <T extends Project> List<T> findByAssignment(
			@Param("accountId") String accountId, @Param("clazz") Class<T> clazz);

	@Query("SELECT p.project FROM JPAManagementPermission p "
			+ "WHERE p.account.id=:accountId ")
	public List<Project> findByAssignment(@Param("accountId") String accountId);
}