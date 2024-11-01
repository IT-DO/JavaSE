package Java_Core.Multithreading.Concurrent2;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableEx implements Callable {

    private String word;

    public CallableEx(String word) {
        this.word = word;
    }

    public Integer call() {
        System.out.println(Thread.currentThread().getName() + ", длина слова: " + word.length());
        return Integer.valueOf(word.length());
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String[] strs = sc.nextLine().split(" ");

        ExecutorService pool = Executors.newFixedThreadPool(10);
        Set<Future<Integer>> set = new HashSet<>();
        for (String word : strs) {
            Callable<Integer> callable = new CallableEx(word);
            Future<Integer> future = pool.submit(callable);
            set.add(future);
        }
        int sum = 0;
        for (Future<Integer> future : set) {
            sum += future.get();
        }
        System.out.printf("The sum of length is %s%n", sum);
        pool.shutdown();
    }
}
