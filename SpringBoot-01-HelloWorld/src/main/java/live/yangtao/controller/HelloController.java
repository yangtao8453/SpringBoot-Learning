package live.yangtao.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yangtao
 * @description
 * @create 2022-07-11 0:22
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(@RequestParam("param") String param) {
        System.out.println(param);
        return "hello, " + param;
    }

}
