package 数组.统计数组中的元素.找到所有数组中消失的数字448;

import java.util.*;

/**
 * 448. 找到所有数组中消失的数字
 * 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
 *
 * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
 *
 * 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
 *
 * 示例:
 *
 * 输入:
 * [4,3,2,7,8,2,3,1]
 *
 * 输出:
 * [5,6]
 *
 * author:caiyi
 * time:2021-02-01
 */
public class DisappearNum {
    public static void main(String[] args){

    }

    /**
     * 使用map
     * @param nums
     * @return
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        Map<Integer, Integer> map=new HashMap<Integer, Integer>(16);
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],1);
        }
        List<Integer> result = new LinkedList<Integer>();
        for(int i=1;i<=nums.length;i++){
            if(!map.containsKey(i)){
                result.add(i);
            }
        }
        return result;
    }
    /**
     * 原地修改
     * @param nums
     * @return
     */
    public List<Integer> findDisappearedNumbers1(int[] nums) {
        for(int i=0;i<nums.length;i++){
            int newIndex=Math.abs(nums[i])-1;
            if(nums[newIndex]>0){
                nums[newIndex]*=-1;
            }
        }
        List<Integer> result = new LinkedList<Integer>();
        for(int i=1;i<=nums.length;i++){
            if(nums[i-1]>0){
                result.add(i);
            }
        }
        return result;
    }

}
