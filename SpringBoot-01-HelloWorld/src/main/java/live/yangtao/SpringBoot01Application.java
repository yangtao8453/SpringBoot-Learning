package live.yangtao;

import live.yangtao.config.MyConfig;
import live.yangtao.domain.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Conditional;
import org.springframework.web.filter.CharacterEncodingFilter;

import java.util.Arrays;

/**
 * @author yangtao
 * @description 项目主程序类
 * @create 2022-07-11 0:21
 */
@SpringBootApplication
public class SpringBoot01Application {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(SpringBoot01Application.class);

//        Object tom1 = run.getBean("tom");
//        Object tom2 = run.getBean("tom");
        //System.out.println(tom1 == tom2);   // true，由此得知声明的组件默认都是单实例的

        // 获取到的是CGLIB代理的对象live.yangtao.config.MyConfig$$EnhancerBySpringCGLIB$$f6df835f@1517f633（默认），SpringBoot总会检查容器中是否含有该组件，保持组件的单实例
        // 如果MyConfig.class的@Configuration=false，则SpringBoot不再检查单实例，每次调用都会返回不同的对象
        /*
        最佳实践：
            1. 配置 类组件之间无依赖关系用Lite模式加速容器启动过程，减少判断
            2. 配置类组件之间有依赖关系，方法会被调用得到之前单实例组件，用Full模式
         */
//        MyConfig bean = run.getBean(MyConfig.class);
        //System.out.println(bean);
//        User user1 = bean.user01();
//        User user2 = bean.user01();
        //System.out.println(user1 == user2); // true，

//        String[] beanNamesForType = run.getBeanNamesForType(User.class);
//        for (String name : beanNamesForType) {
//            System.out.println(name);
//        }

//        System.out.println(run.containsBean("benzProperties"));
//        System.out.println(run.containsBean("testClient"));

//        CharacterEncodingFilter filter = run.getBean("characterEncodingFilter", CharacterEncodingFilter.class);
//        System.out.println(filter);

        CharacterEncodingFilter bean = run.getBean(CharacterEncodingFilter.class);
        System.out.println(bean);















    }
}
