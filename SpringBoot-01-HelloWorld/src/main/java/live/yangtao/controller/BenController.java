package live.yangtao.controller;

import live.yangtao.properties.BenzProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yangtao
 * @description
 * @create 2022-07-12 22:37
 */
//@ConditionalOnBean(name = "benzProperties")
//@RestController("testClient")
//public class BenController {
//
////    @Resource(name = "benzProperties")
//    @Autowired
//    private BenzProperties benzProperties;
//
//    @GetMapping("/benz")
//    public String benz() {
//        String level = benzProperties.getLevel();
//        double price = benzProperties.getPrice();
//        return "奔驰车，级别：" + level + "，价格：" + price;
//    }
//
//}
