package com.example.fadi.supermarket.activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.fadi.supermarket.fragment.LoginFragment;
import com.example.fadi.supermarket.R;
import com.example.fadi.supermarket.fragment.RegisterFragment;

public class MainActivity extends AppCompatActivity {

    private boolean inLoginPage = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LoginFragment loginFragment = new LoginFragment();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        setTitle("Login Screen");
        setContentView(R.layout.activity_main);

        fragmentTransaction.add(R.id.linearLayout2, loginFragment, "loginFragment");
        fragmentTransaction.commit();

        final Button registerChoice = (Button) findViewById(R.id.registerButton);
        final Button loginChoice = (Button) findViewById(R.id.loginButton);


        loginChoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!inLoginPage) {
                    LoginFragment loginFragment = new LoginFragment();
                    FragmentManager fragmentManager2 = getFragmentManager();
                    FragmentTransaction fragmentTransaction2 = fragmentManager2.beginTransaction();
                    fragmentTransaction2.remove(fragmentManager2.findFragmentByTag("registerFragment"));
                    fragmentTransaction2.add(R.id.linearLayout2, loginFragment, "loginFragment");
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
                    fragmentTransaction2.commit();
                    inLoginPage = false;
                }
            }
        });

    }
}
