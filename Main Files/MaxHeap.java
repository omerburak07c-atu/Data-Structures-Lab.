import java.util.Arrays;

public final class MaxHeap<T extends Comparable<? super T>>
        implements MaxHeapInterface<T>
{
    private T[] heap;

    // Array of heap entries; ignore heap[0]
    private int lastIndex;

    // Index of last entry and number of entries
    private boolean integrityOK

            = false;
    private static final int DEFAULT_CAPACITY = 5;

    // NB: Changed to 5 from 25 for testing convenience
    private static final int MAX_CAPACITY = 10000;

    public MaxHeap()
    {
        this(DEFAULT_CAPACITY); // Call next constructor
    } // end default constructor

    public MaxHeap(int initialCapacity)
    {

        integrityOK = false;
        checkCapacity(initialCapacity);


        @SuppressWarnings("unchecked")
        T[] tempHeap = (T[])new Comparable[initialCapacity + 1]; // First array element is not used
        heap = tempHeap;
        lastIndex = 0;
        integrityOK = true;
    } //

    public MaxHeap(T[] entries)
    {
        this(entries.length);

        lastIndex = entries.length;


        for (int index = 1; index <= lastIndex; index++)
            heap[index] = entries[index - 1];


        for (int rootIndex = lastIndex / 2; rootIndex > 0; rootIndex--)
            reheap(rootIndex);
    }

    public void add(T newEntry)
    {
        checkIntegrity();
        int newIndex = lastIndex + 1;
        int parentIndex = newIndex / 2;
        while ( (parentIndex > 0) && newEntry.compareTo(heap[parentIndex]) > 0)
        {
            heap[newIndex] = heap[parentIndex];
            newIndex = parentIndex;
            parentIndex = newIndex / 2;
        }

        heap[newIndex] = newEntry;
        lastIndex++;
        ensureCapacity();
    }

    public T removeMax()
    {
        checkIntegrity();
        T root = null;

        if (!isEmpty())
        {
            root = heap[1];
            heap[1] = heap[lastIndex];
            lastIndex--;
            reheap(1);
        }

        return root;
    }

    public T getMax()
    {
        checkIntegrity();
        T root = null;

        if (!isEmpty())
            root = heap[1];

        return root;
    }

    public boolean isEmpty()
    {
        return lastIndex < 1;
    }

    public int getSize()
    {
        return lastIndex;
    }

    public void clear()
    {
        checkIntegrity();
        while (lastIndex > -1)
        {
            heap[lastIndex] = null;
            lastIndex--;
        }

        lastIndex = 0;
    }


    private void reheap(int rootIndex)
    {
        boolean done = false;
        T orphan = heap[rootIndex];
        int leftChildIndex = 2 * rootIndex;

        while (!done && (leftChildIndex <= lastIndex) )
        {
            int largerChildIndex = leftChildIndex;
            int rightChildIndex = leftChildIndex + 1;

            if ( (rightChildIndex <= lastIndex) &&
                    heap[rightChildIndex].compareTo(heap[largerChildIndex]) > 0)
            {
                largerChildIndex = rightChildIndex;
            }

            if (orphan.compareTo(heap[largerChildIndex]) < 0)
            {
                heap[rootIndex] = heap[largerChildIndex];
                rootIndex = largerChildIndex;
                leftChildIndex = 2 * rootIndex;
            }
            else
                done = true;
        }

        heap[rootIndex] = orphan;
    }


    private void ensureCapacity()
    {
        int numberOfEntries = lastIndex;
        int capacity = heap.length - 1;
        if (numberOfEntries >= capacity)
        {
            int newCapacity = 2 * capacity;
            checkCapacity(newCapacity);
            heap = Arrays.copyOf(heap, newCapacity + 1);
        }
    }


    private void checkIntegrity()
    {
        if (!integrityOK)
            throw new SecurityException ("MaxHeap object is corrupt.");
    }


    private void checkCapacity(int capacity)
    {
        if (capacity < DEFAULT_CAPACITY)
            throw new IllegalStateException("Attempt to create a heap " +
                    "whose capacity is smaller than " +
                    DEFAULT_CAPACITY);
        else if (capacity > MAX_CAPACITY)
            throw new IllegalStateException("Attempt to create a heap " +
                    "whose capacity is larger than " +
                    MAX_CAPACITY);
    }
}

