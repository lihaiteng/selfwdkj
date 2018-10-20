package utils;

import java.util.regex.Pattern;

public class JudgeUtil {

    /**
     * 是否是电话号码
     */
    public static boolean isPhoneNumber(String phone){
        if(phone.startsWith("+") && phone.length()>11){
            phone = phone.substring(phone.length()-11);
        }
        Boolean isPhone = Pattern.compile("^[1][35678][0-9]{9}$").matcher(phone).matches();
        return isPhone;
    }

    /**
     * 是否是邮箱
     */
    public static boolean isEmail(String email){
        if("".equals(email) || email==null){
            return true;
        }
        Boolean isEmail = Pattern.compile("^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$").matcher(email).matches();
        return isEmail;
    }

    /**正确身份证
     */
    public static boolean isCardId(String no)
    {
        if(no.charAt(no.length()-1)=='x'){
            no = no.replace('x','X');
        }
        // 对身份证号进行长度等简单判断
        if (no == null || no.length() != 18 || !no.matches("\\d{17}[0-9X]"))
        {
            return false;
        }
        // 1-17位相乘因子数组
        int[] factor = { 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2 };
        // 18位随机码数组
        char[] random = "10X98765432".toCharArray();
        // 计算1-17位与相应因子乘积之和
        int total = 0;
        for (int i = 0; i < 17; i++)
        {
            total += Character.getNumericValue(no.charAt(i)) * factor[i];
        }
        // 判断随机码是否相等
        return random[total % 11] == no.charAt(17);
    }
}
