package com.goodautodeal.goodautodeal.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.goodautodeal.goodautodeal.respository.AdPostingRepository;
import com.goodautodeal.goodautodeal.webview.response.Response;

/**
 * Created by Bilal Zaman on 02/04/21.
 */
public class AdPostingViewModel extends AndroidViewModel {
    AdPostingRepository adPostingRepository;
    private MutableLiveData<ViewModelStatus> isLoading;

    public AdPostingViewModel(@NonNull Application application) {
        super(application);
        adPostingRepository = new AdPostingRepository(application);
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

    public void getSliderBanner() {
        adPostingRepository.getSliderBanner();
    }

    public void getPremiumAds() {
        adPostingRepository.getPremiumAds();
    }

    public LiveData<Response> getUserData() {
        return adPostingRepository.getMainResponseLifeData();
    }

    public void clear() {
        adPostingRepository.clear();
    }
}

