package ajiet.ise.dept.horizonbank;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class homenavi extends AppCompatActivity {

    private int selectedTab=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homenavi);



        final LinearLayout homelayout= findViewById(R.id.homelayout);
        final LinearLayout tranlayout=findViewById(R.id.tranlayout);
        final LinearLayout notilayout=findViewById(R.id.notilayout);
        final LinearLayout profilelayout=findViewById(R.id.profilelayout);

        final ImageView homeicon=findViewById(R.id.homeicon);
        final ImageView tranicon=findViewById(R.id.tranicon);
        final ImageView noticon=findViewById(R.id.notiicon);
        final ImageView profileicon=findViewById(R.id.profileicon);

        final TextView hometext=findViewById(R.id.hometext);
        final TextView trantext=findViewById(R.id.trantext);
        final TextView notitext=findViewById(R.id.notitext);
        final TextView profiletext=findViewById(R.id.profiletext);

        getSupportFragmentManager().beginTransaction()
                .setReorderingAllowed(true)
                .replace(R.id.fragcon,homefragment.class,null)
                .commit();


        homelayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(selectedTab!=1)
                {
                    getSupportFragmentManager().beginTransaction()
                            .setReorderingAllowed(true)
                            .replace(R.id.fragcon,homefragment.class,null)
                            .commit();

                    trantext.setVisibility(View.GONE);
                    notitext.setVisibility(View.GONE);
                    profiletext.setVisibility(View.GONE);

                    tranicon.setImageResource(R.drawable.transaction);
                    noticon.setImageResource(R.drawable.notifications);
                    profileicon.setImageResource(R.drawable.profile);

                    tranlayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    notilayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    profilelayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    //select home page
                    hometext.setVisibility(View.VISIBLE);
                    homeicon.setImageResource(R.drawable.home2);
                    homelayout.setBackgroundResource(R.drawable.naviback);
                    //animation
                    ScaleAnimation scaleAnimation=new ScaleAnimation(0.8f,1.0f,1f,1f, Animation.RELATIVE_TO_SELF,0.0f,Animation.RELATIVE_TO_SELF,0.0f);
                    scaleAnimation.setDuration(200);
                    scaleAnimation.setFillAfter(true);
                    homelayout.startAnimation(scaleAnimation);

                    selectedTab=1;


                }
            }
        });

        tranlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(selectedTab!=2)
                {
                    getSupportFragmentManager().beginTransaction()
                            .setReorderingAllowed(true)
                            .replace(R.id.fragcon,transfragment.class,null)
                            .commit();

                    hometext.setVisibility(View.GONE);
                    notitext.setVisibility(View.GONE);
                    profiletext.setVisibility(View.GONE);

                    homeicon.setImageResource(R.drawable.home);
                    noticon.setImageResource(R.drawable.notifications);
                    profileicon.setImageResource(R.drawable.profile);

                    homelayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    notilayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    profilelayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    //select home page
                    trantext.setVisibility(View.VISIBLE);
                    tranicon.setImageResource(R.drawable.transaction2);
                    tranlayout.setBackgroundResource(R.drawable.naviback);
                    //animation
                    ScaleAnimation scaleAnimation=new ScaleAnimation(0.8f,1.0f,1f,1f, Animation.RELATIVE_TO_SELF,0.0f,Animation.RELATIVE_TO_SELF,0.0f);
                    scaleAnimation.setDuration(200);
                    scaleAnimation.setFillAfter(true);
                    tranlayout.startAnimation(scaleAnimation);

                    selectedTab=2;


                }
            }
        });

        notilayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(selectedTab!=3)
                {
                    getSupportFragmentManager().beginTransaction()
                            .setReorderingAllowed(true)
                            .replace(R.id.fragcon,notifragment.class,null)
                            .commit();

                    hometext.setVisibility(View.GONE);
                    trantext.setVisibility(View.GONE);
                    profiletext.setVisibility(View.GONE);

                    homeicon.setImageResource(R.drawable.home);
                    tranicon.setImageResource(R.drawable.transaction);
                    profileicon.setImageResource(R.drawable.profile);

                    homelayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    tranlayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    profilelayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    //select home page
                    notitext.setVisibility(View.VISIBLE);
                    noticon.setImageResource(R.drawable.notifications2);
                    notilayout.setBackgroundResource(R.drawable.naviback);
                    //animation
                    ScaleAnimation scaleAnimation=new ScaleAnimation(0.8f,1.0f,1f,1f, Animation.RELATIVE_TO_SELF,0.0f,Animation.RELATIVE_TO_SELF,0.0f);
                    scaleAnimation.setDuration(200);
                    scaleAnimation.setFillAfter(true);
                    notilayout.startAnimation(scaleAnimation);

                    selectedTab=3;


                }
            }
        });

        profilelayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(selectedTab!=4)
                {
                    getSupportFragmentManager().beginTransaction()
                            .setReorderingAllowed(true)
                            .replace(R.id.fragcon,profilefragment.class,null)
                            .commit();

                    hometext.setVisibility(View.GONE);
                    trantext.setVisibility(View.GONE);
                    notitext.setVisibility(View.GONE);


                    homeicon.setImageResource(R.drawable.home);
                    tranicon.setImageResource(R.drawable.transaction);
                    noticon.setImageResource(R.drawable.notifications);

                    homelayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    tranlayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    notilayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    //select home page
                    profiletext.setVisibility(View.VISIBLE);
                    profileicon.setImageResource(R.drawable.profile2);
                    profilelayout.setBackgroundResource(R.drawable.naviback);
                    //animation
                    ScaleAnimation scaleAnimation=new ScaleAnimation(0.8f,1.0f,1f,1f, Animation.RELATIVE_TO_SELF,0.0f,Animation.RELATIVE_TO_SELF,0.0f);
                    scaleAnimation.setDuration(200);
                    scaleAnimation.setFillAfter(true);
                    profilelayout.startAnimation(scaleAnimation);

                    selectedTab=4;


                }
            }
        });


    }
}