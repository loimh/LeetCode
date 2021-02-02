package 数组.统计数组中的元素.缺失的第一个整数41;

/**
 * 41. 缺失的第一个正数
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 *
 * 进阶：你可以实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案吗？
 *
 *
 *
 * 示例 1：
 * 输入：nums = [1,2,0]
 * 输出：3
 *
 * 示例 2：
 * 输入：nums = [3,4,-1,1]
 * 输出：2
 *
 * 示例 3：
 * 输入：nums = [7,8,9,11,12]
 * 输出：1
 */
public class FirstMissingPositive {
    public static void main(String[] args){
        int[] nums={1,2,0};
        findMissingPositive(nums);
    }

    public static int findMissingPositive(int[] nums) {
        int n=nums.length;
        //因为数组里有负数，题目需要找到正整数，所以我们把所有负数赋值为一个未出现的数，最好的是数组外的数，我赋值为数组长度加一
        for(int i=0;i<n;i++){
            if(nums[i]<=0){
                nums[i]=n+1;
            }
        }

        for(int i=0;i<n;i++){
            //num表示取出的数的绝对值
            int num=Math.abs(nums[i]);
            //因为我们把负数都赋值为了数组长度+1，所以我们现在就只判断数组里的正整数
            if(num<=n){
                //如果这个数出现过，就将这个数作为下标的数改为负数，这样有一个数没改为负数，那他的下标就是缺失的那个正整数
                nums[num-1]=-Math.abs(nums[num-1]);
            }
        }
        for(int i=0;i<n;i++){
            if(nums[i]>0){
                return i+1;
            }
        }
        return n+1;
    }
}
