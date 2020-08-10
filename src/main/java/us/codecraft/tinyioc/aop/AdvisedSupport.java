package us.codecraft.tinyioc.aop;

import org.aopalliance.intercept.MethodInterceptor;

/**
 * @author xian.wang
 * @since 下午4:12 2020/8/10
 */
public class AdvisedSupport {

    private TargetSource targetSource;

    private MethodInterceptor methodInterceptor;

    public AdvisedSupport() {
    }

    public AdvisedSupport(TargetSource targetSource, MethodInterceptor methodInterceptor) {
        this.targetSource = targetSource;
        this.methodInterceptor = methodInterceptor;
    }

    public TargetSource getTargetSource() {
        return targetSource;
    }

    public void setTargetSource(TargetSource targetSource) {
        this.targetSource = targetSource;
    }

    public MethodInterceptor getMethodInterceptor() {
        return methodInterceptor;
    }

    public void setMethodInterceptor(MethodInterceptor methodInterceptor) {
        this.methodInterceptor = methodInterceptor;
    }
}
