package src;

public class StackExample {
    public static void main(String[] args) {
        Stack<Integer> numberStack = new Stack<Integer>();
        numberStack.push(10);
        numberStack.push(12);
        System.out.println("current stack: " + numberStack.toString());
        System.out.println("popped element is " + numberStack.pop());
        System.out.println("current stack: " + numberStack.toString());
    }
}
