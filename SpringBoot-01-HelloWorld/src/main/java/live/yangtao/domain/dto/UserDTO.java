package live.yangtao.domain.dto;

import lombok.Data;

import javax.validation.constraints.*;
import java.util.List;

/**
 * @author yangtao
 * @description 测试JSR303的dto
 * @create 2022-07-18 23:48
 */
@Data
public class UserDTO {
    @NotNull(message = "名字不允许为空")   // 添加注解并指定校验不通过时的提示
    private String name;
    @Max(value = 120, message = "年龄不允许超过120岁")
    @Min(value = 1, message = "年龄不允许小于1岁")
    private Integer age;
    @Digits(integer = 6, fraction = 2, message = "请输入6位数，允许保留两位小数")
    private Double salary;
    @Email(message = "邮箱格式不正确")
    private String email;
    @NotEmpty(message = "兴趣爱好不允许为空")
    private List<String> interest;
}