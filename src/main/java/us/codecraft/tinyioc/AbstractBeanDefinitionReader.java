package us.codecraft.tinyioc;

import com.google.common.collect.Maps;

import java.util.Map;

import us.codecraft.tinyioc.io.ResourceLoader;

/**
 * @author xian.wang
 * @since 下午1:32 2020/8/9
 */
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader {

    private Map<String,BeanDefinition> register;

    private ResourceLoader resourceLoader;

    public AbstractBeanDefinitionReader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
        this.register = Maps.newHashMap();
    }

    public Map<String, BeanDefinition> getRegister() {
        return register;
    }

    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }
}
