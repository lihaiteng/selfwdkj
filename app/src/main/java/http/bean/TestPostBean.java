package http.bean;

/**
 * Created by LiHT on 2017/5/9.
 */

public class TestPostBean {

    /**
     * TEST
     * code : 200
     * datas : {"key":"ce8d7fc192748bbcfb6e8d4043d43d8e","username":"18367803056"}
     */
    private int code;
    private DatasEntity datas;

    public void setCode(int code) {
        this.code = code;
    }

    public void setDatas(DatasEntity datas) {
        this.datas = datas;
    }

    public int getCode() {
        return code;
    }

    public DatasEntity getDatas() {
        return datas;
    }

    public class DatasEntity {
        /**
         * key : ce8d7fc192748bbcfb6e8d4043d43d8e
         * username : 18367803056
         */
        private String key;
        private String username;

        public void setKey(String key) {
            this.key = key;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getKey() {
            return key;
        }

        public String getUsername() {
            return username;
        }
    }
}
