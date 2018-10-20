package http.bean;

import java.util.List;

/**
 * Created by 一脸灬邪气 on 2017/12/8 0008 2017/12/8 0008.
 * HDJY.setBug(null);
 */

public class AdmissionFeeBean {

    /**
     * Result : 1
     * ShowMsg : 操作成功！
     * ErrCode : 0
     * Row : 0
     * Data : {"List":[{"ID":"a87601ce-a95d-4e95-88a4-2d09a1aca2b7","Name":"5W"},
     * {"ID":"2562dee9-4a34-4256-89c8-1559209429e5","Name":"3W"},
     * {"ID":"6714e4ee-682b-4c51-81df-9920ab77b725","Name":"1W"},
     * {"ID":"5221fc89-c4ab-4fc7-8acd-da397f7283bb","Name":"5K"}]}
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
             * ID : a87601ce-a95d-4e95-88a4-2d09a1aca2b7
             * Name : 5W
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
