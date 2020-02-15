package cc.xpbootcamp.warmup.fibonacci;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FibonacciTest {
    private Fibonacci fibonacci = new Fibonacci();

    @Test
    void should_return_1_when_calculate_given_position_is_1() {
        int position = 1;
        long result = fibonacci.fibo(position);
        assertEquals(1, result);
    }

    @Test
    void should_return_1_when_calculate_given_position_is_2() {
        int position = 2;
        long result = fibonacci.fibo(position);
        assertEquals(1, result);
    }

    @Test
    void should_return_2_when_calculate_given_position_3() {
        int position = 3;
        long result = fibonacci.fibo(position);
        assertEquals(2, result);
    }

    @Test
    void should_return_34_when_calculate_given_position_9() {
        int position = 9;
        long result = fibonacci.fibo(position);
        assertEquals(34, result);
    }

    @Test
    void should_return_0_when_calculate_given_position_illegal() {
        int position = -1;
        assertThrows(RuntimeException.class, () -> fibonacci.fibo(position));
    }

    @Test
    void should_return_12586269025_when_calculate_given_position_50() {
        int position = 50;
        long result = fibonacci.fibo(position);
        assertEquals(12586269025L, result);
    }
}
