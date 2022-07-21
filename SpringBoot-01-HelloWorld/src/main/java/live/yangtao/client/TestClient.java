package live.yangtao.client;

import live.yangtao.utils.log.PrintLog;
import org.junit.Test;

/**
 * @author yangtao
 * @description 测试
 * @create 2022-07-21 8:32
 */
public class TestClient {

    @Test
    @PrintLog(description = "这是一个测试")
    public void test1() {
        System.out.println(123);
    }

}
