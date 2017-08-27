package com.chi_square.movierating;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button signup = (Button) findViewById(R.id.signupButton);
        Button login = (Button) findViewById(R.id.loginButton);

        final EditText name = (EditText) findViewById(R.id.name);
        final EditText password = (EditText) findViewById(R.id.password);
        final EditText email = (EditText) findViewById(R.id.email);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if( name.getText().toString().length() == 0 ){
                    name.setError( "Name is required!" );
                    name.requestFocus();
                    return;
                }
                if( email.getText().toString().length() == 0 ){
                    email.setError( "Email is required!" );
                    email.requestFocus();
                    return;
                }
                if( !android.util.Patterns.EMAIL_ADDRESS.matcher( email.getText().toString() ).matches() ){
                    email.setError( "Enter a valid E-Mail!" );
                    email.requestFocus();
                    return;
                }
                if( password.getText().toString().length() == 0 ){
                    password.setError( "Password is required!" );
                    password.requestFocus();
                    return;
                }
                Intent i = new Intent(view.getContext(),RateActivity.class);
                startActivity(i);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(),LoginActivity.class);
                startActivity(i);
            }
        });
    }
}
