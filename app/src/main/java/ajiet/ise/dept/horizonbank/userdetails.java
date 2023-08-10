package ajiet.ise.dept.horizonbank;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Base64;
import java.nio.charset.StandardCharsets;

public class userdetails extends AppCompatActivity {

    EditText fn,ln,fmgn,dob,ge,na,ms,ph,pad,rad,intype,in,edu,occuptype,occup,rel,cat;
    TextView em,acn;
    String  e,f,l,p,d,g,n,m,pn,pd,rd,it,inc,ed,ot,o,r,c;
     long a,i=0;
    Button update;
    FirebaseDatabase db;
    DatabaseReference ref;
    FirebaseAuth auth;
    FirebaseUser user;


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userdetails);

        auth= FirebaseAuth.getInstance();
        user=auth.getCurrentUser();
        String userid=user.getUid();


        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        i = sharedPreferences.getLong("counter", 0);
        i++;



        em=findViewById(R.id.pemail);

        fn=findViewById(R.id.firstname);
        ln=findViewById(R.id.lastname);
        fmgn=findViewById(R.id.parentc);
        dob=findViewById(R.id.dob);
        ge=findViewById(R.id.gender);
        na=findViewById(R.id.nationality);
        ms=findViewById(R.id.maritial);
        ph=findViewById(R.id.phno);
        pad=findViewById(R.id.padd);
        rad=findViewById(R.id.radd);
        intype=findViewById(R.id.incometype);
        in=findViewById(R.id.income);
        edu=findViewById(R.id.qualifications);
        occuptype=findViewById(R.id.occuptype);
        occup=findViewById(R.id.occup);
        rel=findViewById(R.id.religion);
        cat=findViewById(R.id.category);
        update=findViewById(R.id.update);

        em.setText(user.getEmail());

            update.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    e = em.getText().toString().trim();
                    f = fn.getText().toString().trim();
                    l = ln.getText().toString().trim();
                    p = fmgn.getText().toString().trim();
                    d = dob.getText().toString().trim();
                    g = ge.getText().toString().trim();
                    n = na.getText().toString().trim();
                    m = ms.getText().toString().trim();
                    pn = ph.getText().toString().trim();
                    pd = pad.getText().toString().trim();
                    rd = rad.getText().toString().trim();
                    it = intype.getText().toString().trim();
                    inc = in.getText().toString().trim();
                    ed = edu.getText().toString().trim();
                    ot = occuptype.getText().toString().trim();
                    o = occup.getText().toString().trim();
                    r = rel.getText().toString().trim();
                    c = cat.getText().toString().trim();

                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putLong("counter", i);
                    editor.apply();

                    if (!(f.isEmpty() && l.isEmpty() && p.isEmpty() && d.isEmpty() && g.isEmpty() && n.isEmpty() && m.isEmpty() && pd.isEmpty() && rd.isEmpty() && it.isEmpty() && inc.isEmpty() && ed.isEmpty() && ot.isEmpty() && o.isEmpty() && r.isEmpty() && c.isEmpty())) {
                        Users users = new Users(i, e, f, l, p, d, g, n, m, pn, pd, rd, it, inc, ed, ot, o, r, c);
                        db = FirebaseDatabase.getInstance();
                        ref = db.getReference("Users");
                        ref.child(userid).setValue(users).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                Toast.makeText(userdetails.this, "Your details has been updated!!", Toast.LENGTH_SHORT).show();
                            }
                        });


                    }
                }
            });

    }
}