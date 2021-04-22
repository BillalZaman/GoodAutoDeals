package com.goodautodeal.goodautodeal.respository;

import android.app.Application;

import androidx.lifecycle.MutableLiveData;

import com.goodautodeal.goodautodeal.ApplicationState;
import com.goodautodeal.goodautodeal.constants.ConstUtils;
import com.goodautodeal.goodautodeal.helpers.PreferenceHelper;
import com.goodautodeal.goodautodeal.helpers.UIHelper;
import com.goodautodeal.goodautodeal.viewmodels.ViewModelStatus;
import com.goodautodeal.goodautodeal.webview.ApiClient;
import com.goodautodeal.goodautodeal.webview.ApiInterface.ApiInterface;
import com.goodautodeal.goodautodeal.webview.response.Response;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Bilal Zaman on 22/04/21.
 */
public class DealerViewRepository {
    private final Application application;
    private final MutableLiveData<ViewModelStatus> status;
    private final ViewModelStatus dataStatus;
    private final CompositeDisposable compositeDisposable = new CompositeDisposable();
    @Inject
    UIHelper uiHelper;
    Response response;
    private Observable<Response> mainResponseObservable;
    private MutableLiveData<Response> mainResponseLifeData = new MutableLiveData<>();

    public DealerViewRepository(Application application) {
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

    public Observable<Response> getDealerProfile() {
        dataStatus.isLoadingList = true;
        status.setValue(dataStatus);

        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        mainResponseObservable = apiInterface.getDealerProfile("Bearer" + " " +
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


    public void clear() {
        compositeDisposable.clear();
    }
}
