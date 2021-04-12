package com.goodautodeal.goodautodeal.respository;

import android.app.Application;
import android.util.ArrayMap;

import androidx.lifecycle.MutableLiveData;

import com.goodautodeal.goodautodeal.ApplicationState;
import com.goodautodeal.goodautodeal.constants.ConstUtils;
import com.goodautodeal.goodautodeal.helpers.UIHelper;
import com.goodautodeal.goodautodeal.viewmodels.ViewModelStatus;
import com.goodautodeal.goodautodeal.views.models.UserInfoModel;
import com.goodautodeal.goodautodeal.webview.ApiClient;
import com.goodautodeal.goodautodeal.webview.ApiInterface.ApiInterface;
import com.goodautodeal.goodautodeal.webview.response.Response;

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
 * Created by Bilal Zaman on 12/04/21.
 */
public class UserRepository {
    private final Application application;
    private final MutableLiveData<ViewModelStatus> status;
    private final ViewModelStatus dataStatus;
    private final CompositeDisposable compositeDisposable = new CompositeDisposable();
    @Inject
    UIHelper uiHelper;
    Response response;
    private Observable<Response> mainResponseObservable;
    private MutableLiveData<Response> mainResponseLifeData = new MutableLiveData<>();


    public UserRepository(Application application) {
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

//    public Observable<Response> getRegister(String _email, String _password, String _name,
//                                         String _city, String _postcode, String _cellno,
//                                         String address) {

    public Observable<Response> getRegister(UserInfoModel userInfoModel) {
        dataStatus.isLoadingList = true;
        status.setValue(dataStatus);

//        Map<String, Object> jsonParams = null;
//        jsonParams = new ArrayMap<String, Object>();
//        jsonParams.put("email", _email);
//        jsonParams.put("name", _name);
//        jsonParams.put("password", _password);
//        jsonParams.put("city", _city);
//        jsonParams.put("post_cody", _postcode);
//        jsonParams.put("cell_no", _cellno);
//        jsonParams.put("address", address);

//        RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"),
//                (new JSONObject(jsonParams)).toString());
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        mainResponseObservable = apiInterface.getRegister(userInfoModel);

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
                        if (response.getCode() == ConstUtils.FAILURE) {
                            uiHelper.showLongToastInCenter(application, response.getMessage());
                        } else {
                            uiHelper.showLongToastInCenter(application, response.getMessage());
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

    public Observable<Response> getLogin(String _email, String _password) {
        dataStatus.isLoadingList = true;
        status.setValue(dataStatus);

        Map<String, Object> jsonParams = null;
        jsonParams = new ArrayMap<String, Object>();
        jsonParams.put("email", _email);
        jsonParams.put("password", _password);

        RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"),
                (new JSONObject(jsonParams)).toString());
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        mainResponseObservable = apiInterface.getLogin(body);

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
                        if (response.getCode() == ConstUtils.FAILURE) {
                            uiHelper.showLongToastInCenter(application, response.getMessage());
                        } else {
                            uiHelper.showLongToastInCenter(application, response.getMessage());
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
