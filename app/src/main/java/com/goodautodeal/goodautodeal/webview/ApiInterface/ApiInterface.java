package com.goodautodeal.goodautodeal.webview.ApiInterface;

import com.goodautodeal.goodautodeal.constants.ConstUtils;
import com.goodautodeal.goodautodeal.views.models.UserInfoModel;
import com.goodautodeal.goodautodeal.webview.response.Response;
import com.google.android.gms.auth.api.Auth;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;


/**
 * Created by Bilal Zaman on 17/02/21.
 */
public interface ApiInterface {

    @POST(Request.LOGIN)
    Observable<Response> getLogin(@Body RequestBody body);

    @POST(Request.REGISTER)
    Observable<Response> getRegister(@Body UserInfoModel body);

    @GET(Request.GET_USER)
    Observable<Response> getUser(@Header("Authorization") String authkey);

    @GET(Request.SLIDER_BANNER)
    Observable<Response> getSlider();

    @GET(Request.PREMIUM_ADS)
    Observable<Response> getPremiumAds();

    @GET(Request.NEW_CAR)
    Observable<Response> getNewCar();

    @GET(Request.USED_CAR)
    Observable<Response> getUsedCar();

    @POST(Request.CHANGE_PASSWORD)
    Observable<Response> getChangePassword(@Header("Authorization") String authkey, @Body RequestBody body);

    @GET(Request.DEALER_LIST)
    Observable<Response> GetDealerList();

    @POST(Request.Ad_view)
    Observable<Response> getAdDetail(@Body RequestBody body);

    @POST(Request.GET_FORGOT_PASSWORD)
    Observable<Response> getForgotPassword(@Body RequestBody body);

    @POST(Request.OTP_verification)
    Observable<Response> getOTPVerification(@Header("Authorization") String authkey, @Body RequestBody body);

    @POST(Request.UPDATE_USER)
    Observable<Response> getUpdateUser(@Header("Authorization") String authkey, @Body UserInfoModel userInfoModel);

    @GET(Request.LOGOUT)
    Observable<Response> getLogout(@Header("Authorization") String authkey);

    @GET(Request.DEALER_PROFILE)
    Observable<Response> getDealerProfile(@Header("Authorization") String authkey);

    @GET(Request.DEALER_DASHBOARD)
    Observable<Response> getDealerDashboardData(@Header("Authorization") String authkey);

    @POST(Request.CONTACT_US)
    Observable<Response> getContactUs(@Header("Authorization") String authkey, @Body RequestBody body);

    @GET(Request.DEALER_PUBLISHED_AD)
    Observable<Response> getDealerPublishedAds(@Header("Authorization") String authkey);

    @GET(Request.DEALER_PENDING_AD)
    Observable<Response> getDealerPendingAds(@Header("Authorization") String authkey);

    @GET(Request.DEALER_REJECTED_AD)
    Observable<Response> getDealerRejectedAds(@Header("Authorization") String authkey);

    @GET(Request.DEALER_SOLD_AD)
    Observable<Response> getDealerSoldAds(@Header("Authorization") String authkey);

    @GET(Request.DEALER_DRAFT_AD)
    Observable<Response> getDealerDraftAds(@Header("Authorization") String authkey);

    @POST(Request.VRM_DUPLICATION)
    Observable<Response> getVRMDuplication(@Header("Authorization") String authkey, @Body RequestBody body);

    interface Request {
        String LOGIN = "login";
        String REGISTER = "register";
        String GET_USER = "user";
        String SLIDER_BANNER = "slider/banners";
        String PREMIUM_ADS = "premimum/ads";
        String NEW_CAR = "new/cars";
        String USED_CAR = "used/cars";
        String CHANGE_PASSWORD = "user/change_password";
        String DEALER_LIST = "dealers/list";
        String Ad_view = "ad/view";
        String GET_FORGOT_PASSWORD = "user/forgot/password";
        String OTP_verification = "user/email/verification_otp";
        String UPDATE_USER = "user/update";
        String LOGOUT = "logout";
        String DEALER_PROFILE = "dealer";
        String DEALER_DASHBOARD = "dealer/dashboard";
        String CONTACT_US = "contact";
        String DEALER_PUBLISHED_AD = "dealer/published/ads";
        String DEALER_PENDING_AD = "dealer/pending/ads";
        String DEALER_REJECTED_AD = "dealer/rejected/ads";
        String DEALER_SOLD_AD = "dealer/sold/ads";
        String DEALER_DRAFT_AD = "dealer/draft/ads";
        String VRM_DUPLICATION = "ad/vrm_exist/check";
    }
}
