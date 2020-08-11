package us.codecraft.tinyioc.beans.factory;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import us.codecraft.tinyioc.BeanDefinition;
import us.codecraft.tinyioc.BeanReference;
import us.codecraft.tinyioc.PropertyValue;
import us.codecraft.tinyioc.PropertyValues;
import us.codecraft.tinyioc.aop.BeanPostProcessor;

/**
 * @author xian.wang
 * @since 下午5:01 2020/8/8
 */
public abstract class AbstractBeanFactory implements BeanFactory {

    private Map<String, BeanDefinition> container = Maps.newHashMap();

    private final List<String> beanDefinitionNames = Lists.newArrayList();

    private List<BeanPostProcessor> beanPostProcessors = Lists.newArrayList();

    public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor){
        beanPostProcessors.add(beanPostProcessor);
    }

    public void initializeBean(Object bean, String beanName) {
        for (BeanPostProcessor beanPostProcessor : beanPostProcessors) {
            beanPostProcessor.postProcessBeforeInitialization(bean, beanName);
        }
        for (BeanPostProcessor beanPostProcessor : beanPostProcessors) {
            beanPostProcessor.postProcessAfterInitialization(bean, beanName);
        }
    }

    public List<String> getBeanDefinitionNames() {
        return beanDefinitionNames;
    }

    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) throws Exception {
        container.put(name, beanDefinition);
        beanDefinitionNames.add(name);
    }

    @Override
    public Object getBean(String name) throws Exception {
        BeanDefinition beanDefinition = container.get(name);
        if (beanDefinition == null) {
            throw new IllegalArgumentException("No bean name:" + name + "is Defined");
        }
        Object bean = beanDefinition.getBean();
        if (bean == null) {
            bean = doCreateBean(beanDefinition);
            initializeBean(bean,name);
        }
        return bean;
    }

    public void preInstantiateSingletons() throws Exception {
        for (String beanDefinitionName : beanDefinitionNames) {
            getBean(beanDefinitionName);
        }
    }

    protected Object doCreateBean(BeanDefinition beanDefinition) throws Exception {
        Object bean = createBean(beanDefinition);
        // 注意:这儿有个递归,如果把setBean放到applyPropertyValue下,会导致内存溢出
        beanDefinition.setBean(bean);
        applyPropertyValue(bean, beanDefinition);
        return bean;
    }

    private void applyPropertyValue(Object bean, BeanDefinition beanDefinition) throws Exception {
        PropertyValues propertyValues = beanDefinition.getPropertyValues();
        List<PropertyValue> propertyValueList = propertyValues.getPropertyValueList();
        for (PropertyValue propertyValue : propertyValueList) {
            Field declaredField = bean.getClass().getDeclaredField(propertyValue.getName());
            declaredField.setAccessible(true);
            Object value = propertyValue.getValue();
            if (value instanceof BeanReference) {
                BeanReference beanReference = (BeanReference) value;
                value = getBean(beanReference.getName());
            }
            declaredField.set(bean, value);
        }

    }

    private Object createBean(BeanDefinition beanDefinition) throws Exception {
        return beanDefinition.getBeanClass().newInstance();
    }

    public List getBeansForType(Class type) throws Exception {
        List beans = Lists.newArrayList();
        for (String beanDefinitionName : beanDefinitionNames) {
            if(type.isAssignableFrom(container.get(beanDefinitionName).getBeanClass())){
                beans.add(getBean(beanDefinitionName));
            }
        }
        return beans;
    }

}
