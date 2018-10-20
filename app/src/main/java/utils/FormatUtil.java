package utils;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import static java.math.BigDecimal.ROUND_HALF_UP;

public class FormatUtil {

    public interface TimeFormatType{
        String ALL = "yyyy-MM-dd HH:mm:ss";
        String WithoutSecond = "yyyy-MM-dd HH:mm";
        String Simple = "MM-dd HH:mm";
    }


    /**
     * 保留小数
     */
    public static String moneyFormat(String money,int keep){

        BigDecimal bigDecimal = new BigDecimal(money).setScale(keep, ROUND_HALF_UP);

        return bigDecimal.toString();

    }

    /**
     * 时间格式
     */
    public static String timeFormat(String millisecond,String format){

        SimpleDateFormat sdf = new SimpleDateFormat(format);

        Date time = new Date(Long.valueOf(millisecond)*1000);

        return sdf.format(time);

    }
}
