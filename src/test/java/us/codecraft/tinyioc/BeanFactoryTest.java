package us.codecraft.tinyioc;

/**
 * @author xian.wang
 * @since 下午3:23 2020/8/8
 */
public class BeanFactoryTest {

    public static void main(String[] args) {
        BeanFactory beanFactory = new BeanFactory();
        beanFactory.registerBeanDefinition("hello",new BeanDefinition(new HelloService()));
        HelloService helloService = (HelloService) beanFactory.getBean("hello");
        System.out.println(helloService);
    }
}
