package 数组.数组的改变移动.最小操作次数使数组元素相等453;

import java.util.Iterator;

/**
 * 453. 最小操作次数使数组元素相等
 * 给定一个长度为 n 的 非空 整数数组，每次操作将会使 n - 1 个元素增加 1。找出让数组所有元素相等的最小操作次数。
 *
 *
 *
 * 示例：
 *
 * 输入：
 * [1,2,3]
 * 输出：
 * 3
 * 解释：
 * 只需要3次操作（注意每次操作会增加两个元素的值）：
 * [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
 *
 * @author caiyi
 * @date 2021-03-18
 */
public class MineMoves {
    public static void main(String[] args){
        int[] nums={1,2,3};
        int num=minMoves(nums);
//        Iterator iterator=nums
            System.out.println(num);
    }

    /**
     * 解题思路：数学法：每次操作将会使n-1个元素增加1，等同于每次操作1个元素减一，所以结果等同于每个元素减到最小元素的值的次数的和。
     * @param nums
     * @return
     */
    public static int minMoves(int[] nums) {
        int min=nums[0];
        for(int i=0;i<nums.length;i++){
            min=Math.min(nums[i],min);
        }
        int num=0;
        for(int i=0;i<nums.length;i++){
            num+=nums[i]-min;
        }
        return num;
    }
}
