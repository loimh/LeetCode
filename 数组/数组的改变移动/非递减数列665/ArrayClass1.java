package 数组.数组的改变移动.非递减数列665;

/**
 * 665. 非递减数列
 * 给你一个长度为 n 的整数数组，请你判断在 最多 改变 1 个元素的情况下，该数组能否变成一个非递减数列。
 *
 * 我们是这样定义一个非递减数列的： 对于数组中任意的 i (0 <= i <= n-2)，总满足 nums[i] <= nums[i + 1]。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums = [4,2,3]
 * 输出: true
 * 解释: 你可以通过把第一个4变成1来使得它成为一个非递减数列。
 * 示例 2:
 *
 * 输入: nums = [4,2,1]
 * 输出: false
 * 解释: 你不能在只改变一个元素的情况下将其变为非递减数列。
 *
 *
 * 提示：
 *
 * 1 <= n <= 10 ^ 4
 * - 10 ^ 5 <= nums[i] <= 10 ^ 5
 *
 *
 * @author caiyi
 * @date 2021-03-18
 */

public class ArrayClass1 {
    public static void main(String[] args){
        int[] nums={3,4,2,3};
        boolean flag=checkPossibility(nums);
    }
    public static boolean checkPossibility(int[] nums) {
        int num=0;
        for(int i=1;i<nums.length;i++){
            if(nums[i-1]>nums[i]){
                if(i==1 || nums[i]>=nums[i-2]) {
                    nums[i - 1] = nums[i];
                }else{
                    nums[i]=nums[i-1];
                }
                num+=1;
            }
        }
        if(num>1){
            return false;
        }
        return true;
    }
}
