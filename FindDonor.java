package lifedonor.lifedonor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class FindDonor extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.finddonor);

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
            Intent intentcontact= new Intent(FindDonor.this,ContactUs.class);
            startActivity(intentcontact);
            return true;
        }
        if (id==R.id.id_about)
        {
            Intent intentabout= new Intent(FindDonor.this,ContactUs.class);
            startActivity(intentabout);
            return true;
        }
        if (id == R.id.logout) {
            Intent intentlogout = new Intent(FindDonor.this, LoginSignup.class);
            startActivity(intentlogout);
            return true;
        }
        return true;
    }
}
