package us.codecraft.tinyioc;

import us.codecraft.tinyioc.aop.BeanPostProcessor;

/**
 * @author xian.wang
 * @since 下午8:53 2020/8/10
 */
public class BeanInitializeLogger implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        System.out.println("Initialize bean " + beanName + " start");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        System.out.println("Initialize bean " + beanName + " end");
        return bean;
    }
}
