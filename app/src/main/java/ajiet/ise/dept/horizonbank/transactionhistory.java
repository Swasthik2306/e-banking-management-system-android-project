package ajiet.ise.dept.horizonbank;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class transactionhistory extends AppCompatActivity {
    // Declare necessary variables
    TextView tv;
    RecyclerView recyclerView;
    DatabaseReference reference;
    FirebaseUser user;
    FirebaseAuth auth;
    MyAdapter myAdapter;
    String userId;

    String phn07,amount07,accn07;

    long tid;

    List<Transactionsdetails> list = new ArrayList<>();

    // Override the onCreate() method
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transactionhistory);

        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();
        userId = user.getUid();

        recyclerView = findViewById(R.id.transrecycview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list.clear();

        reference = FirebaseDatabase.getInstance().getReference("Transactiondetails").child(userId);

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list.clear();
                for (DataSnapshot transactionSnapshot : snapshot.getChildren()) {
                    String tranid07 = transactionSnapshot.getKey(); // Get the transaction ID

                    //for (DataSnapshot transSnapshot : transactionSnapshot.getChildren()) {
                        phn07 = transactionSnapshot.child("senttophno").getValue(String.class);
                        amount07 = transactionSnapshot.child("amount").getValue(String.class);
                       // accn07 = transactionSnapshot.child("acno00").getValue(String.class);
                        //tid = 0;  Default value if the conversion fails

                        try {
                            if (tranid07 != null) {
                                tid = Long.parseLong(tranid07);
                            }
                        } catch (NumberFormatException e) {
                            // Handle the exception if the string cannot be parsed as a long e.printStackTrace(); // or display an error message
                        }
                    //}
                    Transactionsdetails td07 = new Transactionsdetails(tid, amount07, accn07, phn07);
                    list.add(td07);
                }
                myAdapter = new MyAdapter(transactionhistory.this, list);
                recyclerView.setAdapter(myAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(transactionhistory.this, "Error: " + error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
