package web.service;

/**
 * @author : dafeng.guo
 * @date : 15:46 2022/6/3
 **/
public abstract class StrategyAbstract {
    /**
     * 获取bean名字
     * @return
     */
    abstract public String strategyName();

    /**
     * 打印名字
     */
    abstract public void printBeanName();
}
