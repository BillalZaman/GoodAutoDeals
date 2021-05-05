package com.goodautodeal.goodautodeal.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.goodautodeal.goodautodeal.respository.SellAdPostingRepo;
import com.goodautodeal.goodautodeal.webview.response.Response;

/**
 * Created by Bilal Zaman on 05/05/21.
 */
public class SellViewModel extends AndroidViewModel {
    SellAdPostingRepo adPostingRepository;
    private MutableLiveData<ViewModelStatus> isLoading;

    public SellViewModel(@NonNull Application application) {
        super(application);
        adPostingRepository = new SellAdPostingRepo(application);
    }

    public MutableLiveData<ViewModelStatus> getIsLoading() {
        return isLoading = adPostingRepository.getStatus();
    }

    public void getCarDetail() {
        adPostingRepository.getCarDetail();
    }

    public void getValueYourCar() {
        adPostingRepository.valueYourCar();
    }

    public LiveData<Response> getUserData() {
        return adPostingRepository.getMainResponseLifeData();
    }

    public void clear() {
        adPostingRepository.clear();
    }
}
