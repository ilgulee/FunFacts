package ilgulee.com.funfacts;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class FunFactActivity extends AppCompatActivity {
    private static final String KEY_FACT = "KEY_FACT";
    private static final String KEY_COLOR = "KEY_COLOR";
    private TextView factTextView;
    private Button showFactButton;
    private RelativeLayout relativeLayout;
    private String mFact=FactBook.facts[0];
    private String mColor=FactBook.backgroundColors[8];

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
//
        showFactButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                //String fact= String.valueOf(randNum);
                mFact=FactBook.getRandomFact();
                factTextView.setText(mFact);

                mColor=FactBook.getBackgroundColor();
                relativeLayout.setBackgroundColor(Color.parseColor(mColor));
                showFactButton.setTextColor(Color.parseColor(mColor));
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(KEY_FACT,mFact);
        outState.putString(KEY_COLOR,mColor);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        mFact=savedInstanceState.getString(KEY_FACT);
        factTextView.setText(mFact);
        mColor=savedInstanceState.getString(KEY_COLOR);
        relativeLayout.setBackgroundColor(Color.parseColor(mColor));
        showFactButton.setTextColor(Color.parseColor(mColor));
    }
}
