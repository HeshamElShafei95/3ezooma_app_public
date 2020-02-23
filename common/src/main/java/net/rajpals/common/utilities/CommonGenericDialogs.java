package net.rajpals.common.utilities;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import androidx.fragment.app.Fragment;
import androidx.core.content.FileProvider;
import androidx.appcompat.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import android.widget.LinearLayout;

import java.io.File;
import java.util.Calendar;

import net.rajpals.common.R;
import net.rajpals.common.callbacks.GenericImagePickerCallback;
import net.rajpals.common.java.DateTimeUtility;
import net.rajpals.common.logger.AppLogger;

public class CommonGenericDialogs {

    private final static String TAG = CommonGenericDialogs.class.getName();

    public static String OK = "Ok";
    public static String CANCEL = "Cancel";
    public static final int REQUEST_IMAGE_CAPTURE = 1600;
    public static final int RESULT_LOAD_IMAGE = 1601;

    public final static String CAMERA_ERROR = "Unable capture image by camera";
    public final static String IMAGE_UPLOAD_ERROR = "Unable to upload image.";


    public enum DateAllowed {
        PAST,
        FUTURE,
        ALL
    }





    /* Photo picker */

    public static void getPicPiker(Context mContext, final GenericImagePickerCallback dialogBoxInterface) {
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        //Custom layout
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View view = layoutInflater.inflate(R.layout.common_layout_photo_picker, null, false);

        final AlertDialog alert = builder.create();
        alert.setCancelable(true);
        alert.setView(view);
        alert.show();


        LinearLayout mLLCamera = (LinearLayout) view.findViewById(R.id.id_ll_camera);
        mLLCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Camera action
                dialogBoxInterface.pickFromCamera(alert, 0);
            }
        });

        LinearLayout mLLGallery = (LinearLayout) view.findViewById(R.id.id_ll_gallery);
        mLLGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Gallery action
                dialogBoxInterface.pickPromGallery(alert, 0);
            }
        });
    }

    // Take picture
    public static String takeAPicture(Context context) {
        //Creating default image
        String defaultImageName = "NEW_ITEM_IMAGE.jpg";
        File photoFile = FileUtils.createTempImageFile(defaultImageName, context);
        if (photoFile == null) {
            AppLogger.Logger.warn(TAG, new Exception("invalid file url"));
            return null;
        }
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(context.getPackageManager()) == null) {
            AppLogger.Logger.warn(TAG, new Exception("Unable to configure image."));
            return null;
        }

        Uri imageUri = null;
        if (isGreaterThanVersionCode24())
            imageUri = FileProvider.getUriForFile(context, context.getApplicationContext().getPackageName() + ".provider", photoFile);
        else
            imageUri = Uri.fromFile(photoFile);

        if (imageUri == null) {
            return null;
        }
        takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
        ((Activity) context).startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        return photoFile.getAbsolutePath();
    }

    public static String takeAPictureByFragment(Fragment fragment, Context context) {
        //Creating default image
        String defaultImageName = "NEW_ITEM_IMAGE.jpg";
        File photoFile = FileUtils.createTempImageFile(defaultImageName, context);
        if (photoFile == null) {
            AppLogger.Logger.warn(TAG, new Exception("invalid file url"));
            return null;
        }
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(context.getPackageManager()) == null) {
            AppLogger.Logger.warn(TAG, new Exception("Unable to configure image."));
            return null;
        }

        Uri imageUri = null;
        if (isGreaterThanVersionCode24())
            imageUri = FileProvider.getUriForFile(context, context.getApplicationContext().getPackageName() + ".provider", photoFile);
        else
            imageUri = Uri.fromFile(photoFile);
        if (imageUri == null) {
            return null;
        }
        takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
        fragment.startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        return photoFile.getAbsolutePath();
    }

    // Gallery
    public static void getImageFromGallery(Context context) {
        AppLogger.Logger.info(TAG, "Form gallery ");
        Intent i = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        ((Activity) context).startActivityForResult(i, RESULT_LOAD_IMAGE);
    }

    public static void getImageFromGalleryByFragment(Fragment fragment) {
        AppLogger.Logger.info(TAG, "Form gallery ");
        Intent i = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        fragment.startActivityForResult(i, RESULT_LOAD_IMAGE);
    }

    //Is greater than lollipop
    public static boolean isGreaterThanVersionCode24() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.N;
    }


    //  Date picker
    public static DatePickerDialog getDatePickerDialog(Context context, final  DatePickerDialog.OnDateSetListener datePickerDate, DateAllowed dateAllowed) {
        Calendar myCalendar = Calendar.getInstance();
        DatePickerDialog datePickerDialog = new DatePickerDialog(context, datePickerDate,
                myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                myCalendar.get(Calendar.DAY_OF_MONTH));
        DatePicker dp = datePickerDialog.getDatePicker();
        switch (dateAllowed) {
            case PAST:
                dp.setMaxDate(myCalendar.getTimeInMillis());
                break;
            case FUTURE:
                dp.setMinDate(myCalendar.getTimeInMillis());
                break;
            case ALL:
                break;
        }

        //// TODO: 06/03/16 Date validations add minimum date today
        return datePickerDialog;
    }

    public static DatePickerDialog setDate(DatePickerDialog datePickerDialog,String date){
        Calendar calendar = DateTimeUtility.getCalender(date,false);
        if(calendar==null)
            return datePickerDialog;
        datePickerDialog.updateDate(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH));
        return datePickerDialog;
    }
    // TIME PICKER DIALOG
    public static TimePickerDialog getTimePickerDialog(Context context, final TimePickerDialog.OnTimeSetListener timeSetListener, boolean is24Hour) {
        Calendar myCalendar = Calendar.getInstance();
        int hour = myCalendar.get(Calendar.HOUR_OF_DAY);
        int minute = myCalendar.get(Calendar.MINUTE);
        TimePickerDialog mTimePicker;
        mTimePicker = new TimePickerDialog(context, timeSetListener, hour, minute, is24Hour);//Yes 24 hour time
        mTimePicker.setTitle("Select Time");
        return mTimePicker;
    }


}