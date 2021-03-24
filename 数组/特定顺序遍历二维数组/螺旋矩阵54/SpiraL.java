package 数组.特定顺序遍历二维数组.螺旋矩阵54;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 54. 螺旋矩阵
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 *
 *
 *
 * 示例 1：
 *
 *      1   2   3
 *      4   5   6
 *      7   8   9
 *
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 示例 2：
 *
 *      1   2   3   4
 *      5   6   7   8
 *      9   10  11  12
 *
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 *
 * @author loimh
 * @date 2021-03-22
 */
public class SpiraL {

    public List<Integer> spiralOrder(int[][] matrix) {
        LinkedList<Integer> result=new LinkedList<>();
        if(matrix.length==0 || matrix==null){
            return result;
        }
        int left=0;
        int right=matrix[0].length-1;
        int top=0;
        int buttom=matrix.length-1;
        int numEle=matrix.length*matrix[0].length;
        while (numEle>=1){
            for(int i=left;i<=right && numEle>=1;i++){
                result.add(matrix[top][i]);
                numEle--;
            }
            top++;
            for(int i=top;i<=buttom && numEle>=1 ;i++){
                result.add(matrix[i][right]);
                numEle--;
            }
            right--;
            for(int i=right;i>=left && numEle>=1;i--){
                result.add(matrix[buttom][i]);
                numEle--;
            }
            buttom--;
            for(int i=buttom;i>=top && numEle>=1;i--){
                result.add(matrix[i][left]);
                numEle--;
            }
            left++;
        }
        return result;

    }
}
