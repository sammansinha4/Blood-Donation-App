package lifedonor.lifedonor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class BloodBanks extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bloodbanks);


        Button searchbb= (Button)findViewById(R.id.searchbb);
        searchbb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent search= new Intent(BloodBanks.this, BloodBankList.class);
                startActivity(search);
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

            Intent intentcontact= new Intent(BloodBanks.this,ContactUs.class);
            startActivity(intentcontact);
            return true;
        }
        if (id==R.id.id_about)
        {

            Intent intentabout= new Intent(BloodBanks.this, AboutUs.class);
            startActivity(intentabout);
            return true;
        }
        if (id == R.id.logout) {
            Intent intentlogout = new Intent(BloodBanks.this, LoginSignup.class);
            startActivity(intentlogout);
            return true;
        }
        return true;
    }

}
