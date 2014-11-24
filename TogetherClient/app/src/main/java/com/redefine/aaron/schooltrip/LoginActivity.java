package com.redefine.aaron.schooltrip;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class LoginActivity extends Activity {
    private EditText usernameET;
    private EditText pwdET;
    private Button loginBT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        usernameET = (EditText) findViewById(R.id.username);
        pwdET = (EditText) findViewById(R.id.password);
        loginBT = (Button) findViewById(R.id.login_btn);
        loginBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = usernameET.getText().toString();
                String pwd = pwdET.getText().toString();
                if(username.equals("aaron"))
                    if(pwd.equals("123456")){
                        Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                        startActivity(intent);
                        LoginActivity.this.finish();
                    }
                else{
                        Toast.makeText(LoginActivity.this,"帐号或密码错误",Toast.LENGTH_SHORT).show();
                    }
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
