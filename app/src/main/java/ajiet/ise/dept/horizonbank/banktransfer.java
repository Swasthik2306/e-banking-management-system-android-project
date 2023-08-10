package ajiet.ise.dept.horizonbank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class banktransfer extends AppCompatActivity {

    Button submit1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banktransfer);

        submit1=findViewById(R.id.submit);
        submit1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(banktransfer.this,pin2.class);
                startActivity(intent);
            }
        });

    }
}