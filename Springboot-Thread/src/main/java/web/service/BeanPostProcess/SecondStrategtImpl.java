package web.service.BeanPostProcess;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import web.service.StrategyAbstract;

/**
 * @author : dafeng.guo
 * @date : 15:49 2022/6/3
 **/
@Component
@Slf4j
public class SecondStrategtImpl extends StrategyAbstract {

    @Override
    public String strategyName() {
        return "SECOND";
    }

    @Override
    public void printBeanName() {
        log.info("trace log SecondStrategtImpl");
    }
}
