package cloud;

import cloud.Dao.User;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 在controller层之前进行拦截 (拦截类)
 */
@Component
public class CustomerInterceptor implements HandlerInterceptor {

    /**
     * 进入controller层之前拦截请求
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        boolean flag =false;  //这里值为false  webConfig类中添加的黑名单匹配集合将无法访问
        //登录判断
        /*User user=(User) request.getSession().getAttribute("userSession");
        if(null == user){
            //若为空则跳转到登录页
            response.sendRedirect("toLogin");
            flag = false;
        }else{
            flag = true;
        }*/
        return flag;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object handler, ModelAndView modelAndView) throws Exception {
    }
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, Exception ex) throws Exception {
    }
}
