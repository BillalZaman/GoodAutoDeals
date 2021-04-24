package com.goodautodeal.goodautodeal.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.goodautodeal.goodautodeal.respository.DealerAdListViewRepository;
import com.goodautodeal.goodautodeal.webview.response.Response;

/**
 * Created by Bilal Zaman on 25/04/21.
 */
public class DealerAdListViewModel extends AndroidViewModel {
    DealerAdListViewRepository dealerViewRepository;
    private MutableLiveData<ViewModelStatus> isLoading;

    public DealerAdListViewModel(@NonNull Application application) {
        super(application);
        dealerViewRepository = new DealerAdListViewRepository(application);
    }

    public MutableLiveData<ViewModelStatus> getIsLoading() {
        return isLoading = dealerViewRepository.getStatus();
    }

    public void getPublishedAd() {
        dealerViewRepository.getPublishedAds();
    }

    public void getPendingAd() {
        dealerViewRepository.getPendingAds();
    }

    public void getRejectedAd() {
        dealerViewRepository.getRejectedAds();
    }

    public void getSoldAds() {
        dealerViewRepository.getSoldAds();
    }

    public void getDraftAds() {
        dealerViewRepository.getDraftAds();
    }

    public LiveData<Response> getUserData() {
        return dealerViewRepository.getMainResponseLifeData();
    }

    public void clear() {
        dealerViewRepository.clear();
    }
}
