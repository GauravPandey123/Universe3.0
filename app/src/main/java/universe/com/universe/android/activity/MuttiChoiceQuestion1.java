package universe.com.universe.android.activity;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import universe.com.universe.android.R;

/**
 * Created by gaurav.pandey on 11-01-2018.
 */

public class MuttiChoiceQuestion1 extends BaseActivity {

    CheckBox checkBox2, checkBox3, checkBox4, checkBox5, checkBox6, checkBox7, checkBox8, checkBox9, checkBox10, checkBox11, checkBox12;
    CheckBox checkBox13, checkBox14, checkBox15, checkBox16, checkBox17;
    TextView textViewNext, textViewPrevious;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.muti_choice_question_one);
        initialization();
        setUpElements();
    }

    private void initialization() {
        checkBox2 = findViewById(R.id.checkBox2);
        checkBox3 = findViewById(R.id.checkBox3);
        checkBox4 = findViewById(R.id.checkBox4);
        checkBox5 = findViewById(R.id.checkBox5);
        checkBox6 = findViewById(R.id.checkBox6);
        checkBox7 = findViewById(R.id.checkBox7);
        checkBox8 = findViewById(R.id.checkBox8);
        checkBox9 = findViewById(R.id.checkBox9);
        checkBox10 = findViewById(R.id.checkBox10);
        checkBox11 = findViewById(R.id.checkBox11);
        checkBox12 = findViewById(R.id.checkBox13);
        checkBox13 = findViewById(R.id.checkBox14);
        checkBox14 = findViewById(R.id.checkBox15);
        checkBox15 = findViewById(R.id.checkBox16);
        checkBox16 = findViewById(R.id.checkBox17);
        checkBox17 = findViewById(R.id.checkBox18);
        textViewNext = findViewById(R.id.textViewNext);
        textViewPrevious = findViewById(R.id.textViewPrevious);
        textViewPrevious.setVisibility(View.GONE);
    }

    private void setUpElements() {
    }
}
