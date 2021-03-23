package web.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;


/**
 * 过滤器
 * @author : dafeng.guo
 * @date : 16:15 2021/3/19
 **/
@Slf4j
@Component
public class MyFiletr implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("MyFiletr.init() **************************");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("MyFiletr.doFilter() **************************开始执行");
        request.setCharacterEncoding("UTF-8");
        //这里可以进行业务判断  符合条件去执行
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
