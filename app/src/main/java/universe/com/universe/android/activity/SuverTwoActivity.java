package universe.com.universe.android.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import universe.com.universe.android.R;

/**
 * Created by gaurav.pandey on 11-01-2018.
 */

public class SuverTwoActivity extends BaseActivity {
    EditText editTextownerofshop;
    TextView textViewPrevious, textViewNext;
    TextInputLayout textInputLayout;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.survey_category_two);
        initialization();
        setUpElements();
    }

    private void setUpElements() {
        textViewNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, SurveyFourActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);

            }
        });

    }

    private void initialization() {
        editTextownerofshop = findViewById(R.id.editTextownerofshop);
        textViewPrevious = findViewById(R.id.textViewPrevious);
        textViewNext = findViewById(R.id.textViewNext);
        textInputLayout = findViewById(R.id.textinputlayout);
        editTextownerofshop.addTextChangedListener(new MyTextWatcher(editTextownerofshop));
        textViewPrevious.setVisibility(View.GONE);

        textViewNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitForm();
            }
        });


    }

    /**
     * Validating form
     */
    private void submitForm() {
        if (!validateName()) {
            return;
        }


        Toast.makeText(getApplicationContext(), "Thank You!", Toast.LENGTH_SHORT).show();
    }


    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }

    private boolean validateName() {
        if (editTextownerofshop.getText().toString().trim().isEmpty()) {
            textInputLayout.setError(getString(R.string.err_msg_name));
            requestFocus(editTextownerofshop);
            return false;
        } else {
            textInputLayout.setErrorEnabled(false);
        }

        return true;
    }

    private class MyTextWatcher implements TextWatcher {

        private View view;

        private MyTextWatcher(View view) {
            this.view = view;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void afterTextChanged(Editable editable) {
            switch (view.getId()) {
                case R.id.editTextownerofshop:
                    validateName();
                    break;
            }
        }
    }
}
