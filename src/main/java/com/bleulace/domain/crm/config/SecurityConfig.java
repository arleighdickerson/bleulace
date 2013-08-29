package com.bleulace.domain.crm.config;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.DefaultHashService;
import org.apache.shiro.crypto.hash.HashRequest;
import org.apache.shiro.crypto.hash.HashService;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.util.ThreadContext;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.config.MethodInvokingFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * Apache Shiro configuration.
 * 
 * @author Arleigh Dickerson
 * 
 */
@Configuration
public class SecurityConfig
{

	public static final String HASH_ALGO_NAME = "SHA-512";
	public static final String REALM_NAME = "realm";

	/**
	 * 
	 * @return a {@link RandomNumberGenerator} bean, seeded and ready to use
	 */
	@Bean
	public RandomNumberGenerator randomNumberGenerator()
	{
		return new SecureRandomNumberGenerator();
	}

	/**
	 * 
	 * @return a singleton-scoped {@link HashService} bean, configured and ready
	 *         to use.
	 */
	@Bean
	public HashService hashService()
	{
		DefaultHashService service = new DefaultHashService();
		service.setHashAlgorithmName(HASH_ALGO_NAME);
		return service;
	}

	/**
	 * 
	 * @return an {@link AuthorizingRealm} to be used for authentication and
	 *         authorization of end-users
	 */
	@Bean(name = REALM_NAME)
	public AuthorizingRealm realm()
	{
		JpaRealm realm = new JpaRealm();
		realm.setAuthenticationTokenClass(UsernamePasswordToken.class);
		realm.setCredentialsMatcher(new HashedCredentialsMatcher(HASH_ALGO_NAME));
		realm.setName(REALM_NAME);
		return realm;
	}

	/**
	 * 
	 * @return a prototype-scoped {@link HashRequest.Builder} bean, configured
	 *         and ready to use
	 */
	@Bean
	@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public HashRequest.Builder hashRequestBuilder()
	{
		HashRequest.Builder builder = new HashRequest.Builder();
		builder.setAlgorithmName(HASH_ALGO_NAME);
		return builder;
	}

	/**
	 * @see LifecycleBeanPostProcessor
	 */
	@Bean(name = "lifecycleBeanPostProcessor")
	public LifecycleBeanPostProcessor lifecycleBeanPostProcessor()
	{
		return new LifecycleBeanPostProcessor();
	}

	/**
	 * Sets the static security manager reference. This security manager is
	 * used:
	 * 
	 * 1) while using the "test" beans profile 2) while using "dev" or "prod"
	 * beans profiles and ThreadContext is not available.
	 * 
	 * @see ThreadContext
	 * @param realm
	 * @return a method invoking factory bean which set the fallback security
	 *         manager
	 */
	@Bean(name = "securityManagerSetter")
	public MethodInvokingFactoryBean securityManagerSetter(Realm realm)
	{
		MethodInvokingFactoryBean bean = new MethodInvokingFactoryBean();
		bean.setTargetClass(SecurityUtils.class);
		bean.setTargetMethod("setSecurityManager");
		bean.setArguments(new Object[] { new DefaultSecurityManager(realm) });
		return bean;
	}

	/**
	 * 
	 * @param realm
	 *            , the realm the manager will delegate authentication and
	 *            authorization to.
	 * @return the primary, http-compatible security manager configured and
	 *         ready to use
	 */
	@Bean(name = "securityManager")
	public SecurityManager securityManager(AuthorizingRealm realm,
			SessionManager sessionManager)
	{
		// DefaultWebSecurityManager mgr = new DefaultWebSecurityManager(realm);
		DefaultSecurityManager mgr = new DefaultSecurityManager(realm);
		mgr.setSessionManager(sessionManager);
		return mgr;
	}

	@Bean
	public ShiroSubjectAspect shiroAccountAspect()
	{
		return ShiroSubjectAspect.aspectOf();
	}
}