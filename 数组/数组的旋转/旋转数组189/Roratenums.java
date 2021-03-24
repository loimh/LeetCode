package 数组.数组的旋转.旋转数组189;

/**
 * 189. 旋转数组
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 *
 *
 *
 * 进阶：
 *
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 你可以使用空间复杂度为 O(1) 的 原地 算法解决这个问题吗？
 *
 *
 * 示例 1:
 * 输入: nums = [1,2,3,4,5,6,7], k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 *
 *
 * 示例 2:
 * 输入：nums = [-1,-100,3,99], k = 2
 * 输出：[3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 2 * 104
 * -231 <= nums[i] <= 231 - 1
 * 0 <= k <= 105
 *
 * @author loimh
 * @date 2021-03-23
 */
public class Roratenums {

    public static void main(String[] args){
        int[] nums={-1,-2,-3};
        int k=4;
        rotate1(nums,k);
    }
    /**
     * 使用额外的数组解决
     * @param nums
     * @param k
     */
    public static void rotate(int[] nums, int k) {
        int n=nums.length;
        int[] result=new int[n];
        for(int i=0;i<nums.length;i++){
            result[(i+k)%n]=nums[i];
        }
        System.arraycopy(result,0,nums,0,n);
    }
    /**
     *
     * 数组翻转
     * 原始的数组                      1234567
     * 翻转所有元素                    7654321
     * 翻转【0,k mod n -1】区间的元素   5674321
     * 翻转【k mod n,n-1】区间的元素    5671234
     *
     * @param nums
     * @param k
     */
    public static void rotate1(int[] nums, int k) {
        //防止k比数组的长度大
        k=k%nums.length;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
    }

    public static void reverse(int[] nums,int start,int end){
        while (start<end){
            int temp=nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            start++;
            end--;
        }
    }

}
