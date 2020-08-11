package us.codecraft.tinyioc.aop;

import us.codecraft.tinyioc.HelloService;
import us.codecraft.tinyioc.OutputServiceImpl;

/**
 * @author xian.wang
 * @since 下午4:47 2020/8/10
 */
public class HelloServiceImpl implements HelloService {
    private String text;

    private OutputServiceImpl outputServiceImpl;

    @Override
    public void helloWorld(){
        System.out.println(text);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public HelloServiceImpl() {
        System.out.println("hello service init");
    }

    public void setOutputServiceImpl(OutputServiceImpl outputServiceImpl) {
        this.outputServiceImpl = outputServiceImpl;
    }

    public OutputServiceImpl getOutputServiceImpl() {
        return outputServiceImpl;
    }
}
