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

    @GET(Request.VALUE_YOUR_CAR)
    Observable<Response> valueYourCar(@Query("key_VRM") String vrm);

    @GET(Request.GET_CAR_DETAIL)
    Observable<Response> getCarDetail();

    interface Request {
        String VALUE_YOUR_CAR = "ValuationData?v=2&api_nullitems=1&auth_apikey="+ConstUtils.LiveKey+"&user_tag";
        String GET_CAR_DETAIL = ConstUtils.URL + ConstUtils.VRM;
    }
}
