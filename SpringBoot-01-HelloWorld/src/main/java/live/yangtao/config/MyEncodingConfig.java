package live.yangtao.config;

import org.springframework.boot.web.servlet.filter.OrderedCharacterEncodingFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;

/**
 * @author yangtao
 * @description
 * @create 2022-07-14 23:38
 */
@Configuration
public class MyEncodingConfig {

    @Bean
    public CharacterEncodingFilter characterEncodingFilter() {
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("GBK");
        // 拦截器设置的编码覆盖现有的编码（请求和响应）
        filter.setForceEncoding(true);
        return filter;
    }

}
