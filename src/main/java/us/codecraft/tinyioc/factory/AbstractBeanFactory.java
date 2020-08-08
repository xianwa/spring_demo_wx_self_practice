package us.codecraft.tinyioc.factory;

import com.google.common.collect.Maps;

import java.util.Map;

import us.codecraft.tinyioc.BeanDefinition;

/**
 * @author xian.wang
 * @since 下午5:01 2020/8/8
 */
public abstract class AbstractBeanFactory implements BeanFactory {

    private Map<String,BeanDefinition> container = Maps.newHashMap();

    @Override
    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) throws Exception {
        Object bean = doCreateBean(beanDefinition);
        beanDefinition.setBean(bean);
        container.put(name,beanDefinition);
    }

    @Override
    public Object getBean(String name) {
        return container.get(name).getBean();
    }

    protected abstract Object doCreateBean(BeanDefinition definition) throws Exception;
}
