package ilgulee.com.funfacts;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class FunFactActivity extends AppCompatActivity {
    private TextView factTextView;
    private Button showFactButton;
    private RelativeLayout relativeLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fun_fact);

        factTextView=findViewById(R.id.factTextView);
        showFactButton=findViewById(R.id.showFactButton);
        relativeLayout=findViewById(R.id.relativeLayout);
        //originally
//        View.OnClickListener listener= new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        };
//        showFactButton.setOnClickListener(listener);

        showFactButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                //String fact= String.valueOf(randNum);

                factTextView.setText(FactBook.getRandomFact());

                String color=FactBook.getBackgroundColor();

                relativeLayout.setBackgroundColor(Color.parseColor(color));

                showFactButton.setTextColor(Color.parseColor(color));
            }
        });
    }
}
