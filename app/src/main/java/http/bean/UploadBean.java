package http.bean;

/**
 * Created by 一脸灬邪气 on 2017/12/8 0008 2017/12/8 0008.
 * HDJY.setBug(null);
 */

public class UploadBean {

    /**
     * Result : 1
     * ShowMsg : 上传成功
     * ErrCode : 0
     * Row : 0
     * Data : {"FileInfo":{"FileName":"1.png","FileType":"png","FileSize":"0.02",
     * "FilePath":"http://hdjy.turuitech
     * .com/Upload/CardPicPositive/2017-12-12/2ea03305-2515-4d22-9c08-022108fb5129.png"}}
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
         * FileInfo : {"FileName":"1.png","FileType":"png","FileSize":"0.02",
         * "FilePath":"http://hdjy.turuitech
         * .com/Upload/CardPicPositive/2017-12-12/2ea03305-2515-4d22-9c08-022108fb5129.png"}
         */

        private FileInfoEntity FileInfo;

        public FileInfoEntity getFileInfo() {
            return FileInfo;
        }

        public void setFileInfo(FileInfoEntity FileInfo) {
            this.FileInfo = FileInfo;
        }

        public static class FileInfoEntity {
            /**
             * FileName : 1.png
             * FileType : png
             * FileSize : 0.02
             * FilePath : http://hdjy.turuitech
             * .com/Upload/CardPicPositive/2017-12-12/2ea03305-2515-4d22-9c08-022108fb5129.png
             */

            private String FileName;
            private String FileType;
            private String FileSize;
            private String FilePath;

            public String getFileName() {
                return FileName;
            }

            public void setFileName(String FileName) {
                this.FileName = FileName;
            }

            public String getFileType() {
                return FileType;
            }

            public void setFileType(String FileType) {
                this.FileType = FileType;
            }

            public String getFileSize() {
                return FileSize;
            }

            public void setFileSize(String FileSize) {
                this.FileSize = FileSize;
            }

            public String getFilePath() {
                return FilePath;
            }

            public void setFilePath(String FilePath) {
                this.FilePath = FilePath;
            }
        }
    }
}
