package lifedonor.lifedonor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;
import static android.text.Html.*;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import lifedonor.lifedonor.ContactUs.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ContactUs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contactus);

        final EditText editText = (EditText) findViewById(R.id.editText);
        final EditText editText2 = (EditText) findViewById(R.id.editText2);
        final EditText editText3 = (EditText) findViewById(R.id.editText3);
        final EditText editText4 = (EditText) findViewById(R.id.editText4);

        Button submit = (Button) findViewById(R.id.send_query);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = editText.getText().toString();
                String email = editText2.getText().toString();
                String subject = editText3.getText().toString();
                String message = editText4.getText().toString();
                if (TextUtils.isEmpty(name)) {
                    editText.setError("Enter Your Full Name");
                    editText.requestFocus();
                    return;
                }

                Boolean onError = false;
                if (!isValidEmail(email)) {
                    onError = true;
                    editText2.setError("Invalid Email");
                    return;
                }

                if (TextUtils.isEmpty(subject)) {
                    editText3.setError("Enter the Subject");
                    editText3.requestFocus();
                    return;
                }

                if (TextUtils.isEmpty(message)) {
                    editText4.setError("Enter Your Message");
                    editText4.requestFocus();
                    return;
                }

                Intent sendMessage = new Intent(android.content.Intent.ACTION_SEND);


                /* Fill it with the Data */
                sendMessage.setType("plain/text");
                sendMessage.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{"sammansinha@gmail.com"});
                sendMessage.putExtra(android.content.Intent.EXTRA_SUBJECT, subject);
                sendMessage.putExtra(android.content.Intent.EXTRA_TEXT,
                        "name:"+name+'\n'+"Email ID:"+email+'\n'+"Message:"+'\n'+message);

            /* Now Send it off to the Activitychooser */
                startActivity(Intent.createChooser(sendMessage, "Send message..."));



            }

        });
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