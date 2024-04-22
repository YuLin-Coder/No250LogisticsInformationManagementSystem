package cn.oza.logistic.config;

import cn.oza.logistic.shiro.filter.MyFormAuthenticationFilter;
import cn.oza.logistic.shiro.realm.LoginRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.mgt.SessionsSecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;

/**
 * shiro spring boot 官方教程中，只需要添加三个 bean： Realm, ShiroFilterChainDefinition, CacheManager。
 * 如果自己添加了 ShiroFilterFactoryBean 覆盖 ShiroWebFilterConfiguration 自动生成的，ShiroFilterChainDefinition 内部
 * 可以什么都不写，把 chain 写在 ShiroFilterFactoryBean 里。但是还是要生成 ShiroFilterChainDefinition 这个 bean。
 * 最后还要添加一个 bean 解决 controller 无法映射的问题
 */
@Configuration
public class ShiroConfig {
    /**
     * 配置自定义 realm
     * @return
     */
    @Bean
    public Realm realm() {
        LoginRealm loginRealm = new LoginRealm();
        HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
        credentialsMatcher.setHashIterations(3);
        credentialsMatcher.setHashAlgorithmName("md5");
        loginRealm.setCredentialsMatcher(credentialsMatcher);
        return loginRealm;
    }

    @Bean
    public ShiroFilterChainDefinition shiroFilterChainDefinition() {
        DefaultShiroFilterChainDefinition shiroFilterChainDefinition = new DefaultShiroFilterChainDefinition();
        /*
        shiroFilterChainDefinition.addPathDefinition("/lib/**","anon");
        shiroFilterChainDefinition.addPathDefinition("/static/**","anon");
        shiroFilterChainDefinition.addPathDefinition("/verifyCode.jsp","anon");
        shiroFilterChainDefinition.addPathDefinition("/checkVerifyCode","anon");
        shiroFilterChainDefinition.addPathDefinition("/logout","logout");
        shiroFilterChainDefinition.addPathDefinition("/login","authc");
        shiroFilterChainDefinition.addPathDefinition("/**","user");
        */
        return shiroFilterChainDefinition;
    }

    //配置缓存
    @Bean
    public CacheManager cacheManager() {
        EhCacheManager ehCacheManager = new EhCacheManager();
        ehCacheManager.setCacheManagerConfigFile("classpath:shiro-ehcache.xml");
        return ehCacheManager;
    }

    //添加自定义filter
    @Bean
    protected ShiroFilterFactoryBean shiroFilterFactoryBean(SessionsSecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);//注入securityManager
        //注入自定义filter
        Map<String, Filter> filterMap = new LinkedHashMap<>();
        filterMap.put("authc", new MyFormAuthenticationFilter());
        shiroFilterFactoryBean.setFilters(filterMap);
        //设置过滤链
        shiroFilterFactoryBean.setLoginUrl("/login");
        shiroFilterFactoryBean.setSuccessUrl("/index");
        shiroFilterFactoryBean.setUnauthorizedUrl("/unauthorized");
        Map<String, String> filterChain = new LinkedHashMap<>();
        filterChain.put("/lib/**","anon");
        filterChain.put("/static/**","anon");
        filterChain.put("/verifyCode.jsp","anon");
        filterChain.put("/checkVerifyCode","anon");
        filterChain.put("/logout","logout");
        filterChain.put("/login","authc");
        filterChain.put("/**","user");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChain);
        return shiroFilterFactoryBean;
    }


    //spring 手动捕获无权限异常
    @Bean
    public SimpleMappingExceptionResolver simpleMappingExceptionResolver() {
        SimpleMappingExceptionResolver simpleMappingExceptionResolver = new SimpleMappingExceptionResolver();
        Properties properties = new Properties();
        properties.setProperty("org.apache.shiro.authz.AuthorizationException", "unauthorized");
        simpleMappingExceptionResolver.setExceptionMappings(properties);
        return simpleMappingExceptionResolver;
    }

    /**
     * setUsePrefix(true)用于解决一个奇怪的bug。在引入spring aop的情况下。
     * 在@Controller注解的类的方法中加入@RequiresRole等shiro注解，会导致该方法无法映射请求，导致返回404。
     * 加入这项配置能解决这个bug
     */
    @Bean
    public static DefaultAdvisorAutoProxyCreator getDefaultAdvisorAutoProxyCreator(){
        DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator=new DefaultAdvisorAutoProxyCreator();
        defaultAdvisorAutoProxyCreator.setUsePrefix(true);
        return defaultAdvisorAutoProxyCreator;
    }

}
