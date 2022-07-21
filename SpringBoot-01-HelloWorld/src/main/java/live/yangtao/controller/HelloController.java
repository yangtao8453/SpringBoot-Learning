package live.yangtao.controller;

import live.yangtao.domain.po.User;
import live.yangtao.utils.log.PrintLog;
import org.springframework.web.bind.annotation.*;

/**
 * @author yangtao
 * @description
 * @create 2022-07-11 0:22
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    @PrintLog(description = "这是hello controller")
    public String hello(@RequestParam("param") String param) {
        System.out.println(param);
        return "hello, " + param;
    }

    @GetMapping("/hello2")
    @PrintLog
    public void hello2() {
        System.out.println(123);
    }

    @PostMapping("/hello3")
    @PrintLog(description = "返回一个新的User对象")
    public User hello3(@RequestBody User user) {
        return user;
    }

}
