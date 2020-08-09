package us.codecraft.tinyioc;

/**
 * @author xian.wang
 * @since 下午4:26 2020/8/9
 */
public class BeanReference {

    private String name;

    private Object bean;


    public BeanReference(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getBean() {
        return bean;
    }

    public void setBean(Object bean) {
        this.bean = bean;
    }
}
