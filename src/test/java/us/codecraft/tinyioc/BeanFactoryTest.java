package us.codecraft.tinyioc;

import us.codecraft.tinyioc.factory.AutowiredCapableBeanFactory;

/**
 * @author xian.wang
 * @since 下午3:23 2020/8/8
 */
public class BeanFactoryTest {

    public static void main(String[] args) throws Exception {
        BeanDefinition beanDefinition = new BeanDefinition();
        beanDefinition.setBeanClassName("us.codecraft.tinyioc.HelloService");

        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("text","haahahha"));
        beanDefinition.setPropertyValues(propertyValues);

        AutowiredCapableBeanFactory autowiredCapableBeanFactory = new AutowiredCapableBeanFactory();
        autowiredCapableBeanFactory.registerBeanDefinition("hello",beanDefinition);

        HelloService hello = (HelloService) autowiredCapableBeanFactory.getBean("hello");
        System.out.println(hello.getText());

    }
}
