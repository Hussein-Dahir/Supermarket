package com.example.fadi.supermarket.fragment;


import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.fadi.supermarket.R;
import com.example.fadi.supermarket.activity.MainActivity;
import com.example.fadi.supermarket.async.task.AsyncResponse;
import com.example.fadi.supermarket.async.task.RegisterAsyncTaskRunner;
import com.example.fadi.supermarket.database.DataBaseHelper;
import com.example.fadi.supermarket.model.User;

import static android.content.Context.MODE_PRIVATE;


/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterFragment extends Fragment {


    public RegisterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View myView = inflater.inflate(R.layout.fragment_register, container, false);

        Button registerButton = (Button) myView.findViewById(R.id.finalRegisterButton);
        final EditText nameET = (EditText) myView.findViewById(R.id.nameRegister);
        final EditText passwordET = (EditText) myView.findViewById(R.id.passwordRegister);
        final EditText emailET = (EditText) myView.findViewById(R.id.emailRegister);
        final EditText passwordCET = (EditText) myView.findViewById(R.id.passwordCRegister);
        final CheckBox rememberCheckBox = (CheckBox) myView.findViewById(R.id.registerRemember);
        final SharedPreferences sharedPreferences = getActivity().getSharedPreferences("ApplicationUsers", MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences.edit();

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nameET.getText().toString();
                String password = passwordET.getText().toString();
                String email = emailET.getText().toString();
                String passwordC = passwordCET.getText().toString();
                if (passwordC.equals(password)) {
                    if(rememberCheckBox.isChecked()){
                        editor.putString("email", email);
                        editor.putString("password", password);
                        editor.commit();
                    }

                    registerUser(email, name, password);

                } else {
                    passwordCET.setText("");
                    passwordCET.setHint("Please make sure both are matching");
                }
            }

        });
        // Inflate the layout for this fragment
        return myView;
    }

    public void registerUser(String email, String name, String password) {

        User user = new User(email, name, password);

        DataBaseHelper dataBaseHelper = new DataBaseHelper(getActivity());
        dataBaseHelper.insertUser(user);

        boolean successfullyRegistered = true;

        if (successfullyRegistered) {
            LoginFragment loginFragment = new LoginFragment();
            FragmentManager fragmentManager2 = getFragmentManager();
            FragmentTransaction fragmentTransaction2 = fragmentManager2.beginTransaction();
            fragmentTransaction2.remove(fragmentManager2.findFragmentByTag("registerFragment"));
            fragmentTransaction2.add(R.id.linearLayout2, loginFragment, "loginFragment");
            fragmentTransaction2.commit();
        } else {
            // TODO: show error message to user, that register failed
        }
    }
}
