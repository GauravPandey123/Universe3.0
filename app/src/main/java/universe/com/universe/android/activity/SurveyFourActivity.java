package universe.com.universe.android.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import universe.com.universe.android.R;

/**
 * Created by gaurav.pandey on 11-01-2018.
 */

public class SurveyFourActivity extends BaseActivity {

    private RadioGroup radioGroup;
    TextView textViewNext, textViewPrevious;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.survey_category_four);
        initialization();
        setUpElements();
    }

    private void initialization() {
        radioGroup = findViewById(R.id.radioGroup);
        textViewNext=findViewById(R.id.textViewNext);
        textViewPrevious=findViewById(R.id.textViewPrevious);
    }

    private void setUpElements() {
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

            }
        });

        textViewNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, FollowUpChoiceQuestion.class);
                startActivity(intent);
                overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
            }
        });

        textViewPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, SuverTwoActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
            }
        });
    }


}
