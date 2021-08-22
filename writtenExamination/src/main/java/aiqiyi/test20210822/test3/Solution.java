package aiqiyi.test20210822.test3;

import java.util.Scanner;
import java.util.function.IntConsumer;

/**
 * @author Shenhan
 * @create 2021-08-22-14:57
 */
public class Solution {

    public static void main(String[] args) {
        final Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(n);
        new Thread(() -> {
           try {
               zeroEvenOdd.printZoro(System.out::print);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
        }).start();
        new Thread(() -> {
            try {
                zeroEvenOdd.printEven(System.out::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                zeroEvenOdd.printOdd(System.out::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

}

class ZeroEvenOdd {

    private int n;

    public  ZeroEvenOdd(int n) {
        this.n = n;
    }

    public void printZoro(IntConsumer printNumber) throws InterruptedException{

    }

    public void printEven(IntConsumer printNumber) throws InterruptedException{

    }

    public void printOdd(IntConsumer printNumber) throws InterruptedException{

    }

}
