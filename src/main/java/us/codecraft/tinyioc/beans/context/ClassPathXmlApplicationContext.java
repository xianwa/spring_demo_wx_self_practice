package us.codecraft.tinyioc.beans.context;

import java.util.Map;

import us.codecraft.tinyioc.BeanDefinition;
import us.codecraft.tinyioc.BeanDefinitionReader;
import us.codecraft.tinyioc.beans.factory.AbstractBeanFactory;
import us.codecraft.tinyioc.beans.factory.AutowiredCapableBeanFactory;
import us.codecraft.tinyioc.io.ResourceLoader;
import us.codecraft.tinyioc.xml.XmlBeanDefinitionReader;

/**
 * @author xian.wang
 * @since 下午2:57 2020/8/10
 */
public class ClassPathXmlApplicationContext extends AbstractApplicationContext {

    private String configLocation;

    public ClassPathXmlApplicationContext(String configLocation) throws Exception {
        this(new AutowiredCapableBeanFactory(), configLocation);
    }

    public ClassPathXmlApplicationContext(AbstractBeanFactory beanFactory, String configLocation) throws Exception {
        super(beanFactory);
        this.configLocation = configLocation;
        refresh();
    }

    @Override
    public void refresh() throws Exception {
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinitions(configLocation);
        Map<String, BeanDefinition> register = xmlBeanDefinitionReader.getRegister();

        for (Map.Entry<String, BeanDefinition> nameAndBeanDefinitionEntry : register.entrySet()) {
            String name = nameAndBeanDefinitionEntry.getKey();
            BeanDefinition beanDefinition = nameAndBeanDefinitionEntry.getValue();
            beanFactory.registerBeanDefinition(name, beanDefinition);
        }

    }
}
