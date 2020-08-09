package us.codecraft.tinyioc;

/**
 * @author xian.wang
 * @since 下午4:15 2020/8/9
 */
public class OutputService {

    private HelloService helloWorldService;

    public HelloService getHelloService() {
        return helloWorldService;
    }

    public void setHelloWorldService(HelloService helloWorldService) {
        helloWorldService = helloWorldService;
    }
}

