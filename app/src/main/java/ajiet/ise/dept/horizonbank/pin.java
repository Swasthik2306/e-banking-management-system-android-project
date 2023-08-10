package ajiet.ise.dept.horizonbank;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class pin extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference pinRef, transactionRef;
    FirebaseAuth auth;
    FirebaseUser user;
    Button proceed;
    EditText enteredPin;

    long i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pin);

        proceed = findViewById(R.id.pay2);

        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();
        String userId = user.getUid();

        String phno2 = getIntent().getStringExtra("phno");
        String amon2 = getIntent().getStringExtra("amount");
        enteredPin=findViewById(R.id.pin10);

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        database = FirebaseDatabase.getInstance();
        pinRef = database.getReference("Pins").child(userId);
        transactionRef = database.getReference("Transactiondetails").child(userId);

        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pinRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        String storedPin = snapshot.getValue(String.class);
                        String pin100=enteredPin.getText().toString().trim();

                         i = sharedPreferences.getLong("counter", 0);
                        i++;


                        if (storedPin != null && storedPin.equals(pin100)) {
                            // PIN is correct, proceed with the transaction


                            Transactionsdetails td = new Transactionsdetails(i, amon2, user.getUid(), phno2);
                            transactionRef.child(String.valueOf(i)).setValue(td)
                                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            if (task.isSuccessful()) {

                                                SharedPreferences.Editor editor = sharedPreferences.edit();
                                                editor.putLong("counter", i);
                                                editor.apply();
                                                // Proceed to payment done activity or any desired action
                                                Intent intent = new Intent(pin.this, paymentdone.class);
                                                intent.putExtra("amon3", amon2);
                                                intent.putExtra("phno3", phno2);
                                                startActivity(intent);
                                                finish();
                                            } else {
                                                Toast.makeText(pin.this, "Failed to process transaction", Toast.LENGTH_SHORT).show();
                                            }
                                        }
                                    });
                        } else {
                            // PIN is incorrect, display error message
                            Toast.makeText(pin.this, "Incorrect PIN. Please try again.", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText(pin.this, "Failed to authenticate. Please try again.", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
