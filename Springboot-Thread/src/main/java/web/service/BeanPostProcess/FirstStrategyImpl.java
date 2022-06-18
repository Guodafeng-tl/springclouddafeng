package web.service.BeanPostProcess;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import web.service.StrategyAbstract;

/**
 * @author : dafeng.guo
 * @date : 15:47 2022/6/3
 **/
@Slf4j
@Component
public class FirstStrategyImpl extends StrategyAbstract {
    @Override
    public String strategyName() {
        return "FIRST";
    }

    @Override
    public void printBeanName() {
        log.info("trace log FirstStrategyImpl");
    }
}
