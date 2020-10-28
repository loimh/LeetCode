package 栈;


import java.util.Stack;

/**
 * 1021. 删除最外层的括号
 * 有效括号字符串为空 ("")、"(" + A + ")" 或 A + B，其中 A 和 B 都是有效的括号字符串，+ 代表字符串的连接。例如，""，"()"，"(())()" 和 "(()(()))" 都是有效的括号字符串。
 *
 * 如果有效字符串 S 非空，且不存在将其拆分为 S = A+B 的方法，我们称其为原语（primitive），其中 A 和 B 都是非空有效括号字符串。
 *
 * 给出一个非空有效字符串 S，考虑将其进行原语化分解，使得：S = P_1 + P_2 + ... + P_k，其中 P_i 是有效括号字符串原语。
 *
 * 对 S 进行原语化分解，删除分解中每个原语字符串的最外层括号，返回 S 。
 *
 *
 *
 * 示例 1：
 *
 * 输入："(()())(())"
 * 输出："()()()"
 * 解释：
 * 输入字符串为 "(()())(())"，原语化分解得到 "(()())" + "(())"，
 * 删除每个部分中的最外层括号后得到 "()()" + "()" = "()()()"。
 * 示例 2：
 *
 * 输入："(()())(())(()(()))"
 * 输出："()()()()(())"
 * 解释：
 * 输入字符串为 "(()())(())(()(()))"，原语化分解得到 "(()())" + "(())" + "(()(()))"，
 * 删除每个部分中的最外层括号后得到 "()()" + "()" + "()(())" = "()()()()(())"。
 * 示例 3：
 *
 * 输入："()()"
 * 输出：""
 * 解释：
 * 输入字符串为 "()()"，原语化分解得到 "()" + "()"，
 * 删除每个部分中的最外层括号后得到 "" + "" = ""。
 *
 *
 * 提示：
 *
 * S.length <= 10000
 * S[i] 为 "(" 或 ")"
 * S 是一个有效括号字符串
 */
public class DeleteOutBrackets {
    public static void main(String[] args){
        String s="(()())(())(()(()))";
        String ss=removeOuterParentheses1(s);
        System.out.println(ss);
    }
    //设置标志位实现
    public static String removeOuterParentheses(String S) {
        int flag=0;//如果是左括号flag+1，如果右括号flag-1，只要flag>0就表示他在最外层括号内
        StringBuilder sb=new StringBuilder();
      for(char ch:S.toCharArray()){
          switch (ch){
              case '(':
                  if(flag>0){
                      sb.append('(');
                  }
                  flag+=1;
                  break;
              case ')':
                  flag-=1;
                  if(flag>0){
                      sb.append(')');
                  }
                  break;
          }
      }
      return sb.toString();
    }
    //通过栈来实现
    public static String removeOuterParentheses1(String S) {
        StringBuilder ans = new StringBuilder();
        boolean flag=false;//标志每个原语
        int start = 0;// 初始化原语的起始位置
        int end = 0;// 初始化原语的结束位置
       Stack<Character> stack=new Stack<Character>();
       for(int i=0;i<S.length();i++){
           char ch=S.charAt(i);
           if (ch == '(') {
               stack.push(ch);
               if(!flag){
                   start=i;
                   flag=true;
               }
           }
           if (ch == ')') {
               stack.pop();
               if(stack.isEmpty()){//当栈空的时候，找到了一个完整的原语
                   end=i;
                   ans.append(S.substring(start+1,end));
                   flag=false;
               }
           }
           }
            return  ans.toString();
           }
       }
