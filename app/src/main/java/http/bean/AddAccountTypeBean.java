package http.bean;

import java.util.List;

/**
 * Created by 一脸灬邪气 on 2017/12/8 0008 2017/12/8 0008.
 * HDJY.setBug(null);
 */

public class AddAccountTypeBean {

    /**
     * Result : 1
     * ShowMsg : 操作成功！
     * ErrCode : 0
     * Row : 0
     * Data : {"TeamList":[{"Value":1,"Name":"合股人"},{"Value":2,"Name":"合资人"}]}
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
        private List<TeamListEntity> TeamList;

        public List<TeamListEntity> getTeamList() {
            return TeamList;
        }

        public void setTeamList(List<TeamListEntity> TeamList) {
            this.TeamList = TeamList;
        }

        public static class TeamListEntity {
            /**
             * Value : 1
             * Name : 合股人
             */

            private int Value;
            private String Name;

            public int getValue() {
                return Value;
            }

            public void setValue(int Value) {
                this.Value = Value;
            }

            public String getName() {
                return Name;
            }

            public void setName(String Name) {
                this.Name = Name;
            }
        }
    }
}
