package com.example.honey.alertdilog;

import android.content.DialogInterface;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import model.DatePickerFragment;
import model.TimePickerFragment;

public class MainActivity extends AppCompatActivity {
    TextView date_et,time_et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        date_et = findViewById(R.id.date );
        time_et = findViewById( R.id.Time );
    }

    public void showAlert(View view) {
        AlertDialog.Builder myAlert = new AlertDialog.Builder( this );
        myAlert.setTitle( "Alert" );
        myAlert.setMessage( "press ok to continue, or press cancel to stop" );
        myAlert.setPositiveButton( "ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText( MainActivity.this,"ok clicked",Toast.LENGTH_SHORT ).show();
            }
        } );
        myAlert.setNegativeButton( "cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText( MainActivity.this,"cancel clicked",Toast.LENGTH_SHORT ).show();
            }
        } );
        myAlert.show();
    }

    public void showDatePicker(View view) {
        DialogFragment dialogFragment = new DatePickerFragment();
        dialogFragment.show( getSupportFragmentManager(),"datePicker" );
    }
    public void processDatePickerResylt(int year, int month, int day){
        String year_string = Integer.toString( year );
        String month_string = Integer.toString( month );
        String day_string = Integer.toString( day );
        String date = (day_string+"  "+month_string+"  "+year_string);
        date_et.setText( date );
    }

    public void showTime(View view) {
        DialogFragment dialogFragment = new TimePickerFragment();
        dialogFragment.show( getSupportFragmentManager(),"timePicker" );
    }
    public void processTimePickerResylt(int hour,int minutes){
        String hour_string = Integer.toString( hour );
        String minute_string = Integer.toString( minutes );
        String time = (hour_string+":"+minute_string);
        time_et.setText( time );

    }
}
