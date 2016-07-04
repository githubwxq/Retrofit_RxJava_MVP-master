package com.example.y.mvp.utils;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.widget.Toolbar;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;

import com.example.y.mvp.R;

import java.io.File;

/**
 * by y on 2016/4/29.
 */
@SuppressWarnings("ALL")
public class ActivityUtils {

    public static void startActivity(Class<?> clz) {
        Intent intent;
        intent = new Intent(UIUtils.getContext(), clz);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        UIUtils.getContext().startActivity(intent);
    }

    public static void startActivity(Class<?> clz, Bundle bundle) {
        Intent intent = new Intent(UIUtils.getContext(), clz);
        intent.putExtras(bundle);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        UIUtils.getContext().startActivity(intent);
    }

    // 收起软键盘
    public static void closeSyskeyBroad() {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) UIUtils.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(UIUtils.getActivity().getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        } catch (Exception e) {
            LogUtils.i("closeSyskeyBroad", "关闭输入法异常");
        }
    }

    //检测键盘的状态
    public static boolean syskeyBroadStatus() {
        InputMethodManager imm = (InputMethodManager) UIUtils.getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        return imm.isActive();
    }

    //屏幕高度
    public static int getTop() {
        WindowManager windowManager = UIUtils.getActivity().getWindowManager();
        int width = windowManager.getDefaultDisplay().getWidth();
        int height = windowManager.getDefaultDisplay().getHeight();
        return height;
    }

    //toolbar高度
    public static int getToolBarTop(Toolbar toolbar) {
        return toolbar.getTop();
    }


    //状态栏高度
    public static int getRectTop() {
        Rect outRect = new Rect();
        UIUtils.getActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(outRect);
        int i = outRect.top;
        return i;
    }

    //获取图库路径
    public static File ImagePath() {
        String sdcard = Environment.getExternalStorageDirectory().toString();
        File file = new File(sdcard + "/DCIM");
        if (!file.exists()) {
            file.mkdirs();
        }
        File mFile = new File(file + "/Demo");
        if (!mFile.exists()) {
            mFile.mkdirs();
        }
        return mFile.getAbsoluteFile();
    }

    public static void share(String message) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, message);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        UIUtils.getActivity().startActivity(Intent.createChooser(intent, UIUtils.getString(R.string.share)));
    }


}
