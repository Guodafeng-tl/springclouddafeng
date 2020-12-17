package web.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import web.utils.ResultMsg;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : dafeng.guo
 * @date : 17:35 2020/12/17
 *  @ControllerAdvice不指定包默认加了@Controller和@RestController都能控制
 **/
@ControllerAdvice
@Slf4j
public class MyControllerAdvice extends RuntimeException{
    /**
     * 全局异常处理，反正异常返回统一格式的map
     * @param ex
     * @return
     */
    private static final String SYSTEM_EXCEPTION="系统异常";

    private static final String RUN_TIME_EXCEPTION="运行时异常";

    private static final String ARITHMETIC_EXCEPTION="算术异常";
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public ResultMsg exceptionHandler(Exception ex){
        ResultMsg resultMsg = ResultMsg.retuenFail().addMapInfo(SYSTEM_EXCEPTION, ex);
        return resultMsg;
    }

    @ResponseBody
    @ExceptionHandler(RuntimeException.class)
    public ResultMsg handleRuntimeException(RuntimeException e) {
        ResultMsg resultMsg = ResultMsg.retuenFail().addMapInfo(RUN_TIME_EXCEPTION, e);
        return resultMsg;
    }

    @ResponseBody
    @ExceptionHandler(ArithmeticException.class)
    public ResultMsg handleArithmeticException(RuntimeException e) {
        ResultMsg resultMsg = ResultMsg.retuenFail().addMapInfo(ARITHMETIC_EXCEPTION, e);
        return resultMsg;
    }

}
