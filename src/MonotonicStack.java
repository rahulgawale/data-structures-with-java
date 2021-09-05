package src;

public class MonotonicStack {
    Stack<Integer> stack = new Stack<Integer>();
    int[] array;

    MonotonicStack(int[] array) {
        this.array = array;
    }

    public int[] getNextGreaterElements() {
        int[] result = new int[array.length];
        int i = 0;
        while (i < array.length) {
            if (stack.isEmpty() || array[stack.peek()] >= array[i]) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && array[stack.peek()] < array[i]) {
                    result[stack.pop()] = i;
                }
                stack.push(i);
            }
            i++;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] sampleArray = { 0, 1, 0, 2, 1, 0, 1, 3 };
        MonotonicStack mStack = new MonotonicStack(sampleArray);
        int[] result = mStack.getNextGreaterElements();

        for (int i = 0; i < result.length; i++) {
            System.out.println("I: " + sampleArray[i] + " next greater: " + sampleArray[result[i]]);
        }
    }
}