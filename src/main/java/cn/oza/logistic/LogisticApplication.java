package cn.oza.logistic;

import cn.oza.logistic.config.ShiroConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@AutoConfigureBefore(ShiroConfig.class)
public class LogisticApplication {

    public static void main(String[] args) {
        SpringApplication.run(LogisticApplication.class, args);
    }

}
