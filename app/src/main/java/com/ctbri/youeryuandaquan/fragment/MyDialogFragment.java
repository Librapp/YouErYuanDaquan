package com.ctbri.youeryuandaquan.fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

import com.ctbri.youeryuandaquan.util.PhotoUtil;

/**
 * @author 梦思
 * @description 弹出框模块
 */
public class MyDialogFragment extends DialogFragment {
    public static final int CHOSE_PIC = 0;

    public static MyDialogFragment choosePicInstance(String name, int style) {
        MyDialogFragment f = new MyDialogFragment();
        Bundle b = new Bundle();
        b.putString("name", name);
        b.putInt("style", style);
        f.setArguments(b);
        return f;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = null;
        switch (getArguments().getInt("style")) {
            case CHOSE_PIC:
                dialog = PhotoUtil.pickPhoto(getActivity());
                break;
        }
        return dialog;
    }

    @Override
    public void onResume() {
        super.onResume();
//		MobclickAgent.onPageStart("MyDialog");
    }

    @Override
    public void onPause() {
        super.onPause();
//		MobclickAgent.onPageEnd("MyDialog");
    }
}
