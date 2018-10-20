package http.bean;

import java.util.List;

/**
 * Created by 一脸灬邪气 on 2017/12/8 0008 2017/12/8 0008.
 * HDJY.setBug(null);
 */

public class StudentListBean {

    /**
     * Result : 1
     * ShowMsg : 操作成功！
     * ErrCode : 0
     * Row : 0
     * Data : {"TeamList":[{"ID":"2d445645-3c48-4a50-950f-17dc383c67a2",
     * "AccountName":"13222222226","AccountType":3,"AccountTypef":"学员",
     * "MG_ID":"f6acbc15-4bd2-4794-aab0-e5a093805fc2","MG_IDName":"企业",
     * "AF_ID":"dbc3b646-c238-4346-bbed-c08993b5f4c5","AF_IDName":"50W","Cost":500000,
     * "Costf":"500000.00","CardID":"429006197001010202","RealName":"微笑","IsCheck":null,
     * "IsCheckf":"待审核","Child":0}],"PageInfo":{"Rows":2,"page":1,"PageSize":1,"TotalPage":2}}
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
         * TeamList : [{"ID":"2d445645-3c48-4a50-950f-17dc383c67a2","AccountName":"13222222226",
         * "AccountType":3,"AccountTypef":"学员","MG_ID":"f6acbc15-4bd2-4794-aab0-e5a093805fc2",
         * "MG_IDName":"企业","AF_ID":"dbc3b646-c238-4346-bbed-c08993b5f4c5","AF_IDName":"50W",
         * "Cost":500000,"Costf":"500000.00","CardID":"429006197001010202","RealName":"微笑",
         * "IsCheck":null,"IsCheckf":"待审核","Child":0}]
         * PageInfo : {"Rows":2,"page":1,"PageSize":1,"TotalPage":2}
         */

        private PageInfoEntity PageInfo;
        private List<TeamListEntity> TeamList;

        public PageInfoEntity getPageInfo() {
            return PageInfo;
        }

        public void setPageInfo(PageInfoEntity PageInfo) {
            this.PageInfo = PageInfo;
        }

        public List<TeamListEntity> getTeamList() {
            return TeamList;
        }

        public void setTeamList(List<TeamListEntity> TeamList) {
            this.TeamList = TeamList;
        }

        public static class PageInfoEntity {
            /**
             * Rows : 2
             * page : 1
             * PageSize : 1
             * TotalPage : 2
             */

            private int Rows;
            private int page;
            private int PageSize;
            private int TotalPage;

            public int getRows() {
                return Rows;
            }

            public void setRows(int Rows) {
                this.Rows = Rows;
            }

            public int getPage() {
                return page;
            }

            public void setPage(int page) {
                this.page = page;
            }

            public int getPageSize() {
                return PageSize;
            }

            public void setPageSize(int PageSize) {
                this.PageSize = PageSize;
            }

            public int getTotalPage() {
                return TotalPage;
            }

            public void setTotalPage(int TotalPage) {
                this.TotalPage = TotalPage;
            }
        }

        public static class TeamListEntity {
            /**
             * ID : 2d445645-3c48-4a50-950f-17dc383c67a2
             * AccountName : 13222222226
             * AccountType : 3
             * AccountTypef : 学员
             * MG_ID : f6acbc15-4bd2-4794-aab0-e5a093805fc2
             * MG_IDName : 企业
             * AF_ID : dbc3b646-c238-4346-bbed-c08993b5f4c5
             * AF_IDName : 50W
             * Cost : 500000
             * Costf : 500000.00
             * CardID : 429006197001010202
             * RealName : 微笑
             * IsCheck : null
             * IsCheckf : 待审核
             * Child : 0
             */

            private String ID;
            private String AccountName;
            private int AccountType;
            private String AccountTypef;
            private String MG_ID;
            private String MG_IDName;
            private String AF_ID;
            private String AF_IDName;
            private float Cost;
            private String Costf;
            private String CardID;
            private String RealName;
            private Object IsCheck;
            private String IsCheckf;
            private int Child;

            public String getID() {
                return ID;
            }

            public void setID(String ID) {
                this.ID = ID;
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

            public String getMG_ID() {
                return MG_ID;
            }

            public void setMG_ID(String MG_ID) {
                this.MG_ID = MG_ID;
            }

            public String getMG_IDName() {
                return MG_IDName;
            }

            public void setMG_IDName(String MG_IDName) {
                this.MG_IDName = MG_IDName;
            }

            public String getAF_ID() {
                return AF_ID;
            }

            public void setAF_ID(String AF_ID) {
                this.AF_ID = AF_ID;
            }

            public String getAF_IDName() {
                return AF_IDName;
            }

            public void setAF_IDName(String AF_IDName) {
                this.AF_IDName = AF_IDName;
            }

            public float getCost() {
                return Cost;
            }

            public void setCost(int Cost) {
                this.Cost = Cost;
            }

            public String getCostf() {
                return Costf;
            }

            public void setCostf(String Costf) {
                this.Costf = Costf;
            }

            public String getCardID() {
                return CardID;
            }

            public void setCardID(String CardID) {
                this.CardID = CardID;
            }

            public String getRealName() {
                return RealName;
            }

            public void setRealName(String RealName) {
                this.RealName = RealName;
            }

            public Object getIsCheck() {
                return IsCheck;
            }

            public void setIsCheck(Object IsCheck) {
                this.IsCheck = IsCheck;
            }

            public String getIsCheckf() {
                return IsCheckf;
            }

            public void setIsCheckf(String IsCheckf) {
                this.IsCheckf = IsCheckf;
            }

            public int getChild() {
                return Child;
            }

            public void setChild(int Child) {
                this.Child = Child;
            }
        }
    }
}
