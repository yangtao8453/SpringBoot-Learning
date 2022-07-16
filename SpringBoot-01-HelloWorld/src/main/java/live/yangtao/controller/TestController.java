package live.yangtao.controller;

import com.alibaba.fastjson.JSON;
import live.yangtao.properties.YamlDemoProperties;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public String test1(@RequestParam("param") String param) {
        return param;
    }

    @GetMapping("/test2")
    public String test2(@RequestParam("ids") List<Integer> ids) {
        return JSON.toJSONString(ids);
    }

    @GetMapping("/test3")
    public String test3(@RequestParam Map<String, String> params) {
        return JSON.toJSONString(params);
    }

    @GetMapping("/test4/{param}")
    public String test4(@PathVariable("param") String param) {
        return param;
    }

    @GetMapping("/test5/{param1}/{param2}")
    public String test5(@PathVariable Map<String, String> pathVarMap) {
        return JSON.toJSONString(pathVarMap);
    }

    @GetMapping("/test6")
    public String test6(@RequestHeader("User-Agent") String userAgent) {
        return userAgent;
    }

    @GetMapping("/test7")
    public String test7(@RequestHeader Map<String, String> headerMap) {
        return JSON.toJSONString(headerMap);
    }

    @GetMapping("/test8")
    public String test8(@CookieValue("ck1") String _ga) {
        return _ga;
    }

    @GetMapping("/test9")
    public String test9(@CookieValue("ck1") Cookie cookie) {
        return JSON.toJSONString(cookie);
    }

    @GetMapping("/test10/{path1}/{path2}")
    public String test10(@MatrixVariable(value = "p1v1", pathVar = "path1") String path1Var1,
                         @MatrixVariable(value = "p1v2", pathVar = "path1") String path1Var2,
                         @MatrixVariable(value = "p2v1", pathVar = "path2") String path2Var1) {
        Map<String, Object> map = new HashMap<>();
        map.put("p1v1", path1Var1);
        map.put("p1v2", path1Var2);
        map.put("p2v1", path2Var1);
        return JSON.toJSONString(map);
    }

}
