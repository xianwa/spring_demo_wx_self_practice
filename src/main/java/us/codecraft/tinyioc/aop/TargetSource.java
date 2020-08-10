package us.codecraft.tinyioc.aop;

/**
 * @author xian.wang
 * @since 下午4:11 2020/8/10
 */
public class TargetSource {

    private Class targetClass;

    private Object target;

    public TargetSource(Class targetClass, Object target) {
        this.targetClass = targetClass;
        this.target = target;
    }

    public Class getTargetClass() {
        return targetClass;
    }

    public void setTargetClass(Class targetClass) {
        this.targetClass = targetClass;
    }

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }
}
