package ajiet.ise.dept.horizonbank;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class profilefragment extends Fragment {
    TextView n1,n2,p,e,logout;
    ImageView logoutimg;

    LinearLayout needhelp,tnc,aboutus;

    Dialog mdialog;
    Button add,setpin;
    FirebaseAuth auth;
    FirebaseUser user;

    DatabaseReference reff;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =inflater.inflate(R.layout.fragment_profilefragment, container, false);

        auth=FirebaseAuth.getInstance();
        user=auth.getCurrentUser();
        String userid=user.getUid();

        reff=FirebaseDatabase.getInstance().getReference().child("Users");



        n1=v.findViewById(R.id.pfname);
        n2=v.findViewById(R.id.plname);
        p=v.findViewById(R.id.pphone);
        e=v.findViewById(R.id.pemail);
        add=v.findViewById(R.id.adddetails);
        setpin=v.findViewById(R.id.setpin);
        logout=v.findViewById(R.id.logouttext);
        logoutimg=v.findViewById(R.id.logouticon);
        needhelp=v.findViewById(R.id.needhelp);
        tnc=v.findViewById(R.id.termsandcond);
        aboutus=v.findViewById(R.id.aboutus);



        reff.child(userid).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Users users=snapshot.getValue(Users.class);

                if(users!=null)
                {
                    String fn=users.getFirstname();
                    String ln=users.getLastname();
                    String ph=users.getPhno();
                    String em=users.getEmail();
                    n1.setText(fn);
                    n2.setText(ln);
                    p.setText(ph);
                    e.setText(em);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        if(user==null)
        {
            Intent intent=new Intent(getActivity(),login.class);
            startActivity(intent);
        }
      /*  else {
            e.setText(user.getEmail());
        }*/

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),userdetails.class);
                startActivity(intent);
            }
        });

        setpin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),setpin.class);
                startActivity(intent);
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent=new Intent(getActivity(),login.class);
                startActivity(intent);
            }
        });

        logoutimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent=new Intent(getActivity(),login.class);
                startActivity(intent);
            }
        });

        mdialog = new Dialog(getContext());

        needhelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mdialog.setContentView(R.layout.popup);
                mdialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                mdialog.show(); // Show the dialog
            }
        });

        tnc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mdialog.setContentView(R.layout.popup);
                mdialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                mdialog.show(); // Show the dialog
            }
        });

        aboutus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mdialog.setContentView(R.layout.popup);
                mdialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                mdialog.show(); // Show the dialog
            }
        });








        return v;
    }
}