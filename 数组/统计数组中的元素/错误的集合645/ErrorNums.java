package 数组.统计数组中的元素.错误的集合645;

import com.sun.xml.internal.ws.util.StringUtils;

import java.util.*;

/**
 * 645. 错误的集合
 * 集合 s 包含从 1 到 n 的整数。不幸的是，因为数据错误，导致集合里面某一个数字复制了成了集合里面的另外一个数字的值，导致集合 丢失了一个数字 并且 有一个数字重复 。
 *
 * 给定一个数组 nums 代表了集合 S 发生错误后的结果。
 *
 * 请你找出重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,2,4]
 * 输出：[2,3]
 * 示例 2：
 *
 * 输入：nums = [1,1]
 * 输出：[1,2]
 *
 *
 * 提示：
 *
 * 2 <= nums.length <= 104
 * 1 <= nums[i] <= 104
 *
 * author:caiyi
 * time:2021-01-29
 */
public class ErrorNums {
    public static void main(String[] args){
        int[] nums={1,1};
        int[] nums1={1,2,2,4};
        int[] result=findErrorNums(nums);
        for(int n:result){
            System.out.println(n);
        }

    }

    /**
     * 解题思路：我们通过Map存储nums里每个数字出现的次数，存储结构位[num[i],count],表示数字num[i]出现了count次，当一个数字重复出现时，他的count就加1.
     * 再检查 11 到 nn 的每个数字在 mapmap 中出现次数。如果一个数字在 mapmap 中没有出现，它就是缺失数字。如果一个数字的出现了两次，它就是重复数字
     *
     * @param nums
     * @return
     */
    public static int[] findErrorNums(int[] nums) {
        Map<Integer,Integer> map=new HashMap<Integer, Integer>(16);
        //重复的数
        int repeat=-1;
        //缺失的数
        int missint=0;
        for(int n:nums){
            map.put(n,map.getOrDefault(n,0)+1);
        }
        //因为数组是从 1 到 n 的整数
        for(int i=1;i<=nums.length;i++){
            if(map.containsKey(i)){
                //等于2代表这个数出现了两次
                if(map.get(i)==2){
                    repeat=i;
                }
            }else{
                //如果map里面没有这个值，代表这个值是缺失的
                missint=i;
            }
        }
        return  new int[]{repeat,missint};
    }

    /**
     * 在 上一个方法中 中使用 map 存储每个数字出现的次数，每个数字都需要两个变量分别存储数字本身和出现次数，因此存储 n 个数字和出现次数需要 2n2n 的空间。
     * 如果使用数组 arrarr 代替 mapmap，可以将空间减少到 nn。
     * 在数组 arrarr 中，索引代表数字，arrarr 存储每个数字出现的次数。例如 arr[i]arr[i] 存储数字 ii 出现的次数。其他过程与 方法四 相同。
     * @param nums
     * @return
     */
    public static int[] findErrorNums1(int[] nums) {
        int[] arr=new int[nums.length+1];
        int repeat=-1;
        int missing=1;
        for(int i=0;i<nums.length;i++){
            arr[nums[i]]+=1;
        }
        for(int j=1;j<arr.length;j++){
            if(arr[j]==2){
                repeat=j;
            }else if(arr[j]==0){
                missing=j;
            }
        }
        return  new int[]{repeat,missing};
    }
}
