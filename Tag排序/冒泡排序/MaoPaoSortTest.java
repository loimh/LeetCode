package Tag排序.冒泡排序;

public class MaoPaoSortTest {
    public static void main(String[] args){
        int[] arr = {2,5,1,3,8,5,7,4,3};
        bubbleSort(arr);
        for(int i:arr){
            System.out.println(i);
        }

    }

    public static void bubbleSort(int[] nums) {

        if(nums==null || nums.length<0){
            return;
        }
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums.length-i-1;j++){
                if(nums[j]>nums[j+1]){
                    int temp=nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1]=temp;
                }
            }
        }
    }
}
