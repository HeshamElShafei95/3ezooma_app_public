package net.rajpals.common.helpers;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import net.rajpals.common.logger.AppLogger;

public class ExternalIntentHelper {

    public static final String TEXT_TYPE = "text/plain";
    public static final String IAMGE_TYPE = "image/png";
    private static final String TAG = ExternalIntentHelper.class.getName();

    public static String OpenEmailChooser(Context context, String[] to, String subject, String message) {
        try {
            Intent sendIntent = new Intent(Intent.ACTION_SEND);
            sendIntent.setType("text/html");
            sendIntent.putExtra(Intent.EXTRA_EMAIL, to);
            sendIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
            sendIntent.putExtra(Intent.EXTRA_TEXT, message);
            context.startActivity(Intent.createChooser(sendIntent, "Send Email"));
        } catch (Exception ex) {
            AppLogger.Logger.error(TAG, ex.getMessage(), ex);
            return ex.getMessage();
        }
        return null;
    }

    public static String composeEmail(Context context, String[] addresses, String subject, String message) {

        try {
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:")); // only email apps should handle this
            intent.putExtra(Intent.EXTRA_EMAIL, addresses);
            intent.putExtra(Intent.EXTRA_SUBJECT, subject);
            intent.putExtra(Intent.EXTRA_TEXT, message);
            if (intent.resolveActivity(context.getPackageManager()) != null) {
                context.startActivity(intent);
            }
        } catch (Exception ex) {
            AppLogger.Logger.error(TAG, ex.getMessage(), ex);
            return ex.getMessage();
        }
        return null;
    }


    public static String openSkype(Context context, String userName) {
        try {
            Intent skypeIntent = new Intent(Intent.ACTION_SENDTO);
            skypeIntent.setClassName("com.skype.raider", "com.skype.raider.Main");
            skypeIntent.setData(Uri.parse("skype:" + userName));
            context.startActivity(skypeIntent);
        } catch (Exception ex) {
            AppLogger.Logger.error(TAG, ex.getMessage(), ex);
            return ex.getMessage();
        }
        return null;
    }

    public static String share(Context context, String text, String MIMEType) {
        try {
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, text);
            sendIntent.setType(MIMEType);
            context.startActivity(Intent.createChooser(sendIntent, "Share"));
        } catch (Exception ex) {
            AppLogger.Logger.error(TAG, ex.getMessage(), ex);
            return ex.getMessage();
        }
        return null;
    }

    public static String shareImage(Context context, String text, Uri bitmapUri, String MIMEType) {
        try {
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, text);
            sendIntent.putExtra(Intent.EXTRA_STREAM, bitmapUri);
            sendIntent.setType(MIMEType);
            context.startActivity(Intent.createChooser(sendIntent, "Share"));
        } catch (Exception ex) {
            AppLogger.Logger.error(TAG, ex.getMessage(), ex);
            return ex.getMessage();
        }
        return null;
    }


}