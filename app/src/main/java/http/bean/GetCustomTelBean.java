package http.bean;

/**
 * Created by 一脸灬邪气 on 2017/12/8 0008 2017/12/8 0008.
 * HDJY.setBug(null);
 */

public class GetCustomTelBean {


    /**
     * Result : 1
     * ShowMsg : 操作成功！
     * ErrCode : 0
     * Row : 0
     * Data : {"CustomerServiceInfo":{"Tel":"400-8008820","ServiceViewURL":"http://hdjy.turuitech
     * .com/PersonCenter/Service"}}
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
         * CustomerServiceInfo : {"Tel":"400-8008820","ServiceViewURL":"http://hdjy.turuitech
         * .com/PersonCenter/Service"}
         */

        private CustomerServiceInfoEntity CustomerServiceInfo;

        public CustomerServiceInfoEntity getCustomerServiceInfo() {
            return CustomerServiceInfo;
        }

        public void setCustomerServiceInfo(CustomerServiceInfoEntity CustomerServiceInfo) {
            this.CustomerServiceInfo = CustomerServiceInfo;
        }

        public static class CustomerServiceInfoEntity {
            /**
             * Tel : 400-8008820
             * ServiceViewURL : http://hdjy.turuitech.com/PersonCenter/Service
             */

            private String Tel;
            private String ServiceViewURL;

            public String getTel() {
                return Tel;
            }

            public void setTel(String Tel) {
                this.Tel = Tel;
            }

            public String getServiceViewURL() {
                return ServiceViewURL;
            }

            public void setServiceViewURL(String ServiceViewURL) {
                this.ServiceViewURL = ServiceViewURL;
            }
        }
    }
}
