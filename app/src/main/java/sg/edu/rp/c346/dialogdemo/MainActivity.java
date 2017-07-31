package sg.edu.rp.c346.dialogdemo;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    //Simple Dialog Step 2a
    Button btnSimpleDialog;

    //Step 2a for Part2
    TextView tvPart2;
    Button btnPart2;

    //Step 2a for Part3
    TextView tvPart3;
    Button btnPart3;

    //Step 2a for Part4
    TextView tvPart4;
    Button btnPart4;

    //Step 2a for Part4
    TextView tvPart5;
    Button btnPart5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Simple Dialog Step 2b - binding for SimpleDialog
        btnSimpleDialog =(Button)findViewById(R.id.buttonSimpleDialog);

        //step 2c for SimpleDialog
        btnSimpleDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Create the Dialog Builder
                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);
                //if i put below, then the "Close" will not show.
                myBuilder.setPositiveButton("Close", null);
                myBuilder.setTitle("Simple Dialog");
                myBuilder.setMessage("I can develop Android App");
                myBuilder.setCancelable(false);


                AlertDialog myDialog = myBuilder.create();

                myDialog.show();


            }
        });
        //step 2b for Part2
        btnPart2 =(Button)findViewById(R.id.buttonPart2);
        tvPart2 = (TextView) findViewById(R.id.textViewPart2);

        //step 2c for Part2
        btnPart2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);

                myBuilder.setTitle("Demo 2 Buttons Dialog");
                myBuilder.setMessage("Select one of the Button below.");
                myBuilder.setCancelable(false);
                // Configure the 'positive' button
                myBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // IMPORTANT: Update TextView as a form of data passing between Dialog and MainActivity
                        tvPart2.setText("You have selected Yes.");
                    }
                });

                // Configure the 'negative' button
                myBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // IMPORTANT: Update TextView as a form of data passing between Dialog and MainActivity
                        tvPart2.setText("You have selected No.");
                    }
                });

                // Configure the 'neutral' button
                myBuilder.setNeutralButton("Cancel", null);
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();


            }
        });
        //Simple Dialog Step 2b - binding for Part3
        btnPart3 =(Button)findViewById(R.id.ButtonPart3);
        tvPart3 = (TextView) findViewById(R.id.textViewPart3);
        btnPart3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*

                //Inflate the input.xml layout file
                LayoutInflater inflater =
                        (LayoutInflater)getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View viewDialog = inflater.inflate(R.layout.input, null);


                final EditText etInput = (EditText)viewDialog.findViewById(R.id.editTextInput);
                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);

                // Set the view of the dialog
                myBuilder.setView(viewDialog);
                myBuilder.setTitle("Demo 3-Text Input Dialog");

                myBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        // Extract the Text entered by the user
                        String message = etInput.getText().toString();
                        // Update the Text to TextView
                        tvPart3.setText(message);
                    }
                });
                */

                //Part 3
                //Worksheet Exercise
                //Inflate the input.xml layout file
                LayoutInflater inflater = (LayoutInflater)getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View viewDialog = inflater.inflate(R.layout.input2, null);

                // Obtain the UI component in the input.xml layout

                final EditText etInput1 = (EditText)viewDialog.findViewById(R.id.editTextNum1);
                final EditText etInput2 = (EditText)viewDialog.findViewById(R.id.editTextNum2);
                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);

                // Set the view of the dialog
                myBuilder.setView(viewDialog);
                myBuilder.setTitle("Demo 3-Text Input Dialog");

                myBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        // Extract the Text entered by the user
                        /*String message1 = etInput1.getText().toString();
                        String message2 = etInput2.getText().toString();
                        */
                        float sum = Integer.parseInt(etInput1.getText().toString())+ Integer.parseInt(etInput2.getText().toString());

                        // Update the Text to TextView
                        tvPart3.setText("The sum is " + sum);
                    }
                });


                myBuilder.setNegativeButton("Cancel", null);

                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });
        btnPart4 =(Button)findViewById(R.id.ButtonPart4);
        tvPart4 = (TextView) findViewById(R.id.textViewPart4);

        btnPart4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Creating the Listener to set the date
                /*DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear,
                                          int dayOfMonth) {
                        tvPart4.setText("Date: " + dayOfMonth + "/" + (monthOfYear+1) + "/" + year);
                    }
                };

                // Create the Date Picker Dialog
                DatePickerDialog myDateDialog = new DatePickerDialog(MainActivity.this,
                        myDateListener, 2014, 11, 31);

                myDateDialog.show();*/

               final Calendar now = Calendar.getInstance();
                int currentYear = now.get((Calendar.YEAR));
                int currentMonth = (now.get((Calendar.MONTH))+1);
                int currentDay = now.get((Calendar.DAY_OF_MONTH));

               tvPart4.setText(currentDay+"/"+currentMonth+"/"+currentYear);
            }
        });
        btnPart5 =(Button)findViewById(R.id.ButtonPart5);
        tvPart5 = (TextView) findViewById(R.id.textViewPart5);

        btnPart5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Creating the Listener to set the time
                TimePickerDialog.OnTimeSetListener myTimeListener = new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                        tvPart5.setText("Time: " + hourOfDay + ":" + minute);
                    }
                };

               /* // Create the Time Picker Dialog
                TimePickerDialog myTimeDialog = new TimePickerDialog(MainActivity.this,
                        myTimeListener, 20, 00, true);

                myTimeDialog.show();*/
             Calendar now = Calendar.getInstance();
                int hour = now.get((Calendar.HOUR_OF_DAY));
                int minute = (now.get((Calendar.MINUTE)));
               TimePickerDialog myTimeDialog = new TimePickerDialog(MainActivity.this,
                       myTimeListener, hour, minute, true);
                myTimeDialog.show();

            }
        });






    }

}
