package live.yangtao.properties;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Properties;

/**
 * @author yangtao
 * @description
 * @create 2022-07-12 21:38
 */
@Slf4j
public class MyProperties {

    private static String serverPort;

    static {
        Properties properties = new Properties();
        Class<MyProperties> myPropertiesClass = MyProperties.class;
        ClassLoader classLoader = myPropertiesClass.getClassLoader();
        InputStream resourceAsStream = classLoader.getResourceAsStream("application.properties");
        try {
            properties.load(resourceAsStream);
        } catch (IOException e) {
            log.error("加载配置文件出错");
        }
        Field[] fields = myPropertiesClass.getDeclaredFields();
        Arrays.stream(fields).forEach(field -> {
            Object value = properties.getOrDefault(humpNameHandle(field.getName()), null);
            field.setAccessible(true);
            try {
                field.set(myPropertiesClass, value);
            } catch (IllegalAccessException e) {
                log.error("属性 {} 赋值出错", field.getName(), e);
            }
        });
    }

    private static String humpNameHandle(String humpName) {
        if (humpName == null) {
            return null;
        }
        StringBuilder res = new StringBuilder();
        byte[] bytes = humpName.getBytes();
        for (byte aByte : bytes) {
            res.append((aByte >= 65 && aByte <= 90) ? "." + (char) aByte : (char) aByte);
        }
        return res.toString().toLowerCase();
    }

    public static void main(String[] args) {
        System.out.println(MyProperties.serverPort);
    }

}
