package http.retrofit.base;

import java.util.Map;

import http.bean.AddAccountTypeBean;
import http.bean.AddUserBean;
import http.bean.AdmissionFeeBean;
import http.bean.ApplayRetreatBean;
import http.bean.ChangePwdBean;
import http.bean.GetChildTotalBean;
import http.bean.GetCustomTelBean;
import http.bean.GetPayOrderBean;
import http.bean.GetUserBean;
import http.bean.InformationBean;
import http.bean.LoginBean;
import http.bean.MemberBean;
import http.bean.MemberShipGradeBean;
import http.bean.PayBean;
import http.bean.SaveInfomationBean;
import http.bean.StudentListBean;
import http.bean.TeamListBean;
import http.bean.TestGetBean;
import http.bean.TestPostBean;
import http.bean.TestUserMsgBean;
import http.bean.UpdateBean;
import http.bean.UploadBean;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Query;
import retrofit2.http.Streaming;
import retrofit2.http.Url;
import rx.Observable;

/**
 * Created by LiHT on 2017/5/9.
 */

public interface IHttpService {

//    String HOST = "http://washop.turuitech.com/";
//
    @FormUrlEncoded
    @POST("mobile/index.php?act=login&op=index")
    Call<TestPostBean> getPostBean(@Field("username") String username, @Field("password") String password, @Field("client") String client);

    @GET("mobile/index.php")
    Call<TestGetBean> getGetBean(@Query("act") String act, @Query("op") String version);

    @FormUrlEncoded
    @POST("mobile/index.php?act=login&op=index")
    Observable<TestPostBean> getPostBeanO(@Field("username") String username, @Field("password") String password, @Field("client") String client);

    @GET("mobile/index.php")
    Observable<TestGetBean> getGetBeanO(@Query("act") String act, @Query("op") String version);

    @GET(" mobile/index.php?act=member_index")
    Observable<TestUserMsgBean> getGerUserMsg(@Query("key") String key);

    /**
     * 文件上传部分待验证
     * **/
    //上传单个文件
    @Multipart
    @POST("upload")
    Call<ResponseBody> uploadFile(@Part("description") RequestBody description, @Part MultipartBody.Part file);

    // 上传定数多个文件
    @Multipart
    @POST("upload")
    Call<ResponseBody> uploadMultipleFiles(@Part("description") RequestBody description, @Part MultipartBody.Part file1, @Part MultipartBody.Part file2);

    // 上传不定数多个文件
    @Multipart
    @POST("upload")
    Call<ResponseBody> uploadMultipleFiles2(@Part("description") RequestBody description, @PartMap() Map<String, MultipartBody.Part> maps);

    //下载文件 OK
//    @Streaming //大文件时要加不然会OOM
//    @GET
//    Observable<ResponseBody> downloadFile(@Url String fileUrl);

    /**
     *
     *
     * ****************************************************************************************************
     */

    //http://hdjy.turuitech.com/API_Public/Login/UserLogin?apikey=HDJY_2017&apisecret
    // =DF9D3F208EAC60B2C19E5F1650F8BFF2
    //HDJY
    //String HOST = "http://hdjy.turuitech.com/";
    String HOST = "http://www.chinaydedu.com/";
    //获取客服电话接口
    @FormUrlEncoded
    @POST("API_Public/Login/GetCustomerService")
    Observable<GetCustomTelBean> GetCustomTel(@Field("atLeastOne") int atLeastOne);

    //登入接口
    @FormUrlEncoded
    @POST("API_Public/Login/UserLogin")
    Observable<LoginBean> Login(@Field("AccountName") String accountName,
                                @Field("ComparePassword") String comparePassword,
                                @Field("TerminalType") String terminalType);

    //获取用户信息接口
    @FormUrlEncoded
    @POST("API_Public/User/GetUser")
    Observable<GetUserBean> GetUser(@Field("atLeastOne") int atLeastOne);

    //获取用户基本信息接口
    @FormUrlEncoded
    @POST("API_Public/User/GetUserDetailInfo")
    Observable<InformationBean> Infomation(@Field("atLeastOne") int atLeastOne);

    //保存用户基本信息
    @FormUrlEncoded
    @POST("API_Public/User/SaveUserDetailInfo")
    Observable<SaveInfomationBean> SaveInfomation(
            @Field("Tel") String Tel,
            @Field("UserDetailID") String UserDetailID,
            @Field("RealName") String RealName,
            @Field("CardID") String CardID,
            @Field("TeachingAddress") String TeachingAddress,
            @Field("BusinessLicenseNo") String BusinessLicenseNo,
            @Field("CardPicPositive") String CardPicPositive,
            @Field("CardPicOpposite") String CardPicOpposite,
            @Field("BusinessLicensePic") String BusinessLicensePic,
            @Field("RentalAgreement") String RentalAgreement
    );

    //上传图片
    @Multipart
    @POST("API_Public/PostFile/PostFile")
    Observable<UploadBean> UploadImg(@PartMap Map<String, RequestBody> map, @Part MultipartBody.Part img);

    //获取会员信息接口
    @FormUrlEncoded
    @POST("API_Public/User/GetUserInfo")
    Observable<MemberBean> MemberInfo(@Field("atLeastOne") int atLeastOne);

    //获取团队列表接口
    @FormUrlEncoded
    @POST("API_Public/User/GetUserTeamsPaging")
    Observable<TeamListBean> TeamList(@Field("page") int
                                              page, @Field("PageSize") int pagesize, @Field("UserID") String userId);

    //获取下线已经总金额接口
    @FormUrlEncoded
    @POST("API_Public/User/GetUserChildTotal")
    Observable<GetChildTotalBean> GetChildTotal(@Field("UserID") String UserID);

    //获取学员列表接口
    @FormUrlEncoded
    @POST("API_Public/User/GetUserStudentsPaging")
    Observable<StudentListBean> StudentList(@Field("page") int
                                                    page, @Field("PageSize") int pagesize, @Field("UserID") String userId);

    //修改密码接口
    @FormUrlEncoded
    @POST("API_Public/User/ChangePass")
    Observable<ChangePwdBean> ChangePass(@Field("AccountName") String userName, @Field("OriginalPass") String oldPwd,
                                         @Field("NewPass") String newPass, @Field("ComparePass") String new2Pwd);

    //新增团员接口
    @FormUrlEncoded
    @POST(" API_Public/User/AddUser")
    Observable<AddUserBean> AddUser(@Field("RealName") String realName,
                                    @Field("Tel") String phone,
                                    @Field("Pass") String pass,
                                    @Field("CardID") String cardId,
                                    @Field("AccountType") String memberType,
                                    @Field("MG_ID") String mgId,
                                    @Field("AF_ID") String adId);

    //申请退会
    @FormUrlEncoded
    @POST("API_Public/User/SubmitApplyForRenunciation")
    Observable<ApplayRetreatBean> ApplayRetreat(@Field("atLeastOne") int atLeastOne);

    //获取新增团员类型接口
    @FormUrlEncoded
    @POST("API_Public/User/GetUserAddAccountType")
    Observable<AddAccountTypeBean> GetAccountType(@Field("atLeastOne") int atLeastOne);

    //获取会员等级接口
    @FormUrlEncoded
    @POST("API_Public/MembershipDues/GetMembershipGrade")
    Observable<MemberShipGradeBean> GetMembershipGrade(@Field("atLeastOne") int atLeastOne);

    //获取会费等级接口
    @FormUrlEncoded
    @POST("API_Public/MembershipDues/GetAdmissionFee")
    Observable<AdmissionFeeBean> GetAdmissionFee(@Field("MG_ID") String mgId);

    //获取订单接口
    @FormUrlEncoded
    @POST("API_Public/User/GetUserOrder")
    Observable<GetPayOrderBean> GetPayOrder(@Field("atLeastOne") int atLeastOne);

    //支付信息更新接口
    @FormUrlEncoded
    @POST("API_Public/Pay/GetPayParam")
    Observable<PayBean> Pay(@Field("CardPicPositive") String CardPicPositive,
                            @Field("CardPicOpposite") String CardPicOpposite,
                            @Field("BusinessLicensePic") String BusinessLicensePic,
                            @Field("BusinessLicenseNo") String BusinessLicenseNo,
                            @Field("TeachingAddress") String TeachingAddress,
                            @Field("paymentType") String paymentType,
                            @Field("IsUpdateUserInfo") Boolean IsUpdateUserInfo,
                            @Field("terminalType") String terminalType,
                            @Field("RentalAgreement") String RentalAgreement);

    //更新接口
    @FormUrlEncoded
    @POST("API_Public/Version/CheckTheUpdate")
    Observable<UpdateBean> CheckUpdate(@Field("PackageType") String type);

    //下载apk文件
    @Streaming //大文件时要加不然会OOM
    @GET
    Observable<ResponseBody> downloadFile(@Url String fileUrl);
}
