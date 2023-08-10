package ajiet.ise.dept.horizonbank;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;

public class investment extends AppCompatActivity {

    CardView i1,i2,i3,i4;
    Dialog mdialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_investment);

        i1=findViewById(R.id.mf);
        i2=findViewById(R.id.stoc);
        i3=findViewById(R.id.fix);
        i4=findViewById(R.id.goli);

        mdialog = new Dialog(investment.this);

        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mdialog.setContentView(R.layout.dialogbox2);
                mdialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                mdialog.show(); // Show the dialog
            }
        });
    }
}