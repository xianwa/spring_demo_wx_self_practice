package us.codecraft.tinyioc.beans.context;

import us.codecraft.tinyioc.beans.factory.AbstractBeanFactory;

/**
 * @author xian.wang
 * @since 下午2:54 2020/8/10
 */
public abstract class AbstractApplicationContext implements ApplicationContext {

    protected AbstractBeanFactory beanFactory;

    public AbstractApplicationContext(AbstractBeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    @Override
    public Object getBean(String name) throws Exception {
        return beanFactory.getBean(name);
    }

    public void refresh() throws Exception {
    }
}
