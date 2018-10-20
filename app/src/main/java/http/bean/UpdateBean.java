package http.bean;

/**
 * Created by liht on 2018/1/23 0023.
 */

public class UpdateBean {

    /**
     * Result : 1
     * ShowMsg : 操作成功！
     * ErrCode : 0
     * Row : 0
     * Data : {"VersionInfo":{"Version":"V1.0.0_test","Description":"安卓测试版本","Updates":"测试第一版",
     * "PackagePath":"/Upload/PackagePath/2018-01-22/55165899-dbaf-41df-a8a3-1313dc703acb.apk",
     * "FileName":"ydjy_v1_0_0.apk","FileSize":"8.56","FileSizef":"8.56MB"}}
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
         * VersionInfo : {"Version":"V1.0.0_test","Description":"安卓测试版本","Updates":"测试第一版",
         * "PackagePath":"/Upload/PackagePath/2018-01-22/55165899-dbaf-41df-a8a3-1313dc703acb
         * .apk","FileName":"ydjy_v1_0_0.apk","FileSize":"8.56","FileSizef":"8.56MB"}
         */

        private VersionInfoEntity VersionInfo;

        public VersionInfoEntity getVersionInfo() {
            return VersionInfo;
        }

        public void setVersionInfo(VersionInfoEntity VersionInfo) {
            this.VersionInfo = VersionInfo;
        }

        public static class VersionInfoEntity {
            /**
             * Version : V1.0.0_test
             * Description : 安卓测试版本
             * Updates : 测试第一版
             * PackagePath : /Upload/PackagePath/2018-01-22/55165899-dbaf-41df-a8a3-1313dc703acb.apk
             * FileName : ydjy_v1_0_0.apk
             * FileSize : 8.56
             * FileSizef : 8.56MB
             */

            private String Version;
            private String Description;
            private String Updates;
            private String PackagePath;
            private String FileName;
            private String FileSize;
            private String FileSizef;

            public String getVersion() {
                return Version;
            }

            public void setVersion(String Version) {
                this.Version = Version;
            }

            public String getDescription() {
                return Description;
            }

            public void setDescription(String Description) {
                this.Description = Description;
            }

            public String getUpdates() {
                return Updates;
            }

            public void setUpdates(String Updates) {
                this.Updates = Updates;
            }

            public String getPackagePath() {
                return PackagePath;
            }

            public void setPackagePath(String PackagePath) {
                this.PackagePath = PackagePath;
            }

            public String getFileName() {
                return FileName;
            }

            public void setFileName(String FileName) {
                this.FileName = FileName;
            }

            public String getFileSize() {
                return FileSize;
            }

            public void setFileSize(String FileSize) {
                this.FileSize = FileSize;
            }

            public String getFileSizef() {
                return FileSizef;
            }

            public void setFileSizef(String FileSizef) {
                this.FileSizef = FileSizef;
            }
        }
    }
}
