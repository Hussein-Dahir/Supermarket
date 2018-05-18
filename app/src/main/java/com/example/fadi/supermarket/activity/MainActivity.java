package com.example.fadi.supermarket.activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.fadi.supermarket.fragment.LoginFragment;
import com.example.fadi.supermarket.R;
import com.example.fadi.supermarket.fragment.RegisterFragment;

public class MainActivity extends AppCompatActivity {

    public static boolean inLoginPage = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LoginFragment loginFragment = new LoginFragment();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        setTitle("Login Screen");
        setContentView(R.layout.activity_main);
        LinearLayout twoButtonLinearLayout = (LinearLayout) findViewById(R.id.linearLayoutButtons);
        twoButtonLinearLayout.setBackgroundDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.edit_text_style));
        fragmentTransaction.add(R.id.linearLayout2, loginFragment, "loginFragment");
        fragmentTransaction.commit();

        final Button registerChoice = (Button) findViewById(R.id.registerButton);
        final Button loginChoice = (Button) findViewById(R.id.loginButton);

        loginChoice.setBackgroundColor(Color.GRAY);
        registerChoice.setBackgroundColor(Color.WHITE);
        registerChoice.setTextColor(Color.GRAY);
        loginChoice.setTextColor(Color.WHITE);

        loginChoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!inLoginPage) {
                    LoginFragment loginFragment = new LoginFragment();
                    FragmentManager fragmentManager2 = getFragmentManager();
                    FragmentTransaction fragmentTransaction2 = fragmentManager2.beginTransaction();
                    fragmentTransaction2.remove(fragmentManager2.findFragmentByTag("registerFragment"));
                    fragmentTransaction2.add(R.id.linearLayout2, loginFragment, "loginFragment");

                    loginChoice.setBackgroundColor(Color.GRAY);
                    registerChoice.setBackgroundColor(Color.WHITE);
                    registerChoice.setTextColor(Color.GRAY);
                    loginChoice.setTextColor(Color.WHITE);
                    fragmentTransaction2.commit();
                    inLoginPage = true;
                }
            }
        });

        registerChoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (inLoginPage) {
                    RegisterFragment registerFragment = new RegisterFragment();
                    FragmentManager fragmentManager2 = getFragmentManager();
                    FragmentTransaction fragmentTransaction2 = fragmentManager2.beginTransaction();
                    fragmentTransaction2.remove(fragmentManager2.findFragmentByTag("loginFragment"));
                    fragmentTransaction2.add(R.id.linearLayout2, registerFragment, "registerFragment");

                    loginChoice.setBackgroundColor(Color.WHITE);
                    registerChoice.setBackgroundColor(Color.GRAY);
                    registerChoice.setTextColor(Color.WHITE);
                    loginChoice.setTextColor(Color.GRAY);
                    fragmentTransaction2.commit();
                    inLoginPage = false;
                }
            }
        });

    }
}
