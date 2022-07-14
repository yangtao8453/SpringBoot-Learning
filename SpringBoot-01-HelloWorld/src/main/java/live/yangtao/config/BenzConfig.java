package live.yangtao.config;

import live.yangtao.properties.BenzProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author yangtao
 * @description
 * @create 2022-07-12 23:07
 */
@Configuration
@EnableConfigurationProperties(BenzProperties.class)
public class BenzConfig {
}
