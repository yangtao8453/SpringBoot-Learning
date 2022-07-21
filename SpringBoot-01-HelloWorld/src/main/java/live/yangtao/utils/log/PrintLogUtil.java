package live.yangtao.utils.log;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.CodeSignature;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yangtao
 * @description 配合PrintLog注解实现方法入参及返回值的打印
 * @create 2022-07-21 7:39
 */
@Component
@Aspect
@Slf4j
public class PrintLogUtil {

    @Pointcut("@annotation(live.yangtao.utils.log.PrintLog)")
    public void pointCut() {
    }

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint point) {
        Object result = null;
        try {
            // 返回
            long startTime = System.currentTimeMillis();
            result = point.proceed();
            long endTime = System.currentTimeMillis();
            // 类名
            String className = point.getTarget().getClass().getName();
            // 方法
            MethodSignature signature = (MethodSignature) point.getSignature();
            Method method = signature.getMethod();
            String methodName = method.getName();
            String methodReturnType = method.getReturnType().getName();
            String fullMethodName = className + "#" + methodName;
            // 注解值
            PrintLog printLog = method.getDeclaredAnnotation(PrintLog.class);
            String description = printLog.description().equals("") ? fullMethodName : printLog.description();
            // 入参
            Object[] args = point.getArgs();
            String[] parameters = ((CodeSignature) point.getSignature()).getParameterNames();
            Map<String, Object> argsMap = new HashMap<>();
            for (int i = 0; i < args.length; i++) {
                argsMap.put(parameters[i], args[i]);
            }
            // 日志输出
            log.info("******************** {} - 执行开始 ********************", description);
            log.info("{}, 入参: {}, 返回值: {} ({}), 耗时 {} ms", fullMethodName, JSON.toJSONString(argsMap), JSON.toJSONString(result), methodReturnType, endTime - startTime);
            log.info("******************** {} - 执行结束 ********************", description);
        } catch (Throwable e) {
            log.error("切面日志异常：{}", e.getMessage());
        }
        return result;
    }

}
