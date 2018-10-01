package com.example.igorkovasyo.a1laba;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText pass =  findViewById(R.id.password);
        final EditText pass2 = findViewById(R.id.confirm);
        final EditText phone = findViewById(R.id.phone);
        final EditText email = findViewById(R.id.email);
        final EditText f_name = findViewById(R.id.first_name);
        final EditText l_name = findViewById(R.id.last_name);
        final String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        final String phonePattern = "^(\\+38)?[0-9]{10}$";
        final TextView res = findViewById(R.id.result);
        Button btn_submit = findViewById(R.id.btn_submit);
        btn_submit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                boolean flag = true;
                res.setText("");
                if(pass.getText().toString().equals(pass2.getText().toString()) == false) {
                    res.setText(res.getText().toString() + "\n The password do not match");
                    flag = false;
                }
                if (email.getText().toString().trim().matches(emailPattern) == false) {
                    res.setText(res.getText().toString() + "\n The email is not valid");
                    flag = false;
                }
                if(pass.getText().toString().trim().length() == 0 || pass2.getText().toString().trim().length() == 0 || phone.getText().toString().trim().length() == 0
                        || email.getText().toString().trim().length() == 0 || f_name.getText().toString().trim().length() == 0 || l_name.getText().toString().trim().length() == 0) {
                    res.setText(res.getText().toString() + "\n Enter all fields");
                    flag = false;
                }

                if(pass.getText().toString().trim().length() < 8 || pass2.getText().toString().trim().length() < 8) {
                    res.setText(res.getText().toString() + "\n Short password");
                    flag = false;
                }
                if(phone.getText().toString().trim().matches(phonePattern) == false) {
                    res.setText(res.getText().toString() + "\n Phone is not valid");
                    flag = false;
                }
                if(flag == true) {
                    res.setText("Authorization is successful");
                }
            }
        });
    }
}