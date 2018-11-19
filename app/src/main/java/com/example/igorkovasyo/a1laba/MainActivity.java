package com.example.igorkovasyo.a1laba;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText password;
    EditText password_confirm;
    EditText phone;
    EditText email;
    EditText first_name;
    EditText last_name;
    TextView res;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    String phonePattern = "^(\\+38)?[0-9]{10}$";
    boolean flag;

    SharedPreferences shared;
    ArrayList<String> name;
    ArrayList<String> number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        shared = getSharedPreferences("users_list", MODE_PRIVATE);

        name = new ArrayList<>();
        number = new ArrayList<>();

        password =  findViewById(R.id.password);
        password_confirm =  findViewById(R.id.confirm);
        phone =  findViewById(R.id.phone);
        email =  findViewById(R.id.email);
        first_name =  findViewById(R.id.first_name);
        last_name =  findViewById(R.id.last_name);
        res = findViewById(R.id.result);

        Button btn_submit = findViewById(R.id.btn_submit);
        Button btn_view = findViewById(R.id.view_list);

        flag = true;
        btn_submit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                flag = true;
                res.setText("");
                CheckFields();
                CheckPassword();
                CheckEmail();
                CheckPhone();
                if(flag == true) {
                    res.setText("Authorization is successful");
                    User user = new User(first_name.getText().toString(),
                            last_name.getText().toString(),
                            phone.getText().toString());
                    saveData(user);
                    Clear();
                }
            }
        });

        btn_view.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
            }
        });
    }

    public void CheckPassword(){
        if(password.getText().toString().equals(password_confirm.getText().toString()) == false) {
            res.setText(res.getText().toString() + "\n The password do not match");
            flag = false;
        }

        if(password.getText().toString().trim().length() < 8 || password_confirm.getText().toString().trim().length() < 8) {
            res.setText(res.getText().toString() + "\n Short password");
            flag = false;
        }
    }

    public void CheckEmail(){
        if (email.getText().toString().trim().matches(emailPattern) == false) {
            res.setText(res.getText().toString() + "\n The email is not valid");
            flag = false;
        }
    }

    public void CheckPhone() {
        if (phone.getText().toString().trim().matches(phonePattern) == false) {
            res.setText(res.getText().toString() + "\n Phone is not valid");
            flag = false;
        }
    }

    public void CheckFields(){
        if(password.getText().toString().trim().length() == 0 || password_confirm.getText().toString().trim().length() == 0 || phone.getText().toString().trim().length() == 0
                || email.getText().toString().trim().length() == 0 || first_name.getText().toString().trim().length() == 0 || last_name.getText().toString().trim().length() == 0) {
            res.setText(res.getText().toString() + "\n Enter all fields");
            flag = false;
        }
    }

    public void Clear(){
        password.setText("");
        password_confirm.setText("");
        email.setText("");
        phone.setText("");
        first_name.setText("");
        last_name.setText("");
    }

    private void saveData(User user){
        SharedPreferences mPrefs = getSharedPreferences("user", Context.MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = mPrefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(user);
        prefsEditor.putString("user", json);
        prefsEditor.apply();
    }

}