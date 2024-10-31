package Java_Core.Multithreading.concurrent2;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.*;
import java.util.concurrent.*;

public class FileGeneratorCallable implements Callable {


    @Override
    public List<String> call() throws Exception {
        String threadName = Thread.currentThread().getName();
        List<String> fileList = new LinkedList<>();

        for (int i = 0; i < 10; i++) {
            String filename = "res/" + threadName + "_" + i + ".txt";
            fileList.add(filename);
            try (OutputStream os = new FileOutputStream(filename); BufferedOutputStream bos = new BufferedOutputStream(os)) {
                bos.write(("Java " + i).getBytes());
                bos.flush();
            }
        }
        Thread.sleep(1000);
        return fileList;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(3);
        Set<Future<List<String>>> futures = new HashSet<>();

        for (int i = 0; i < 10; i++) {
            Callable<List<String>> fileGenerator = new FileGeneratorCallable();
            Future<List<String>> future = pool.submit(fileGenerator);
            futures.add(future);
        }

        List<String> resultList = new ArrayList<>();
        for (Future<List<String>> f : futures) {
            resultList.addAll(f.get());
        }

        System.out.println(resultList);

        pool.shutdown();
    }
}
