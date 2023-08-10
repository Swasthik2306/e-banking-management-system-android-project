package ajiet.ise.dept.horizonbank;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class homefragment extends Fragment {
 AppCompatImageButton qr,ppn,bt,mr,ins,loan,cc,inv;
 TextView qrt,ppnt,btt,mrt,inst,loant,cct,invt;
 TextView hfname,hlname,accno,accbal;

 RelativeLayout rview;

 DatabaseReference reference,reference2,reference3;
 FirebaseDatabase db1;
 FirebaseAuth auth;
 FirebaseUser user;

 int sentbal,newbal=0,orgbal=10000;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_homefragment, container, false);

        auth= FirebaseAuth.getInstance();
        user=auth.getCurrentUser();
        String userid=user.getUid();



        rview=v.findViewById(R.id.homecardview);



        qr=v.findViewById(R.id.qrb);
        qrt=v.findViewById(R.id.qrt);
        ppn=v.findViewById(R.id.paynob);
        ppnt=v.findViewById(R.id.paynot);
        bt=v.findViewById(R.id.bankb);
        btt=v.findViewById(R.id.bankt);
        mr=v.findViewById(R.id.mr);
        mrt=v.findViewById(R.id.mrt);
        ins=v.findViewById(R.id.ins);
        inst=v.findViewById(R.id.mrt);
        loan=v.findViewById(R.id.lb);
        loant=v.findViewById(R.id.lt);
        cc=v.findViewById(R.id.cc);
        cct=v.findViewById(R.id.cct);
        inv=v.findViewById(R.id.inv);
        invt=v.findViewById(R.id.invt);

        hfname=v.findViewById(R.id.hfname);
        hlname=v.findViewById(R.id.hlname);
        accno=v.findViewById(R.id.accno);
        accbal=v.findViewById(R.id.accbal);

        ImageView refresh=v.findViewById(R.id.refresh);


        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reference3=FirebaseDatabase.getInstance().getReference().child("Transactionsdetails");
                reference3.child(userid).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        Transactionsdetails td100=snapshot.getValue(Transactionsdetails.class);
                        if(td100!=null)
                        {
                            sentbal= Integer.parseInt(td100.getAmount());

                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });

        orgbal=orgbal-sentbal;


        reference= FirebaseDatabase.getInstance().getReference().child("Users");
        reference.child(userid).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Users users=snapshot.getValue(Users.class);

                if(users!=null)
                {
                    String n1=users.getFirstname();
                    String n2=users.getLastname();
                    long id=users.getAcid();

                    accno.setText("HB00SAV00"+id);
                    hfname.setText(n1);
                    hlname.setText(n2);
                    accbal.setText("₹"+orgbal);

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        rview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String em = user.getEmail();
                String acno = accno.getText().toString().trim();
                String acbal = accbal.getText().toString().trim();


                accdetaills acd = new accdetaills(acno,acbal,em);
                db1 = FirebaseDatabase.getInstance();
                reference2 = db1.getReference("accdetails"); // Reference to the "accdetails" table
                reference2.child(acno).setValue(acd);
            }
        });

        /*String em=user.getEmail();
        String acno=accno.getText().toString().trim();
        String acbal=accbal.getText().toString().trim();

        accdetaills acd=new accdetaills(em,acno,acbal);
        db1=FirebaseDatabase.getInstance();
        db1.getReference("accdetails");
        reference2.child(em).setValue(acd);*/




        qr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), qrscanner.class);
                startActivity(intent);

            }
        });

        qrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), qrscanner.class);
                startActivity(intent);

            }
        });

        ppn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),payphone.class);
                startActivity(intent);

            }
        });

        ppnt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),payphone.class);
                startActivity(intent);

            }
        });

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),banktransfer.class);
                startActivity(intent);

            }
        });
        btt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),banktransfer.class);
                startActivity(intent);

            }
        });

        mr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),mobilerecharge.class);
                startActivity(intent);

            }
        });
        mrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),mobilerecharge.class);
                startActivity(intent);

            }
        });
        ins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),insurance.class);
                startActivity(intent);

            }
        });
        inst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),insurance.class);
                startActivity(intent);

            }
        });
        loan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),applyloan.class);
                startActivity(intent);

            }
        });
        loant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),applyloan.class);
                startActivity(intent);

            }
        });
        cc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),currencyconvertor.class);
                startActivity(intent);

            }
        });

        cct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),currencyconvertor.class);
                startActivity(intent);

            }
        });

        inv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),investment.class);
                startActivity(intent);

            }
        });
        invt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),investment.class);
                startActivity(intent);

            }
        });
        return v;
    }
}


/* reference.addValueEventListener(new ValueEventListener() {
          @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists())
                {
                    acno=(snapshot.getChildrenCount());

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });*/