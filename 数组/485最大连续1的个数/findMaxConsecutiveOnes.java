

/**
 *485. 最大连续1的个数
 * 给定一个二进制数组， 计算其中最大连续1的个数。
 *
 * 示例 1:
 *
 * 输入: [1,1,0,1,1,1]
 * 输出: 3
 * 解释: 开头的两位和最后的三位都是连续1，所以最大连续1的个数是 3.
 * 注意：
 *
 * 输入的数组只包含 0 和1。
 * 输入数组的长度是正整数，且不超过 10,000。
 */

/**
 * 思路： 数组循环遍历，遇到1统计数加1，如果不是1，先判断最大统计数和统计数大小，如果最大统计数比统计数小，则赋值给最大统计数，然后将统计数归0继续遍历。
 */

public class findMaxConsecutiveOnes {
    public static  void main(String[] args){
        int[] nums={1,0,1,1,1,1};
        int count =method(nums);
        System.out.println(count);

    }
    public static int method(int[] nums) {
        int count=0;
        int maxCount=0;
        for(int i:nums){
            if(i==1){
                count++;
            }else{
                if(count>maxCount){
                    maxCount=Math.max(maxCount, count);
                }
                count=0;
            }
        }
        return Math.max(maxCount, count);
    }
}
