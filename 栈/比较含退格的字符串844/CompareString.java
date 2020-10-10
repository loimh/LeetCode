package 栈.比较含退格的字符串844;

import java.util.Stack;

/**
 * 844. 比较含退格的字符串
 * 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
 *
 * 注意：如果对空文本输入退格字符，文本继续为空。
 *
 *
 *
 * 示例 1：
 *
 * 输入：S = "ab#c", T = "ad#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “ac”。
 * 示例 2：
 *
 * 输入：S = "ab##", T = "c#d#"
 * 输出：true
 * 解释：S 和 T 都会变成 “”。
 * 示例 3：
 *
 * 输入：S = "a##c", T = "#a#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “c”。
 * 示例 4：
 *
 * 输入：S = "a#c", T = "b"
 * 输出：false
 * 解释：S 会变成 “c”，但 T 仍然是 “b”。
 *
 *
 * 提示：
 *
 * 1 <= S.length <= 200
 * 1 <= T.length <= 200
 * S 和 T 只含有小写字母以及字符 '#'。
 *
 */

/**
 * 解题思路：将字符串中的字符一个一个推入栈中，如果见到‘#’号，不推入并将栈顶元素推出
 */
public class CompareString {
    public static void main(String[] args){
        String S="a#c";
        String T="b";
        boolean flag=backspaceCompare(S,T);
        System.out.println(flag);
    }
    public static boolean backspaceCompare(String S, String T) {
        Stack<Character> stackA=new Stack<>();
        Stack<Character> stackB=new Stack<>();
        for(char ch:S.toCharArray()){
                if(ch=='#'){
                    if(!stackA.isEmpty()){
                        stackA.pop();
                    }
                }else{
                    stackA.push(ch);
                }
        }
        for(char ch:T.toCharArray()){
            if(ch=='#'){
                if(!stackB.isEmpty()){
                    stackB.pop();
                }
            }else{
                stackB.push(ch);
            }
        }
        if (stackB.size() != stackA.size()) {
            return false;
        }
        return  stackA.toString().equals(stackB.toString());
    }
}
