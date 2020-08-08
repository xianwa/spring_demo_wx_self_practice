package us.codecraft.tinyioc;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author xian.wang
 * @since 下午6:18 2020/8/8
 */
public class PropertyValues {

    private final List<PropertyValue> propertyValueList = Lists.newArrayList();

    public void addPropertyValue(PropertyValue propertyValue){
        propertyValueList.add(propertyValue);
    }

    public List<PropertyValue> getPropertyValueList() {
        return propertyValueList;
    }
}
