package http.bean;

/**
 * Created by liht on 2018/1/19 0019.
 */

public class GetChildTotalBean {

    /**
     * Result : 1
     * ShowMsg : 操作成功！
     * ErrCode : 0
     * Row : 0
     * Data : {"RealName":"嘎嘎嘎n","totao_fee":150000}
     */

    private String Result;
    private String ShowMsg;
    private String ErrCode;
    private int Row;
    private DataEntity Data;

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

    public DataEntity getData() {
        return Data;
    }

    public void setData(DataEntity Data) {
        this.Data = Data;
    }

    public static class DataEntity {
        /**
         * RealName : 嘎嘎嘎n
         * totao_fee : 150000
         */

        private String RealName;
        private float totao_fee;
        private float partStudent_fee;

        public float getPartStudent_fee() {
            return partStudent_fee;
        }

        public void setPartStudent_fee(float partStudent_fee) {
            this.partStudent_fee = partStudent_fee;
        }

        public String getRealName() {
            return RealName;
        }

        public void setRealName(String RealName) {
            this.RealName = RealName;
        }

        public float getTotao_fee() {
            return totao_fee;
        }

        public void setTotao_fee(int totao_fee) {
            this.totao_fee = totao_fee;
        }
    }
}
