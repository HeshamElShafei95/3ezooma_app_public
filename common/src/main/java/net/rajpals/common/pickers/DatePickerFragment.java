package net.rajpals.common.pickers;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import android.widget.DatePicker;

import java.util.Calendar;
import java.util.Date;

public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {
    public static final String TAG = DatePickerFragment.class.getSimpleName();
    private static final String PICKER_TYPE = "_picker_type";
    private OnDateListener mOnDateListener;

    public enum PickerType {
        DATE_BIRTH, NORMAL
    }

    public static DatePickerFragment newInstance() {
        return newInstance(PickerType.NORMAL);
    }

    public static DatePickerFragment newInstance(PickerType pickerType) {
        Bundle args = new Bundle();
        args.putSerializable(PICKER_TYPE, pickerType);
        DatePickerFragment fragment = new DatePickerFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current date as the default date in the picker
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        // Create a new instance of DatePickerDialog and return it
        DatePickerDialog dialog = new DatePickerDialog(getActivity(), this, year, month, day);
        if (((PickerType) getArguments().getSerializable(PICKER_TYPE)) == PickerType.DATE_BIRTH)
            dialog.getDatePicker().setMaxDate(new Date().getTime());
        return dialog;
    }

    public void onDateSet(DatePicker view, int year, int month, int day) {
        // do some stuff for example write on log and update TextField on activity
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, day);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        if (mOnDateListener != null)
            mOnDateListener.onDateSelected(calendar);
        dismiss();
    }

    public void setOnDateListener(OnDateListener onDateListener) {
        mOnDateListener = onDateListener;
    }

    public interface OnDateListener {
        void onDateSelected(Calendar date);
    }
}