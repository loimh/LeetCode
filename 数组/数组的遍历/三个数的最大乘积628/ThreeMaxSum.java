package 数组.数组的遍历.三个数的最大乘积628;

import java.util.Arrays;

/**
 * 628. 三个数的最大乘积
 * 给你一个整型数组 nums ，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：6
 * 示例 2：
 *
 * 输入：nums = [1,2,3,4]
 * 输出：24
 * 示例 3：
 *
 * 输入：nums = [-1,-2,-3]
 * 输出：-6
 *
 *
 * 提示：
 *
 * 3 <= nums.length <= 104
 * -1000 <= nums[i] <= 1000
 *
 * author:caiyi
 * time:2021-01-29
 *
 */
public class ThreeMaxSum {
    public static void main(String[] args){
        int[] nums={1,2,3};
        int max=maximumProduct(nums);
        System.out.println(max);
    }

    /**
     *
     *首先将数组排序,-,-
     *如果数组中全是非负数，则排序后最大的三个数相乘即为最大乘积 例如[2,3,4]；如果全是非正数，则最大的三个数相乘同样也为最大乘积 例如：[-8,-6,-3,-2]。
     *如果数组中有正数有负数，则最大乘积既可能是三个最大正数的乘积，也可能是两个最小负数（即绝对值最大）与最大正数的乘积[-8,-6,-3,5,7,9]。
     *综上，我们在给数组排序后，分别求出三个最大正数的乘积，以及两个最小负数与最大正数的乘积，二者之间的最大值即为所求答案。
     * @param nums
     * @return
     */
    public static int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        return Math.max(nums[n-1]*nums[n-2]*nums[n-3],nums[0]*nums[1]*nums[n-1]);
    }
}
