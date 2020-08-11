package us.codecraft.tinyioc.beans.factory;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

import us.codecraft.tinyioc.BeanDefinition;
import us.codecraft.tinyioc.BeanReference;
import us.codecraft.tinyioc.PropertyValue;
import us.codecraft.tinyioc.PropertyValues;

/**
 * @author xian.wang
 * @since 下午5:11 2020/8/8
 */
public class AutowiredCapableBeanFactory extends AbstractBeanFactory {

    @Override
    protected void applyPropertyValue(Object bean, BeanDefinition beanDefinition) throws Exception {
        PropertyValues propertyValues = beanDefinition.getPropertyValues();
        List<PropertyValue> propertyValueList = propertyValues.getPropertyValueList();
        for (PropertyValue propertyValue : propertyValueList) {
            String name = propertyValue.getName();
            Object value = propertyValue.getValue();
            if (value instanceof BeanReference) {
                BeanReference beanReference = (BeanReference) value;
                value = getBean(beanReference.getName());
            }
            try {
                Method declaredMethod = bean.getClass().getDeclaredMethod("set" + name.substring(0, 1).toUpperCase() + name.substring(1), value.getClass());
                declaredMethod.setAccessible(true);

                declaredMethod.invoke(bean, value);
            } catch (NoSuchMethodException e) {
                Field declaredField = bean.getClass().getDeclaredField(name);
                declaredField.setAccessible(true);
                declaredField.set(bean, value);
            }
        }

    }
}
