package web.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import web.entity.User;
import web.service.UserService;
import org.springframework.web.bind.annotation.*;
import web.util.ResultMsg;

import javax.annotation.Resource;

/**
 * @author makejava
 * @since 2021-03-23 14:53:59
 */
@RestController
@Slf4j
//@Transactional
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/selectOne")
    public User selectOne(Integer id) {
        User user = userService.queryById(id);
        return user;
    }

    /**
     * 游客
     * @return
     */
    @RequestMapping(value = "/guest/login", method = RequestMethod.GET)
    public ResultMsg guestLogin() {
        ResultMsg resultMsg = ResultMsg.retuenSuccess();
        resultMsg.setMsg("欢迎进入，您的身份是游客");
        return resultMsg;
    }

    /**
     * 用户
     * @return
     */
    @RequestMapping(value = "/user/login", method = RequestMethod.GET)
    public ResultMsg userLogin() {
        ResultMsg resultMsg = ResultMsg.retuenSuccess();
        resultMsg.setMsg("欢迎进入，您的身份是用户");
        return resultMsg;
    }

    /**
     * 用户
     * @return
     */
    @RequestMapping(value = "/admin/login", method = RequestMethod.GET)
    public ResultMsg adminLogin() {
        ResultMsg resultMsg = ResultMsg.retuenSuccess();
        resultMsg.setMsg("欢迎进入，您的身份是管理员");
        return resultMsg;
    }

    /**
     * 未登录
     * @return
     */
    @RequestMapping(value = "/notLogin", method = RequestMethod.GET)
    public ResultMsg notLogin() {
        ResultMsg resultMsg = ResultMsg.retuenSuccess();
        resultMsg.setMsg("您尚未登录");
        return resultMsg;
    }

    /**
     * 没有权限
     * @return
     */
    @RequestMapping(value = "/unauthorized", method = RequestMethod.GET)
    public ResultMsg notRole() {
        ResultMsg resultMsg = ResultMsg.retuenSuccess();
        resultMsg.setMsg("权限认证失败,您没有权限");
        return resultMsg;
    }

    /**
     * 注销
     * @return
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ResultMsg logout() {
        Subject subject = SecurityUtils.getSubject();
        //注销
        subject.logout();
        ResultMsg resultMsg = ResultMsg.retuenSuccess();
        resultMsg.setMsg("成功注销");
        return resultMsg;
    }

    /**
     * 登陆
     *
     * @param username 用户名
     * @param password 密码
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ResultMsg login(String username, String password) {
        // 从SecurityUtils里边创建一个 subject
        Subject subject = SecurityUtils.getSubject();
        // 在认证提交前准备 token（令牌）
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        // 执行认证登陆
        subject.login(token);
        //执行权限校验
        /*subject.hasRole("user");*/
        //根据权限，指定返回数据
        String role = userService.queryByUserName(username).getRole();
        ResultMsg resultMsg = ResultMsg.retuenSuccess();
        if ("user".equals(role)) {
            resultMsg.setMsg("欢迎登陆");
            return resultMsg;
        }
        if ("admin".equals(role)) {
            resultMsg.setMsg("欢迎来到管理员页面");
            return resultMsg;
        }
        resultMsg.setMsg("权限错误");
        return resultMsg;
    }

    @RequestMapping(value = "/login/testMysqlInsert", method = RequestMethod.GET)
    public String testInsert(){
        //
        User userExist = userService.queryById(8);
        log.info(userExist.toString());
        userService.deleteById(8);
        userService.insert(User.builder().id(8).name("xxxxx11").role("A11").build());
        userService.update(User.builder().id(8).name("yyyyyy11").role("roleeee11").build());
        userService.update(User.builder().id(8).name("zzzz111").role("ooooo11").build());
        User userNew = userService.queryById(8);
        log.info(userNew.toString());
        return "插入成功";
    }

    @RequestMapping(value = "/login/testAspect", method = RequestMethod.GET)
    public void testAspect(){
        System.out.println("*************这是testAspect*********");
    }

}