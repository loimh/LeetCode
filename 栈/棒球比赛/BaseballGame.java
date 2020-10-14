package 栈.棒球比赛;

import java.util.Stack;
import java.util.regex.Pattern;

/**
 * 682. 棒球比赛
 * 你现在是棒球比赛记录员。
 * 给定一个字符串列表，每个字符串可以是以下四种类型之一：
 * 1.整数（一轮的得分）：直接表示您在本轮中获得的积分数。
 * 2. "+"（一轮的得分）：表示本轮获得的得分是前两轮有效 回合得分的总和。
 * 3. "D"（一轮的得分）：表示本轮获得的得分是前一轮有效 回合得分的两倍。
 * 4. "C"（一个操作，这不是一个回合的分数）：表示您获得的最后一个有效 回合的分数是无效的，应该被移除。
 *
 * 每一轮的操作都是永久性的，可能会对前一轮和后一轮产生影响。
 * 你需要返回你在所有回合中得分的总和。
 *
 * 示例 1:
 *
 * 输入: ["5","2","C","D","+"]
 * 输出: 30
 * 解释:
 * 第1轮：你可以得到5分。总和是：5。
 * 第2轮：你可以得到2分。总和是：7。
 * 操作1：第2轮的数据无效。总和是：5。
 * 第3轮：你可以得到10分（第2轮的数据已被删除）。总数是：15。
 * 第4轮：你可以得到5 + 10 = 15分。总数是：30。
 * 示例 2:
 *
 * 输入: ["5","-2","4","C","D","9","+","+"]
 * 输出: 27
 * 解释:
 * 第1轮：你可以得到5分。总和是：5。
 * 第2轮：你可以得到-2分。总数是：3。
 * 第3轮：你可以得到4分。总和是：7。
 * 操作1：第3轮的数据无效。总数是：3。
 * 第4轮：你可以得到-4分（第三轮的数据已被删除）。总和是：-1。
 * 第5轮：你可以得到9分。总数是：8。
 * 第6轮：你可以得到-4 + 9 = 5分。总数是13。
 * 第7轮：你可以得到9 + 5 = 14分。总数是27。
 * 注意：
 *
 * 输入列表的大小将介于1和1000之间。
 * 列表中的每个整数都将介于-30000和30000之间。
 */

/**
 * 解题思路：遍历数组，将数组中每个操作的结果都push进栈Stack中，最后遍历stack得到结果
 */
public class BaseballGame {
    public static void main(String[] args){
        String[] ops={"5","2","C","D","+"};
        int result=calPoints(ops);
        System.out.println(result);
    }
    public static int calPoints(String[] ops) {
        int result=0;
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<ops.length;i++){
            if(ops[i] .equals("+")){
                int ans=0;
                //先将栈顶元素pop出来，并赋值给一个变量
                int temp=stack.pop();
                //“+”号表示前两轮有效 回合得分的总和，即为上一个栈顶元素赋值的变量加上现在的栈顶元素
                ans+=temp+stack.peek();
                //然后将刚才pop出去的栈顶元素再push回来
                stack.push(temp);
                stack.push(ans);
            }else if(ops[i] .equals("D")){
                //“D”表示前一轮有效 回合得分的两倍，即给stack push进栈顶元素的两倍
                stack.push(stack.peek()*2);
            }else if(ops[i] .equals("C")){
                //“C”表示最后一个有效 回合的分数是无效的，即移除栈顶元素
                stack.pop();
            }else {
                stack.push(Integer.parseInt(ops[i]));
            }
            }
        while (!stack.empty()) {
            result+=stack.pop();
        }
        return  result;
    }
}
