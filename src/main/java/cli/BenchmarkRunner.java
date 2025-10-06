package cli;

import algorithms.SelectionSort;
import metrics.PerformanceTracker;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class BenchmarkRunner {

    public static void main(String[] args) {
        int[] sizes = {100, 1000, 10000, 50000, 100000}; // You can add/remove sizes here
        Random rand = new Random();

        String outputFile = "results.csv";

        try (FileWriter writer = new FileWriter(outputFile)) {
            writer.write("n,time_ms,comparisons,swaps,array_accesses\n");

            for (int n : sizes) {
                int[] arr = generateArray(n, "random", rand);

                PerformanceTracker tracker = new PerformanceTracker();

                long start = System.nanoTime();
                SelectionSort.sort(arr, tracker);
                long end = System.nanoTime();

                double timeMs = (end - start) / 1_000_000.0;

                writer.write(String.format("%d,%.3f,%d,%d,%d\n",
                        n, timeMs, tracker.getComparisons(), tracker.getSwaps(), tracker.getArrayAccesses()));

                System.out.printf("Completed n=%d | Time: %.3f ms | %s%n",
                        n, timeMs, tracker);
            }

            System.out.println("\nBenchmark complete!");
            System.out.println("Results saved to: " + outputFile);
            System.out.println("Verification: " + verifySortedExample());

        } catch (IOException e) {
            System.err.println("Error writing benchmark results: " + e.getMessage());
        }
    }
    private static int[] generateArray(int n, String type, Random rand) {
        int[] arr = new int[n];
        switch (type.toLowerCase()) {
            case "sorted":
                for (int i = 0; i < n; i++) arr[i] = i;
                break;
            case "reverse":
                for (int i = 0; i < n; i++) arr[i] = n - i;
                break;
            default: // random
                for (int i = 0; i < n; i++) arr[i] = rand.nextInt(n);
        }
        return arr;
    }

    private static boolean verifySortedExample() {
        int[] test = {5, 3, 1, 4, 2};
        PerformanceTracker tracker = new PerformanceTracker();
        SelectionSort.sort(test, tracker);
        return Arrays.equals(test, new int[]{1, 2, 3, 4, 5});
    }
}
