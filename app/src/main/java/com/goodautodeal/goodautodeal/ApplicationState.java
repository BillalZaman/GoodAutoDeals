package com.goodautodeal.goodautodeal;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Base64;
import android.util.Log;

import com.facebook.stetho.Stetho;
import com.goodautodeal.goodautodeal.constants.ConstUtils;
import com.goodautodeal.goodautodeal.interfaces.ApplicationComponent;
import com.goodautodeal.goodautodeal.interfaces.DaggerApplicationComponent;
import com.goodautodeal.goodautodeal.modules.internetModule.InternetModule;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Bilal Zaman on 17/02/21.
 */
public class ApplicationState extends Application {

    private static ApplicationState app;
    public String merchantID = "";
    ApplicationComponent applicationComponent;
    private String totalAmount = "";

    public static ApplicationState getApp() {
        return app;
    }

    public String getMerchantID() {
        return merchantID;
    }

    public void setMerchantID(String merchantID) {
        this.merchantID = merchantID;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        app = this;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        ConstUtils.CONTEXT = getApplicationContext();
//        Fabric.with(this, new Crashlytics());
        Stetho.initializeWithDefaults(this);
        applicationComponent = DaggerApplicationComponent.builder()
                .internetModule(new InternetModule())
                .build();
        printHashKey();
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }

    public void printHashKey(){
        // Add code to print out the key hash
        try {
            PackageInfo info = getPackageManager().getPackageInfo(
                    "com.goodautodeals.goodautodeals",
                    PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        } catch (PackageManager.NameNotFoundException e) {

        } catch (NoSuchAlgorithmException e) {

        }
    }
}

