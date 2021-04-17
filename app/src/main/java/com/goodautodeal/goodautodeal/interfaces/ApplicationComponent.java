package com.goodautodeal.goodautodeal.interfaces;

import com.goodautodeal.goodautodeal.respository.AdPostingRepository;
import com.goodautodeal.goodautodeal.respository.UserRepository;
import com.goodautodeal.goodautodeal.views.activities.AdsManagementActivity;
import com.goodautodeal.goodautodeal.views.activities.CarViewAdListingActivity;
import com.goodautodeal.goodautodeal.views.activities.ChangePasswordActivity;
import com.goodautodeal.goodautodeal.views.activities.DealerMainActivity;
import com.goodautodeal.goodautodeal.views.activities.LoginActivity;
import com.goodautodeal.goodautodeal.views.activities.PackagesActivity;
import com.goodautodeal.goodautodeal.views.activities.PostAdSucesssActivity;
import com.goodautodeal.goodautodeal.views.activities.RegistrationActivity;
import com.goodautodeal.goodautodeal.views.activities.SellMyCarPartThreeActivity;
import com.goodautodeal.goodautodeal.fragments.FragmentNavigationDrawer;
import com.goodautodeal.goodautodeal.modules.internetModule.InternetModule;
import com.goodautodeal.goodautodeal.modules.uiHelperModule.UIHelperModule;
import com.goodautodeal.goodautodeal.views.activities.MainActivity;
import com.goodautodeal.goodautodeal.views.activities.SellMyCarPartFiveActivity;
import com.goodautodeal.goodautodeal.views.activities.SellMyCarPartFourActivity;
import com.goodautodeal.goodautodeal.views.activities.SellMyCarPartOneActivity;
import com.goodautodeal.goodautodeal.views.activities.SellMyCarPartTwoActivity;
import com.goodautodeal.goodautodeal.views.activities.SplashActivity;
import com.goodautodeal.goodautodeal.views.activities.ValueYourCarActivity;
import com.goodautodeal.goodautodeal.views.activities.WelcomeActivity;
import com.goodautodeal.goodautodeal.views.adapters.AdFeaturedAdapter;
import com.goodautodeal.goodautodeal.views.adapters.DealerDashboardAdapter;
import com.goodautodeal.goodautodeal.views.adapters.GeneralAdViewAdapter;
import com.goodautodeal.goodautodeal.views.adapters.PackagesAdapter;
import com.goodautodeal.goodautodeal.views.adapters.PremiumAdapter;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {InternetModule.class, UIHelperModule.class})
public interface ApplicationComponent {

    void injectInternet(ChangePasswordActivity loginActivity);

    void injectInternet(CarViewAdListingActivity loginActivity);

    void injectInternet(MainActivity loginActivity);

    void injectInternet(LoginActivity loginActivity);

    void injectInternet(RegistrationActivity loginActivity);

    void injectInternet(SellMyCarPartThreeActivity sellMyCarPartThreeActivity);

    void injectInternet(SellMyCarPartTwoActivity sellMyCarPartOneActivity);

    void injectInternet(SellMyCarPartOneActivity sellMyCarPartOneActivity);

    void injectInternet(ValueYourCarActivity valueYourCarActivity);

    void injectUIHelper(ValueYourCarActivity valueYourCarActivity);

    void injectUIHelper(FragmentNavigationDrawer fragmentNavigationDrawer);

    void injectUIHelper(SplashActivity splashActivity);

    void injectUIHelper(MainActivity mainActivity);

    void injectUIHelper(SellMyCarPartOneActivity sellMyCarPartOneActivity);

    void injectUIHelper(SellMyCarPartTwoActivity sellMyCarPartOneActivity);

    void injectUIHelper(SellMyCarPartThreeActivity sellMyCarPartOneActivity);

    void injectUIHelper(SellMyCarPartFourActivity sellMyCarPartOneActivity);

    void injectUIHelper(SellMyCarPartFiveActivity sellMyCarPartOneActivity);

    void injectUIHelper(PostAdSucesssActivity sellMyCarPartOneActivity);

    void injectUIHelper(AdsManagementActivity adsManagementActivity);

    void injectUIHelper(DealerDashboardAdapter dealerDashboardAdapter);

    void injectUIHelper(DealerMainActivity dealerMainActivity);

    void injectUIHelper(LoginActivity dealerMainActivity);

    void injectUIHelper(PremiumAdapter dealerMainActivity);

    void injectUIHelper(CarViewAdListingActivity dealerMainActivity);

    void injectUIHelper(WelcomeActivity welcomeActivity);

    void injectUIHelper(PackagesAdapter packagesAdapter);

    void injectUIHelper(PackagesActivity packagesActivity);

    void injectUIHelper(AdPostingRepository adPostingRepository);

    void injectUIHelper(UserRepository adPostingRepository);

    void injectUIHelper(RegistrationActivity adPostingRepository);

    void injectUIHelper(GeneralAdViewAdapter adPostingRepository);

    void injectUIHelper(AdFeaturedAdapter adPostingRepository);

    void injectUIHelper(ChangePasswordActivity adPostingRepository);
}
