package http.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by 一脸灬邪气 on 2017/12/11 0011 2017/12/11 0011.
 * HDJY.setBug(null);
 */

public class PayBean {

    /**
     * Result : 1
     * ShowMsg : 操作成功！
     * ErrCode : 0
     * Row : 0
     * Data : {"PayJson":{"appId":"wxc3906593612b5620","timeStamp":"1516259093",
     * "nonceStr":"6852628","package":"prepay_id=wx201801181504530b2bd1b8c20342803309",
     * "signType":"MD5","paySign":"95720FE9DEA9115441564F73F26FC383"}}
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
         * PayJson : {"appId":"wxc3906593612b5620","timeStamp":"1516259093","nonceStr":"6852628",
         * "package":"prepay_id=wx201801181504530b2bd1b8c20342803309","signType":"MD5",
         * "paySign":"95720FE9DEA9115441564F73F26FC383"}
         */

        private PayJsonEntity PayJson;

        public PayJsonEntity getPayJson() {
            return PayJson;
        }

        public void setPayJson(PayJsonEntity PayJson) {
            this.PayJson = PayJson;
        }

        public static class PayJsonEntity {
            @SerializedName("appid")
            private String appId;
            private String partnerid;
            @SerializedName("timestamp")
            private String timeStamp;
            private String nonceStr;
            @SerializedName("package")
            private String packageX;
            private String sign;
            private String prepayid;
            private String PaySDK;

            public String getPaySDK() {
                return PaySDK;
            }

            public void setPaySDK(String paySDK) {
                PaySDK = paySDK;
            }

            public String getAppId() {
                return appId;
            }

            public void setAppId(String appId) {
                this.appId = appId;
            }

            public String getTimeStamp() {
                return timeStamp;
            }

            public void setTimeStamp(String timeStamp) {
                this.timeStamp = timeStamp;
            }

            public String getNonceStr() {
                return nonceStr;
            }

            public void setNonceStr(String nonceStr) {
                this.nonceStr = nonceStr;
            }

            public String getPackageX() {
                return packageX;
            }

            public void setPackageX(String packageX) {
                this.packageX = packageX;
            }

            public String getPartnerid() {
                return partnerid;
            }

            public String getSign() {
                return sign;
            }

            public String getPrepayid() {
                return prepayid;
            }

            public void setPartnerid(String partnerid) {
                this.partnerid = partnerid;
            }

            public void setSign(String sign) {
                this.sign = sign;
            }

            public void setPrepayid(String prepayid) {
                this.prepayid = prepayid;
            }
        }
    }
}
