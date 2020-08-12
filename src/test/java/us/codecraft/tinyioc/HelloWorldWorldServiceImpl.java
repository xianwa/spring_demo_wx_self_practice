package us.codecraft.tinyioc;

/**
 * @author xian.wang
 * @since 下午4:47 2020/8/10
 */
public class HelloWorldWorldServiceImpl implements HelloWorldService {
    private String text;

    private OutputService outputService;

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

    public HelloWorldWorldServiceImpl() {
        System.out.println("hello service init");
    }

    public OutputService getOutputService() {
        return outputService;
    }

    public void setOutputService(OutputService outputService) {
        this.outputService = outputService;
    }
}
