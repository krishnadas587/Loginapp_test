package com.example.login_page;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void Login(View view){
        EditText username=findViewById(R.id.user_name);
        EditText password=findViewById(R.id.password);
        if (check_credentials(username.getText().toString(),password.getText().toString())){
            Intent intent=new Intent(MainActivity.this,HomePage.class);
            startActivity(intent);
            finish();
        }else {
            Toast.makeText(getApplicationContext(),"Please check credentials",Toast.LENGTH_SHORT).show();
        }

    }
    boolean check_credentials(String id,String pass){
        if(id.equals("admin")&&pass.equals("admin")){
            return true;
        }
        return false;
    }
}