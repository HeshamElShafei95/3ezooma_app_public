package net.rajpals.common.utilities;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.UnderlineSpan;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;


public class StringUtils {

    private final static int MAX_TEXT_LENGTH = 140;

    // email validation :
    public static boolean isValidEmailAddress(final String mailAddress) {
        return !TextUtils.isEmpty(mailAddress) && android.util.Patterns.EMAIL_ADDRESS.matcher(mailAddress).matches();
       /* if (mailAddress == null)
            return false;
        if (mailAddress.isEmpty())
            return false;

        Pattern pattern;
        Matcher matcher;
        final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        if (mailAddress != null) {
            pattern = Pattern.compile(EMAIL_PATTERN);
            matcher = pattern.matcher(mailAddress);
           *//* return matcher.matches();*//*
            return !TextUtils.isEmpty(mailAddress) && android.util.Patterns.EMAIL_ADDRESS.matcher(mailAddress).matches();
        }
        return false;*/

    }

    public static boolean isEmpty(final String text) {
        return TextUtils.isEmpty(text);
    }

    /* Get text from editText */
    @NonNull
    public static String getTextFromEditText(View editText) {
        if (editText instanceof EditText)
            return ((EditText) editText).getText().toString().trim();
        else if (editText instanceof TextView)
            return ((TextView) editText).getText().toString().trim();
        else
            return "";
    } /* Get text from editText */

    @NonNull
    public static int getIntFromEditText(View editText) {
        String input;
        if (editText instanceof EditText)
            input = ((EditText) editText).getText().toString().trim();
        else if (editText instanceof TextView)
            input = ((TextView) editText).getText().toString().trim();
        else
            input = "0";
        try {
            return Integer.valueOf(input);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static void setTextToEditText(View editText, String text) {
        if (editText instanceof EditText)
            ((EditText) editText).setText(text);
        else if (editText instanceof TextView)
            ((TextView) editText).setText(text);

    }

    /* Limiting the width of text */
    private static String mReadMore = " ...Read More";

    public static Spannable limitTheWidthOfText(@NonNull String textValue, int color) {
        if (textValue.length() > MAX_TEXT_LENGTH) {
            textValue = textValue.substring(0, 120) + mReadMore;
            Spannable wordToSpan = new SpannableString(textValue);
            wordToSpan.setSpan(new ForegroundColorSpan(color), textValue.length() - mReadMore.length(), textValue.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            return wordToSpan;
        }
        return new SpannableString(textValue);
    }

    public static boolean isMoreThanLimit(@Nullable String textValue) {
        if (textValue == null || textValue.isEmpty() || textValue.length() < MAX_TEXT_LENGTH)
            return false;
        return true;
    }

    public static Spannable getSpannableUnderLineString(String textValue, int startIndex, int endIndex, int color) {
        Spannable wordToSpan = new SpannableString(textValue);
        wordToSpan.setSpan(new UnderlineSpan(), startIndex, endIndex, 0);
        wordToSpan.setSpan(new ForegroundColorSpan(color), startIndex, endIndex, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return wordToSpan;

    }

    /*Make first letter to upper case*/
    public static String getStringWithFirstLetterInUpperCase(String value) {
        if (value == null || value.isEmpty())
            return "";
        else if (value.length() == 1)
            return Character.toUpperCase(value.charAt(0)) + "";
        else
            return Character.toUpperCase(value.charAt(0)) + value.substring(1);
    }

    public static String getFontAwesomeIconString(Context context, String value) {
        String packageName = context.getPackageName();
        value = value.trim();
        String fixedString = "fa fa-";
        String fontTempName = value.substring(fixedString.length(), value.length()).replaceAll("-", "_").replaceAll(" ", "_");
        String fontName = "fa_" + fontTempName;
        //AppLogger.Logger.debug("getFontAwesomeIconString", fontName);
        try {
            int resId = context.getResources().getIdentifier(fontName, "string", packageName);
            return context.getString(resId);
        } catch (Exception ex) {
            int resId = context.getResources().getIdentifier("fa_desktop", "string", packageName);
            return context.getString(resId);
        }

    }

    public static int getResoureceIdFromString(Context context, String value) {
        String packageName = context.getPackageName();
        return context.getResources().getIdentifier(value, "string", packageName);
    }


    public static Map<String, String> bundleToHashMapConversion(Bundle bundle, Gson gson) throws Exception {
        final Set<String> keySet = bundle.keySet();
        Map<String, String> hashMap = new HashMap<>(keySet.size());
        for (final String key : keySet) {
            hashMap.put(key, bundle.getString(key));
        }
        Log.e("bundleToJsonString", "Exception: " + gson.toJson(hashMap));
        return hashMap;
    }


    public static String format(String format, Object... args) {
        return String.format(Locale.ENGLISH, format, args);
    }


    public static String capitalizeFirstLetter(String input) {
        if (input == null || input.length() <= 0)
            return input;
        return input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase();
    }

    public static String capitalizeFirstLetterOfEachWord(String input) {
        if (input == null || input.length() <= 0)
            return input;
        input = input.toLowerCase().trim();
        int length = input.length();
        char character = Character.toUpperCase(input.charAt(0));
        input = character + input.substring(1);
        for (int i = 0; i < length; i++) {
            char val = input.charAt(i);
            if (val == ' ') {
                character = Character.toUpperCase(input.charAt(i + 1));
                input = input.substring(0, i) +" "+character + input.substring(i + 2);
            }
        }
        return input;
    }
}
