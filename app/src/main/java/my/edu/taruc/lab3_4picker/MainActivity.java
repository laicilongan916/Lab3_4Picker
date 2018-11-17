package my.edu.taruc.lab3_4picker;

import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    int age = 0;
    Integer ageInt = 0;
    String ageStr;

    TextView textViewMsg = findViewById(R.id.buttonDoB);
    TextView textViewAge = findViewById(R.id.textViewAge);
    TextView textViewAccBalance = findViewById(R.id.editTextAccBalance);
    TextView textViewEligibleAmt = findViewById(R.id.textViewEligibleAmt);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void showDatePicker(View view) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(),"datePicker");
    }

    public void processDatePickerResult(int year, int month, int day) {
        String day_string = Integer.toString(day);
        String month_string = Integer.toString(month+1);
        String year_string = Integer.toString(year);
        String dateMessage = (day_string + "/" + month_string + "/" + year_string);

        textViewMsg.setText(dateMessage);

        getAge(day_string,month_string,year_string);
    }

    public void getAge(String year, String month, String day)
    {
        Calendar DoB =  Calendar.getInstance();
        Calendar currentDay = Calendar.getInstance();

        DoB.set(Integer.parseInt(day),Integer.parseInt(month),Integer.parseInt(year));

        age = currentDay.get(Calendar.YEAR) - DoB.get(Calendar.YEAR);

        ageInt = new Integer(age);
        ageStr = ageInt.toString();

        textViewAge.setText(ageStr);
    }

    public void getEligibleAmt (View view)
    {
        double minBasicSaving = 0.0;

        if (ageInt >= 16 && ageInt <= 20)
        {
            minBasicSaving = 5000.00;
        }
        else if (ageInt >= 21 && ageInt <= 25)
        {
            minBasicSaving = 14000.00;
        }
        else if (ageInt >= 26 && ageInt <= 30)
        {
            minBasicSaving = 29000.00;
        }
        else if (ageInt >= 31 && ageInt <= 35)
        {
            minBasicSaving = 50000.00;
        }
        else if (ageInt >= 36 && ageInt <= 40)
        {
            minBasicSaving = 78000.00;
        }
        else if (ageInt >= 41 && ageInt <= 45)
        {
            minBasicSaving = 116000.00;
        }
        else if (ageInt >= 46 && ageInt <= 50)
        {
            minBasicSaving = 165000.00;
        }
        else if (ageInt >= 51 && ageInt <= 55)
        {
            minBasicSaving = 228000.00;
        }

        //double balance ;
        int accBalance = Integer.parseInt(textViewAccBalance.getText().toString());

        if (accBalance <= minBasicSaving)
        {
            textViewEligibleAmt.setText("NOT ELIGIBLE");
        }
        else
        {
            double balance = (accBalance - minBasicSaving)* 0.3 ;
            textViewEligibleAmt.setText(String.valueOf(balance));
        }
    }

    public void reset(View view)
    {

    }
}
