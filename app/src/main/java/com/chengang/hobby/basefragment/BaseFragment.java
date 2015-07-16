package com.chengang.hobby.basefragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * ȫFragment基类
 *
 * @author chengang (https://github.com/developerchengang)
 * @version 1.0
 * @created 2015-07-10
 */
public class BaseFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
