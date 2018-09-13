package com.example.igorkovasyo.a1laba;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button buttonHello,   buttonClear;
    EditText inputName;
    EditText inputName2;
    TextView myName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputName = findViewById(R.id.inputName);
        buttonClear = findViewById(R.id.buttonClear);
        buttonHello = findViewById(R.id.buttonHello);
        myName = findViewById(R.id.myName);
    }

    public void clearMessage(View view) {
        inputName.getText().clear();
    }
    public void showMessage(View view) {
        myName.setText("Hello" + " " + inputName .getText().toString());
        inputName.getText().clear();
    }



}
