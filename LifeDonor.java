package lifedonor.lifedonor;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
public class LifeDonor extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.lifedonor);


        Button button1 = (Button) findViewById(R.id.button1);
        Button button2 = (Button) findViewById(R.id.button2);
        Button button3 = (Button) findViewById(R.id.button3);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int1 = new Intent(LifeDonor.this, FindDonor.class);
                startActivity(int1);

            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int2 = new Intent(LifeDonor.this, BloodBanks.class);
                startActivity(int2);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int3 = new Intent(LifeDonor.this, BecomeDonor.class);
                startActivity(int3);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu manu) {
        getMenuInflater().inflate(R.menu.main, manu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.id_contact) {

            Intent intentcontact = new Intent(LifeDonor.this, ContactUs.class);
            startActivity(intentcontact);
            return true;
        }
        if (id == R.id.id_about) {
            Intent intentabout = new Intent(LifeDonor.this, AboutUs.class);
            startActivity(intentabout);
            return true;
        }
        if (id == R.id.logout) {
            Intent intentlogout = new Intent(LifeDonor.this, LoginSignup.class);
            startActivity(intentlogout);
            return true;
        }
        return true;
    }
    }