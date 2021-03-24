package 数组.特定顺序遍历二维数组.螺旋矩阵II59;

/**
 * 59. 螺旋矩阵 II
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 *
 *          1   2   3   4
 *         12  13   14  5
 *         11  16   15  6
 *         10   9   8   7
 *
 *
 * 示例 1：
 *
 * 输入：n = 3
 * 输出：[[1,2,3],[8,9,4],[7,6,5]]
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：[[1]]
 *
 */
public class Matrix {
    public int[][] generateMatrix(int n) {
        int left=0; int right=n-1;
        int top=0; int buttom=n-1;
        int[][] result=new int[n][n];
        int index=1;
        while (index<=n*n){
            for(int i=left;i<=right;i++){
                result[top][i]=index++;
            }
            top++;
            for(int i=top;i<=buttom;i++){
                result[i][right]=index++;
            }
            right--;
            for(int i=right;i>=left;i--){
                result[buttom][i]=index++;
            }
            buttom--;
            for(int i=buttom;i>=top;i--){
                result[i][left]=index++;
            }
            left++;
        }
        return  result;
    }
}
