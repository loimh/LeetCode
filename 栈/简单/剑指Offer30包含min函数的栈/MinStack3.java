//package 栈.剑指Offer30包含min函数的栈;
//
//import java.util.Stack;
//
///**
// *
// 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
//
//
//
// 示例:
//
// MinStack minStack = new MinStack();
// minStack.push(-2);
// minStack.push(0);
// minStack.push(-3);
// minStack.min();   --> 返回 -3.
// minStack.pop();
// minStack.top();      --> 返回 0.
// minStack.min();   --> 返回 -2.
//
//
// 提示：
//
// 各函数的调用总次数不超过 20000 次
//
// */
//public class MinStack3 {
//
//    Stack<Integer> stackA;
//    Stack<Integer> stackB;
//    /** initialize your data structure here. */
//    public MinStack() {
//        stackA=new Stack<>();
//        stackB=new Stack<>();
//    }
//
//    public void push(int x) {
//        stackA.push(x);
//        if(!stackB.isEmpty()){
//            if(x<stackB.peek()){
//                stackB.push(x);
//            }else{
//                stackB.push(stackB.peek());
//            }
//        }else{
//            stackB.push(x);
//        }
//    }
//
//    public void pop() {
//        if(!stackB.isEmpty()){
//            stackA.pop();
//            stackB.pop();
//        }
//    }
//
//    public int top() {
//        return  stackA.peek();
//    }
//
//    public int min() {
//        return  stackB.peek();
//    }
//}
