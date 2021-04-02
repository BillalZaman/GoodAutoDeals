package com.goodautodeal.goodautodeal.webview.ApiInterface;

import com.goodautodeal.goodautodeal.constants.ConstUtils;
import com.goodautodeal.goodautodeal.webview.response.Response;

import io.reactivex.Observable;
import retrofit2.http.GET;


/**
 * Created by Bilal Zaman on 17/02/21.
 */
public interface ApiInterface {
    @GET(Request.VALUE_YOUR_CAR)
    Observable<Response> valueYourCar();

//    "https://uk1.ukvehicledata.co.uk/api/datapackage/ValuationData?v=2&api_nullitems=1&auth_apikey=ac3f0001-4f94-4c53-987c-e481980d4bbd&user_tag=&key_VRM=ap10nbz&key_mileage=30,000"
    interface Request {
        String VALUE_YOUR_CAR = "ValuationData?v=2&api_nullitems=1&auth_apikey=ac3f0001-4f94-4c53-987c-e481980d4bbd&user_tag=&key_VRM=" + ConstUtils.VRM + "&key_mileage=" + ConstUtils.Mileage;
    }
}
