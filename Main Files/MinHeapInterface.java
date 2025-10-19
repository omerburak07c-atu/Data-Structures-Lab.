public interface MinHeapInterface<T extends Comparable<? super T>> {

    /** Adds a new entry to this heap.
     @param newEntry  An object to be added. */
    public void add(T newEntry);

    /** Removes and returns the smallest item in this heap.
     @return  Either the smallest object in the heap or,
     if the heap is empty before the operation, null. */
    public T removeMin(); // removeMax -> removeMin

    /** Retrieves the smallest item in this heap.
     @return  Either the smallest object in the heap or,
     if the heap is empty, null. */
    public T getMin();    // getMax -> getMin

    /** Detects whether this heap is empty.
     @return  True if the heap is empty, or false otherwise. */
    public boolean isEmpty();

    /** Gets the size of this heap.
     @return  An integer that is the number of entries in the heap. */
    public int getSize();

    /** Removes all entries from this heap. */
    public void clear();
}