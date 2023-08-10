package ajiet.ise.dept.horizonbank;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class pin2 extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference ref2, ref3, pinRef;
    String acno1;
    FirebaseAuth auth;
    FirebaseUser user;
    static long i=0;
    Button proceed;
    EditText pin20;
    boolean isSettingPin = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pin2);

        proceed = findViewById(R.id.pay2a);
        pin20 = findViewById(R.id.pin20);

        Intent intent =new Intent(pin2.this, paymentdone2.class);
        startActivity(intent);

       /* auth= FirebaseAuth.getInstance();
        user=auth.getCurrentUser();
        String userId = user.getUid();

        String phno2 = getIntent().getStringExtra("phno");
        String amon2 = getIntent().getStringExtra("amount");

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        i = sharedPreferences.getLong("counter", 0);
        i++;

        database = FirebaseDatabase.getInstance();
        ref2 = database.getReference("Transactiondetails");
        pinRef = database.getReference("Pins").child(userId);

        ref3 = FirebaseDatabase.getInstance().getReference().child("accdetails");

        ref3.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    accdetaills acd1 = dataSnapshot.getValue(accdetaills.class);

                    if (acd1 != null) {
                        acno1 = acd1.getAccountnumber();
                        break; // Stop looping once account number is found
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pin = pin20.getText().toString();

                if (isSettingPin) {
                    if (isValidPin(pin)) {
                        // Store the PIN in Firebase Realtime Database
                        pinRef.setValue(pin).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(pin2.this, "PIN set successfully", Toast.LENGTH_SHORT).show();
                                    isSettingPin = false;
                                    pin20.getText().clear();
                                    pin20.setHint("Enter PIN");
                                    Intent intent=new Intent(pin2.this,homenavi.class);
                                    startActivity(intent);
                                } else {
                                    Toast.makeText(pin2.this, "Failed to set PIN", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                    } else {
                        Toast.makeText(pin2.this, "Invalid PIN. Please enter a 4-digit PIN.", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    // Authenticate using the entered PIN
                    pinRef.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            String storedPin = snapshot.getValue(String.class);
                            if (pin.equals(storedPin)) {

                                // Proceed with the desired action
                                Transactionsdetails td = new Transactionsdetails(i, amon2, acno1, phno2);
                                ref2.child(userId).child(String.valueOf(i)).setValue(td);
                                Intent intent = new Intent(pin2.this, paymentdone.class);
                                intent.putExtra("amon3", amon2);
                                intent.putExtra("phno3", phno2);
                                startActivity(intent);
                            } else {
                                Toast.makeText(pin2.this, " Invalid PIN.", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                            Toast.makeText(pin2.this, " Please try again.", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });
    }

    private boolean isValidPin(String pin) {
        // Check if the PIN is exactly 4 digits
        return pin.length() == 4;*/
    }
}

