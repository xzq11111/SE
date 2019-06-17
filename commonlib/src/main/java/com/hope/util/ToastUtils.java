package com.hope.util;

import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.content.ComponentName;
import android.content.Context;
import android.widget.Toast;

import java.util.List;

/**
 * Created by zhangchongxuan on 17/5/22.
 */
public class ToastUtils {

    /** 之前显示的内容 */
    private static String oldMsg ;
    /** Toast对象 */
    private static Toast toast = null ;
    /** 第一次时间 */
    private static long oneTime = 0 ;
    /** 第二次时间 */
    private static long twoTime = 0 ;

    /**
     * 显示Toast
     * @param context
     * @param message
     */
    public static void showToast(Context context, String message){
        if(toast == null){
            toast = Toast.makeText(context, null, Toast.LENGTH_SHORT);
            toast.setText(message);
            toast.show() ;
            oneTime = System.currentTimeMillis() ;
        }else{
            twoTime = System.currentTimeMillis() ;
            if(message.equals(oldMsg)){
                if(twoTime - oneTime > Toast.LENGTH_SHORT){
                    toast.show() ;
                }
            }else{
                oldMsg = message ;
                toast.setText(message) ;
                toast.show() ;
            }
        }
        oneTime = twoTime ;
    }

    public static void toast(Context context, String message, int duration) {
        if (isApplicationForeground(context)) {
            Toast.makeText(context, message, duration).show();
        }
    }

    public static void toast(Context context, int messageID, int duration) {
        if (isApplicationForeground(context)) {
            Toast.makeText(context, messageID, duration).show();
        }
    }

    @SuppressWarnings("deprecation")
    public static boolean isApplicationForeground(Context context) {
        ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        KeyguardManager kgm = (KeyguardManager) context.getSystemService(Context.KEYGUARD_SERVICE);

        boolean isForeground = false;
        boolean isScreenActive = true;
        if (kgm.inKeyguardRestrictedInputMode()) {
            isScreenActive = false;
        }

        List<ActivityManager.RunningTaskInfo> tasks = am.getRunningTasks(1);
        if (!tasks.isEmpty()) {
            ComponentName topActivity = tasks.get(0).topActivity;
            if (topActivity.getPackageName().equals(context.getPackageName())) {
                isForeground = true;
            }
        }
        return isForeground && isScreenActive;
    }

}
