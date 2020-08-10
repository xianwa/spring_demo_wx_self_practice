package us.codecraft.tinyioc.aop;

import java.lang.reflect.Method;

/**
 * @author xian.wang
 * @since 下午8:05 2020/8/10
 */
public interface MethodMatcher {

    boolean matches(Method method, Class targetClass);
}
