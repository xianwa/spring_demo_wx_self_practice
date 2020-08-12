package us.codecraft.tinyioc.aop;

import org.junit.Test;

import us.codecraft.tinyioc.HelloWorldService;
import us.codecraft.tinyioc.HelloWorldWorldServiceImpl;

/**
 * @author xian.wang
 * @since 下午8:56 2020/8/10
 */
public class AspectJExpressionPointcutTest {

    @Test
    public void testClassFilter(){
        String expression = "execution(* us.codecraft.tinyioc.*.*(..))";
        AspectJExpressionPointCut aspectJExpressionPointCut = new AspectJExpressionPointCut();
        aspectJExpressionPointCut.setExpression(expression);
        boolean matches = aspectJExpressionPointCut.getClassFilter().matches(HelloWorldService.class);
        System.out.println(matches);
    }

    @Test
    public void testMethodInterceptor() throws Exception {
        String expression = "execution(* us.codecraft.tinyioc.*.*(..))";
        AspectJExpressionPointCut aspectJExpressionPointCut = new AspectJExpressionPointCut();
        aspectJExpressionPointCut.setExpression(expression);
        boolean matches = aspectJExpressionPointCut.getMethodMatcher()
                .matches(HelloWorldWorldServiceImpl.class.getDeclaredMethod("helloWorld"), HelloWorldWorldServiceImpl.class);
        System.out.println(matches);
    }
}
