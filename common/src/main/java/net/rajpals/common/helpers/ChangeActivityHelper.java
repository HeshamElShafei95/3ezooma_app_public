package net.rajpals.common.helpers;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.View;

public class ChangeActivityHelper implements View.OnClickListener {

    private Activity mSource;
    private Class<?> mDestination;
    private boolean mFinishActivity;

    public ChangeActivityHelper(Activity source, Class<?> destination) {
        super();
        mSource = source;
        mDestination = destination;
        mFinishActivity = false;
    }

    public ChangeActivityHelper(Activity source, Class<?> destination, boolean finishActivity) {
        this(source, destination);
        mFinishActivity = finishActivity;
    }

    public static void changeActivity(Activity source, Class<?> destination) {
        changeActivity(source, destination, false);
    }

    /**
     * call when you need to transit form one activity to another
     *
     * @param shouldFinishContext: true if you want to finish context of the current activity, false otherwise
     */
    public static void changeActivity(@NonNull Activity source, @NonNull Class<?> destination, Boolean shouldFinishContext) {

        changeActivity(source, destination, shouldFinishContext, false);
    }

    public static void changeActivity(@NonNull Activity source, @NonNull Class<?> destination, @NonNull Bundle bundle) {
        changeActivity(source, destination, false, bundle);
    }

    public static void changeActivity(@NonNull Activity source, @NonNull Class<?> destination, boolean shouldFinishContext, boolean clearTop) {
        if (shouldFinishContext) {
            source.finish();
        }
        Intent intent = new Intent(source, destination);
        if (clearTop)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        source.startActivity(intent);
    }

    // Intent with bundle
    public static void changeActivity(@NonNull Activity source, @NonNull Class<?> destination, boolean shouldFinishContext, @Nullable Bundle bundle) {
        if (shouldFinishContext) {
            source.finish();
        }
        Intent intent = new Intent(source, destination);

        if (bundle != null)
            intent.putExtras(bundle);
        source.startActivity(intent);
    }

    // Intent with bundle
    public static void changeActivityForResult(@NonNull Activity source, @NonNull Class<?> destination, int requestCode) {
        changeActivityForResult(source, destination, requestCode, null);
    }

    // Intent with bundle
    public static void changeActivityForResult(@NonNull Activity source, @NonNull Class<?> destination, int requestCode, @Nullable Bundle bundle) {
        Intent intent = new Intent(source, destination);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        source.startActivityForResult(intent, requestCode);
    }

    // Intent with bundle
    public static void changeActivityForResultByFragment(@NonNull Fragment source, @NonNull Class<?> destination, int requestCode, @Nullable Bundle bundle) {
        Intent intent = new Intent(source.getActivity(), destination);
        if (bundle != null)
            intent.putExtras(bundle);
        source.startActivityForResult(intent, requestCode);
    }



    @Override
    public void onClick(View v) {
        changeActivity(mSource, mDestination, mFinishActivity);
    }
}