package us.codecraft.tinyioc;

import java.util.Map;

import us.codecraft.tinyioc.factory.AutowiredCapableBeanFactory;
import us.codecraft.tinyioc.factory.BeanFactory;
import us.codecraft.tinyioc.io.Resource;
import us.codecraft.tinyioc.io.ResourceLoader;
import us.codecraft.tinyioc.xml.XmlBeanDefinitionReader;

/**
 * @author xian.wang
 * @since 下午3:23 2020/8/8
 */
public class BeanFactoryTest {

    public static void main(String[] args) throws Exception {
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinitions("tinyioc.xml");

        BeanFactory beanFactory = new AutowiredCapableBeanFactory();
        Map<String, BeanDefinition> register = xmlBeanDefinitionReader.getRegister();
        for (Map.Entry<String, BeanDefinition> stringBeanDefinitionEntry : register.entrySet()) {
            String name = stringBeanDefinitionEntry.getKey();
            BeanDefinition beanDefinition = stringBeanDefinitionEntry.getValue();
            beanFactory.registerBeanDefinition(name,beanDefinition);
        }

        HelloService helloService = (HelloService) beanFactory.getBean("hello");
        System.out.println(helloService.getText());
    }
}
