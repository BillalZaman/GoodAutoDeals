package com.goodautodeal.goodautodeal.respository;

import android.app.Application;
import android.util.ArrayMap;

import androidx.lifecycle.MutableLiveData;

import com.goodautodeal.goodautodeal.ApplicationState;
import com.goodautodeal.goodautodeal.constants.ConstUtils;
import com.goodautodeal.goodautodeal.helpers.PreferenceHelper;
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
                        if (response.getResp().getCode() == ConstUtils.FAILURE) {
                            uiHelper.showLongToastInCenter(application, response.getResp().getMessage());
                        } else {
                            uiHelper.showLongToastInCenter(application, response.getResp().getMessage());
                        }
                    }

                    @Override
                    public void onComplete() {
//                        Toast.makeText(application, "Success" + response.getResp().getMessage(), Toast.LENGTH_SHORT).show();
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
                        if (response.getResp().getCode() == ConstUtils.FAILURE) {
                            uiHelper.showLongToastInCenter(application, response.getResp().getMessage());
                        } else {
                            uiHelper.showLongToastInCenter(application, response.getResp().getMessage());
                        }
                    }

                    @Override
                    public void onComplete() {
//                        Toast.makeText(application, "Success" + response.getResp().getMessage(), Toast.LENGTH_SHORT).show();
                        dataStatus.isLoadingList = false;
                        status.setValue(dataStatus);
                        mainResponseLifeData.setValue(response);

                    }
                }));

        return Observable.just(response);
    }

    public Observable<Response> getChangePassword(String oldPassword, String newPassword) {
        dataStatus.isLoadingList = true;
        status.setValue(dataStatus);

        Map<String, Object> jsonParams = null;
        jsonParams = new ArrayMap<String, Object>();
        jsonParams.put("old_password", oldPassword);
        jsonParams.put("new_password", newPassword);

        RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"),
                (new JSONObject(jsonParams)).toString());
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        mainResponseObservable = apiInterface.getChangePassword("Bearer" + " " +
                        PreferenceHelper.getInstance().getString(ConstUtils.APIAccessToken,"")
                ,body);

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
//                        Toast.makeText(application, "Success" + response.getResp().getMessage(), Toast.LENGTH_SHORT).show();
                        dataStatus.isLoadingList = false;
                        status.setValue(dataStatus);
                        mainResponseLifeData.setValue(response);

                    }
                }));

        return Observable.just(response);
    }

    public Observable<Response> getUser() {
        dataStatus.isLoadingList = true;
        status.setValue(dataStatus);

        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        mainResponseObservable = apiInterface.getUser("Bearer" + " " +
                PreferenceHelper.getInstance().getString(ConstUtils.APIAccessToken,"")
        );

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
                        if (0 == ConstUtils.FAILURE) {
                            uiHelper.showLongToastInCenter(application, "response.getResp().getMessage()");
                        } else {
                            uiHelper.showLongToastInCenter(application, response.getResp().getMessage());
                        }
                    }

                    @Override
                    public void onComplete() {
//                        Toast.makeText(application, "Success" + response.getResp().getMessage(), Toast.LENGTH_SHORT).show();
                        dataStatus.isLoadingList = false;
                        status.setValue(dataStatus);
                        mainResponseLifeData.setValue(response);

                    }
                }));

        return Observable.just(response);
    }

    public Observable<Response> getDealerList() {
        dataStatus.isLoadingList = true;
        status.setValue(dataStatus);

        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        mainResponseObservable = apiInterface.GetDealerList();

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
//                        Toast.makeText(application, "Success" + response.getResp().getMessage(), Toast.LENGTH_SHORT).show();
                        dataStatus.isLoadingList = false;
                        status.setValue(dataStatus);
                        mainResponseLifeData.setValue(response);

                    }
                }));

        return Observable.just(response);
    }

    public Observable<Response> getAdDetail(String ad_id) {
        dataStatus.isLoadingList = true;
        status.setValue(dataStatus);

        Map<String, Object> jsonParams = null;
        jsonParams = new ArrayMap<String, Object>();
        jsonParams.put("ad_id", ad_id);

        RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"),
                (new JSONObject(jsonParams)).toString());

        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        mainResponseObservable = apiInterface.getAdDetail("Bearer" + " " +
                ConstUtils.APIAccessToken , body);

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
                        if (response.getResp().getCode() == 400) {
                            uiHelper.showLongToastInCenter(application, response.getResp().getMessage());
                        } else {
                            uiHelper.showLongToastInCenter(application, response.getResp().getMessage());
                        }
                    }

                    @Override
                    public void onComplete() {
//                        Toast.makeText(application, "Success" + response.getResp().getMessage(), Toast.LENGTH_SHORT).show();
                        dataStatus.isLoadingList = false;
                        status.setValue(dataStatus);
                        mainResponseLifeData.setValue(response);

                    }
                }));

        return Observable.just(response);
    }

    public Observable<Response> getForgotPassword(String email) {
        dataStatus.isLoadingList = true;
        status.setValue(dataStatus);

        Map<String, Object> jsonParams = null;
        jsonParams = new ArrayMap<String, Object>();
        jsonParams.put("email", email);

        RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"),
                (new JSONObject(jsonParams)).toString());

        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        mainResponseObservable = apiInterface.getForgotPassword(body);

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
                        if (response.getResp().getCode() == 400) {
                            uiHelper.showLongToastInCenter(application, response.getResp().getMessage());
                        } else {
                            uiHelper.showLongToastInCenter(application, response.getResp().getMessage());
                        }
                    }

                    @Override
                    public void onComplete() {
//                        Toast.makeText(application, "Success" + response.getResp().getMessage(), Toast.LENGTH_SHORT).show();
                        dataStatus.isLoadingList = false;
                        status.setValue(dataStatus);
                        mainResponseLifeData.setValue(response);

                    }
                }));

        return Observable.just(response);
    }

    public Observable<Response> getOTPVerification(String OTP) {
        dataStatus.isLoadingList = true;
        status.setValue(dataStatus);

        Map<String, Object> jsonParams = null;
        jsonParams = new ArrayMap<String, Object>();
        jsonParams.put("otp", OTP);

        RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"),
                (new JSONObject(jsonParams)).toString());

        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        mainResponseObservable = apiInterface.getOTPVerification("Bearer" + " " +
                PreferenceHelper.getInstance().getString(ConstUtils.APIAccessToken,""), body);

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
//                        Toast.makeText(application, "Success" + response.getResp().getMessage(), Toast.LENGTH_SHORT).show();
                        dataStatus.isLoadingList = false;
                        status.setValue(dataStatus);
                        mainResponseLifeData.setValue(response);

                    }
                }));

        return Observable.just(response);
    }

    public Observable<Response> getUpdateUser(UserInfoModel userInfoModel) {
        dataStatus.isLoadingList = true;
        status.setValue(dataStatus);

        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        mainResponseObservable = apiInterface.getUpdateUser("Bearer" + " " +
                PreferenceHelper.getInstance().getString(ConstUtils.APIAccessToken,""), userInfoModel);

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
//                        Toast.makeText(application, "Success" + response.getResp().getMessage(), Toast.LENGTH_SHORT).show();
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

