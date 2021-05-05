package com.goodautodeal.goodautodeal.interfaces;

import com.goodautodeal.goodautodeal.fragments.DashboardFragment;
import com.goodautodeal.goodautodeal.fragments.DraftFragment;
import com.goodautodeal.goodautodeal.fragments.FragmentNavigationDrawer;
import com.goodautodeal.goodautodeal.fragments.PendingFragment;
import com.goodautodeal.goodautodeal.fragments.ProfileFragment;
import com.goodautodeal.goodautodeal.fragments.PublishedFragment;
import com.goodautodeal.goodautodeal.fragments.RejectedFragment;
import com.goodautodeal.goodautodeal.fragments.SoldVehicleFragment;
import com.goodautodeal.goodautodeal.modules.internetModule.InternetModule;
import com.goodautodeal.goodautodeal.modules.uiHelperModule.UIHelperModule;
import com.goodautodeal.goodautodeal.respository.AdPostingRepository;
import com.goodautodeal.goodautodeal.respository.DealerAdListViewRepository;
import com.goodautodeal.goodautodeal.respository.DealerViewRepository;
import com.goodautodeal.goodautodeal.respository.SellAdPostingRepo;
import com.goodautodeal.goodautodeal.respository.UserRepository;
import com.goodautodeal.goodautodeal.views.activities.AdsManagementActivity;
import com.goodautodeal.goodautodeal.views.activities.CarAdDetailActivity;
import com.goodautodeal.goodautodeal.views.activities.CarViewAdListingActivity;
import com.goodautodeal.goodautodeal.views.activities.ChangePasswordActivity;
import com.goodautodeal.goodautodeal.views.activities.ContactUsActivity;
import com.goodautodeal.goodautodeal.views.activities.DealerMainActivity;
import com.goodautodeal.goodautodeal.views.activities.DealersActivity;
import com.goodautodeal.goodautodeal.views.activities.FilterActivity;
import com.goodautodeal.goodautodeal.views.activities.ForgotPasswordActivity;
import com.goodautodeal.goodautodeal.views.activities.LoginActivity;
import com.goodautodeal.goodautodeal.views.activities.MainActivity;
import com.goodautodeal.goodautodeal.views.activities.OtpVerificationActivity;
import com.goodautodeal.goodautodeal.views.activities.PackagesActivity;
import com.goodautodeal.goodautodeal.views.activities.PostAdSucesssActivity;
import com.goodautodeal.goodautodeal.views.activities.ProfileActivity;
import com.goodautodeal.goodautodeal.views.activities.RegistrationActivity;
import com.goodautodeal.goodautodeal.views.activities.SellMyCarPartFiveActivity;
import com.goodautodeal.goodautodeal.views.activities.SellMyCarPartFourActivity;
import com.goodautodeal.goodautodeal.views.activities.SellMyCarPartOneActivity;
import com.goodautodeal.goodautodeal.views.activities.SellMyCarPartThreeActivity;
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

    void injectInternet(DraftFragment dashboardFragment);

    void injectInternet(SoldVehicleFragment dashboardFragment);

    void injectInternet(RejectedFragment dashboardFragment);

    void injectInternet(PendingFragment dashboardFragment);

    void injectInternet(PublishedFragment dashboardFragment);

    void injectInternet(ContactUsActivity dashboardFragment);

    void injectInternet(DashboardFragment dashboardFragment);

    void injectInternet(FilterActivity loginActivity);

    void injectInternet(DealerMainActivity loginActivity);

    void injectInternet(ProfileFragment loginActivity);

    void injectInternet(OtpVerificationActivity loginActivity);

    void injectInternet(ForgotPasswordActivity loginActivity);

    void injectInternet(CarAdDetailActivity loginActivity);

    void injectInternet(DealersActivity loginActivity);

    void injectInternet(ProfileActivity loginActivity);

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

    void injectUIHelper(ProfileActivity adPostingRepository);

    void injectUIHelper(DealersActivity adPostingRepository);

    void injectUIHelper(CarAdDetailActivity adPostingRepository);

    void injectUIHelper(ForgotPasswordActivity adPostingRepository);

    void injectUIHelper(OtpVerificationActivity adPostingRepository);

    void injectUIHelper(ProfileFragment adPostingRepository);

    void injectUIHelper(DealerViewRepository loginActivity);

    void injectUIHelper(FilterActivity loginActivity);

    void injectUIHelper(DashboardFragment dashboardFragment);

    void injectUIHelper(ContactUsActivity dashboardFragment);

    void injectUIHelper(DealerAdListViewRepository dashboardFragment);

    void injectUIHelper(PublishedFragment dashboardFragment);

    void injectUIHelper(DraftFragment dashboardFragment);

    void injectUIHelper(SoldVehicleFragment dashboardFragment);

    void injectUIHelper(RejectedFragment dashboardFragment);

    void injectUIHelper(PendingFragment dashboardFragment);

    void injectUIHelper(SellAdPostingRepo dashboardFragment);
}
