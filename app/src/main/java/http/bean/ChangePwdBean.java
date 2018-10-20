package http.bean;

/**
 * Created by Administrator on 2017/12/10.
 */

public class ChangePwdBean {

    /**
     * Result : 0
     * ShowMsg : 操作失败 系统异常
     * ErrCode : 0
     * Row : 0
     * Data : {}
     */

    private String Result;
    private String ShowMsg;
    private String ErrCode;
    private int Row;
    private DataBean Data;

    public String getResult() {
        return Result;
    }

    public void setResult(String Result) {
        this.Result = Result;
    }

    public String getShowMsg() {
        return ShowMsg;
    }

    public void setShowMsg(String ShowMsg) {
        this.ShowMsg = ShowMsg;
    }

    public String getErrCode() {
        return ErrCode;
    }

    public void setErrCode(String ErrCode) {
        this.ErrCode = ErrCode;
    }

    public int getRow() {
        return Row;
    }

    public void setRow(int Row) {
        this.Row = Row;
    }

    public DataBean getData() {
        return Data;
    }

    public void setData(DataBean Data) {
        this.Data = Data;
    }

    public static class DataBean {
    }
}
