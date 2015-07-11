package com.chengang.hobby.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chengang.hobby.R;

/**
 * 音乐界面
 *
 * @author chengang (https://github.com/developerchengang)
 * @version 1.0
 * @created 2015-07-10
 */
public class MusicFragment extends Fragment {

    public static MusicFragment newInstance(){
        return new MusicFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_music, container , false);
        return root;
    }
}
