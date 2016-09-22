package com.example.webonise.broadcastsample;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;

/**
 * Created by webonise on 16/9/16.
 */
public class SignUpActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener, RadioGroup.OnCheckedChangeListener {

    private final String TAG = getClass().getSimpleName();

    private EditText editFirstName;
    private EditText editLastName;
    private EditText editContact;
    private EditText editEmail;
    private EditText editPassword;
    private EditText editConfirmPassword;

    private RadioGroup radioGroup;
    private RadioButton radioButtonMale;
    private RadioButton radioButtonFemale;

    private EditText editAddress;
    private EditText editAnswer;

    private Spinner spinner;
    private Button btnLogin;
    private Button btnCancel;
    private Toast toast;

    private TextInputLayout input_layout_fname, input_layout_lname, input_layout_contact, input_layout_email, input_layout_password, input_layout_confirmPassword;

    private String firstname, lastname, email, password, confirmPassword, gender, address, securityQuestion, securityAnswer, contactString;

    Realm realm;
    int contact;
    private double contactdouble;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);
        Log.v(TAG, "In Signup onCreate");
        realm = Realm.getDefaultInstance();
        initViews();
    }

    private void initViews() {
        spinner = (Spinner) findViewById(R.id.spinner);

        editFirstName = (EditText) findViewById(R.id.editFirstName);
        editLastName = (EditText) findViewById(R.id.editLastName);
        editContact = (EditText) findViewById(R.id.editContact);
        editEmail = (EditText) findViewById(R.id.editEmail);
        editPassword = (EditText) findViewById(R.id.editPassword);
        editConfirmPassword = (EditText) findViewById(R.id.editConfirmPassword);
        editAddress = (EditText) findViewById(R.id.editAddress);
        editAnswer = (EditText) findViewById(R.id.editanswer);

        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioButtonMale = (RadioButton) findViewById(R.id.radioButtonMale);
        radioButtonFemale = (RadioButton) findViewById(R.id.radioButtonFemale);

        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnCancel = (Button) findViewById(R.id.btnCancel);

        input_layout_fname = (TextInputLayout) findViewById(R.id.input_layout_fname);
        input_layout_lname = (TextInputLayout) findViewById(R.id.input_layout_lname);
        input_layout_contact = (TextInputLayout) findViewById(R.id.input_layout_contact);
        input_layout_email = (TextInputLayout) findViewById(R.id.input_layout_email);
        input_layout_password = (TextInputLayout) findViewById(R.id.input_layout_password);
        input_layout_confirmPassword = (TextInputLayout) findViewById(R.id.input_layout_cpassword);

        radioGroup.setOnCheckedChangeListener(this);
        spinner.setOnItemSelectedListener(this);
        btnLogin.setOnClickListener(this);
        btnCancel.setOnClickListener(this);

        List<String> itemSpinner = new ArrayList<>();
        itemSpinner.add("What is your nick name?");
        itemSpinner.add("Who is your favourite actor?");
        itemSpinner.add("Which school you went?");
        itemSpinner.add("First pet you had?");
        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, itemSpinner);
        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String item = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btnLogin:
                onLoginButtonClicked();
                break;
            case R.id.btnCancel:
                System.exit(0);
                break;
            default:
                break;
        }
    }

    private void onLoginButtonClicked() {

        firstname = editFirstName.getText().toString();
        lastname = editLastName.getText().toString();
        contactString = editContact.getText().toString();
        email = editEmail.getText().toString();
        password = editPassword.getText().toString();
        confirmPassword = editConfirmPassword.getText().toString();
        address = editAddress.getText().toString();
        securityQuestion = spinner.getSelectedItem().toString();
        securityAnswer = editAnswer.getText().toString();



        if (!valiDateProfile()) {
            Toast toast = Toast.makeText(getApplicationContext(), "Enter Data", Toast.LENGTH_SHORT);
        } else {
            saveToDatabase(firstname, lastname, contact, email, password, confirmPassword, address, securityQuestion, securityAnswer);
            Intent intent = new Intent(this, ActivityMenu.class);
            startActivity(intent);
        }
    }

    private void saveToDatabase(final String fname, final String lname, final int contact, final String email, final String password, final String confirmPassword, final String address, final String securityQuestion, final String securityAnswer) {
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm bgRealm) {
                UserProfile user = realm.createObject(UserProfile.class);
                user.setFname(fname);
                user.setLname(lname);
                user.setContact(contact);
                user.setEmail(email);
                user.setPassword(password);
                user.setConfirmPassword(confirmPassword);
                user.setAddress(address);
                user.setSecurityQuestion(securityQuestion);
                user.setSecurityAnswer(securityAnswer);
            }
        });
        Log.v("message", "Success on data storing");
    }

    private boolean valiDateProfile() {
        String aplhaPattern = "([a-zA-Z]{3,30}\\s*)+";
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        if (firstname.trim().isEmpty()) {
            input_layout_fname.setError("Enter First Name");
            return false;
        } else {
            input_layout_fname.setErrorEnabled(false);
        }
        if (!firstname.matches(aplhaPattern)) {
            input_layout_fname.setError("Enter Valid First Name");
            return false;
        } else {
            input_layout_fname.setErrorEnabled(false);
        }
        if (lastname.trim().isEmpty()) {
            input_layout_lname.setError("Enter Last Name");
            return false;
        } else {
            input_layout_lname.setErrorEnabled(false);
        }
        if (!lastname.matches(aplhaPattern)) {
            input_layout_lname.setError("Enter Valid Last Name with atleast 3 characters");
            return false;
        } else {
            input_layout_lname.setErrorEnabled(false);
        }
        if (contactString.length() > 10 || contactString.length() < 10) {
            contactdouble = Double.parseDouble(contactString);
            contact = (int) contactdouble;
            input_layout_contact.setError("Enter 10 Digit Contact Number");
            return false;
        } else {
            input_layout_contact.setErrorEnabled(false);
        }
        if (email.trim().isEmpty()) {
            input_layout_email.setError("Enter Email ID");
            return false;
        } else {
            input_layout_email.setErrorEnabled(false);
        }
        if (!email.matches(emailPattern)) {
            input_layout_email.setError("Enter Valid Email ID");
            return false;
        } else {
            input_layout_email.setErrorEnabled(false);
        }
        if (password.trim().isEmpty()) {
            input_layout_password.setError("Enter Password");
            return false;
        } else {
            input_layout_email.setErrorEnabled(false);
        }
        if (confirmPassword.trim().isEmpty()) {
            input_layout_confirmPassword.setError("Enter Confirm Password");
            return false;
        } else {
            input_layout_email.setErrorEnabled(false);
        }

        if (!password.equals(confirmPassword)) {
            input_layout_confirmPassword.setError("Enter Password same as in Password Field");
            return false;
        } else {
            input_layout_confirmPassword.setErrorEnabled(false);
        }
        return true;
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        RadioButton checkedRadioButton = (RadioButton) findViewById(checkedId);
        gender = checkedRadioButton.getText().toString();
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.v(TAG, "In Signup onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v(TAG, "In Signup onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v(TAG, "In Signup onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v(TAG, "In Signup onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v(TAG, "In Signup onDestroy");
        realm.close();
    }
}
