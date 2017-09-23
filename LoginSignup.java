package lifedonor.lifedonor;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

public class LoginSignup extends AppCompatActivity implements View.OnClickListener {


    private EditText namelgn;
    private EditText passwordlgn;
    private Button loginin;

    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginsignup);

        loginin = (Button) findViewById(R.id.loginin);
        passwordlgn = (EditText) findViewById(R.id.passwordlgn);
        namelgn = (EditText) findViewById(R.id.namelgn);

        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);



        TextView tvsignup = (TextView) findViewById(R.id.tvsignup);
        TextView forgotpass = (TextView) findViewById(R.id.forgotpass);
        Button loginin = (Button) findViewById(R.id.loginin);

        loginin.setOnClickListener(this);

        tvsignup.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent signup = new Intent(LoginSignup.this, SignUp.class);
                startActivity(signup);
            }
        });


        forgotpass.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent forgotpassword = new Intent(LoginSignup.this, ForgotPassword.class);
                startActivity(forgotpassword);
            }
        });


    }


    private void userLogin() {
        String email = namelgn.getText().toString().trim();
        String password = passwordlgn.getText().toString().trim();

        //checking if email and passwords are empty
        if (TextUtils.isEmpty(email)) {
            namelgn.setError("Enter Your Email");
            namelgn.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            passwordlgn.setError("Enter the Password");
            passwordlgn.requestFocus();
            return;
        }

        progressDialog.setMessage("Signing in you as " +email);
        progressDialog.show();

        //signin credentials with firebase
        firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();
                        //if the task is successfull
                        if (task.isSuccessful()) {
                            //start the profile activity
                            finish();
                            startActivity(new Intent(getApplicationContext(), LifeDonor.class));
                        }else{
                            //display some message here
                            Toast.makeText(LoginSignup.this,"Something Went Wrong",Toast.LENGTH_LONG).show();
                        }
                        progressDialog.dismiss();

                    }
                });


    }

    @Override
    public void onClick(View view) {
        if(view==loginin){
            userLogin();

    }
}


}
