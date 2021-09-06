/* 
@author Rahul Gawale
Input must be an array of integers 1 to N 
*/

package src.algorithms.sort;

import java.util.Arrays;

public class CyclicSort {
    int array[];

    public CyclicSort(int[] array) {
        this.array = array;
    }

    /* sort using the cyclic sort */
    public void sort() {
        int i = 0;
        while (i < array.length) {
            int correct = array[i] - 1;
            if (array[i] != array[correct]) {
                swap(i, correct);
            } else {
                i++;
            }
        }
    }

    private void swap(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }

    // Example
    public static void main(String[] args) {
        CyclicSort cSort = new CyclicSort(new int[] { 1, 2, 3, 4, 5 });
        System.out.println("original: " + cSort.toString());
        cSort.sort();
        System.out.println("sorted: " + cSort.toString());

    }
}
