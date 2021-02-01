package 数组.统计数组中的元素.数组的度697;

import javax.print.attribute.HashAttributeSet;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 697. 数组的度
 * 给定一个非空且只包含非负数的整数数组 nums, 数组的度的定义是指数组里任一元素出现频数的最大值。
 *
 * 你的任务是找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
 *
 * 示例 1:
 *
 * 输入: [1, 2, 2, 3, 1]
 * 输出: 2
 * 解释:
 * 输入数组的度是2，因为元素1和2的出现频数最大，均为2.
 * 连续子数组里面拥有相同度的有如下所示:
 * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 * 最短连续子数组[2, 2]的长度为2，所以返回2.
 * 示例 2:
 *
 * 输入: [1,2,2,3,1,4,2]
 * 输出: 6
 * 注意:
 *
 * nums.length 在1到50,000区间范围内。
 * nums[i] 是一个在0到49,999范围内的整数。
 *
 * author:caiyi
 * time:2021-02-01
 */
public class ShortestSubArray {
    public static  void main(String[] args){

    }
    public int findShortestSubArray(int[] nums) {
        //记录数组中数字第一次出现的位置
        Map<Integer,Integer> leftMap=new HashMap<Integer, Integer>(16);
        //记录数组中数字最后一次出现的位置
        Map<Integer,Integer> rightMap=new HashMap<Integer, Integer>(16);
        //记录每个数字出现次数
        Map<Integer,Integer> countMap=new HashMap<Integer, Integer>(16);
        for(int i=0;i<nums.length;i++){
            int x=nums[i];
            if(leftMap.get(x)==null){
                //给leftMap存入数字第一次出现的位置
                leftMap.put(x,i);
            }
            //数组最后出现的位置需要一直更新直到循环结束
            rightMap.put(x,i);
            countMap.put(x,countMap.getOrDefault(x,0)+1);
        }
        //默认结果为数组的长度
        int ans = nums.length;
        //在countMap里找出出现的最多次数
        int max= Collections.max(countMap.values());
        for(int n:nums){
            if(countMap.get(n)==max){
                ans=Math.min(ans,rightMap.get(n)-leftMap.get(n)+1);
            }
        }
        return ans;
    }
}
