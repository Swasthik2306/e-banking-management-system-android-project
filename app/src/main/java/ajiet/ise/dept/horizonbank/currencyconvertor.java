package ajiet.ise.dept.horizonbank;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class currencyconvertor extends AppCompatActivity {

    Button dollar,yen,rubble;
    TextView ruppe,curenn;

    float a= (float) 81.92;
    float b= (float) 0.58;
    float c= (float) 0.98;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currencyconvertor);

        dollar=findViewById(R.id.dollar);
        yen=findViewById(R.id.yen);
        rubble=findViewById(R.id.ruble);
        ruppe=findViewById(R.id.rupee);
        curenn=findViewById(R.id.ccuren);



        dollar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float cx=Float.parseFloat(ruppe.getText().toString());
                float r=(cx/a);
                curenn.setText("$"+r);
            }
        });

        yen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float cx=Float.parseFloat(ruppe.getText().toString());
                float r=(cx/b);
                curenn.setText("¥"+r);
            }
        });

        rubble.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float cx=Float.parseFloat(ruppe.getText().toString());
                float r=(cx/c);
                curenn.setText("₽"+r);
            }
        });


    }
}