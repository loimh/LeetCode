package 数组.前缀和数组.二维区域和检索矩阵不可变304;

/**
 * 给定一个二维矩阵，计算其子矩形范围内元素的总和，该子矩阵的左上角为 (row1, col1) ，右下角为 (row2, col2) 。
 *
 *
 * 上图子矩阵左上角 (row1, col1) = (2, 1) ，右下角(row2, col2) = (4, 3)，该子矩形内元素的总和为 8。
 *
 *  
 *
 * 示例：
 *
 * 给定 matrix = [
 *   [3, 0, 1, 4, 2],
 *   [5, 6, 3, 2, 1],
 *   [1, 2, 0, 1, 5],
 *   [4, 1, 0, 1, 7],
 *   [1, 0, 3, 0, 5]
 * ]
 *
 *  [0, 3, 3, 4, 8, 10],
 *  [0, 5, 11,14,16,17],
 *  [0, 1, 3, 3, 4, 9],
 *  [0, 4, 5, 5, 6, 13],
 *  [0, 1, 1, 4, 4, 9]
 *
 * sumRegion(2, 1, 4, 3) -> 8
 * sumRegion(1, 1, 2, 2) -> 11
 * sumRegion(1, 2, 2, 4) -> 12
 *
 */
public class NumMatrix {
    int[][] sums;

    public static void main(String[] args){
        int[][] matrix={{3, 0, 1, 4, 2},{5, 6, 3, 2, 1},{1, 2, 0, 1, 5},{4, 1, 0, 1, 7},{1, 0, 3, 0, 5}};
        int m=matrix.length;
        if(m>0){
            int n=matrix[0].length;
            int[][] sums=new int[m][n+1];
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    sums[i][j+1]=sums[i][j]+matrix[i][j];
                }
            }
            int sum = 0;
            for (int i = 1; i <= 2; i++) {
                sum += sums[i][2 + 1] - sums[i][1];
            }
        }
    }

    public NumMatrix(int[][] matrix) {
        int m=matrix.length;
        if(m>0){
            int n=matrix[0].length;
            sums=new int[m][n+1];
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    sums[i][j+1]=sums[i][j]+matrix[i][j];
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int i = row1; i <= row2; i++) {
            sum += sums[i][col2 + 1] - sums[i][col1];
        }
        return sum;
    }

}
