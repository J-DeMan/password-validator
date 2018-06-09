package com.deman.jerrett.password_validator;

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

        final Button validateButton = (Button)findViewById(R.id.validateButton);
        final EditText inputField = (EditText)findViewById(R.id.inputField);
        final TextView resultField = (TextView)findViewById(R.id.resultField);

        validateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = inputField.getText().toString();

                if (Validator.validate(input) > 0) {
                    resultField.setText("Password is not string enough.");
                }
                else {
                    resultField.setText("Password is strong.");
                }
            }
        });
    }


}
