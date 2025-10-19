# Data-Structures-Lab.
Exercise 1
The fundamental change is reversing the comparison logic. A Max Heap ensures the largest element is always at the top, while a Min Heap does the opposite, keeping the smallest at the top. We implemented this by simply swapping the comparison operators (e.g., changing > to <) inside the critical methods that maintain the heap structure.

Exercise 2
To convert the structure, we inverted the heap's core comparison rule. A Max Heap operates by ensuring a parent node is always larger than its children, pushing the maximum value to the root. To create a Min Heap, we reversed this logic—ensuring a parent is smaller than its children—which pushes the minimum value to the root. This was done by swapping the > and < operators in the key sorting methods.

Exercise 3
The conversion simply required inverting the comparison logic. Max Heaps keep the largest item at the top; Min Heaps keep the smallest at the top. We switched from one to the other by swapping the > and < operators in the code's key structural methods.
