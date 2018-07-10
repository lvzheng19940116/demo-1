package treeset;
import java.text.SimpleDateFormat;
import java.util.Date;

/*package treeset;
*//**
* @author LvZheng
* 创建时间：2018年3月8日 下午6:25:02
*/
public class Num {
	private static Object lockObj="loc";
	public static void main(String[] args) {
		long orderNumCount=0;
		long maxPerMSECSize=0;
        String finOrderNum = "";
        try {
            // 最终生成的订单号
            synchronized (lockObj) {
                // 取系统当前时间作为订单号变量前半部分，精确到毫秒
                long nowLong = Long.parseLong(new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()));
                // 计数器到最大值归零，可扩展更大，目前1毫秒处理峰值1000个，1秒100万
                if (orderNumCount > maxPerMSECSize) {
                    orderNumCount = 0L;
                }
                // 组装订单号
                String countStr = maxPerMSECSize + orderNumCount + "";
                finOrderNum = nowLong + countStr.substring(1);
                orderNumCount++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(finOrderNum);
    
	}

}
