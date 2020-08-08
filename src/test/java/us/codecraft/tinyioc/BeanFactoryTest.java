package us.codecraft.tinyioc;

import us.codecraft.tinyioc.factory.AutowiredCapableBeanFactory;
import us.codecraft.tinyioc.factory.BeanFactory;

/**
 * @author xian.wang
 * @since 下午3:23 2020/8/8
 */
public class BeanFactoryTest {

    public static void main(String[] args) {
        BeanDefinition beanDefinition = new BeanDefinition();
        beanDefinition.setBeanClassName("us.codecraft.tinyioc.HelloService");
        AutowiredCapableBeanFactory autowiredCapableBeanFactory = new AutowiredCapableBeanFactory();
        autowiredCapableBeanFactory.registerBeanDefinition("hello",beanDefinition);

        Object hello = autowiredCapableBeanFactory.getBean("hello");
        System.out.println(hello);

    }
}
