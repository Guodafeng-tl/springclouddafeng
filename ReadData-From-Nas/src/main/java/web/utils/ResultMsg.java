package web.utils;


import java.util.HashMap;
import java.util.Map;

/**
 * @author : dafeng.guo
 * @date : 18:06 2020/12/17
 * 自己封装返回信息的对象
 **/
public class ResultMsg {
    /**
     * 200-代表成功
     * 201-失败
     */
    private int code;

    private String msg;

    private static final int successCode=200;

    private static final int failCode=201;

    private static final String success="SUCCESS";

    private static final String fail="FAIL";

    private Map<String,Object> mapInfo=new HashMap<String, Object>();

    public static ResultMsg retuenSuccess(){
        ResultMsg resultMsg = new ResultMsg();
        resultMsg.setCode(successCode);
        resultMsg.setMsg(success);
        return resultMsg;
    }
    public static ResultMsg retuenFail(){
        ResultMsg resultMsg = new ResultMsg();
        resultMsg.setCode(failCode);
        resultMsg.setMsg(fail);
        return resultMsg;
    }

    public ResultMsg addMapInfo(String key,Object value){
        this.getMapInfo().put(key,value);
        return this;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, Object> getMapInfo() {
        return mapInfo;
    }

    public void setMapInfo(Map<String, Object> mapInfo) {
        this.mapInfo = mapInfo;
    }
}
