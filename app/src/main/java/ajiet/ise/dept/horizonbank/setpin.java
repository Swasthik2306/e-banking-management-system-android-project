package ajiet.ise.dept.horizonbank;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class setpin extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference pinRef;
    FirebaseAuth auth;
    FirebaseUser user;
    Button proceed;
    EditText pinEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setpin); // Update the layout resource file name

        proceed = findViewById(R.id.setpin);
        pinEditText = findViewById(R.id.pin30);

        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();
        String userId = user.getUid();

        database = FirebaseDatabase.getInstance();
        pinRef = database.getReference("Pins").child(userId);

        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pin = pinEditText.getText().toString();

                if (isValidPin(pin)) {
                    // Store the PIN in Firebase Realtime Database
                    pinRef.setValue(pin).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(setpin.this, "PIN set successfully", Toast.LENGTH_SHORT).show();
                                // Proceed with the desired action
                            } else {
                                Toast.makeText(setpin.this, "Failed to set PIN", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                } else {
                    Toast.makeText(setpin.this, "Invalid PIN. Please enter a 4-digit PIN.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean isValidPin(String pin) {
        // Check if the PIN is exactly 4 digits
        return pin.length() == 4;
    }
}
