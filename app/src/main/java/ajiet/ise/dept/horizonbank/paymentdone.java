package ajiet.ise.dept.horizonbank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class paymentdone extends AppCompatActivity {
    TextView paydone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paymentdone);

       String phno4=getIntent().getStringExtra("phno3");
       String amon4=getIntent().getStringExtra("amon3");

       paydone=findViewById(R.id.paydonetext);
       paydone.setText("Paid ₹"+amon4+" To "+phno4);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent =new Intent(getApplicationContext(),homenavi.class);
                startActivity(intent);
                finish();
            }
        },5000);
    }
}
