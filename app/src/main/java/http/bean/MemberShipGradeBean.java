package http.bean;

import java.util.List;

/**
 * Created by 一脸灬邪气 on 2017/12/8 0008 2017/12/8 0008.
 * HDJY.setBug(null);
 */

public class MemberShipGradeBean {

    /**
     * Result : 1
     * ShowMsg : 操作成功！
     * ErrCode : 0
     * Row : 0
     * Data : {"List":[{"ID":"4481569b-5fbd-4950-a355-9fda21741ff8","Name":"个人"},
     * {"ID":"f6acbc15-4bd2-4794-aab0-e5a093805fc2","Name":"企业"}]}
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
        private java.util.List<ListEntity> List;

        public List<ListEntity> getList() {
            return List;
        }

        public void setList(List<ListEntity> List) {
            this.List = List;
        }

        public static class ListEntity {
            /**
             * ID : 4481569b-5fbd-4950-a355-9fda21741ff8
             * Name : 个人
             */

            private String ID;
            private String Name;

            public String getID() {
                return ID;
            }

            public void setID(String ID) {
                this.ID = ID;
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
