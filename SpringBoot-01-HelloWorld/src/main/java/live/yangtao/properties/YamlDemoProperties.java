package live.yangtao.properties;

import live.yangtao.domain.po.User;
import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author yangtao
 * @description 测试yaml配置文件绑定类
 * @create 2022-07-15 0:50
 */
@Component("yamlDemoProperties")
@ConfigurationProperties(prefix = "yaml")
@Data
@ToString
public class YamlDemoProperties {
    private Integer integer;
    private Double aDouble;
    private Boolean aBoolean;
    private String string;
    private String string2;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime localDateTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date date;
    private String[] strings;
    private List<String> list;
    private Map<String, Object> map;
    private Set<String> set;
    private Map<String, List<String>> listMap;
    private User user;
}
