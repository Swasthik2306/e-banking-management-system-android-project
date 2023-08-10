package ajiet.ise.dept.horizonbank;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;

public class applyloan extends AppCompatActivity {

    CardView l1,l2,l3,l4,l5,l6;
    Dialog mdialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_applyloan);

        l1=findViewById(R.id.edu);
        l2=findViewById(R.id.hom);
        l3=findViewById(R.id.veh);
        l4=findViewById(R.id.per);
        l5=findViewById(R.id.arg);
        l6=findViewById(R.id.gol);

        mdialog = new Dialog(applyloan.this);

        l1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mdialog.setContentView(R.layout.dialogbox1);
                mdialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                mdialog.show(); // Show the dialog
            }
        });


    }
}