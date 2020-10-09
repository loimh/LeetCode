package 栈.栈的最小值面试题0302;

import java.util.Stack;

/**
 * 面试题 03.02. 栈的最小值
 * 请设计一个栈，除了常规栈支持的pop与push函数以外，还支持min函数，该函数返回栈元素中的最小值。执行push、pop和min操作的时间复杂度必须为O(1)。
 *
 *
 * 示例：
 *
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/min-stack-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/** 辅助栈算法
 * 解题思路：通过两个栈，stackA栈存放数据，stackB栈存放最小值
 * push:当stackB为空时，stackA和stackB都push进数据。如果stack不为空，如果push的值比stackB栈顶的值小，则将该值push进stackB中，如果比他大，则stackB再push一遍自己的栈顶保持和stackA元素个数相同
 * pop：stackA和stackB都pop元素
 * top:取stackA的栈顶元素
 * getMin:取stackB的栈顶元素
 */
public class MinStack1 {
    Stack<Integer> stackA;
    Stack<Integer> stackB;
    /** initialize your data structure here. */
    public MinStack() {
        stackA=new Stack<>();
        stackB=new Stack<>();
    }

    public void push(int x) {
        stackA.push(x);
        if(stackB.isEmpty()){
            stackB.push(x);
        }else{
            int top=stackB.peek();
            if(top>x){
                stackB.push(x);
            }else{
                stackB.push(top);
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
        return stackA.peek();
    }

    public int getMin() {
        return stackB.peek();
    }
}
