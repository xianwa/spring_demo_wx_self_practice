package us.codecraft.tinyioc.factory;

import java.lang.reflect.Field;
import java.util.List;

import us.codecraft.tinyioc.BeanDefinition;
import us.codecraft.tinyioc.PropertyValue;
import us.codecraft.tinyioc.PropertyValues;

/**
 * @author xian.wang
 * @since 下午5:11 2020/8/8
 */
public class AutowiredCapableBeanFactory extends AbstractBeanFactory {

    @Override
    protected Object doCreateBean(BeanDefinition beanDefinition) throws Exception{
        Object bean = createBean(beanDefinition);
        applyPropertyValue(bean,beanDefinition);
        return bean;
    }

    private void applyPropertyValue(Object bean, BeanDefinition beanDefinition) throws Exception {
        PropertyValues propertyValues = beanDefinition.getPropertyValues();
        List<PropertyValue> propertyValueList = propertyValues.getPropertyValueList();
        for (PropertyValue propertyValue : propertyValueList) {
            Field declaredField = bean.getClass().getDeclaredField(propertyValue.getName());
            declaredField.setAccessible(true);
            declaredField.set(bean,propertyValue.getValue());
        }

    }

    private Object createBean(BeanDefinition beanDefinition) throws Exception{
        return beanDefinition.getBeanClass().newInstance();
    }
}
