package rashmi.umkc.edu.samplecalendarapp;

import java.util.Calendar;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.app.DatePickerDialog;
import com.example.displaycalendareventintent.R;
import java.text.SimpleDateFormat;
import java.util.Locale;


public class MainActivity extends Activity {
    EditText yourCalenderset ;
    // initiate month,day and year
    int Month;
    int Day;
    int Year;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button disp = (Button) findViewById(R.id.dispbut);
        disp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                disp();
            }
        });
        yourCalenderset = (EditText) findViewById(R.id.calenderset);
        yourCalenderset.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            Calendar currentDate = Calendar.getInstance();
            // Get the current day,month and year
            Month = currentDate.get(Calendar.MONTH);
            Day = currentDate.get(Calendar.DAY_OF_MONTH);
            Year = currentDate.get(Calendar.YEAR);
            DatePickerDialog DatePicker = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                public void onDateSet(DatePicker datepicker, int selectmonth, int selectday, int selectyear) {
                    Calendar deviceCalendar = Calendar.getInstance();// get my device calender
                    String myFormat = "MM/dd/yy";// the date should be in format of month day and year
                    SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);// Simple date format
                    yourCalenderset.setText(sdf.format(deviceCalendar.getTime()));
                    // select month day and year
                    Month = selectmonth;
                    Day = selectday;
                    Year = selectyear;
                }
            }, Year, Month, Day);
            DatePicker.show();
        }
    });
}
public void disp() {
        Calendar startTime = Calendar.getInstance();
        startTime.set(2013, 2, 13, 11, 35);
        Uri uri = Uri.parse("content://com.android.calendar/time/"
                + String.valueOf(startTime.getTimeInMillis()));
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        // Use the Calendar app to view the time.
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}