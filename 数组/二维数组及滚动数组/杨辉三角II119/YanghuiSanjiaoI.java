package 数组.二维数组及滚动数组.杨辉三角II119;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 *
 *
 *
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 *
 * 输入: 3
 * 输出: [1,3,3,1]
 * 进阶：
 *
 * @author caiyi
 * @date 2021-03-22
 */
public class YanghuiSanjiaoI {
    public static void main(String[] args){
        getRow(3);
    }
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> result=new ArrayList<>();
        for(int i=0;i<rowIndex+1;i++){
            List<Integer> row=new ArrayList<>();
            for(int j=0;j<=i;j++){
                if(j==0 || i==j){
                    row.add(1);
                }else {
                    row.add(result.get(j - 1) + result.get(j));
                }
            }
            result=row;
        }
        return result;
    }
}
