package ajiet.ise.dept.horizonbank;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Transactionsdetails {



    long transid;
    private  String senttophno,amount,acno00;
    String acno1;
    public  Transactionsdetails()
    {

    }
    public Transactionsdetails(long tid, String am, String acno0, String phno, String acno1) {
        this.transid = tid;
        this.acno00 = acno0;
        this.amount = am;
        this.senttophno = phno;
        this.acno1 = acno1;
    }

    public Transactionsdetails(long tid, String am, String acno0, String phno) {

       DatabaseReference ref3 = FirebaseDatabase.getInstance().getReference().child("accdetails");


        ref3.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    accdetaills acd1 = dataSnapshot.getValue(accdetaills.class);

                    acno1 = acd1.getAccountnumber();

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        /*DatabaseReference transref = FirebaseDatabase.getInstance().getReference("Transactiondetails").child("acno1");
        transref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists())
                {
                    trid=(snapshot.getChildrenCount());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });*/


            this.transid=tid;
            this.acno00 = acno0;
            this.amount = am;
            this.senttophno = phno;

    }




    public String getAcno00() {
        return acno00;
    }

    public void setAcno00(String acno00) {
        this.acno00 = acno00;
    }


   public long getTransid() {
        return transid;
    }

    public void setTransid(long transid) {
        this.transid = transid;

    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getSenttophno() {
        return senttophno;
    }

    public void setSenttophno(String accountnumber) {
        this.senttophno = accountnumber;
    }
}
