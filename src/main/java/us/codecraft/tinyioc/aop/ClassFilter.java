package us.codecraft.tinyioc.aop;

/**
 * @author xian.wang
 * @since 下午8:04 2020/8/10
 */
public interface ClassFilter {

    boolean matches(Class targetClass);
}
