import java.util.Arrays;

public class TestE2 {
    public static void main(String[] args) {

        Integer[] unprocessedData = {32,98,65,7,14,55};

        System.out.println("Unprocessed Data:");
        System.out.println(Arrays.toString(unprocessedData));


        MaxHeap<Integer> heap = new MaxHeap<>(unprocessedData);

        System.out.println("Max: " + heap.getMax());

        System.out.println("Elements of Heap:");
        while (!heap.isEmpty()) {
            System.out.print(heap.removeMax() + " ");
        }
        System.out.println();
    }
}
