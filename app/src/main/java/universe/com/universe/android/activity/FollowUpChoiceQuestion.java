package universe.com.universe.android.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import universe.com.universe.android.R;

/**
 * Created by gaurav.pandey on 11-01-2018.
 */

public class FollowUpChoiceQuestion extends BaseActivity {

    EditText followUpQuestion;
    TextView textViewNext, textViewPrevious;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.follow_up_choice_layout);
        initialization();
        setUpElements();
    }

    private void setUpElements() {
        textViewNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        textViewPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, SurveyFourActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
            }
        });
    }

    private void initialization() {
        followUpQuestion = findViewById(R.id.editTextfollowup);
        textViewNext = findViewById(R.id.textViewNext);
        textViewPrevious = findViewById(R.id.textViewPrevious);

    }


}
