package cn.oza.logistic;

import cn.oza.logistic.ssm.pojo.User;
import cn.oza.logistic.ssm.service.UserService;
import org.apache.shiro.mgt.SessionsSecurityManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LogisticApplicationTests {

    @Autowired
    private UserService userService;

    @Autowired
    private SessionsSecurityManager sessionsSecurityManager;

    @Test
    public void contextLoads() {
        System.out.println(sessionsSecurityManager.getClass().getName());
        System.out.println(sessionsSecurityManager.getCacheManager().getClass().getName());
    }

}
