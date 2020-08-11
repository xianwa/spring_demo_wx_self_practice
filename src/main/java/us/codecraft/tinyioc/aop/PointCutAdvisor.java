package us.codecraft.tinyioc.aop;

/**
 * @author xian.wang
 * @since 下午8:23 2020/8/10
 */
public interface PointCutAdvisor extends Advisor{

    PointCut getPointCut();

}
