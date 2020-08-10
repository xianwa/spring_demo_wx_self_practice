package us.codecraft.tinyioc.beans.factory;

/**
 * @author xian.wang
 * @since 下午1:39 2020/8/8
 */
public interface BeanFactory {

    Object getBean(String name) throws Exception;
}
