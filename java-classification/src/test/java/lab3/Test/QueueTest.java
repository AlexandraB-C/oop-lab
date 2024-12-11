package lab3.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import lab3.ArrayQueue;
import lab3.CircularQueue;
import lab3.LinkedQueue;
import lab3.Queue;

public class QueueTest {

    @Test
    public void testCircularQueue() {
        var queues = List.of(
            new CircularQueue<>(3),
            new LinkedQueue<>(),
            new ArrayQueue<>()
        );

        queues.forEach(queue -> {
            queue.enqueue(1);
            queue.enqueue(2);
            queue.enqueue(3);
            assertThrows(IllegalStateException.class, () -> queue.enqueue(4));
            assertEquals(Integer.valueOf(1), queue.dequeue());
            queue.enqueue(4);
            assertEquals(Integer.valueOf(2), queue.dequeue());
        });
    }

    @Test
    public void testLinkedQueue() {
        Queue<String> queue = new LinkedQueue<>();
        queue.enqueue("A");
        queue.enqueue("B");
        assertEquals("A", queue.dequeue());
        assertEquals(1, queue.size());
        assertEquals("B", queue.dequeue());
        assertTrue(queue.isEmpty());
    }
}