package http.bean;

import java.io.Serializable;

/**
 * Created by 一脸灬邪气 on 2017/12/7 0007 2017/12/7 0007.
 * WDKJ.setBug(null);
 */

public class LoginBean {


    /**
     * Result : 1
     * ShowMsg : 操作成功！
     * ErrCode : 0
     * Row : 0
     * Data : {"UserInfo":{"UserID":"b2217277-f128-4731-8dbb-fba58209a7fb","AccountType":1,
     * "AccountTypeName":"合股人","AccountName":"13211111111","RealName":"杨一","Tel":"13211111111",
     * "ReferralCode":"201512547600","QRcode":"http://hdjy.turuitech.comhttp://ycty.turuitech
     * .com/Upload/ReferralCode/b2217277-f128-4731-8dbb-fba58209a7fbf0cfd618-0bbc-43e6-9de7
     * -a9540793d3d0.jpg","OpenState":0,"IsCheck":1}}
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
         * UserInfo : {"UserID":"b2217277-f128-4731-8dbb-fba58209a7fb","AccountType":1,
         * "AccountTypeName":"合股人","AccountName":"13211111111","RealName":"杨一",
         * "Tel":"13211111111","ReferralCode":"201512547600","QRcode":"http://hdjy.turuitech
         * .comhttp://ycty.turuitech
         * .com/Upload/ReferralCode/b2217277-f128-4731-8dbb-fba58209a7fbf0cfd618-0bbc-43e6-9de7
         * -a9540793d3d0.jpg","OpenState":0,"IsCheck":1}
         */

        private UserInfoEntity UserInfo;

        public UserInfoEntity getUserInfo() {
            return UserInfo;
        }

        public void setUserInfo(UserInfoEntity UserInfo) {
            this.UserInfo = UserInfo;
        }

        public static class UserInfoEntity implements Serializable{

            public String getIsCheckStr(){
                String str = "不通过";
                switch (IsCheck){
                    case 0:
                        str = "不通过";
                        break;
                    case 1:
                        str = "已通过";
                    break;
                    case 2:
                        str = "待审核";
                    break;
                }
                return str;
            }
            /**
             * UserID : b2217277-f128-4731-8dbb-fba58209a7fb
             * AccountType : 1
             * AccountTypeName : 合股人
             * AccountName : 13211111111
             * RealName : 杨一
             * Tel : 13211111111
             * ReferralCode : 201512547600
             * QRcode : http://hdjy.turuitech.comhttp://ycty.turuitech
             * .com/Upload/ReferralCode/b2217277-f128-4731-8dbb-fba58209a7fbf0cfd618-0bbc-43e6
             * -9de7-a9540793d3d0.jpg
             * OpenState : 0
             * IsCheck : 1
             */
            private String ReferralViewURL;
            private String UserID;
            private int AccountType;
            private String AccountTypeName;
            private String AccountName;
            private String RealName;
            private String Tel;
            private String ReferralCode;
            private String QRcode;
            private int OpenState;
            private int IsCheck;
            private String CustomerServiceTel;
            private int AddFlag;

            public int getAddFlag() {
                return AddFlag;
            }

            public void setAddFlag(int addFlag) {
                AddFlag = addFlag;
            }

            public String getReferralViewURL() {
                return ReferralViewURL;
            }

            public void setReferralViewURL(String referralViewURL) {
                ReferralViewURL = referralViewURL;
            }

            public String getUserID() {
                return UserID;
            }

            public void setUserID(String UserID) {
                this.UserID = UserID;
            }

            public int getAccountType() {
                return AccountType;
            }

            public void setAccountType(int AccountType) {
                this.AccountType = AccountType;
            }

            public String getAccountTypeName() {
                return AccountTypeName;
            }

            public void setAccountTypeName(String AccountTypeName) {
                this.AccountTypeName = AccountTypeName;
            }

            public String getAccountName() {
                return AccountName;
            }

            public void setAccountName(String AccountName) {
                this.AccountName = AccountName;
            }

            public String getRealName() {
                return RealName;
            }

            public void setRealName(String RealName) {
                this.RealName = RealName;
            }

            public String getTel() {
                return Tel;
            }

            public void setTel(String Tel) {
                this.Tel = Tel;
            }

            public String getReferralCode() {
                return ReferralCode;
            }

            public void setReferralCode(String ReferralCode) {
                this.ReferralCode = ReferralCode;
            }

            public String getQRcode() {
                return QRcode;
            }

            public void setQRcode(String QRcode) {
                this.QRcode = QRcode;
            }

            public int getOpenState() {
                return OpenState;
            }

            public void setOpenState(int OpenState) {
                this.OpenState = OpenState;
            }

            public int getIsCheck() {
                return IsCheck;
            }

            public void setIsCheck(int IsCheck) {
                this.IsCheck = IsCheck;
            }

            public String getCustomerServiceTel() {
                return CustomerServiceTel;
            }

            public void setCustomerServiceTel(String customerServiceTel) {
                CustomerServiceTel = customerServiceTel;
            }
        }
    }
}
