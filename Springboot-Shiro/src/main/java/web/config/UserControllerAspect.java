package web.config;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author : dafeng.guo
 * @date : 20:03 2021/11/25
 **/
@Aspect
@Component
public class UserControllerAspect {

    private final String POINT_CUT = "execution(public * web.controller.UserController.*(..))";

    @Pointcut(POINT_CUT)
    private void pointcutInfo(){
    }

    @Before(POINT_CUT)
    public void advice01(){
        System.out.println("**************开始切入this is pointcutInfo()*********************");
    }
}
