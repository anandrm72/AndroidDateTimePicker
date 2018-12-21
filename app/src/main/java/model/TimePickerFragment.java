package model;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.text.format.DateFormat;
import android.widget.TimePicker;

import com.example.honey.alertdilog.MainActivity;

import java.util.Calendar;

public class TimePickerFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener{

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        MainActivity mainActivity = (MainActivity)getActivity();
        mainActivity.processTimePickerResylt( hourOfDay,minute );
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get( Calendar.HOUR );
        int minute = calendar.get( Calendar.MINUTE );
        return new TimePickerDialog( getActivity(),this,hour,minute,DateFormat.is24HourFormat(getActivity()));
    }
}

