package com.example.tastymix;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class Signup  extends AppCompatActivity {

        private EditText username, gmail, password, confirmPassword;
        private Button registerBtn;
        private ProgressBar loading;
        private FirebaseAuth mAuth;
        private RadioGroup isCooker;
        private RadioButton yesRadioButton;
        private RadioButton noRadioButton;
        public boolean isValidEmail(String email) {
                // Gmail regex pattern
                String gmailPattern = "^[a-zA-Z0-9._%+-]+@gmail\\.com$";

                // Compile the pattern
                Pattern pattern = Pattern.compile(gmailPattern);

                // Match the input email against the pattern
                Matcher matcher = pattern.matcher(email);

                // Return true if it matches the Gmail pattern, false otherwise
                return matcher.matches();
        }

@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FirebaseApp.initializeApp(this);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference usersRef = database.getReference("users");
        setContentView(R.layout.activity_signup);
        username=findViewById(R.id.username);
        gmail=findViewById(R.id.email);
        password=findViewById(R.id.password);
        confirmPassword=findViewById(R.id.confirm_password);
        mAuth= FirebaseAuth.getInstance();
        registerBtn = findViewById(R.id.signup_button);
        isCooker=findViewById(R.id.isCooker);
        yesRadioButton = findViewById(R.id.yes);
        noRadioButton = findViewById(R.id.no);

        loading=findViewById(R.id.progress_bar);


        registerBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                        loading.setVisibility(View.VISIBLE);
                        String usernameText = username.getText().toString();
                        String gmailText=gmail.getText().toString();
                        String passwordText=password.getText().toString();
                        String confirmPasswordText=confirmPassword.getText().toString();

                        if(!(passwordText!=confirmPasswordText))
                        {
                                Toast.makeText(Signup.this,"Confirm Password doesn't match to Password",Toast.LENGTH_SHORT ).show();
                        }else if(TextUtils.isEmpty(usernameText)||TextUtils.isEmpty(passwordText)||TextUtils.isEmpty(confirmPasswordText)||TextUtils.isEmpty(confirmPasswordText)||TextUtils.isEmpty(gmailText)){
                                Toast.makeText(Signup.this,"Please fill all you info",Toast.LENGTH_SHORT ).show();
                        }else if(!isValidEmail(gmailText)){
                                Toast.makeText(Signup.this,"Invalid gmail! ",Toast.LENGTH_SHORT ).show();

                        }else{


                                ////////////////////
                                int selectedRadioButtonId = isCooker.getCheckedRadioButtonId();
                                        if (selectedRadioButtonId == yesRadioButton.getId()) {
                                                Intent i = new Intent(Signup.this, )
                                        } else if (selectedRadioButtonId == noRadioButton.getId()) {
                                                mAuth.createUserWithEmailAndPassword(gmailText, passwordText).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                                        @Override
                                                        public void onComplete(@NonNull Task<AuthResult> task) {
                                                                if(task.isSuccessful()){
                                                                        loading.setVisibility(View.GONE);
                                                                        Toast.makeText(Signup.this,"User registered! ",Toast.LENGTH_SHORT ).show();
                                                                        Intent i = new Intent(Signup.this,Login.class);
                                                                        FirebaseUser firebaseUser = mAuth.getCurrentUser();

                                                                        String userId = firebaseUser.getUid();

                                                                        com.example.tastymix.models.UserModel user = new com.example.tastymix.models.UserModel(usernameText,gmailText,passwordText);
                                                                        DatabaseReference usersRef = FirebaseDatabase.getInstance().getReference("users");
                                                                        usersRef.child(userId).setValue(user).addOnCompleteListener(databaseTask -> {
                                                                                if (databaseTask.isSuccessful()) {
                                                                                        // Database write successful
                                                                                        // Proceed with any other necessary actions or UI updates
                                                                                } else {
                                                                                        // Database write failed
                                                                                        Toast.makeText(Signup.this, "Failed to store user data.",
                                                                                                Toast.LENGTH_SHORT).show();
                                                                                }
                                                                        });

                                                                        startActivity(i);
                                                                        finish();

                                                                }else{
                                                                        loading.setVisibility(View.GONE);
                                                                        Toast.makeText(Signup.this,"Fail to register! ",Toast.LENGTH_SHORT ).show();
                                                                }
                                                        }
                                                });
                                        }else{
                                                Toast.makeText(getApplicationContext(), "Please choose either you are a cooker or not", Toast.LENGTH_SHORT).show();

                                        }

                                ///////////////////


                        }




                }

        });



        }
}