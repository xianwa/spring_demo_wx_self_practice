package us.codecraft.tinyioc;

/**
 * @author xian.wang
 * @since 下午2:13 2020/8/8
 */
public class HelloService {

    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public HelloService() {
        System.out.println("hello service");
    }
}
