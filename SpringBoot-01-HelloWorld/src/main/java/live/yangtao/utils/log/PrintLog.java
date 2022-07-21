package live.yangtao.utils.log;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author yangtao
 * @description 日志注解，打印方法参数以及返回值
 * @create 2022-07-21 7:37
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface PrintLog {
    String description() default "";
}
