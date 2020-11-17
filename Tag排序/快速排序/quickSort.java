package Tag排序.快速排序;

public class quickSort {
    public static  void main(String[] args){
        int[] arr = {2,5,1,3,8,5,7,4,3};
        sort(arr,0,arr.length-1);
        for(int i:arr){
            System.out.println(i);
        }
    }

    public static void sort(int[] nums,int left,int right){
        int i,j,t,temp;
        if(left>right){
            return;
        }
        temp=nums[left];
        i=left;
        j=right;
        while(i!=j){
            while(nums[j]>=temp && i<j){
                j--;
            }
            while(nums[i]<=temp && i<j){
                i++;
            }
            if(i<j) {
                t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
            }
        }
        nums[left]=nums[i];
        nums[i]=temp;
        sort(nums,left,i-1);
        sort(nums,i+1,right);
    }

}
