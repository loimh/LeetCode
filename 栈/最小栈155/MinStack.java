package 栈.最小栈155;

import java.util.Stack;

/**
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 *  
 *
 * 示例:
 *
 * 输入：
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 *
 * 输出：
 * [null,null,null,null,-3,null,0,-2]
 *
 * 解释：
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/min-stack
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/** 辅助栈算法
 * 解题思路：通过两个栈，stackA栈存放数据，stackB栈存放最小值
 * push:当stackB为空时，stackA和stackB都push进数据。如果stack不为空，如果push的值比stackB栈顶的值小，则将该值push进stackB中，如果比他大，则stackB再push一遍自己的栈顶保持和stackA元素个数相同
 * pop：stackA和stackB都pop元素
 * top:取stackA的栈顶元素
 * getMin:取stackB的栈顶元素
 */
public class MinStack {
    public static void main(String[] args){
        //["MinStack","push","push","push","push","pop","getMin","pop","getMin","pop","getMin"]
        //[[],[512],[-1024],[-1024],[512],[],[],[],[],[],[]]
        MinStack minStack=new MinStack();
        minStack.push(512);
        minStack.push(-1024);
        minStack.push(1024);
        minStack.push(512);
        minStack.pop();
        minStack.getMin();
        minStack.pop();
        minStack.getMin();
        minStack.pop();
        minStack.getMin();
    }
    Stack<Integer> stackA;
    Stack<Integer> stackB;
    int min=0;
    /** initialize your data structure here. */
    public MinStack() {
        stackA=new Stack<Integer>();
        stackB=new Stack<Integer>();
    }

    public void push(int x) {
        stackA.push(x);
        if(stackB.isEmpty()){
            //第一次push不用判断直接push进stackB
            stackB.push(x);
        }else{
            //如果插入的值比stackB的栈顶元素小，则将值插入stackB
            if(x<=stackB.peek()){
                stackB.push(x);
            }else{
                //插入值比stackB栈顶的元素大，则再插入一次stackB的栈顶元素，保持栈顶元素是最小值，并和stackA元素个数保持相同
                stackB.push(stackB.peek());
            }
        }
    }

    public void pop() {
        if(!stackB.isEmpty()){
            stackA.pop();
            stackB.pop();
        }
    }

    public int top() {
        return  stackA.peek();
    }

    public int getMin() {
            return  stackB.peek();
    }
}
