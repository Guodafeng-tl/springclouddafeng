package web.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import web.service.StrategyAbstract;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : dafeng.guo
 * @date : 15:45 2022/6/3
 **/
@Slf4j
@Component
public class StrageContext implements BeanPostProcessor {
    private static final Map<String, StrategyAbstract> strageMap = new HashMap<>();
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof StrategyAbstract){
            StrategyAbstract strategyAbstract = (StrategyAbstract)bean;
            String strategyName = strategyAbstract.strategyName();
            if (!strageMap.containsKey(strategyName)){
                strageMap.put(strategyName, strategyAbstract);
            }
        }
        return bean;
    }

    public StrategyAbstract getStrategyInfo(String beanName){
        return strageMap.get(beanName);
    }
}
