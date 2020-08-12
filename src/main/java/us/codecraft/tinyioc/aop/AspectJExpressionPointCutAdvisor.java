package us.codecraft.tinyioc.aop;

import org.aopalliance.aop.Advice;

/**
 * @author xian.wang
 * @since 下午8:25 2020/8/10
 */
public class AspectJExpressionPointCutAdvisor implements PointCutAdvisor {

    private AspectJExpressionPointCut pointCut = new AspectJExpressionPointCut();

    private Advice advice;

    public void setAdvice(Advice advice) {
        this.advice = advice;
    }

    public void setExpression(String expression){
        pointCut.setExpression(expression);
    }

    @Override
    public PointCut getPointCut() {
        return pointCut;
    }

    @Override
    public Advice getAdvice() {
        return advice;
    }
}
