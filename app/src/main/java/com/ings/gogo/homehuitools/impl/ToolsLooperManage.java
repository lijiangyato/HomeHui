package com.ings.gogo.homehuitools.impl;

import android.os.Handler;
import android.os.Looper;

public class ToolsLooperManage extends Handler {
    private static ToolsLooperManage instance = new ToolsLooperManage(Looper.getMainLooper());

    protected ToolsLooperManage(Looper looper) {
        super(looper);
    }

    public static ToolsLooperManage getInstance() {
        return instance;
    }

    public static void runOnUiThread(Runnable runnable) {
        if (Looper.getMainLooper().equals(Looper.myLooper())) {
            runnable.run();
        } else {
            instance.post(runnable);
        }

    }
}
