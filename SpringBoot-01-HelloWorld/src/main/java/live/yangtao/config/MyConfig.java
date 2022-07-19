package live.yangtao.config;

import live.yangtao.domain.po.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

/**
 * @author yangtao
 * @description
 * @create 2022-07-11 23:41
 */
@Import({User.class})
@Configuration(proxyBeanMethods = true)
@ConditionalOnMissingBean(name = "tony")
@ImportResource("classpath:beans.xml")
public class MyConfig {

    @Bean("tom")
    public User user01() {
        return new User(1, "tom");
    }

    @ConditionalOnBean(name = "tom")
    @Bean("tony")
    public User user02() {
        return new User(2, "tony");
    }

    @ConditionalOnMissingClass({"live.yangtao.domain.po.User"})
    @Bean("pony")
    public User user03() {
        return new User(3, "pony");
    }

}
