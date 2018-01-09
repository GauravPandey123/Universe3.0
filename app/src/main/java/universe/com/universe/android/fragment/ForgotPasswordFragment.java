package universe.com.universe.android.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import universe.com.universe.android.R;

/**
 * Created by gaurav.pandey on 05-01-2018.
 */

public class ForgotPasswordFragment extends BaseFragment {
    View view;
    EditText editTextForgotEmail;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.forgot_password_fragment,container,false);
        setViews(view);
        return view;
    }

    private void setViews(View view) {
        editTextForgotEmail=view.findViewById(R.id.input_forgot_email);
    }


}
