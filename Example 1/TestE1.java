public class TestE1 {
    public static void main(String[] args) {
        Integer[] Data = {75, 40, 12, 5, 14, 19};

        MaxHeapInterface<Integer> maxHeap = new MaxHeap<>();
        for (int i = 0; i < Data.length; i++) {
            maxHeap.add(Data[i]);
        }

        if (maxHeap.isEmpty())
            System.out.println("The heap is empty.");
        else
            System.out.println("The heap is not empty; it contains " +
                    maxHeap.getSize() + " elements.");

        System.out.println("The largest element is " + maxHeap.getMax());

        System.out.println("Removing entries in descending order:");
        while (!maxHeap.isEmpty())
            System.out.println("Removing " + maxHeap.removeMax());
    }

}