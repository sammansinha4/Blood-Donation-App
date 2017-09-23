package lifedonor.lifedonor;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;

import java.util.Random;

public class SplashScreen extends AppCompatActivity {
    Thread thread;
    ImageView imageView;
    ActionBar actionBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscreen);
        imageView = (ImageView)findViewById(R.id.imLogo);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);

        thread = new Thread() {
            @Override
            public void run() {
                try {
                    int waited = 0;
                    // Splash screen pause time
                    while (waited < 3500) {
                        sleep(50);
                        waited += 100;
                    }
                    Intent intent = new Intent(SplashScreen.this,
                            LoginSignup.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(intent);
                    SplashScreen.this.finish();
                } catch (InterruptedException e) {
                    // do nothing
                } finally {
                    SplashScreen.this.finish();
                }

            }
        };
        thread.start();
    }
}