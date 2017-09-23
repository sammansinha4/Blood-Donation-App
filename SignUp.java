package lifedonor.lifedonor;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.android.gms.tasks.OnCompleteListener;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignUp extends AppCompatActivity implements View.OnClickListener{

    private Button registersg;
    private EditText fullname;
    private EditText usernamereg;
    private EditText emailreg;
    private EditText passwordreg;
    private EditText cpasswordreg;

    private ProgressDialog progressDialog;

    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);


        firebaseAuth= FirebaseAuth.getInstance();


        progressDialog = new ProgressDialog(this);
        registersg= (Button) findViewById(R.id.registersg);
        fullname= (EditText) findViewById(R.id.fullname);
        emailreg= (EditText) findViewById(R.id.emailreg);
        passwordreg= (EditText) findViewById(R.id.passwordreg);
        cpasswordreg= (EditText) findViewById(R.id.cpasswordreg);

        registersg.setOnClickListener(this);
    }

    private void registerUser(){
        String email= emailreg.getText().toString().trim();
        String password= passwordreg.getText().toString().trim();
        String name= fullname.getText().toString().trim();
        String confirm= cpasswordreg.getText().toString().trim();



        if(TextUtils.isEmpty(name)){
            //name is empty
            fullname.setError("Enter Your FullName");
            fullname.requestFocus();
            return;
        }

        if(TextUtils.isEmpty(password)){
            //pssword is empty
            passwordreg.setError("Enter the Subject");
            passwordreg.requestFocus();
            return;

        }
        Boolean onError = false;
        if (!isValidEmail(email)) {
            onError = true;
            emailreg.setError("Invalid Email");
            return;
        }
        if(TextUtils.isEmpty(confirm)){
            //email is empty
            cpasswordreg.setError("Enter the Subject");
            cpasswordreg.requestFocus();
            return;
        }



        //displaying a progress dialog

        progressDialog.setMessage("Hola! Registering Please Wait...");
        progressDialog.show();




        //creating a new user
        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        //checking if success
                        if(task.isSuccessful()){
                            finish();
                            startActivity(new Intent(getApplicationContext(), LoginSignup.class));
                        }else{
                            //display some message here
                            Toast.makeText(SignUp.this,"Registration Error",Toast.LENGTH_LONG).show();
                        }
                        progressDialog.dismiss();

                    }
                });

    }
    @Override
    public void onClick(View view) {
        if (view == registersg){
            registerUser();
        }

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
