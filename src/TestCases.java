
public class TestCases {

    public static void main(String[] args) {
        QueueInterface q = new ListQueue();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(1);
        q.enqueue(3);
        q.enqueue(1);
        q.enqueue(4);
        q.enqueue(5);
        q.enqueue(6);
        q.enqueue(7);
        q.enqueue(0);
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.peek());
        q.enqueue(8);
        q.enqueue(9);
        q.enqueue(10);
        q.enqueue(0);
        System.out.println(q);

        // StackInterface s = new ListStack();
        // s.push(1);
        // s.push(2);
        // s.push(3);
        // s.pop();
        // s.push(4);
        // System.out.println(s.peek());
        // s.push(5);
        // s.push(6);
        // System.out.println(s);

        // QueueInterface q = new ArrayQueue();
        // q.enqueue(1);
        // q.enqueue(2);
        // q.enqueue(1);
        // q.enqueue(3);
        // q.enqueue(1);
        // q.enqueue(4);
        // q.enqueue(5);
        // q.enqueue(6);
        // q.enqueue(7);
        // q.enqueue(0);
        // // System.out.println(q.dequeue());
        // // System.out.println(q.dequeue());
        // // System.out.println(q.dequeue());
        // q.enqueue(8);
        // q.enqueue(9);
        // q.enqueue(10);
        // q.enqueue(0);
        // System.out.println(q);

        // StackInterface s = new ArrayStack();
        // s.push(1);
        // s.push(1);
        // s.push(2);
        // s.push(1);
        // s.push(3);
        // s.push(4);
        // s.push(5);
        // s.push(6);
        // s.push(7);
        // s.push(8);
        // s.push(9);
        // s.push(10);
        // s.push(11);
        // s.push(99999);
        // System.out.println(s);
    }

}
