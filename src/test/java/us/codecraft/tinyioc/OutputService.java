package us.codecraft.tinyioc;

/**
 * @author xian.wang
 * @since 下午4:15 2020/8/9
 */
public class OutputService {

    private HelloService helloService;

    public HelloService getHelloService() {
        return helloService;
    }

    public void setHelloWorldService(HelloService helloWorldService) {
        helloService = helloWorldService;
    }
}

