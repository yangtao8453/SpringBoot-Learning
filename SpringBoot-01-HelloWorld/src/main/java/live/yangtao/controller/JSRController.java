package live.yangtao.controller;

import com.alibaba.fastjson.JSON;
import live.yangtao.CommonApiResponse;
import live.yangtao.domain.dto.UserDTO;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yangtao
 * @description
 * @create 2022-07-19 23:07
 */
@RestController
@RequestMapping("/jsr")
public class JSRController {

    @PostMapping("/test1")      // BindingResult对象可以获取到校验结果
    public String test1(@Valid @RequestBody UserDTO dto, BindingResult result) {
        boolean b = result.hasErrors();
        List<FieldError> fieldErrors = result.getFieldErrors();     // 获取所有的出错提示
        Map<String, Object> map = new LinkedHashMap<>();
        fieldErrors.forEach(item -> {
            map.put(item.getField(), item.getDefaultMessage() == null ? "参数值错误" : item.getDefaultMessage());
        });
        if (result.hasErrors()) {
            return CommonApiResponse.fail(map);
        } else {
            return CommonApiResponse.success();
        }
    }

}
