package ajiet.ise.dept.horizonbank;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Objects;
import java.util.regex.Pattern;

public class register extends AppCompatActivity {

    EditText edemail,edpass,edconf;
    Button reg;

    String em,ps,cn;
    TextView already;
    FirebaseAuth mAuth;
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            Intent intent=new Intent(register.this,homenavi.class);
            startActivity(intent);
            finish();
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        edemail=findViewById(R.id.remail);
        edpass=findViewById(R.id.rpassword);
        edconf=findViewById(R.id.rconfirm);
        already=findViewById(R.id.already);
        reg=findViewById(R.id.register);

        mAuth=FirebaseAuth.getInstance();

        ImageView chideshow=findViewById(R.id.confhs);
        ImageView phideshow=findViewById(R.id.passhs);
        phideshow.setImageResource(R.drawable.hide);
        chideshow.setImageResource(R.drawable.hide);


        phideshow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edpass.getTransformationMethod().equals(HideReturnsTransformationMethod.getInstance()))
                {
                    edpass.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    phideshow.setImageResource(R.drawable.hide);
                }
                else
                {
                    edpass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    phideshow.setImageResource(R.drawable.show);
                }
            }
        });
        chideshow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edconf.getTransformationMethod().equals(HideReturnsTransformationMethod.getInstance()))
                {
                    edconf.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    chideshow.setImageResource(R.drawable.hide);
                }
                else
                {
                    edconf.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    chideshow.setImageResource(R.drawable.show);
                }
            }
        });


        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


               em=String.valueOf(edemail.getText());
               ps=String.valueOf(edpass.getText());
               cn=String.valueOf(edconf.getText());

                if (em.length() == 0 || ps.length() == 0 || cn.length() == 0)
                {
                    Toast.makeText(getApplicationContext(), "Please fill all details", Toast.LENGTH_SHORT).show();
                }
                else
                if(Patterns.EMAIL_ADDRESS.matcher(em).matches()) {
                    if (ps.compareTo(cn) == 0) {
                        if(isvalid(ps))
                        {

                            mAuth.createUserWithEmailAndPassword(em, ps)
                                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                        @Override
                                        public void onComplete(@NonNull Task<AuthResult> task) {
                                            if (task.isSuccessful()) {

                                                Toast.makeText(getApplicationContext(), "REGISTERED", Toast.LENGTH_SHORT).show();
                                                Intent intent =new Intent(register.this,homenavi.class);
                                                startActivity(intent);
                                                finish();
                                                // Registration successful
                                            } else {
                                                // Registration failed
                                                Toast.makeText(register.this, "Registration failed: " + Objects.requireNonNull(task.getException()).getMessage(), Toast.LENGTH_SHORT).show();
                                            }
                                        }
                                    });
                        }
                    }
                    else
                        Toast.makeText(getApplicationContext(), "password and confirm password must be same", Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(getApplicationContext(), "enter a valid email", Toast.LENGTH_SHORT).show();
            }

        });

        already.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(register.this,login.class);
                startActivity(intent);
                finish();
            }
        });

    }

    private boolean isvalid(String pass)
    {
        Pattern lc = Pattern.compile("^.*[a-z].*$");
        Pattern uc = Pattern.compile("^.*[A-Z].*$");
        Pattern n = Pattern.compile("^.*[0-9].*$");
        Pattern sc = Pattern.compile("^.*[^a-zA-Z0-9].*$");

        if(pass.length()<8)
            return  false;
        if(!lc.matcher(pass).matches())
            return false;
        if(!uc.matcher(pass).matches())
            return false;
        if(!n.matcher(pass).matches())
            return false;
        if(!sc.matcher(pass).matches())
            return false;

        return true;
    }

}

