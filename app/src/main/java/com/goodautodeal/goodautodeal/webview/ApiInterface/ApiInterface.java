package com.goodautodeal.goodautodeal.webview.ApiInterface;

import com.goodautodeal.goodautodeal.constants.ConstUtils;
import com.goodautodeal.goodautodeal.views.models.UserInfoModel;
import com.goodautodeal.goodautodeal.webview.response.Response;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
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

    @POST(Request.GET_USER)
    Observable<Response> getUser(@Body Request body);

    @GET(Request.VALUE_YOUR_CAR)
    Observable<Response> valueYourCar();

    @GET(Request.GET_CAR_DETAIL)
    Observable<Response> getCarDetail();

    @GET(Request.SLIDER_BANNER)
    Observable<Response> getSlider();

    @GET(Request.PREMIUM_ADS)
    Observable<Response> getPremiumAds();

    interface Request {
        String LOGIN = "login";
        String REGISTER = "register";
        String GET_USER = "user";
        String VALUE_YOUR_CAR = "ValuationData?v=2&api_nullitems=1&auth_apikey=ac3f0001-4f94-4c53-987c-e481980d4bbd&user_tag=&key_VRM=" + ConstUtils.VRM + "&key_mileage=" + ConstUtils.Mileage;
        String GET_CAR_DETAIL = "VehicleData?v=2&api_nullitems=1&auth_apikey=ac3f0001-4f94-4c53-987c-e481980d4bbd&user_tag=&key_VRM=" + ConstUtils.VRM;
        String SLIDER_BANNER = "slider/banners";
        String PREMIUM_ADS = "premimum/ads";
    }
}
