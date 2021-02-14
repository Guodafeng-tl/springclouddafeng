package web.service;

import org.springframework.stereotype.Component;

/**
 * @author : dafeng.guo
 * @date : 23:58 2021/2/14
 * 微服务调用异常的兜底实现类
 **/
@Component
public class ProviderServiceImpl implements  ProviderService {

    @Override
    public String providerInfo_OK(Integer id) {
        return "**********I am providerInfo_OK,/(ㄒoㄒ)/***************";
    }

    @Override
    public String providerInfo_TimeOut(Integer id) {
        return "**********I am providerInfo_TimeOut,/(ㄒoㄒ)/***************";
    }
}
