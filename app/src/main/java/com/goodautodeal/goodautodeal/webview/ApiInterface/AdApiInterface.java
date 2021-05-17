package com.goodautodeal.goodautodeal.webview.ApiInterface;

import com.goodautodeal.goodautodeal.constants.ConstUtils;
import com.goodautodeal.goodautodeal.webview.response.Response;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Bilal Zaman on 05/05/21.
 */
public interface AdApiInterface {

    @GET(Request.GET_CAR_DETAIL)
    Observable<Response> getCarDetail(@Query("key_VRM") String vrm, @Query("key_VRM") String mileage);

    @GET(Request.VALUE_YOUR_CAR)
    Observable<Response> valueYourCar(@Query("key_VRM") String vrm);

    interface Request {
        String GET_CAR_DETAIL = "VehicleData?v=2&api_nullitems=1&auth_apikey=" + ConstUtils.STAGING_API + "&user_tag=&key_VRM="
                + ConstUtils.VRM;
        String VALUE_YOUR_CAR = "ValuationData?v=2&api_nullitems=1&auth_apikey=" + ConstUtils.STAGING_API + "&user_tag=&key_VRM="
                + ConstUtils.VRM + "&key_mileage=" + ConstUtils.Mileage;
    }
}
