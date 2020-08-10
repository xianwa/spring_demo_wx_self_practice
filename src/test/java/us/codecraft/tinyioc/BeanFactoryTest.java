package us.codecraft.tinyioc;

import us.codecraft.tinyioc.beans.context.ApplicationContext;
import us.codecraft.tinyioc.beans.context.ClassPathXmlApplicationContext;

/**
 * @author xian.wang
 * @since 下午3:23 2020/8/8
 */
public class BeanFactoryTest {

    public static void main(String[] args) throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("tinyioc.xml");
        HelloService helloService = (HelloService) applicationContext.getBean("helloWorldService");
        helloService.helloWorld();
    }
}
