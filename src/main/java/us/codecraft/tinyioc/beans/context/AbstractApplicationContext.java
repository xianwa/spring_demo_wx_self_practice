package us.codecraft.tinyioc.beans.context;

import java.util.List;

import us.codecraft.tinyioc.aop.BeanPostProcessor;
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
        loadBeanDefinition(beanFactory);
        registerBeanPostProcessors(beanFactory);
        onRefresh();
    }

    protected void onRefresh() throws Exception {
        beanFactory.preInstantiateSingletons();
    }

    abstract void loadBeanDefinition(AbstractBeanFactory beanFactory) throws Exception;

    protected void registerBeanPostProcessors(AbstractBeanFactory beanFactory) throws Exception {
        List beanPostProcessors = beanFactory.getBeansForType(BeanPostProcessor.class);
        for (Object beanPostProcessor : beanPostProcessors) {
            beanFactory.addBeanPostProcessor((BeanPostProcessor) beanPostProcessor);
        }
    }
}
