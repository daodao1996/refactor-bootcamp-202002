package cc.xpbootcamp.warmup.fibonacci;

public class Fibonacci {

    public long fibo(int position) {
        if(position < 0)
            throw new RuntimeException();
        if(position <= 1)
            return position;
        else
            return fibo(position - 1) + fibo(position - 2);
    }
}
