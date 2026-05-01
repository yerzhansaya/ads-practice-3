
public class Main {

    public static void main(String[] args) {

        Sorter sorter = new Sorter();
        Searcher searcher = new Searcher();
        Experiment experiment = new Experiment();


        int[] small = sorter.generateRandomArray(10);

        System.out.println("=== SMALL ARRAY ===");
        sorter.printArray(small);

        sorter.basicSort(small);
        System.out.println("After Selection Sort:");
        sorter.printArray(small);

        int targetSmall = small[5];
        System.out.println("Search result index: " + searcher.search(small, targetSmall));


        int[] medium = sorter.generateRandomArray(100);
        int[] mediumSorted = medium.clone();
        sorter.advancedSort(mediumSorted);

        System.out.println("\n=== MEDIUM ARRAY ===");
        System.out.println("Search index: " + searcher.search(mediumSorted, mediumSorted[50]));


        int[] large = sorter.generateRandomArray(1000);
        int[] largeSorted = large.clone();
        sorter.advancedSort(largeSorted);

        System.out.println("\n=== LARGE ARRAY ===");
        System.out.println("Search index: " + searcher.search(largeSorted, largeSorted[500]));


        System.out.println("\n=== PERFORMANCE TEST ===");
        experiment.runAllExperiments();
    }
}