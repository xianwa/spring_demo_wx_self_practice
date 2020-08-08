package us.codecraft.tinyioc;

/**
 * @author xian.wang
 * @since 下午1:39 2020/8/8
 */
public class BeanDefinition {

    private Object bean;

    public BeanDefinition(Object bean) {
        this.bean = bean;
    }

    public Object getBean() {
        return bean;
    }
}
