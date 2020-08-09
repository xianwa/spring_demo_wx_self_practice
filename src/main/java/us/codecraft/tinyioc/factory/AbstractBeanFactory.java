package us.codecraft.tinyioc.factory;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.List;
import java.util.Map;

import us.codecraft.tinyioc.BeanDefinition;

/**
 * @author xian.wang
 * @since 下午5:01 2020/8/8
 */
public abstract class AbstractBeanFactory implements BeanFactory {

    private Map<String,BeanDefinition> container = Maps.newHashMap();

    private final List<String> beanDefinitionNames = Lists.newArrayList();

    public List<String> getBeanDefinitionNames() {
        return beanDefinitionNames;
    }

    @Override
    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) throws Exception {
        container.put(name,beanDefinition);
        beanDefinitionNames.add(name);
    }

    @Override
    public Object getBean(String name) throws Exception {
        BeanDefinition beanDefinition = container.get(name);
        if(beanDefinition == null){
            throw new IllegalArgumentException("No bean name:" + name + "is Defined");
        }
        Object bean = beanDefinition.getBean();
        if(bean == null){
            bean = doCreateBean(beanDefinition);
        }
        return bean;
    }

    @Override
    public void preInstantiateSingletons() throws Exception {
        for (String beanDefinitionName : beanDefinitionNames) {
            getBean(beanDefinitionName);
        }
    }

    protected abstract Object doCreateBean(BeanDefinition definition) throws Exception;
}
