package add0;

import java.util.HashMap;
import java.util.Map;

/**
 * @author LvZheng
 * 创建时间：2019/7/29 4:06 PM
 */
public class AddTwo {



    public static void main(String[] args) {
        int[]  nums = {2, 7, 11, 15};

      int  target = 9;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    int[] a = new int[] { i, j };
                    System.out.println(i+j);
                }
            }
        }


        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                System.out.println( new int[]{map.get(complement), i});
            }
            map.put(nums[i], i);
        }
    }
}
