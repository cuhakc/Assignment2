package algorithms;

import metrics.PerformanceTracker;

public class SelectionSort {

    public static void sort(int[] arr, PerformanceTracker tracker) {
        if (arr == null || arr.length <= 1) return;

        int n = arr.length;
        boolean sorted;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            sorted = true;

            for (int j = i + 1; j < n; j++) {
                tracker.incrementComparisons();
                tracker.incrementArrayAccesses();
                tracker.incrementArrayAccesses();

                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                    sorted = false;
                }
            }

            if (minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
                tracker.incrementSwaps();
                tracker.incrementArrayAccesses();
                tracker.incrementArrayAccesses();
                tracker.incrementArrayAccesses();
            }

            if (sorted) break;
        }
    }
}