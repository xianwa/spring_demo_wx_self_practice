package us.codecraft.tinyioc.aop;

/**
 * @author xian.wang
 * @since 下午8:28 2020/8/10
 */
public interface BeanPostProcessor {

    Object postProcessBeforeInitialization(Object bean, String beanName);

    Object postProcessAfterInitialization(Object bean, String beanName);
}
