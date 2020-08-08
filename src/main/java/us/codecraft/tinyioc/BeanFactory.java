package us.codecraft.tinyioc;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * @author xian.wang
 * @since 下午1:39 2020/8/8
 */
public class BeanFactory {

    private Map<String, BeanDefinition> container = Maps.newHashMap();

    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) {
        container.put(name, beanDefinition);
    }

    public Object getBean(String name){
        return container.get(name).getBean();
    }
}
