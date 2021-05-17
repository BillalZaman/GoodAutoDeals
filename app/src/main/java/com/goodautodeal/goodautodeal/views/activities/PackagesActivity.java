package com.goodautodeal.goodautodeal.views.activities;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import com.goodautodeal.goodautodeal.ApplicationState;
import com.goodautodeal.goodautodeal.R;
import com.goodautodeal.goodautodeal.constants.ConstUtils;
import com.goodautodeal.goodautodeal.databinding.ActivityPackagesBinding;
import com.goodautodeal.goodautodeal.helpers.Internet;
import com.goodautodeal.goodautodeal.helpers.PreferenceHelper;
import com.goodautodeal.goodautodeal.helpers.UIHelper;
import com.goodautodeal.goodautodeal.interfaces.PaypalInterface;
import com.goodautodeal.goodautodeal.viewmodels.AdPostingViewModel;
import com.goodautodeal.goodautodeal.views.adapters.PackagesAdapter;
import com.goodautodeal.goodautodeal.views.models.PackagesModel;
import com.paypal.android.sdk.payments.PayPalConfiguration;
import com.paypal.android.sdk.payments.PayPalPayment;
import com.paypal.android.sdk.payments.PayPalService;
import com.paypal.android.sdk.payments.PaymentActivity;
import com.paypal.android.sdk.payments.PaymentConfirmation;

import org.json.JSONException;

import java.math.BigDecimal;
import java.util.ArrayList;

import javax.inject.Inject;

public class PackagesActivity extends AppCompatActivity implements PaypalInterface {
    private static final int PAYPAL_REQUEST_CODE = 7171;
    private static final PayPalConfiguration config = new PayPalConfiguration().environment(PayPalConfiguration.ENVIRONMENT_SANDBOX)
            .clientId(ConstUtils.PAYPAL_CLIENT_ID);
    @Inject
    UIHelper uiHelper;
    ProgressDialog loading;
    AdPostingViewModel viewModel;
    @Inject
    Internet internet;
    private final ArrayList<PackagesModel> packagesModels = new ArrayList<>();
    private ActivityPackagesBinding binding;
    private PackagesAdapter packagesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_packages);
        ApplicationState.getApp().getApplicationComponent().injectUIHelper(this);
        ApplicationState.getApp().getApplicationComponent().injectInternet(this);
        viewModel = ViewModelProviders.of(this).get(AdPostingViewModel.class);
        initData();
    }

    private void initData() {

        packagesModels.add(new PackagesModel("Silver", PreferenceHelper.getInstance().getString(ConstUtils.silver,""), "2 weeks", "30", "1", "Depends on Search Criteria"));
        packagesModels.add(new PackagesModel("Gold", PreferenceHelper.getInstance().getString(ConstUtils.gold,""), "4 weeks", "50", "1", "Depends on Search Criteria"));
        packagesModels.add(new PackagesModel("Diamond", PreferenceHelper.getInstance().getString(ConstUtils.diamond,""), "6 weeks", "50", "1", "Appears in top 100 in the Search Randomly"));
        packagesModels.add(new PackagesModel("Platinum", PreferenceHelper.getInstance().getString(ConstUtils.platinum,""), "6 weeks", "50", "1", "Depends on Search Criteria"));

        packagesAdapter = new PackagesAdapter(packagesModels, this);
        binding.horizontalviewpager.setAdapter(packagesAdapter);

        Intent intent = new Intent(this, PayPalService.class);
        intent.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION, config);
        startService(intent);
    }

    @Override
    public void buyPackages(String packageName, String price) {
        if (packageName.equalsIgnoreCase("silver")) {
            processPayment(price);
        } else if (packageName.equalsIgnoreCase("gold")) {
            processPayment(price);
        } else if (packageName.equalsIgnoreCase("diamond")) {
            processPayment(price);
        } else if (packageName.equalsIgnoreCase("platinum")) {
            processPayment(price);
        }
    }

    private void processPayment(String price) {
        PayPalPayment payPalPayment = new PayPalPayment(new BigDecimal(price), "EUR", "Package GoodAutoDeals"
                , PayPalPayment.PAYMENT_INTENT_SALE);
        Intent intent = new Intent(this, PaymentActivity.class);
        intent.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION, config);
        intent.putExtra(PaymentActivity.EXTRA_PAYMENT, payPalPayment);
        startActivityForResult(intent, PAYPAL_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PAYPAL_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                PaymentConfirmation paymentConfirmActivity = data.getParcelableExtra(PaymentActivity.EXTRA_RESULT_CONFIRMATION);
                if (paymentConfirmActivity != null) {
                    try {
                        String paymentDetail = paymentConfirmActivity.toJSONObject().toString(4);
                        startActivity(new Intent(this, SellMyCarPartFiveActivity.class));
                    } catch (JSONException jsonException) {
                        jsonException.printStackTrace();
                    }
                }
            } else if (requestCode == Activity.RESULT_CANCELED) {
                uiHelper.showLongToastInCenter(this, "Payment Cancel");
            }
        } else if (resultCode == PaymentActivity.RESULT_EXTRAS_INVALID) {
            uiHelper.showLongToastInCenter(this, "Invalid Credentials");
        }
    }

    @Override
    protected void onDestroy() {
        stopService(new Intent(this, PayPalService.class));
        super.onDestroy();
    }
}