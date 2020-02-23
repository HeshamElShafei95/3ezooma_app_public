package net.rajpals.common.pickers;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import android.widget.TimePicker;

import java.util.Calendar;

public class TimePickerFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener {
    public static final String TAG = TimePickerFragment.class.getSimpleName();
    private OnTimeListener mOnTimeListener;

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
        calendar.set(Calendar.MINUTE, minute);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        if (mOnTimeListener != null)
            mOnTimeListener.onTimeSelected(calendar);
        dismiss();
    }



    public static TimePickerFragment newInstance() {
        Bundle args = new Bundle();
        TimePickerFragment fragment = new TimePickerFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current date as the default date in the picker
        final Calendar c = Calendar.getInstance();

        int hour = c.get(Calendar.HOUR_OF_DAY);
        int min = c.get(Calendar.MINUTE);

        // Create a new instance of DatePickerDialog and return it
        TimePickerDialog dialog = new TimePickerDialog(getActivity(),this,hour,min,false);

        return dialog;
    }



    public void setOnTimeListener(OnTimeListener onTimeListener) {

        mOnTimeListener = onTimeListener;
    }

    public interface OnTimeListener {
        void onTimeSelected(Calendar date);
    }
}