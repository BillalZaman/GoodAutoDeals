package com.goodautodeal.goodautodeal.respository;

import android.app.Application;
import android.util.ArrayMap;

import androidx.lifecycle.MutableLiveData;

import com.goodautodeal.goodautodeal.ApplicationState;
import com.goodautodeal.goodautodeal.constants.ConstUtils;
import com.goodautodeal.goodautodeal.helpers.PreferenceHelper;
import com.goodautodeal.goodautodeal.helpers.UIHelper;
import com.goodautodeal.goodautodeal.viewmodels.ViewModelStatus;
import com.goodautodeal.goodautodeal.webview.ApiInterface.AdApiInterface;
import com.goodautodeal.goodautodeal.webview.response.Response;
import com.goodautodeal.goodautodeal.webview.SellApiClient;

import org.json.JSONObject;

import java.util.Map;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import okhttp3.RequestBody;

/**
 * Created by Bilal Zaman on 05/05/21.
 */
public class SellAdPostingRepo {
    private final Application application;
    private final MutableLiveData<ViewModelStatus> status;
    private final ViewModelStatus dataStatus;
    private final CompositeDisposable compositeDisposable = new CompositeDisposable();
    @Inject
    UIHelper uiHelper;
    Response response;
    private Observable<Response> mainResponseObservable;
    private MutableLiveData<Response> mainResponseLifeData = new MutableLiveData<>();


    public SellAdPostingRepo(Application application) {
        this.application = application;
        status = new MutableLiveData<>();
        dataStatus = new ViewModelStatus();
        ApplicationState.getApp().getApplicationComponent().injectUIHelper(this);

        response = new Response();
    }

    public MutableLiveData<ViewModelStatus> getStatus() {
        return status;
    }

    public MutableLiveData<Response> getMainResponseLifeData() {
        return mainResponseLifeData;
    }

    public Observable<Response> getCarDetail() {
        dataStatus.isLoadingList = true;
        status.setValue(dataStatus);

//        Map<String, Object> jsonParams = null;
//        jsonParams = new ArrayMap<String, Object>();
//        jsonParams.put("key_VRM", PreferenceHelper.getInstance().getString(ConstUtils.VRM,""));
//
//        RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"),
//                (new JSONObject(jsonParams)).toString());

        AdApiInterface apiInterface = SellApiClient.getValueYourCarClient().create(AdApiInterface.class);
        mainResponseObservable = apiInterface.getCarDetail(PreferenceHelper.getInstance().getString(ConstUtils.VRM,""));

        mainResponseLifeData = new MutableLiveData<>();
        compositeDisposable.add(mainResponseObservable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<Response>() {
                    @Override
                    public void onNext(Response _response) {
                        response = _response;

                    }

                    @Override
                    public void onError(Throwable e) {
                        dataStatus.isLoadingList = false;
                        status.setValue(dataStatus);
                    }

                    @Override
                    public void onComplete() {
//                        Toast.makeText(application, "Success" + response.getMessage(), Toast.LENGTH_SHORT).show();
                        dataStatus.isLoadingList = false;
                        status.setValue(dataStatus);
                        mainResponseLifeData.setValue(response);

                    }
                }));

        return Observable.just(response);
    }

    public Observable<Response> valueYourCar() {
        dataStatus.isLoadingList = true;
        status.setValue(dataStatus);

        Map<String, Object> jsonParams = null;
        jsonParams = new ArrayMap<String, Object>();
//        jsonParams.put("key_VRM", PreferenceHelper.getInstance().getString(ConstUtils.VRM,""));
//        jsonParams.put("key_mileage", 30000);


        RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"),
                (new JSONObject(jsonParams)).toString());

        AdApiInterface apiInterface = SellApiClient.getValueYourCarClient().create(AdApiInterface.class);
        mainResponseObservable = apiInterface.valueYourCar(
                PreferenceHelper.getInstance().getString(ConstUtils.VRM,""),
                PreferenceHelper.getInstance().getString(ConstUtils.Mileage,""));

        mainResponseLifeData = new MutableLiveData<>();
        compositeDisposable.add(mainResponseObservable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<Response>() {
                    @Override
                    public void onNext(Response _response) {
                        response = _response;

                    }

                    @Override
                    public void onError(Throwable e) {
                        dataStatus.isLoadingList = false;
                        status.setValue(dataStatus);
                        if (response.getResp().getCode() == ConstUtils.FAILURE) {
                            uiHelper.showLongToastInCenter(application, response.getResp().getMessage());
                        } else {
                            uiHelper.showLongToastInCenter(application, response.getResp().getMessage());
                        }
                    }

                    @Override
                    public void onComplete() {
//                        Toast.makeText(application, "Success" + response.getMessage(), Toast.LENGTH_SHORT).show();
                        dataStatus.isLoadingList = false;
                        status.setValue(dataStatus);
                        mainResponseLifeData.setValue(response);

                    }
                }));

        return Observable.just(response);
    }

    public void clear() {
        compositeDisposable.clear();
    }
}
