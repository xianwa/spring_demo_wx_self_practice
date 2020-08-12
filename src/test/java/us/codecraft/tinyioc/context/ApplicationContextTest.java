package us.codecraft.tinyioc.context;

import org.junit.Test;

import us.codecraft.tinyioc.HelloService;
import us.codecraft.tinyioc.beans.context.ApplicationContext;
import us.codecraft.tinyioc.beans.context.ClassPathXmlApplicationContext;

/**
 * @author xian.wang
 * @since 上午9:19 2020/8/12
 */
public class ApplicationContextTest {

    @Test
    public void test() throws Exception{
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("tinyioc.xml");
        HelloService helloWorldService = (HelloService) applicationContext.getBean("helloWorldService");
        helloWorldService.helloWorld();
    }

    @Test
    public void testPostBeanProcessor() throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("tinyioc-postbeanprocessor.xml");
        HelloService helloWorldService = (HelloService) applicationContext.getBean("helloWorldService");
        helloWorldService.helloWorld();
    }

}
