package com.goodautodeal.goodautodeal.views.activities;

import android.Manifest;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.AnyRes;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;

import com.goodautodeal.goodautodeal.ApplicationState;
import com.goodautodeal.goodautodeal.R;
import com.goodautodeal.goodautodeal.constants.ConstUtils;
import com.goodautodeal.goodautodeal.databinding.ActivitySellMyCarPartFiveBinding;
import com.goodautodeal.goodautodeal.helpers.UIHelper;
import com.goodautodeal.goodautodeal.interfaces.SubServiceInterface;
import com.goodautodeal.goodautodeal.views.adapters.AdImagesSelectorAdapter;
import com.goodautodeal.goodautodeal.views.models.UploadImageListModel;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import javax.inject.Inject;

import pl.aprilapps.easyphotopicker.ChooserType;
import pl.aprilapps.easyphotopicker.DefaultCallback;
import pl.aprilapps.easyphotopicker.EasyImage;
import pl.aprilapps.easyphotopicker.MediaFile;
import pl.aprilapps.easyphotopicker.MediaSource;

import static android.Manifest.permission.CAMERA;

public class SellMyCarPartFiveActivity extends AppCompatActivity implements SubServiceInterface {
    @Inject
    UIHelper uiHelper;
    private ActivitySellMyCarPartFiveBinding binding;
    private EasyImage easyImage;
    private AdImagesSelectorAdapter imageSelectionAdapter;
    private ArrayList<UploadImageListModel> imageList = new ArrayList<>();
    private int currentPosition = -1;
    private boolean isUploadServer = false, selectAllAnswer = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sell_my_car_part_five);
        ApplicationState.getApp().getApplicationComponent().injectUIHelper(this);

        init();
    }

    private void init() {

        easyImage = new EasyImage.Builder(this)
                .setChooserTitle("Pick media")
                .setCopyImagesToPublicGalleryFolder(false)
                .setChooserType(ChooserType.CAMERA_AND_GALLERY)
                .setFolderName("EasyImage sample")
                .allowMultiple(false)
                .build();


        setImageuri();
        imageSelectionAdapter = new AdImagesSelectorAdapter(this, imageList);
        binding.recyclerview.setAdapter(imageSelectionAdapter);

        binding.btnPublishedNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uiHelper.openActivity(SellMyCarPartFiveActivity.this, PostAdSucesssActivity.class);
            }
        });
    }

    @Override
    public void subServiceOnClick(int position) {
        isUploadServer = !imageList.get(position).isSelected();
        currentPosition = position;
        verifyCameraStoragePermission();
    }

    public void setImageuri() {

            for (int i = 0; i < 5; i++) {
                imageList.add(new UploadImageListModel((String.valueOf(getUriToResource(this, R.drawable.image_rec))),
                        false));

        }
    }

    public static final Uri getUriToResource(@NonNull Context context, @AnyRes int resId) throws Resources.NotFoundException {
        Resources res = context.getResources();

        Uri resUri = Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE +
                "://" + res.getResourcePackageName(resId)
                + '/' + res.getResourceTypeName(resId)
                + '/' + res.getResourceEntryName(resId));

        return resUri;
    }

    public void verifyCameraStoragePermission() {
        String[] permission = {Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.CAMERA};

        if (ContextCompat.checkSelfPermission(this, permission[0]) == PackageManager.PERMISSION_GRANTED
                && ContextCompat.checkSelfPermission(this, permission[1]) == PackageManager.PERMISSION_GRANTED
                && ContextCompat.checkSelfPermission(this, permission[2]) == PackageManager.PERMISSION_GRANTED) {
            selectImage();
        } else {
            ActivityCompat.requestPermissions(this, permission, 123);
        }

    }

    public void selectImage() {
        try {
            PackageManager pm = getPackageManager();
            int hasPerm = pm.checkPermission(CAMERA, getPackageName());
            final CharSequence[] options = {getResources().getString(R.string.take_photo),
                    getResources().getString(R.string.chhose_from_gallery),
                    getResources().getString(R.string.cancel_btn)};
            androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(this);
            builder.setTitle(getResources().getString(R.string.select_option));
            builder.setItems(options, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int item) {
                    if (options[item].equals(getResources().getString(R.string.take_photo))) {
                        dialog.dismiss();
                        easyImage.openCameraForImage(SellMyCarPartFiveActivity.this);
                    } else if (options[item].equals(getResources().getString(R.string.chhose_from_gallery))) {
                        dialog.dismiss();
                        easyImage.openGallery(SellMyCarPartFiveActivity.this);
                    } else if (options[item].equals(getResources().getString(R.string.cancel_btn))) {
                        dialog.dismiss();
                    }
                }
            });
            builder.show();

        } catch (Exception e) {
            Toast.makeText(this, getResources().getString(R.string.camera_permission_error), Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        easyImage.handleActivityResult(requestCode, resultCode, data, this, new DefaultCallback() {
            @Override
            public void onMediaFilesPicked(@NotNull MediaFile[] mediaFiles, @NotNull MediaSource mediaSource) {
                if (mediaFiles[0].getFile().exists()) {
                    imageSelectionAdapter.setImage(String.valueOf(mediaFiles[0].getFile()), currentPosition);
                }
            }
        });
    }

}