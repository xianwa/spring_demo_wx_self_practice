package us.codecraft.tinyioc.aop;

import org.aopalliance.intercept.MethodInterceptor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


/**
 * @author xian.wang
 * @since 下午4:16 2020/8/10
 */
public class JdkDynamicAopProxy implements AopProxy, InvocationHandler {

    private AdvisedSupport advisedSupport;

    public JdkDynamicAopProxy(AdvisedSupport advisedSupport) {
        this.advisedSupport = advisedSupport;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        MethodInterceptor methodInterceptor = advisedSupport.getMethodInterceptor();
        ReflectiveMethodInvocation reflectiveMethodInvocation = new ReflectiveMethodInvocation(advisedSupport.getTargetSource().getTarget(), method, args);
        return methodInterceptor.invoke(reflectiveMethodInvocation);
    }

    @Override
    public Object getProxy() {
        return Proxy.newProxyInstance(getClass().getClassLoader(),
                new Class[]{advisedSupport.getTargetSource().getTargetClass()}, this);
    }
}
