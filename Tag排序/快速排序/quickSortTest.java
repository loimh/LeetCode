package Tag排序.快速排序;

public class quickSortTest {
    public static  void main(String[] args){
        int[] arr = {2,5,1,3,8,5,7,4,3};
        sort(arr,0,arr.length-1);
        for(int i:arr){
            System.out.println(i);
        }
    }

    public static void sort(int[] nums,int left,int right){
        int i,j,t;
        if(left>right){
            return;
        }
        i=left;
        j=right;
        t=nums[left];
        while (i!=j){
            while (nums[j]>=t && i<j){
                j--;
            }
            while (nums[i]<=t && i<j){
                i++;
            }
            if(i<j){
                int temp=nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
            }
        }
        nums[left]=nums[i];
        nums[i]=t;
        sort(nums,left,i-1);
        sort(nums,i+1,right);
    }
}
