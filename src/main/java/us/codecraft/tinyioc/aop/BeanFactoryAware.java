package us.codecraft.tinyioc.aop;

import us.codecraft.tinyioc.beans.factory.BeanFactory;

/**
 * @author xian.wang
 * @since 下午3:29 2020/8/11
 */
public interface BeanFactoryAware {

    void setBeanFactory(BeanFactory beanFactory);
}
