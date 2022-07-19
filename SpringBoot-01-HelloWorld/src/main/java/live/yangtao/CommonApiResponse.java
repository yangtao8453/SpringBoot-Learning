package live.yangtao;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author yangtao
 * @description 通用接口返回
 * @create 2022-07-20 0:12
 */
@SuppressWarnings("all")
public class CommonApiResponse<T> {

    private static final Logger logger = LoggerFactory.getLogger(CommonApiResponse.class);
    private static Integer SUCCESS_CODE = 0;
    private static String SUCCESS_MESSAGE = "success";
    private static Integer FAIL_CODE = 1;
    private static String FAIL_MESSAGE = "fail";

    private Integer code;
    private String message;
    private T data = null;

    public static<T> String success(T... t) {
        return new CommonApiResponse(SUCCESS_CODE, SUCCESS_MESSAGE, t.length == 1 ? t[0] : null).toJsonString();
    }

    public static<T> String fail(T... t) {
        return new CommonApiResponse(FAIL_CODE, FAIL_MESSAGE, t.length == 1 ? t[0] : null).toJsonString();
    }

    public static<T> String commonApiResponse(Integer code, String message, T data) {
        return new CommonApiResponse<T>(code, message, data).toJsonString();
    }

    public static CommonApiResponse getInstance() {
        return new CommonApiResponse();
    }

    public CommonApiResponse<T> CODE(Integer CODE) {
        return new CommonApiResponse<>(CODE, message, data);
    }

    public CommonApiResponse<T> MESSAGE(String MESSAGE) {
        return new CommonApiResponse<>(code, MESSAGE, data);
    }

    public CommonApiResponse<T> DATA(T DATA) {
        return new CommonApiResponse<>(code, message, DATA);
    }

    private CommonApiResponse() {
    }

    private CommonApiResponse(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public String toJsonString() {
        Map<String, Object> map = new LinkedHashMap<>();
        Class<? extends CommonApiResponse> aClass = this.getClass();
        Field[] fields = aClass.getDeclaredFields();
        try {
            for (Field field : fields) {
                if (!Modifier.isStatic(field.getModifiers())) {
                    field.setAccessible(true);
                    map.put(field.getName(), field.get(this));
                }
            }
        } catch (Exception e) {
            logger.error("为属性设置值出错");
        }
        return JSON.toJSONString(map);
    }

}
