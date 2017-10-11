/*David Hoang - CSC 202 - October 11, 2017 - Programming Ex. 23.7 pg. 892*/

public class mini_Heap {

    static class Heap<E extends Comparable<E>> { // Listing 23.9 Heap.java from page 878

        private java.util.ArrayList<E> listing = new java.util.ArrayList<E>();


        public Heap() {
        }


        public Heap(E[] objects) {
            for (int i = 0; i < objects.length; i++)
                add(objects[i]);
        }


        public void add(E newObject) {
            listing.add(newObject);
            int current_Index = listing.size() - 1;

            while (current_Index > 0) {
                int parentIndex = (current_Index - 1) / 2;

                if (listing.get(current_Index).compareTo(listing.get(parentIndex)) < 0) {
                    E temp = listing.get(current_Index);
                    listing.set(current_Index, listing.get(parentIndex));
                    listing.set(parentIndex, temp);
                } else
                    break;

                current_Index = parentIndex;
            }
        }


        public E remove() {
            if (listing.size() == 0)
                return null;

            E removedObject = listing.get(0);
            listing.set(0, listing.get(listing.size() - 1));
            listing.remove(listing.size() - 1);

            int current_Index = 0;
            while (current_Index < listing.size()) {
                int leftChildIndex = 2 * current_Index + 1;
                int rightChildIndex = 2 * current_Index + 2;


                if (leftChildIndex >= listing.size())
                    break;
                int max_Index = leftChildIndex;
                if (rightChildIndex < listing.size()) {
                    if (listing.get(max_Index).compareTo(listing.get(rightChildIndex)) > 0) {
                        max_Index = rightChildIndex;
                    }
                }


                if (listing.get(current_Index).compareTo(listing.get(max_Index)) > 0) {
                    E temp = listing.get(max_Index);
                    listing.set(max_Index, listing.get(current_Index));
                    listing.set(current_Index, temp);
                    current_Index = max_Index;
                } else
                    break;
            }

            return removedObject;
        }


        public int get_Size() {
            return listing.size();
        }
    }




    public static void main(String[] args) {
        Integer[] listing = { -60, -3, -2, 7, 7, 60, -44, 200, 70, 15, -20, 80, 43 }; //Integer list that will be sorted through heap sort
        heapSort(listing);
        for (int i = 0; i < listing.length; i++)
            System.out.print(listing[i] + " ");
    }

    public static <E extends Comparable<E>> void heapSort(E[] listing) {
        Heap<E> heap = new Heap<E>();

        for (int i = 0; i < listing.length; i++)
            heap.add(listing[i]);
        
        for (int i = listing.length - 1; i >= 0; i--)
            listing[i] = heap.remove();
    }




}