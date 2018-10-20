package http.bean;

/**
 * Created by 一脸灬邪气 on 2017/12/14 0014 2017/12/14 0014.
 * HDJY.setBug(null);
 */

public class GetUserBean {

    /**
     * Result : 1
     * ShowMsg : 操作成功！
     * ErrCode : 0
     * Row : 0
     * Data : {"UserInfo":{"UserID":"56723ce3-3174-4449-8665-572e17d3e855","AccountType":2,
     * "AccountTypeName":"合资人","AccountName":"15669289885","OpenState":0,
     * "ReferralCode":"211512724157","QRcode":"http://hdjy.turuitech
     * .com/Upload/ReferralCode/56723ce3-3174-4449-8665-572e17d3e8557ac21610-c524-459f-88f0
     * -1f7c19e8599e.jpg","ReferralViewURL":"http://hdjy.turuitech
     * .com/WeChat/PersonCenter/Recommend","IsCheck":2,"IsCheckf":"待审核"}}
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
         * UserInfo : {"UserID":"56723ce3-3174-4449-8665-572e17d3e855","AccountType":2,
         * "AccountTypeName":"合资人","AccountName":"15669289885","OpenState":0,
         * "ReferralCode":"211512724157","QRcode":"http://hdjy.turuitech
         * .com/Upload/ReferralCode/56723ce3-3174-4449-8665-572e17d3e8557ac21610-c524-459f-88f0
         * -1f7c19e8599e.jpg","ReferralViewURL":"http://hdjy.turuitech
         * .com/WeChat/PersonCenter/Recommend","IsCheck":2,"IsCheckf":"待审核"}
         */

        private UserInfoEntity UserInfo;

        public UserInfoEntity getUserInfo() {
            return UserInfo;
        }

        public void setUserInfo(UserInfoEntity UserInfo) {
            this.UserInfo = UserInfo;
        }

        public static class UserInfoEntity {
            /**
             * UserID : 56723ce3-3174-4449-8665-572e17d3e855
             * AccountType : 2
             * AccountTypeName : 合资人
             * AccountName : 15669289885
             * OpenState : 0
             * ReferralCode : 211512724157
             * QRcode : http://hdjy.turuitech
             * .com/Upload/ReferralCode/56723ce3-3174-4449-8665-572e17d3e8557ac21610-c524-459f
             * -88f0-1f7c19e8599e.jpg
             * ReferralViewURL : http://hdjy.turuitech.com/WeChat/PersonCenter/Recommend
             * IsCheck : 2
             * IsCheckf : 待审核
             */

            private String UserID;
            private int AccountType;
            private String AccountTypeName;
            private String AccountName;
            private int OpenState;
            private String ReferralCode;
            private String QRcode;
            private String ReferralViewURL;
            private int IsCheck;
            private String IsCheckf;
            private int AddFlag;

            public int getAddFlag() {
                return AddFlag;
            }

            public void setAddFlag(int addFlag) {
                AddFlag = addFlag;
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

            public int getOpenState() {
                return OpenState;
            }

            public void setOpenState(int OpenState) {
                this.OpenState = OpenState;
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

            public String getReferralViewURL() {
                return ReferralViewURL;
            }

            public void setReferralViewURL(String ReferralViewURL) {
                this.ReferralViewURL = ReferralViewURL;
            }

            public int getIsCheck() {
                return IsCheck;
            }

            public void setIsCheck(int IsCheck) {
                this.IsCheck = IsCheck;
            }

            public String getIsCheckf() {
                return IsCheckf;
            }

            public void setIsCheckf(String IsCheckf) {
                this.IsCheckf = IsCheckf;
            }
        }
    }
}
