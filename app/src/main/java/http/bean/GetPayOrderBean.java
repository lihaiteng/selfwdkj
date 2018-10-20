package http.bean;

/**
 * Created by 一脸灬邪气 on 2017/12/11 0011 2017/12/11 0011.
 * HDJY.setBug(null);
 */

public class GetPayOrderBean {

    /**
     * Result : 1
     * ShowMsg : 操作成功！
     * ErrCode : 0
     * Row : 0
     * Data : {"OrderInfo":{"ID":"7248e004-d2d7-4116-846c-671bec2b0d55",
     * "UserDetailID":"0ee19252-f765-4e59-a3a4-f07a89669739","RealName":"杨一",
     * "AccountName":"13211111111","AccountType":1,"AccountTypef":"合股人",
     * "AF_ID":"dbc3b646-c238-4346-bbed-c08993b5f4c5","AF_Name":"50W","Cost":500000,
     * "OrderStateFlag":0,"Tel":"","CardID":"33022719930514053X","BusinessLicenseNo":"",
     * "StateFlag":0,"PayUrl":""}}
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
         * OrderInfo : {"ID":"7248e004-d2d7-4116-846c-671bec2b0d55",
         * "UserDetailID":"0ee19252-f765-4e59-a3a4-f07a89669739","RealName":"杨一",
         * "AccountName":"13211111111","AccountType":1,"AccountTypef":"合股人",
         * "AF_ID":"dbc3b646-c238-4346-bbed-c08993b5f4c5","AF_Name":"50W","Cost":500000,
         * "OrderStateFlag":0,"Tel":"","CardID":"33022719930514053X","BusinessLicenseNo":"",
         * "StateFlag":0,"PayUrl":""}
         */

        private OrderInfoEntity OrderInfo;

        public OrderInfoEntity getOrderInfo() {
            return OrderInfo;
        }

        public void setOrderInfo(OrderInfoEntity OrderInfo) {
            this.OrderInfo = OrderInfo;
        }

        public static class OrderInfoEntity {
            /**
             * ID : 7248e004-d2d7-4116-846c-671bec2b0d55
             * UserDetailID : 0ee19252-f765-4e59-a3a4-f07a89669739
             * RealName : 杨一
             * AccountName : 13211111111
             * AccountType : 1
             * AccountTypef : 合股人
             * AF_ID : dbc3b646-c238-4346-bbed-c08993b5f4c5
             * AF_Name : 50W
             * Cost : 500000
             * OrderStateFlag : 0
             * Tel :
             * CardID : 33022719930514053X
             * BusinessLicenseNo :
             * StateFlag : 0
             * PayUrl :
             */

            private String ID;
            private String UserDetailID;
            private String RealName;
            private String AccountName;
            private int AccountType;
            private String AccountTypef;
            private String AF_ID;
            private String AF_Name;
            private float Cost;
            private int OrderStateFlag;
            private String Tel;
            private String CardID;
            private String BusinessLicenseNo;
            private int StateFlag;
            private String PayUrl;
            private float PayTotalFee;
            private String TradeType;
            private String PaymentTime;
            private String OrderID;

            public void setCost(float cost) {
                Cost = cost;
            }

            public float getPayTotalFee() {
                return PayTotalFee;
            }

            public void setPayTotalFee(float payTotalFee) {
                PayTotalFee = payTotalFee;
            }

            public String getTradeType() {
                return TradeType;
            }

            public void setTradeType(String tradeType) {
                TradeType = tradeType;
            }

            public String getPaymentTime() {
                return PaymentTime;
            }

            public void setPaymentTime(String paymentTime) {
                PaymentTime = paymentTime;
            }

            public String getOrderID() {
                return OrderID;
            }

            public void setOrderID(String orderID) {
                OrderID = orderID;
            }

            public String getID() {
                return ID;
            }

            public void setID(String ID) {
                this.ID = ID;
            }

            public String getUserDetailID() {
                return UserDetailID;
            }

            public void setUserDetailID(String UserDetailID) {
                this.UserDetailID = UserDetailID;
            }

            public String getRealName() {
                return RealName;
            }

            public void setRealName(String RealName) {
                this.RealName = RealName;
            }

            public String getAccountName() {
                return AccountName;
            }

            public void setAccountName(String AccountName) {
                this.AccountName = AccountName;
            }

            public int getAccountType() {
                return AccountType;
            }

            public void setAccountType(int AccountType) {
                this.AccountType = AccountType;
            }

            public String getAccountTypef() {
                return AccountTypef;
            }

            public void setAccountTypef(String AccountTypef) {
                this.AccountTypef = AccountTypef;
            }

            public String getAF_ID() {
                return AF_ID;
            }

            public void setAF_ID(String AF_ID) {
                this.AF_ID = AF_ID;
            }

            public String getAF_Name() {
                return AF_Name;
            }

            public void setAF_Name(String AF_Name) {
                this.AF_Name = AF_Name;
            }

            public float getCost() {
                return Cost;
            }

            public int getOrderStateFlag() {
                return OrderStateFlag;
            }

            public void setOrderStateFlag(int OrderStateFlag) {
                this.OrderStateFlag = OrderStateFlag;
            }

            public String getTel() {
                return Tel;
            }

            public void setTel(String Tel) {
                this.Tel = Tel;
            }

            public String getCardID() {
                return CardID;
            }

            public void setCardID(String CardID) {
                this.CardID = CardID;
            }

            public String getBusinessLicenseNo() {
                return BusinessLicenseNo;
            }

            public void setBusinessLicenseNo(String BusinessLicenseNo) {
                this.BusinessLicenseNo = BusinessLicenseNo;
            }

            public int getStateFlag() {
                return StateFlag;
            }

            public void setStateFlag(int StateFlag) {
                this.StateFlag = StateFlag;
            }

            public String getPayUrl() {
                return PayUrl;
            }

            public void setPayUrl(String PayUrl) {
                this.PayUrl = PayUrl;
            }
        }
    }
}
