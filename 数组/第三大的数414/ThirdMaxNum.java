package 数组.第三大的数414;

/**
 *414. 第三大的数
 * 给你一个非空数组，返回此数组中 第三大的数 。如果不存在，则返回数组中最大的数。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[3, 2, 1]
 * 输出：1
 * 解释：第三大的数是 1 。
 * 示例 2：
 *
 * 输入：[1, 2]
 * 输出：2
 * 解释：第三大的数不存在, 所以返回最大的数 2 。
 * 示例 3：
 *
 * 输入：[2, 2, 3, 1]
 * 输出：1
 * 解释：注意，要求返回第三大的数，是指第三大且唯一出现的数。
 * 存在两个值为2的数，它们都排第二。
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 104
 * -231 <= nums[i] <= 231 - 1
 *
 *
 * 进阶：你能设计一个时间复杂度 O(n) 的解决方案吗？
 *
 *
 * author:caiyi
 * time:2021-01-29 15:45
 */

public class ThirdMaxNum {
    public static void main(String[] args){
        int[] nums={3,2,1};
        int n=thirdMax(nums);
        System.out.println(n);
    }
    public static int thirdMax(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        if(nums.length==2){
            return  nums[0]>nums[1] ? nums[0]:nums[1];
        }

        long firstMax=Long.MIN_VALUE;
        long secondMax=Long.MIN_VALUE;
        long thirdMax=Long.MIN_VALUE;
        for(int n:nums){
            if(n>firstMax){
                thirdMax=secondMax;
                secondMax=firstMax;
                firstMax=n;
            }else if(firstMax==n){
                continue;
            }else if(n>secondMax){
                thirdMax=secondMax;
                secondMax=n;
            }else if(n==secondMax){
                continue;
            }else if(n>=thirdMax){
                thirdMax=n;
            }
        }
        //如果第大的数没有被修改过则返回最大值
        return  thirdMax==Long.MIN_VALUE ?(int)firstMax:(int)(thirdMax);
    }
}
