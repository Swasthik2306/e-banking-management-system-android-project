package ajiet.ise.dept.horizonbank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class amount extends AppCompatActivity {
 Button pay;
 EditText amount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amount);

        amount=findViewById(R.id.amount);
        pay=findViewById(R.id.pay);

        String aphno=getIntent().getStringExtra("phone");
        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String am2=amount.getText().toString().trim();
                Intent intent=new Intent(amount.this,pin.class);
                intent.putExtra("amount", am2);
                intent.putExtra("phno",aphno);
                startActivity(intent);
                finish();
            }
        });
    }
}