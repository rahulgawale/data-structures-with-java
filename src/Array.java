package src;

/* Dynamic Array Implementation Using Java */
import java.util.Iterator;

@SuppressWarnings("unchecked")
public class Array<T> implements Iterable<T> {
    private T[] array;
    private int length = 0;
    private int capacity = 0;

    public int size() {
        return length;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public T get(int index) {
        if (index >= length) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        return array[index];
    }

    public void set(T element, int index) {
        if (index >= length) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        array[index] = element;
    }

    public void clear() {
        for (int i = 0; i < length; i++) {
            array[i] = null;
        }
        length = 0;
    }

    public Array() {
        this(16);
    }

    public Array(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Capacity must be greater than or equals to 0.");
        }
        this.capacity = capacity;
        array = (T[]) new Object[capacity];
        System.out.println("array length: " + array.length);
    }

    public void add(T element) {
        if (length + 1 >= capacity) {
            if (capacity == 0) {
                capacity = 1;
            } else {
                capacity = capacity * 2;
            }

            T[] newArray = (T[]) new Object[capacity];
            for (int i = 0; i < length; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }
        array[length++] = element;
    }

    public T removeAt(int index) {
        if (index >= length) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        T element = array[index];
        array[index] = null;

        for (int i = index; i < length; i++) {
            array[i] = array[i + 1];
        }
        length--;
        return element;
    }

    public int indexOf(T element) {
        for (int i = 0; i < length; i++) {
            if (array[i] == element) {
                return i;
            }
        }
        return -1;
    }

    public boolean remove(T element) {
        int index = indexOf(element);
        if (index == -1) {
            return false;
        }
        removeAt(index);
        return true;
    }

    public boolean contains(T element) {
        return indexOf(element) != -1;
    }

    @Override
    public String toString() {
        if (length == 0) {
            return "[]";
        }
        String value = "[";
        for (int i = 0; i < length - 1; i++) {
            value += array[i] + ", ";
        }
        value += array[length - 1] + "]";
        return value;
    }

    @Override
    public Iterator<T> iterator() {

        return new Iterator<T>() {
            int index = 0;

            public boolean hasNext() {
                return index < length;
            }

            public T next() {
                return array[index++];
            }
        };
    }
}