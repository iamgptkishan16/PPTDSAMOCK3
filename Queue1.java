public class Queue1<T> {
    private Node<T> front;  // Points to the front of the queue
    private Node<T> rear;   // Points to the rear of the queue

    private static class Node<T> {
        private T data;      // Data stored in the node
        private Node<T> next;  // Reference to the next node

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return front == null;
    }

    // Enqueue an element into the queue
    public void enqueue(T item) {
        Node<T> newNode = new Node<>(item);

        // If the queue is empty, set the new node as both front and rear
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            // Add the new node at the rear and update the rear pointer
            rear.next = newNode;
            rear = newNode;
        }

        System.out.println(item + " enqueued into the queue.");
    }

    // Dequeue an element from the queue and return it
    public T dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue element.");
            return null;  // or throw an exception
        }

        // Remove the front node and update the front pointer
        Node<T> dequeuedNode = front;
        front = front.next;

        // If front becomes null after dequeue, update the rear pointer to null as well
        if (front == null) {
            rear = null;
        }

        System.out.println(dequeuedNode.data + " dequeued from the queue.");
        return dequeuedNode.data;
    }


    public static void main(String[] args) {
        Queue1<Integer> queue = new Queue1<>();

        System.out.println("Is the queue empty? " + queue.isEmpty());

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);

        System.out.println("Is the queue empty? " + queue.isEmpty());

        queue.dequeue();
        queue.dequeue();

        queue.enqueue(50);
        queue.enqueue(60);

        queue.dequeue();
        queue.dequeue();
        queue.dequeue();

        System.out.println("Is the queue empty? " + queue.isEmpty());

        queue.dequeue();  // Trying to dequeue from an empty queue
    }
    }

