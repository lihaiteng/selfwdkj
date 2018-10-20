package http.retrofit;

/**
 * Created by LiHT on 2017/5/26.
 */
/**
 * 该类需要根据接口实际情况修改
 * http请求响应状态相关的外围字段，所组成的http请求状态类，一般根据 错误接口 来的
 */
public class HttpStatus {
    private String Result;
    private String ShowMsg;
    private String ErrCode;
    private int Row;

    public String getResult() {
        return Result;
    }

    public String getShowMsg() {
        return ShowMsg;
    }

    public String getErrCode() {
        return ErrCode;
    }

    public int getRow() {
        return Row;
    }

    public void setResult(String result) {
        Result = result;
    }

    public void setShowMsg(String showMsg) {
        ShowMsg = showMsg;
    }

    public void setErrCode(String errCode) {
        ErrCode = errCode;
    }

    public void setRow(int row) {
        Row = row;
    }

    /**
     * API是否请求成功
     */
    public boolean requestIfSuccess() {
        boolean ifSuccess = (Result.equals(Constants.WEB_RESP_CODE_SUCCESS));
        return ifSuccess;
    }
}
