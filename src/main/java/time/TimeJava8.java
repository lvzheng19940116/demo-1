package time;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.concurrent.TimeUnit;

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
 * 创建时间：2019/6/17 4:40 PM
 */
public class TimeJava8 {
    public static void main(String[] args) {


//        TimeUnit.DAYS          //天
//        TimeUnit.HOURS         //小时
//        TimeUnit.MINUTES       //分钟
//        TimeUnit.SECONDS       //秒
//        TimeUnit.MILLISECONDS  //毫秒
//        TimeUnit.NANOSECONDS   //毫微秒

        //1天有24个小时    1代表1天：将1天转化为小时
        TimeUnit.DAYS.toHours(1);
        try {
            //延时5秒，完成了
            TimeUnit.SECONDS.sleep( 5 );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String format = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println(format);

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("当前日期时间" + localDateTime);

        LocalTime localTime = LocalTime.now();
        System.out.println("当前时间" + localTime);

        LocalDate today = LocalDate.now();
        System.out.println(today);
        //多少天
        int dayOfYear = today.getDayOfYear();
        System.out.println(dayOfYear);
        //哪年、
        int year = today.getYear();
        System.out.println(year);
        //几月
        int monthValue = today.getMonthValue();
        System.out.println(monthValue);
        //几号
        int dayOfMonth = today.getDayOfMonth();
        System.out.println(dayOfMonth);
        //星期几
        DayOfWeek dayOfWeek = today.getDayOfWeek();
        System.out.println(dayOfWeek);


        //判断两个日期相差多少天
        LocalDate date1 = LocalDate.of(2018, 9, 20);
        LocalDate date2 = LocalDate.of(2018, 10, 3);
        long l = date2.toEpochDay() - date1.toEpochDay();
        System.out.println(l);

        // 取本月第1天：
        LocalDate firstDayOfThisMonth = today.with(TemporalAdjusters.firstDayOfMonth());
        // 取本月第2天：
        LocalDate secondDayOfThisMonth = today.withDayOfMonth(2);
        // 取本月最后一天，再也不用计算是28，29，30还是31：
        LocalDate lastDayOfThisMonth = today.with(TemporalAdjusters.lastDayOfMonth());
        // 取下一天：
        LocalDate firstDayOf2015 = lastDayOfThisMonth.plusDays(1);
        // 取2015年1月第一个周一，这个计算用Calendar要死掉很多脑细胞： // 2015-01-05
        LocalDate firstMondayOf2015 = LocalDate.parse("2019-01-01").with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));
        // 判断闰年
        boolean isLeapYear = today.isLeapYear();
        //判断该月天数
        int days = today.lengthOfMonth();

    }
}