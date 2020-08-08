package us.codecraft.tinyioc;

/**
 * @author xian.wang
 * @since 下午6:14 2020/8/8
 */
public class PropertyValue {

    private final String name;

    private final Object value;

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }
}
