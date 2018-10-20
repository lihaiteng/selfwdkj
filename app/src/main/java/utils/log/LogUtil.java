package utils.log;

import android.util.Log;

import com.turui.yuncheng.BuildConfig;

/**
 * Created by bockey on 2017/2/10.
 */
public class LogUtil {

    private static String className;//类名
    private static String methodName;//方法名
    private static int lineNumber;//行数

    private static void getMethodNames(StackTraceElement[] sElements){
        //sElements[0] 对应的是获取 sElements 所在的方法d()的信息，sElements[1]才是调用LogUtils.d()方法所在的方法的信息
        className = sElements[1].getFileName();
        methodName = sElements[1].getMethodName();
        lineNumber = sElements[1].getLineNumber();
    }
    /*
        new Throwable().getStackTrace()
     */
    public static void d(int message){
        if (!BuildConfig.DEBUG)
            return;
        /**
         * new Throwable().getStackTrace()获取的是栈 StackTraceElement[] sElements
         * sElements中每个元素的信息有：文件名，类名，方法名，方法所在行数等
         */
        getMethodNames(new Throwable().getStackTrace());

        Log.d(className, createLog(String.valueOf(message),""));
    }

    public static void d(String message){
        if (!BuildConfig.DEBUG)
            return;
        getMethodNames(new Throwable().getStackTrace());

        Log.d(className, createLog(message,""));
    }

    public static void d(boolean message){
        if (!BuildConfig.DEBUG)
            return;
        getMethodNames(new Throwable().getStackTrace());

        Log.d(className, createLog(String.valueOf(message),""));
    }

    public static void d(String msg1,int msg2){
        if (!BuildConfig.DEBUG)
            return;
        getMethodNames(new Throwable().getStackTrace());

        Log.d(className, createLog(msg1, String.valueOf(msg2)));
    }

    public static void d(String msg1,String msg2){
        if (!BuildConfig.DEBUG)
            return;
        getMethodNames(new Throwable().getStackTrace());

        Log.d(className, createLog(msg1,msg2));
    }

    private static String createLog( String logmsg1,String logmsg2) {
        if(!"".equals(logmsg2)){
            logmsg2=":  "+logmsg2;
        }
        StringBuffer buffer = new StringBuffer();
        buffer.append(methodName);
        buffer.append("(").append(className).append(":").append(lineNumber).append(")");
        buffer.append(" --> "+logmsg1+logmsg2);
        return buffer.toString();
    }
}
