package universe.com.universe.android.fragment;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import universe.com.universe.android.activity.BaseActivity;
import universe.com.universe.android.utils.Utility;

/**
 * Created by gaurav.pandey on 05-01-2018.
 */

public class BaseFragment extends Fragment {
    protected Context mContext;
    protected BaseActivity mActivity;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        mActivity = (BaseActivity) getActivity();
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    public void showProgress() {
        showProgress("Loading");
    }

    public void showProgress(String message) {
        mActivity.showProgress(message);
    }

    public void showProgress(int msgId) {
        String message = Utility.getStringRes(msgId);
        mActivity.showProgress(message);
    }

    public void dismissProgress() {
        mActivity.dismissProgress();
    }

}
