package 数组.统计数组中的元素.数组中重复的数据442;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 442. 数组中重复的数据
 * 给定一个整数数组 a，其中1 ≤ a[i] ≤ n （n为数组长度）, 其中有些元素出现两次而其他元素出现一次。
 *
 * 找到所有出现两次的元素。
 *
 * 你可以不用到任何额外空间并在O(n)时间复杂度内解决这个问题吗？
 *
 * 示例：
 *
 * 输入:
 * [4,3,2,7,8,2,3,1]
 *
 * 输出:
 * [2,3]
 *
 * @author:caiyi
 * @time:2021-02-01
 */
public class FindRepeatNums {
    public static void main(String[] args){
        int[] nums={4,3,2,7,8,2,3,1};
        List<Integer> result=findDuplicates(nums);
    }

    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> result=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            //减1是防止数组越界,因为数组里面的内容是从1开始，而数组里的下标是从零开始的
            int index=Math.abs(nums[i])-1;
            if(nums[index]<0){
                result.add(Math.abs(index+1));
            }
            nums[index]=-nums[index];
        }
        return result;
    }
}
