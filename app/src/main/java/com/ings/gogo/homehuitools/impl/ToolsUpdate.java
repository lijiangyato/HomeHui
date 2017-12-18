package com.ings.gogo.homehuitools.impl;
/*
@公司:贵州家汇互联网科技有限公司
@作者:LiJiang
@邮箱:yaoyaoling8888@gmail.com
@时间: admin 2017/10/7.
@作用:版本更新工具
*/


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;

import com.ings.gogo.R;
import com.ings.gogo.homehuidata.model.IModelUpdate;
import com.ings.gogo.homehuidata.model.impl.ModelUpdate;
import com.ings.gogo.homehuidata.unified.IUnifiedDataListener;
import com.ings.gogo.homehuidata.update.entity.EntityUpdate;
import com.ings.gogo.homehuitools.impl.ToolsApp;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;


public class ToolsUpdate {
    private Context mContext;
    private IModelUpdate mIModelUpdate;
    private ProgressBar mProgressBar;
    private Dialog mDownloadDialong;
    private String mSavePath;
    private EntityUpdate mEntityUpdate;
    private int mProgress;
    private static final int DOWNLOADING = 1;
    private static final int DOWNLOAD_FINISH = 2;
    private static final int DOWNLOAD_FINISH_NO = 3;
    private boolean mIsCancel = false;


    public ToolsUpdate(Context context) {
        this.mContext = context;

        mIModelUpdate = new ModelUpdate();
        mIModelUpdate.getUpdate("android", new IUnifiedDataListener<EntityUpdate>() {
            @Override
            public void success(EntityUpdate response) {
                mEntityUpdate = response;
                //服务器版本
                int versiondigit = mEntityUpdate.getData().getVersiondigit();
                //本地版本
                int versiondigetben = ToolsApp.getVersionCode(mContext);

                if (versiondigetben<versiondigit) {
                   mUpdateProgressHandler.sendEmptyMessage(DOWNLOAD_FINISH_NO);

                } else {
                    return;
                }

            }

            @Override
            public void fail(int errCode, String msg) {
                Log.e("fail", errCode + msg + "");
            }
        });

    }


    /*检查版本是否要更新*/
    public void checkUpdate() {
        showNOticeDielog();
    }


    /*发送消息更新*/
    private Handler mUpdateProgressHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case DOWNLOAD_FINISH_NO:
                    checkUpdate();
                    break;
                case DOWNLOADING:
                    //设置进度
                    mProgressBar.setProgress(mProgress);
                    break;
                case DOWNLOAD_FINISH:
                    //隐藏当前的对话框
                    mDownloadDialong.dismiss();
                    //安装apk
                    installapk();
                    break;
            }

        }
    };

    /*@更新时显示提示对话框*/
    public void showNOticeDielog() {
        String message = "更新成功";
        //.setView(view)
        new AlertDialog.Builder(mContext)
                .setTitle("提示")
                .setMessage(message)
                .setCancelable(false)

                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setPositiveButton("更新", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        //显示对话框
                        showDialog();
                    }
                })
                .show();
    }


    /*显示下载对话框*/
    public void showDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        builder.setTitle("下载中");
        View view = LayoutInflater.from(mContext).inflate(R.layout.update_dialog_progress, null);
        mProgressBar = (ProgressBar) view.findViewById(R.id.name_progressbar_id);
        builder.setView(view);
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //隐藏对话框
                dialog.dismiss();
                //设置下载状态为取消
                mIsCancel = true;

            }
        });
        mDownloadDialong = builder.create();
        mDownloadDialong.show();
        //下载文件
        downloadapk();

    }

    /*开启新的线程下载*/
    public void downloadapk() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
                        String msdPath = Environment.getExternalStorageDirectory() + "/";
                        mSavePath = msdPath + "homehuip";
                        File dir = new File(msdPath);
                        if (!dir.exists()) {
                            dir.mkdir();
                        }
                            //下载文件
                            HttpURLConnection mconn = (HttpURLConnection) new URL(mEntityUpdate.getData().getDownload()).openConnection();
                            mconn.connect();
                            InputStream mis = mconn.getInputStream();
                            int length = mconn.getContentLength();

                            File mapkFile = new File(mSavePath);
                            FileOutputStream mfos = new FileOutputStream(mapkFile);
                            int count = 0;
                            byte[] buffer = new byte[1024];
                            while (!mIsCancel) {
                                int numread = mis.read(buffer);
                                count += numread;
                                //计算当前进度条的位置
                                mProgress = (int) (((float) count / length) * 100);
                                //更新
                                mUpdateProgressHandler.sendEmptyMessage(DOWNLOADING);
                                //下载完成
                                if (numread < 0) {
                                    mUpdateProgressHandler.sendEmptyMessage(DOWNLOAD_FINISH);
                                    break;
                                }
                                mfos.write(buffer, 0, numread);
                            }
                            mfos.close();
                            mis.close();

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    /*下载的本地执行安装*/

    public void installapk() {
        File apkFile = new File(mSavePath);
        if (!apkFile.exists()) {
            return;
        }
        Uri muri = Uri.parse("file://" + apkFile.toString());
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setDataAndType(muri, "application/vnd.android.package-archive");
        mContext.startActivity(intent);
    }
}
