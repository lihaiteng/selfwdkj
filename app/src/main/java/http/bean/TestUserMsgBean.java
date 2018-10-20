package http.bean;

/**
 * Created by LiHT on 2017/6/8.
 */

public class TestUserMsgBean {

    /**
     * code : 200
     * datas : {"member_info":{"member_id":"116","cart_count":4,"invite_msg":"请您邀请您的亲朋好友享受世外香格世界，购买全球最佳的健康有机产品，可靠，方便，高信任。按此开始。","user_name":"18367803056","member_email":"ii@Q.com","if_nameserver":0,"count":{"need_pay":0,"need_get":0,"need_send":1,"need_eva":0,"refund":0},"nameserver_info":{"like":"","sex":"","alphabet":"","age":""},"member_sex":0,"voucher_total_price":0,"private_count":"1","avator":"http://washop.turuitech.com/data/upload/shop/common/default_user_portrait.gif","app_download":{"android_code":"http://washop.turuitech.com/data/upload/shop/common/android_code.png","download_url":"http://www.swxiangge.com/wap/download.html","ios_code":"http://washop.turuitech.com/data/upload/shop/common/ios_code.png"},"predepoit":"0.00","member_truename":"哈哈","invite_code":"uuMrlKIUe","stock":"0.0000","msg_count":"0"}}
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
         * member_info : {"member_id":"116","cart_count":4,"invite_msg":"请您邀请您的亲朋好友享受世外香格世界，购买全球最佳的健康有机产品，可靠，方便，高信任。按此开始。","user_name":"18367803056","member_email":"ii@Q.com","if_nameserver":0,"count":{"need_pay":0,"need_get":0,"need_send":1,"need_eva":0,"refund":0},"nameserver_info":{"like":"","sex":"","alphabet":"","age":""},"member_sex":0,"voucher_total_price":0,"private_count":"1","avator":"http://washop.turuitech.com/data/upload/shop/common/default_user_portrait.gif","app_download":{"android_code":"http://washop.turuitech.com/data/upload/shop/common/android_code.png","download_url":"http://www.swxiangge.com/wap/download.html","ios_code":"http://washop.turuitech.com/data/upload/shop/common/ios_code.png"},"predepoit":"0.00","member_truename":"哈哈","invite_code":"uuMrlKIUe","stock":"0.0000","msg_count":"0"}
         */
        private Member_infoEntity member_info;

        public void setMember_info(Member_infoEntity member_info) {
            this.member_info = member_info;
        }

        public Member_infoEntity getMember_info() {
            return member_info;
        }

        public class Member_infoEntity {
            /**
             * member_id : 116
             * cart_count : 4
             * invite_msg : 请您邀请您的亲朋好友享受世外香格世界，购买全球最佳的健康有机产品，可靠，方便，高信任。按此开始。
             * user_name : 18367803056
             * member_email : ii@Q.com
             * if_nameserver : 0
             * count : {"need_pay":0,"need_get":0,"need_send":1,"need_eva":0,"refund":0}
             * nameserver_info : {"like":"","sex":"","alphabet":"","age":""}
             * member_sex : 0
             * voucher_total_price : 0
             * private_count : 1
             * avator : http://washop.turuitech.com/data/upload/shop/common/default_user_portrait.gif
             * app_download : {"android_code":"http://washop.turuitech.com/data/upload/shop/common/android_code.png","download_url":"http://www.swxiangge.com/wap/download.html","ios_code":"http://washop.turuitech.com/data/upload/shop/common/ios_code.png"}
             * predepoit : 0.00
             * member_truename : 哈哈
             * invite_code : uuMrlKIUe
             * stock : 0.0000
             * msg_count : 0
             */
            private String member_id;
            private int cart_count;
            private String invite_msg;
            private String user_name;
            private String member_email;
            private int if_nameserver;
            private CountEntity count;
            private Nameserver_infoEntity nameserver_info;
            private int member_sex;
            private int voucher_total_price;
            private String private_count;
            private String avator;
            private App_downloadEntity app_download;
            private String predepoit;
            private String member_truename;
            private String invite_code;
            private String stock;
            private String msg_count;

            public void setMember_id(String member_id) {
                this.member_id = member_id;
            }

            public void setCart_count(int cart_count) {
                this.cart_count = cart_count;
            }

            public void setInvite_msg(String invite_msg) {
                this.invite_msg = invite_msg;
            }

            public void setUser_name(String user_name) {
                this.user_name = user_name;
            }

            public void setMember_email(String member_email) {
                this.member_email = member_email;
            }

            public void setIf_nameserver(int if_nameserver) {
                this.if_nameserver = if_nameserver;
            }

            public void setCount(CountEntity count) {
                this.count = count;
            }

            public void setNameserver_info(Nameserver_infoEntity nameserver_info) {
                this.nameserver_info = nameserver_info;
            }

            public void setMember_sex(int member_sex) {
                this.member_sex = member_sex;
            }

            public void setVoucher_total_price(int voucher_total_price) {
                this.voucher_total_price = voucher_total_price;
            }

            public void setPrivate_count(String private_count) {
                this.private_count = private_count;
            }

            public void setAvator(String avator) {
                this.avator = avator;
            }

            public void setApp_download(App_downloadEntity app_download) {
                this.app_download = app_download;
            }

            public void setPredepoit(String predepoit) {
                this.predepoit = predepoit;
            }

            public void setMember_truename(String member_truename) {
                this.member_truename = member_truename;
            }

            public void setInvite_code(String invite_code) {
                this.invite_code = invite_code;
            }

            public void setStock(String stock) {
                this.stock = stock;
            }

            public void setMsg_count(String msg_count) {
                this.msg_count = msg_count;
            }

            public String getMember_id() {
                return member_id;
            }

            public int getCart_count() {
                return cart_count;
            }

            public String getInvite_msg() {
                return invite_msg;
            }

            public String getUser_name() {
                return user_name;
            }

            public String getMember_email() {
                return member_email;
            }

            public int getIf_nameserver() {
                return if_nameserver;
            }

            public CountEntity getCount() {
                return count;
            }

            public Nameserver_infoEntity getNameserver_info() {
                return nameserver_info;
            }

            public int getMember_sex() {
                return member_sex;
            }

            public int getVoucher_total_price() {
                return voucher_total_price;
            }

            public String getPrivate_count() {
                return private_count;
            }

            public String getAvator() {
                return avator;
            }

            public App_downloadEntity getApp_download() {
                return app_download;
            }

            public String getPredepoit() {
                return predepoit;
            }

            public String getMember_truename() {
                return member_truename;
            }

            public String getInvite_code() {
                return invite_code;
            }

            public String getStock() {
                return stock;
            }

            public String getMsg_count() {
                return msg_count;
            }

            public class CountEntity {
                /**
                 * need_pay : 0
                 * need_get : 0
                 * need_send : 1
                 * need_eva : 0
                 * refund : 0
                 */
                private int need_pay;
                private int need_get;
                private int need_send;
                private int need_eva;
                private int refund;

                public void setNeed_pay(int need_pay) {
                    this.need_pay = need_pay;
                }

                public void setNeed_get(int need_get) {
                    this.need_get = need_get;
                }

                public void setNeed_send(int need_send) {
                    this.need_send = need_send;
                }

                public void setNeed_eva(int need_eva) {
                    this.need_eva = need_eva;
                }

                public void setRefund(int refund) {
                    this.refund = refund;
                }

                public int getNeed_pay() {
                    return need_pay;
                }

                public int getNeed_get() {
                    return need_get;
                }

                public int getNeed_send() {
                    return need_send;
                }

                public int getNeed_eva() {
                    return need_eva;
                }

                public int getRefund() {
                    return refund;
                }
            }

            public class Nameserver_infoEntity {
                /**
                 * like :
                 * sex :
                 * alphabet :
                 * age :
                 */
                private String like;
                private String sex;
                private String alphabet;
                private String age;

                public void setLike(String like) {
                    this.like = like;
                }

                public void setSex(String sex) {
                    this.sex = sex;
                }

                public void setAlphabet(String alphabet) {
                    this.alphabet = alphabet;
                }

                public void setAge(String age) {
                    this.age = age;
                }

                public String getLike() {
                    return like;
                }

                public String getSex() {
                    return sex;
                }

                public String getAlphabet() {
                    return alphabet;
                }

                public String getAge() {
                    return age;
                }
            }

            public class App_downloadEntity {
                /**
                 * android_code : http://washop.turuitech.com/data/upload/shop/common/android_code.png
                 * download_url : http://www.swxiangge.com/wap/download.html
                 * ios_code : http://washop.turuitech.com/data/upload/shop/common/ios_code.png
                 */
                private String android_code;
                private String download_url;
                private String ios_code;

                public void setAndroid_code(String android_code) {
                    this.android_code = android_code;
                }

                public void setDownload_url(String download_url) {
                    this.download_url = download_url;
                }

                public void setIos_code(String ios_code) {
                    this.ios_code = ios_code;
                }

                public String getAndroid_code() {
                    return android_code;
                }

                public String getDownload_url() {
                    return download_url;
                }

                public String getIos_code() {
                    return ios_code;
                }
            }
        }
    }
}
