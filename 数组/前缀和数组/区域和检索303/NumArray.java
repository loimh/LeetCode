package 数组.前缀和数组.区域和检索303;

/**
 *
 给定一个整数数组  nums，求出数组从索引 i 到 j（i ≤ j）范围内元素的总和，包含 i、j 两点。

 实现 NumArray 类：

 NumArray(int[] nums) 使用数组 nums 初始化对象
 int sumRange(int i, int j) 返回数组 nums 从索引 i 到 j（i ≤ j）范围内元素的总和，包含 i、j 两点（也就是 sum(nums[i], nums[i + 1], ... , nums[j])）


 示例：

 输入：
 ["NumArray", "sumRange", "sumRange", "sumRange"]
 [[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
 输出：
 [null, 1, -1, -3]

 解释：
 NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
 numArray.sumRange(0, 2); // return 1 ((-2) + 0 + 3)
 numArray.sumRange(2, 5); // return -1 (3 + (-5) + 2 + (-1))
 numArray.sumRange(0, 5); // return -3 ((-2) + 0 + 3 + (-5) + 2 + (-1))
 */
public class NumArray {

    int[] sums;

    /**
     * 由于是数显一个函数，如果sumRange每次都是遍历一边数组进行相加，时间复杂度太高。
     * 所以我们在初始化的时候提前进行操作：新数组index下的数等于原数组index之前包括index的数相加的和，后面进行sumRange操作时
     * 只用互相相减就能得到这个区间的总和
     * @param nums
     */
    public NumArray(int[] nums) {
        int n=nums.length;
        sums=new int[n+1];
        for(int i=0;i<nums.length;i++){
            sums[i+1]=sums[i]+nums[i];
        }

    }

    public int sumRange(int left, int right) {
       return sums[right+1]-sums[left];
    }
}
