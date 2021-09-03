package common;

/**
 * Author : mahdi ,  Date : 9/2/2021
 */

public class Calculator {
    public int sum(int i,int j){
        return i+j;
    }

    public int sumDelay(int i,int j) throws InterruptedException {
        Thread.sleep(10);
        return i+j;
    }

    public int multiple(int i,int j){
        return i*j;
    }

    public int subtraction(int i,int j){
        return i-j;
    }

    public int divided(int i,int j){
        return i/j;
    }
}
