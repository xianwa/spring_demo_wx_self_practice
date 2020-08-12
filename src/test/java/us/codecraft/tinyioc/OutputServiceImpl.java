package us.codecraft.tinyioc;

/**
 * @author xian.wang
 * @since 下午4:15 2020/8/9
 */
public class OutputServiceImpl implements OutputService {
    @Override
    public void output(String text) {
        System.out.println(text);
    }
}

