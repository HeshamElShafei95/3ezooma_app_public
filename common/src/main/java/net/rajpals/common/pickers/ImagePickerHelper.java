package net.rajpals.common.pickers;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import androidx.constraintlayout.widget.ConstraintLayout;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.mlsdev.rximagepicker.RxImageConverters;
import com.mlsdev.rximagepicker.RxImagePicker;
import com.mlsdev.rximagepicker.Sources;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import net.rajpals.common.R;
import net.rajpals.common.utilities.FileUtils;

import java.io.File;

import io.reactivex.ObservableSource;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import me.shaohui.advancedluban.Luban;
import me.shaohui.advancedluban.OnCompressListener;

/**
 * Created by Macrew on 30-01-2018.
 */

public class ImagePickerHelper implements View.OnClickListener {

    private final Activity mActivity;
    private Dialog mDialog;
    private OnImagePickerListener mOnImagePickerListener;
    private boolean mShouldCrop;

    public ImagePickerHelper(Activity activity) {
        mActivity = activity;
    }

    public void cropImage(File photoFile) {
        CropImage.activity(Uri.fromFile(photoFile))
                .setGuidelines(CropImageView.Guidelines.ON)
                .setAllowFlipping(false)
                .start(mActivity);
    }

    public File createTempFile() {
        return FileUtils.createTempImageFile("user_image" + System.currentTimeMillis() + ".jpg", mActivity);

    }

    public File convertToFile(Bitmap bitmap, FileUtils.OnTaskCompleteListener onTaskCompleteListener) {
        final File mUserImageFile = FileUtils.createTempImageFile("user_image" + System.currentTimeMillis() + ".jpg", mActivity);
        FileUtils.persistImageAsync(bitmap, mUserImageFile, Bitmap.CompressFormat.JPEG, onTaskCompleteListener);
        return mUserImageFile;
    }

    /**
     * If true then, include below code in your AndroidManifest.xml file.
     * <activity
     * android:name="com.theartofdev.edmodo.cropper.CropImageActivity"
     * android:screenOrientation="portrait"
     * android:theme="@style/AppTheme" />
     *
     * @param shouldCrop true, for image cropping feature
     * @return ImagePickerHelper;
     */
    public ImagePickerHelper setShouldCropImage(boolean shouldCrop) {
        mShouldCrop = shouldCrop;

        return this;
    }

    public void showImagePicker(@NonNull Sources sources, @NonNull OnImagePickerListener onImagePickerListener) {
        mOnImagePickerListener = onImagePickerListener;
        openImagePicker(sources);
    }

    public void showChooserDialog(@NonNull OnImagePickerListener onImagePickerListener) {
        mOnImagePickerListener = onImagePickerListener;
        mDialog = new Dialog(mActivity);
        mDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        mDialog.setContentView(R.layout.dialog_image_chooser);
        Window window = mDialog.getWindow();
        WindowManager.LayoutParams wlp = window.getAttributes();
        wlp.gravity = Gravity.CENTER;
        window.setAttributes(wlp);
        mDialog.getWindow().setLayout(ConstraintLayout.LayoutParams.MATCH_PARENT, ConstraintLayout.LayoutParams.WRAP_CONTENT);
        mDialog.setCancelable(false);
        mDialog.show();
        mDialog.findViewById(R.id.txt_take_picture).setOnClickListener(this);
        mDialog.findViewById(R.id.txt_gallery).setOnClickListener(this);
        mDialog.findViewById(R.id.txt_cancel).setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        int i = view.getId();
        if (i == R.id.txt_take_picture) {
            openImagePicker(Sources.CAMERA);
        } else if (i == R.id.txt_gallery) {
            openImagePicker(Sources.GALLERY);
        } else if (i == R.id.txt_cancel) {
            dismiss();
        }
    }

    @SuppressLint("CheckResult")
    private void openImagePicker(Sources sources) {
        RxImagePicker.with(getContext()).requestImage(sources)
                .flatMap(new Function<Uri, ObservableSource<File>>() {
                    @Override
                    public ObservableSource<File> apply(@NonNull Uri uri) throws Exception {
                        return RxImageConverters.uriToFile(getContext(), uri, createTempFile());

                    }
                }).subscribe(new Consumer<File>() {
            @Override
            public void accept(@NonNull File bitmap) throws Exception {
                // Do something with Bitmap
                if (mOnImagePickerListener != null)
                    mOnImagePickerListener.onImagePicked(bitmap);
                dismiss();
            }
        });
    }

    private Context getContext() {
        return mActivity;
    }

    private void dismiss() {
        mOnImagePickerListener.onCancelled();
        if (mDialog != null && mDialog.isShowing())
            mDialog.dismiss();
    }

    public void compressImage(File file, OnImageCompressListener onImageCompressListener) {
        saveAndCompressImage(file, onImageCompressListener);
    }

    private void saveAndCompressImage(final File file, final OnImageCompressListener onImageCompressListener) {


        Luban.compress(mActivity, file)
                .putGear(Luban.THIRD_GEAR)      // set the compress mode, default is : THIRD_GEAR
                .launch(new OnCompressListener() {
                    @Override
                    public void onStart() {

                    }

                    @Override
                    public void onSuccess(File file) {
                        if (onImageCompressListener != null)
                            onImageCompressListener.onSuccess(file, null);
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (onImageCompressListener != null)
                            onImageCompressListener.onSuccess(null, e.getMessage());
                    }
                });
    }


    public interface OnImagePickerListener {
        void onImagePicked(@NonNull File file);

        void onCancelled();
    }

    public interface OnImageCompressListener {
        void onSuccess(File file, String error);

    }
}
