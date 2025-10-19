public class TestE3 {
    public static void main(String[] args) {


        Integer[] Data = {15,84,75,62,36,22};

        MinHeapInterface<Integer> minHeap = new MinHeap<>();
        for (int i = 0; i < Data.length; i++) {
            minHeap.add(Data[i]);
        }

        if (minHeap.isEmpty())
            System.out.println("The heap is empty - INCORRECT");
        else
            System.out.println("The heap is not empty; it contains " +
                    minHeap.getSize() + " elements.");

        System.out.println("The smallest element is " + minHeap.getMin());

        System.out.println("Removing elements in ascending order:");
        while (!minHeap.isEmpty())
            System.out.println("Removing " + minHeap.removeMin());
    }
}
