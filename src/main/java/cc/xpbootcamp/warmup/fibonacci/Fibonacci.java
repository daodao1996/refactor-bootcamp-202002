package cc.xpbootcamp.warmup.fibonacci;

public class Fibonacci {

    public long fibo(int position) {
        if(position < 0)
            throw new RuntimeException();
        if(position <= 1)
            return position;
        else
            return calculateFibonacci(position, 1, 0, 2);
    }

    private long calculateFibonacci(int position, long preNum, long prePreNum, int current){
        if(current == position)
            return preNum + prePreNum;
        else
            return calculateFibonacci(position, preNum + prePreNum, preNum, current + 1);
    }
}
