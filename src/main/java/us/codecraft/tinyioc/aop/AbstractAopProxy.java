package us.codecraft.tinyioc.aop;

/**
 * @author xian.wang
 * @since 下午9:09 2020/8/12
 */
public abstract class AbstractAopProxy implements AopProxy {

    protected AdvisedSupport advised;

    public AbstractAopProxy(AdvisedSupport advised) {
        this.advised = advised;
    }

    public AdvisedSupport getAdvised() {
        return advised;
    }
}
