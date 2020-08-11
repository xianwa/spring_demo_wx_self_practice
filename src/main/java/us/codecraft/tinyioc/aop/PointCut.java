package us.codecraft.tinyioc.aop;

/**
 * @author xian.wang
 * @since 下午8:06 2020/8/10
 */
public interface PointCut {

    ClassFilter getClassFilter();

    MethodMatcher getMethodMatcher();
}
