package us.codecraft.tinyioc;

/**
 * @author xian.wang
 * @since 下午1:31 2020/8/9
 */
public interface BeanDefinitionReader {

    void loadBeanDefinitions(String location) throws Exception;
}
