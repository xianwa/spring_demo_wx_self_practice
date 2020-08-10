package us.codecraft.tinyioc.aop;

import org.aspectj.weaver.Advice;

/**
 * @author xian.wang
 * @since 下午8:03 2020/8/10
 */
public interface Advisor {

    Advice getAdvice();

}
