package live.yangtao.controller;

import com.alibaba.fastjson.JSON;
import live.yangtao.properties.YamlDemoProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author yangtao
 * @description
 * @create 2022-07-11 23:21
 */
@RestController
public class TestController {

    @Resource(name = "yamlDemoProperties")
    YamlDemoProperties yamlDemoProperties;

    @GetMapping("/test1")
    public String test1() {
        return JSON.toJSONString(yamlDemoProperties);
    }

}
