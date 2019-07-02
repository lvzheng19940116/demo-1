package time;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * 以动手实践为荣,以只看不练为耻.
 * 以打印日志为荣,以出错不报为耻.
 * 以局部变量为荣,以全局变量为耻.
 * 以单元测试为荣,以手工测试为耻.
 * 以代码重用为荣,以复制粘贴为耻.
 * 以多态应用为荣,以分支判断为耻.
 * 以定义常量为荣,以魔法数字为耻.
 * 以总结思考为荣,以不求甚解为耻.
 *
 * @author LvZheng
 * 创建时间：2019/6/28 4:26 PM
 */
public class DateUtil {
    public static void main(String[] args) {
        LocalDate localDate=LocalDate.now();
        LocalDate date = localDate.minusDays(1);
        String string = DateUtil.dateToString(date, "yyyyMMdd");
        System.out.println(string);
    }


    /**
     * 把日期格式化为字符串
     *
     * @param ldt
     * @param partten
     * @return
     */
    public static String dateToString(LocalDate ldt, String partten) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(partten);
        String format = ldt.format(dtf);
        return format;
    }

    /**
     * 把指定字符串格式化为日期
     *
     * @param str
     * @param partten
     * @return
     */

    public static LocalDate stringToDate(String str, String partten) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(partten);
        LocalDate parse = LocalDate.parse(str, dtf);
        return parse;

    }


}
