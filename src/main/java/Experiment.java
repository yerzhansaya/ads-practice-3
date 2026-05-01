import java.util.Arrays;

public class Experiment {

    private Sorter sorter = new Sorter();
    private Searcher searcher = new Searcher();

    public long measureSortTime(int[] arr, String type) {
        int[] copy = Arrays.copyOf(arr, arr.length);

        long start = System.nanoTime();

        if (type.equals("basic")) {
            sorter.basicSort(copy);
        } else {
            sorter.advancedSort(copy);
        }

        long end = System.nanoTime();
        return end - start;
    }

    public long measureSearchTime(int[] arr, int target) {
        int[] copy = Arrays.copyOf(arr, arr.length);

        sorter.advancedSort(copy);

        long start = System.nanoTime();
        searcher.search(copy, target);
        long end = System.nanoTime();

        return end - start;
    }

    public void runAllExperiments() {

        int[] sizes = {10, 100, 1000};

        System.out.println("===== RESULTS =====");

        for (int size : sizes) {

            int[] random = sorter.generateRandomArray(size);
            int[] sorted = Arrays.copyOf(random, random.length);
            sorter.advancedSort(sorted);

            int target = sorted[size / 2];

            System.out.println("\nSize: " + size);

            System.out.println("Random:");
            System.out.println("Selection: " + measureSortTime(random, "basic"));
            System.out.println("Merge: " + measureSortTime(random, "advanced"));
            System.out.println("Search: " + measureSearchTime(random, target));

            System.out.println("Sorted:");
            System.out.println("Selection: " + measureSortTime(sorted, "basic"));
            System.out.println("Merge: " + measureSortTime(sorted, "advanced"));
            System.out.println("Search: " + measureSearchTime(sorted, target));
        }
    }
}