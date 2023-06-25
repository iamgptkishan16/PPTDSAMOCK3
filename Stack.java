/*Question 1--------Implement a stack using an array in Java. Include the necessary methods such as push, pop, and isEmpty.*/

public class Stack {
    private int maxSize;       // Maximum size of the stack
    private int top;           // Index of the top element
    private int[] stackArray;  // Array to store the stack elements

    // Constructor
    public Stack(int size) {
        maxSize = size;
        stackArray = new int[maxSize];
        top = -1;  // Stack is initially empty
    }

    // Push an element onto the stack
    public void push(int value) {
        if (isFull()) {
            System.out.println("Stack is full. Cannot push element.");
            return;
        }
        stackArray[++top] = value;
        System.out.println(value + " pushed onto the stack.");
    }

    // Pop the top element from the stack and return it
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot pop element.");
            return -1; // or throw an exception
        }
        int poppedValue = stackArray[top--];
        System.out.println(poppedValue + " popped from the stack.");
        return poppedValue;
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return (top == -1);
    }

    // Check if the stack is full
    public boolean isFull() {
        return (top == maxSize - 1);
    }

    // Get the top element of the stack without removing it
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return -1; // or throw an exception
        }
        return stackArray[top];
    }

    // Get the number of elements in the stack
    public int size() {
        return top + 1;
    }

    public static void main(String[] args) {
        Stack stack = new Stack(5);

        System.out.println("Is the stack empty? " + stack.isEmpty());

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        stack.push(60);  // Trying to push onto a full stack

        System.out.println("Is the stack full? " + stack.isFull());

        System.out.println("Top element of the stack: " + stack.peek());

        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();  // Trying to pop from an empty stack
    }
}

