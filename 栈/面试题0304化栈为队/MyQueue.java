package 栈.面试题0304化栈为队;

import java.util.Stack;

/**
 * 解题思路：新建两个栈，一个stackA用于存放插入的数，stackB用于执行弹出操作。
 * push操作：将元素push到stackA
 * pop操作： 如果stackB不为空，那么StackB中存放的就是队列的头部数据，如果为空，就将stack倒序的放入stackB栈，然后popstackB的元素
 * peek操作：一开始stackB队列为空时，将stackA的元素全部pop出push进StackB栈，那么stackB就相当于一个队列，执行peek()方法即可。
 * Empty操作：两个栈都为空，这个队列才是空的。因为有可能stackA把所有元素放到stackB，所以要同时判断stackA和stackB都是否为空
 *
 */
public class MyQueue {
    Stack<Integer> stackA,stackB;
    public MyQueue() {
        stackA=new Stack<Integer>();
        stackB=new Stack<Integer>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stackA.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
       peek();
       return  stackB.pop();
    }

    /** Get the front element. */
    public int peek() {
       if(stackB.isEmpty()){
           while(!stackA.isEmpty()){
               stackB.push(stackA.pop());
           }
       }
       return  stackB.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stackA.isEmpty() && stackB.isEmpty();
    }
}
