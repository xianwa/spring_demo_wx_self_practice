package us.codecraft.tinyioc.aop;

import org.junit.Test;

import us.codecraft.tinyioc.HelloService;
import us.codecraft.tinyioc.beans.context.ApplicationContext;
import us.codecraft.tinyioc.beans.context.ClassPathXmlApplicationContext;

/**
 * @author xian.wang
 * @since 下午4:36 2020/8/10
 */
public class AopTest {

    @Test
    public static void aopTest() throws Exception {
        // helloService without AOP
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("tinyioc.xml");
//        HelloService helloService = (HelloService) applicationContext.getBean("helloWorldService");
//        helloService.helloWorld();
//
//        // helloService with AOP
//        // 1.设置被代理对象(JoinPoint)
//        AdvisedSupport advisedSupport = new AdvisedSupport();
//        advisedSupport.setTargetSource(new TargetSource(HelloService.class,helloService));
//        // 2.设置拦截器(Advice)
//        TimerInterceptor timerInterceptor = new TimerInterceptor();
//        advisedSupport.setMethodInterceptor(timerInterceptor);
//        // 3.创建代理(Proxy)
//        JdkDynamicAopProxy jdkDynamicAopProxy = new JdkDynamicAopProxy(advisedSupport);
//        HelloService helloServiceProxy = (HelloService) jdkDynamicAopProxy.getProxy();
//        // 4.基于aop的调用
//        helloServiceProxy.helloWorld();
    }
}
