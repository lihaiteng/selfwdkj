package http.bean;

/**
 * Created by 一脸灬邪气 on 2017/12/7 0007 2017/12/7 0007.
 * WDKJ.setBug(null);
 */

public class MemberBean {

    /**
     * Result : 1
     * ShowMsg : 操作成功！
     * ErrCode : 0
     * Row : 0
     * Data : {"UserInfo":{"UserID":"b2217277-f128-4731-8dbb-fba58209a7fb",
     * "AccountName":"13211111111","AccountType":1,"AccountTypeName":"合股人","AF_Name":"50W",
     * "MG_Name":"企业","Cost":500000,"EffectiveDate":"","ReferralCode":"201512547600",
     * "QRcode":"http://ycty.turuitech
     * .com/Upload/ReferralCode/b2217277-f128-4731-8dbb-fba58209a7fbf0cfd618-0bbc-43e6-9de7
     * -a9540793d3d0.jpg","ParentID":"0","OpenState":0}}
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
         * UserInfo : {"UserID":"b2217277-f128-4731-8dbb-fba58209a7fb",
         * "AccountName":"13211111111","AccountType":1,"AccountTypeName":"合股人","AF_Name":"50W",
         * "MG_Name":"企业","Cost":500000,"EffectiveDate":"","ReferralCode":"201512547600",
         * "QRcode":"http://ycty.turuitech
         * .com/Upload/ReferralCode/b2217277-f128-4731-8dbb-fba58209a7fbf0cfd618-0bbc-43e6-9de7
         * -a9540793d3d0.jpg","ParentID":"0","OpenState":0}
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
             * UserID : b2217277-f128-4731-8dbb-fba58209a7fb
             * AccountName : 13211111111
             * AccountType : 1
             * AccountTypeName : 合股人
             * AF_Name : 50W
             * MG_Name : 企业
             * Cost : 500000
             * EffectiveDate :
             * ReferralCode : 201512547600
             * QRcode : http://ycty.turuitech
             * .com/Upload/ReferralCode/b2217277-f128-4731-8dbb-fba58209a7fbf0cfd618-0bbc-43e6
             * -9de7-a9540793d3d0.jpg
             * ParentID : 0
             * OpenState : 0
             */

            private String UserID;
            private String AccountName;
            private int AccountType;
            private String AccountTypeName;
            private String AF_Name;
            private String MG_Name;
            private float Cost;
            private String EffectiveDate;
            private String ReferralCode;
            private String QRcode;
            private String ParentID;
            private int OpenState;

            private String DicID_Rank;
            private int ChildCount;

            public String getDicID_Rank() {
                return DicID_Rank;
            }

            public void setDicID_Rank(String dicID_Rank) {
                DicID_Rank = dicID_Rank;
            }

            public int getChildCount() {
                return ChildCount;
            }

            public void setChildCount(int childCount) {
                ChildCount = childCount;
            }

            public String getUserID() {
                return UserID;
            }

            public void setUserID(String UserID) {
                this.UserID = UserID;
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

            public String getAccountTypeName() {
                return AccountTypeName;
            }

            public void setAccountTypeName(String AccountTypeName) {
                this.AccountTypeName = AccountTypeName;
            }

            public String getAF_Name() {
                return AF_Name;
            }

            public void setAF_Name(String AF_Name) {
                this.AF_Name = AF_Name;
            }

            public String getMG_Name() {
                return MG_Name;
            }

            public void setMG_Name(String MG_Name) {
                this.MG_Name = MG_Name;
            }

            public float getCost() {
                return Cost;
            }

            public void setCost(float Cost) {
                this.Cost = Cost;
            }

            public String getEffectiveDate() {
                return EffectiveDate;
            }

            public void setEffectiveDate(String EffectiveDate) {
                this.EffectiveDate = EffectiveDate;
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

            public String getParentID() {
                return ParentID;
            }

            public void setParentID(String ParentID) {
                this.ParentID = ParentID;
            }

            public int getOpenState() {
                return OpenState;
            }

            public void setOpenState(int OpenState) {
                this.OpenState = OpenState;
            }
        }
    }
}
