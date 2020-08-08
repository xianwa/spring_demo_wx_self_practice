package us.codecraft.tinyioc.factory;

import us.codecraft.tinyioc.BeanDefinition;

/**
 * @author xian.wang
 * @since 下午1:39 2020/8/8
 */
public interface BeanFactory {

    void registerBeanDefinition(String name, BeanDefinition beanDefinition) throws Exception;

    Object getBean(String name);
}
