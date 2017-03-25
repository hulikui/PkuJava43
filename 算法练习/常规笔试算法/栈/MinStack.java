/**
 * 带最小值操作的栈

 实现一个带有取最小值min方法的栈，min方法将返回当前栈中的最小值。

 你实现的栈将支持push，pop 和 min 操作，所有操作要求都在O(1)时间内完成。

 注意事项

 如果堆栈中没有数字则不能进行min方法的调用

 样例
 如下操作：push(1)，pop()，push(2)，push(3)，min()， push(1)，min() 返回 1，2，1
 */
/
/**
 * 申请两个栈， 一个是最小栈 mins 保证栈顶一直是最小的， 一个是数据栈， 正常push保存数据
 */
/
public class MinStack {
    private Stack<Integer> mins;
    private Stack<Integer> data;
    public MinStack() {
        mins = new Stack<>();
        data = new Stack<>();
    }
    public void push(int number){
        data.push(number);
        if(mins.empty() || mins.peek() > number){
            mins.push(number);
        }else{
            mins.push(mins.peek());//始终保持最小 复制数据
        }
    }
    public int pop() {
        if(!data.empty() && !mins.empty()){
            data.pop();
            return mins.pop();
        }
        return 0;
    }
    public int min() {
        if(!data.empty() && mins.empty()){
            return mins.peek();
        }
        return 0;
    }
}