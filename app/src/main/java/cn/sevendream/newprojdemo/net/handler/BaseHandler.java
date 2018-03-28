package cn.sevendream.newprojdemo.net.handler;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.DialogFragment;

import cn.sevendream.newprojdemo.net.response.common.ParentResp;

public class BaseHandler extends Handler {

    private Activity activity;
    public static DialogFragment tokenDialog;
    private static DialogFragment pwdDialog;

    public BaseHandler(Activity mActivity) {
        super();
        this.activity = mActivity;
    }

    @Override
    public void handleMessage(Message msg) {
        super.handleMessage(msg);
        if (this.activity == null) {
            return;
        }
        if (msg.obj != null) {
            ParentResp resp = null;
            if (msg.obj instanceof ParentResp) {
                resp = (ParentResp) msg.obj;
            } else {
                return;
            }

        }
    }


}
