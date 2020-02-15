package cc.xpbootcamp.warmup.fibonacci;

public class Fibonacci {

    public long fibo(int position) {
        if(position == 1 || position == 2)
            return 1;
        else
            return fibo(position - 1) + fibo(position - 2);
    }
}
