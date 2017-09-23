package lifedonor.lifedonor;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.widget.Toast;


import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.jar.Attributes;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BecomeDonor extends AppCompatActivity {

    private EditText namebecome;
    private EditText agebecome;
    private EditText mobilebecome;
    private EditText emailbecome;
    private EditText bloodgrp;
    private Button submitbd;
    private ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.becomedonor);

        final Context context = this;

        namebecome = (EditText) findViewById(R.id.namebecome);
        agebecome = (EditText) findViewById(R.id.agebecome);
        mobilebecome = (EditText) findViewById(R.id.mobilebecome);
        emailbecome = (EditText) findViewById(R.id.emailbecome);
        bloodgrp = (EditText) findViewById(R.id.bloodgrp);
        submitbd = (Button) findViewById(R.id.submitbd);

        submitbd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                        context);
                // set title
                alertDialogBuilder.setTitle("Thanks For Donating :)");

                // set dialog message
                alertDialogBuilder
                        .setMessage("Close Window ?")
                        .setCancelable(false)
                        .setPositiveButton("Close", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // if this button is clicked, close
                                // current activity
                               BecomeDonor.this.finish();
                            }
                        });

                // create alert dialog
                AlertDialog alertDialog = alertDialogBuilder.create();

                // show it
                alertDialog.show();
            }
        });
    }



    @Override
    public boolean onCreateOptionsMenu(Menu manu){
        getMenuInflater().inflate(R.menu.main, manu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id= item.getItemId();
        if(id==R.id.id_contact){
            Intent intentcontact= new Intent(BecomeDonor.this,ContactUs.class);
            startActivity(intentcontact);
            return true;
        }
        if (id==R.id.id_about) {
            Intent intentabout = new Intent(BecomeDonor.this, ContactUs.class);
            startActivity(intentabout);
            return true;
        }
            if (id == R.id.logout) {
                Intent intentlogout = new Intent(BecomeDonor.this, LoginSignup.class);
                startActivity(intentlogout);
                return true;
            }
        return true;
    }

    // check for validating email id

    private boolean isValidEmail(String email) {
        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

}

