package 栈.剑指Offer09.两个栈实现队列;

import java.util.Stack;

/**
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 *
 *  
 *
 * 示例 1：
 *
 * 输入：
 * ["CQueue","appendTail","deleteHead","deleteHead"]
 * [[],[3],[],[]]
 * 输出：[null,null,3,-1]
 * 示例 2：
 *
 * 输入：
 * ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
 * [[],[],[5],[2],[],[]]
 * 输出：[null,-1,null,null,5,2]
 * 提示：
 *
 * 1 <= values <= 10000
 * 最多会对 appendTail、deleteHead 进行 10000 次调用
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


/**
 * 解题思路：通过两个队列stackA,stackB实现队列，stackA当作队列，stackB当作辅助队列。
 * 在appendTail操作时，appenTail要求队列尾部插入整数，需要先将stack里面的元素pop出放入stackB，然后将整数放入stackA，再将stakB中所有元素push进stackA
 * deleteHead头部删除整数操作，将stackA.pop()抛出第一个元素即可
 * 文字理解不了，可以看解题思路gif
 */
public class TwoStackBecomeQueue {
    public static void main(String[] args){

    }
    Stack<Integer> stackA,stackB;
    public  void CQueue() {
        stackA=new Stack<Integer>();
        stackB=new Stack<Integer>();
    }

    public void appendTail(int value) {
        while(!stackA.isEmpty()){
            stackB.push(stackA.pop());
        }
       stackA.push(value);
       while (!stackB.isEmpty()){
           stackA.push(stackB.pop());
       }
    }

    public int deleteHead() {
        if(stackA.isEmpty()){
            return -1;
        }
        return stackA.pop();
    }
}
