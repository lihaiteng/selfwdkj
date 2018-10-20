package http.bean;

import java.util.List;

/**
 * Created by 一脸灬邪气 on 2017/12/7 0007 2017/12/7 0007.
 * WDKJ.setBug(null);
 */

public class InformationBean {

    /**
     * Result : 1
     * ShowMsg : 操作成功！
     * ErrCode : 0
     * Row : 0
     * Data : {"UserDetailInfo":{"UserDetailID":"037ff505-1062-4ebd-82ac-4a0cdce0630f",
     * "RealName":"可可","Tel":"","CardID":"429006198001010101","CardPicPositive":"",
     * "CardPicOpposite":"","BusinessLicenseNo":"","BusinessLicensePic":"","TeachingAddress":"",
     * "IsCheck":2}}
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
         * UserDetailInfo : {"UserDetailID":"037ff505-1062-4ebd-82ac-4a0cdce0630f",
         * "RealName":"可可","Tel":"","CardID":"429006198001010101","CardPicPositive":"",
         * "CardPicOpposite":"","BusinessLicenseNo":"","BusinessLicensePic":"",
         * "TeachingAddress":"","IsCheck":2}
         */

        private UserDetailInfoEntity UserDetailInfo;

        public UserDetailInfoEntity getUserDetailInfo() {
            return UserDetailInfo;
        }

        public void setUserDetailInfo(UserDetailInfoEntity UserDetailInfo) {
            this.UserDetailInfo = UserDetailInfo;
        }

        public static class UserDetailInfoEntity {
            /**
             * UserDetailID : 037ff505-1062-4ebd-82ac-4a0cdce0630f
             * RealName : 可可
             * Tel :
             * CardID : 429006198001010101
             * CardPicPositive :
             * CardPicOpposite :
             * BusinessLicenseNo :
             * BusinessLicensePic :
             * TeachingAddress :
             * IsCheck : 2
             */

            private String UserDetailID;
            private String RealName;
            private String Tel;
            private String CardID;
            private String CardPicPositive;
            private String CardPicOpposite;
            private String BusinessLicenseNo;
            private String BusinessLicensePic;
            private String TeachingAddress;
            private int IsCheck;
            private List<String> RentalAgreementlist;

            public List<String> getRentalAgreementlist() {
                return RentalAgreementlist;
            }

            public void setRentalAgreementlist(List<String> rentalAgreementlist) {
                RentalAgreementlist = rentalAgreementlist;
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

            public String getCardPicPositive() {
                return CardPicPositive;
            }

            public void setCardPicPositive(String CardPicPositive) {
                this.CardPicPositive = CardPicPositive;
            }

            public String getCardPicOpposite() {
                return CardPicOpposite;
            }

            public void setCardPicOpposite(String CardPicOpposite) {
                this.CardPicOpposite = CardPicOpposite;
            }

            public String getBusinessLicenseNo() {
                return BusinessLicenseNo;
            }

            public void setBusinessLicenseNo(String BusinessLicenseNo) {
                this.BusinessLicenseNo = BusinessLicenseNo;
            }

            public String getBusinessLicensePic() {
                return BusinessLicensePic;
            }

            public void setBusinessLicensePic(String BusinessLicensePic) {
                this.BusinessLicensePic = BusinessLicensePic;
            }

            public String getTeachingAddress() {
                return TeachingAddress;
            }

            public void setTeachingAddress(String TeachingAddress) {
                this.TeachingAddress = TeachingAddress;
            }

            public int getIsCheck() {
                return IsCheck;
            }

            public void setIsCheck(int IsCheck) {
                this.IsCheck = IsCheck;
            }
        }
    }
}
