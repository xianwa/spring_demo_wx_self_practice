package us.codecraft.tinyioc.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author xian.wang
 * @since 下午7:40 2020/8/8
 */
public interface Resource {

    InputStream getInputStream() throws IOException;
}
