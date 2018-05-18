package com.example.fadi.supermarket.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.fadi.supermarket.R;
import com.example.fadi.supermarket.activity.HomeActivity;
import com.example.fadi.supermarket.database.DataBaseHelper;

import static android.content.Context.MODE_PRIVATE;

public class LoginFragment extends Fragment {


    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View myView = inflater.inflate(R.layout.fragment_login, container, false);

        Button loginButton = (Button) myView.findViewById(R.id.finalLoginButton);
        final EditText emailET = (EditText) myView.findViewById(R.id.emailLogin);
        final EditText passwordET = (EditText) myView.findViewById(R.id.passwordLogin);
        final CheckBox rememberCheck = (CheckBox) myView.findViewById(R.id.loginRemember);

        final SharedPreferences sharedPreferences = getActivity().getSharedPreferences("ApplicationUsers", MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences.edit();

        if (!(sharedPreferences.getString("email", "noValue").equals("noValue"))) {
            emailET.setText(sharedPreferences.getString("email", "noValue"));
            passwordET.setText(sharedPreferences.getString("password", "noValue"));
            rememberCheck.setChecked(true);
        }

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = emailET.getText().toString();
                String password = passwordET.getText().toString();

                if (rememberCheck.isChecked()) {
                    if (!(sharedPreferences.getString("email", "noValue").equals("noValue"))) {
                        editor.putString("email", email);
                        editor.putString("password", password);
                        editor.commit();
                    }
                }

                loginUser(email, password);
            }
        });

        return myView;
    }

    public void loginUser(String email, String password) {

        DataBaseHelper dataBaseHelper = new DataBaseHelper(getActivity());
        Cursor cursor = dataBaseHelper.getUser(email);

        String realPassword = null;

        if(cursor != null && cursor.getCount() != 0) {
            cursor.moveToFirst();
            realPassword = cursor.getString(2);
        }

        if (realPassword != null && password.equals(realPassword)) {
            Intent homeIntent = new Intent(getActivity(), HomeActivity.class);
            startActivity(homeIntent);
        } else {
            Toast.makeText(getActivity(), "Wrong email or password!",
                    Toast.LENGTH_LONG).show();
        }
    }
}
