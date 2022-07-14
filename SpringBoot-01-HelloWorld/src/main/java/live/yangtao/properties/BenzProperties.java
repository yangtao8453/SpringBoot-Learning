package live.yangtao.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author yangtao
 * @description
 * @create 2022-07-12 22:32
 */
/* 方式1：Properties类两个注解
@Component("benzProperties")
@ConfigurationProperties(prefix = "car.benz")
 */
// 方式2：Properties声明配置文件的前缀 + 其他配置类配置绑定，将该Properties类注册到容器中
@ConfigurationProperties(prefix = "car.benz")
@Data
public class BenzProperties {

    private String level;
    private double price;

}
