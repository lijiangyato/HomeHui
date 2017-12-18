package com.ings.gogo.homehuitools.impl;
/*
@公司:贵州家汇互联网科技有限公司
@作者:LiJiang
@邮箱:yaoyaoling8888@gmail.com
@时间: admin 2017/10/7.
@作用:
*/

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import com.hulab.debugkit.DebugFunction;
import com.hulab.debugkit.DevTool;
import com.hulab.debugkit.DevToolFragment;
import com.ings.gogo.homehuitools.IToolsView;

import java.util.List;

public class ToolsView  implements IToolsView{
    public Context mContext;
    public ToolsView(Context context){
        this.mContext=context;
    }


    @Override
    public void setToolsdataView(final String a, final String b, final String c, final List<String> e, final String f, final String g) {
        final DevTool.Builder builder = new DevTool.Builder((Activity) mContext);

        builder.addFunction(new DebugFunction(b) {
            @Override
            public String call() throws Exception {
                log(a);
                return c;
            }

        }).addFunction(new DebugFunction(f) {
            @Override
            public String call() throws Exception {
                log(a);
                for (int i=0;i<e.size();i++){
                    log(e.get(i));
                }


                return g;
            }

        });
        builder.setTextSize(16);
        builder.getTool().setConsoleWidth(300);
        builder.getTool().setConsoleHeight(220);
        builder.setTheme(DevToolFragment.DevToolTheme.DARK)
                .build();
    }
}
