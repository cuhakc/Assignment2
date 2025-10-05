package algorithms;

import metrics.PerformanceTracker;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SelectionSortTest {

    @Test
    void testEmptyArray() {
        int[] arr = {};
        SelectionSort.sort(arr, new PerformanceTracker());
        assertArrayEquals(new int[]{}, arr);
    }

    @Test
    void testSingleElement() {
        int[] arr = {42};
        SelectionSort.sort(arr, new PerformanceTracker());
        assertArrayEquals(new int[]{42}, arr);
    }

    @Test
    void testAlreadySorted() {
        int[] arr = {1, 2, 3, 4, 5};
        SelectionSort.sort(arr, new PerformanceTracker());
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    void testReverseSorted() {
        int[] arr = {5, 4, 3, 2, 1};
        SelectionSort.sort(arr, new PerformanceTracker());
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    void testWithDuplicates() {
        int[] arr = {3, 1, 2, 1, 3};
        SelectionSort.sort(arr, new PerformanceTracker());
        assertArrayEquals(new int[]{1, 1, 2, 3, 3}, arr);
    }
}