package interview.HW2;


public class ArrList<E> implements MyList {

    private Object[] myArray;
    private int capacity;
    private int currentQuantity;

    {
        currentQuantity = 0;
        capacity = 8;
        myArray = new Object[capacity];
    }

    public ArrList(int arrCapacity) {
        this.myArray = new Object[arrCapacity];
        this.capacity = arrCapacity;
    }

    public ArrList() {
    }

    @Override
    public void add(Object o) {
        if (capacity - 1 > currentQuantity) {
            myArray[currentQuantity] = o;
            currentQuantity++;
        } else {
            extendArr();
            add(o);
        }
    }

    private void extendArr() {
        capacity = capacity * 2;
        myArray = arrClone();
    }

    private Object[] arrClone() {
        Object[] newMyArray = new Object[capacity];
        for (int i = 0; i + 1 < myArray.length; i++) {
            newMyArray[i] = myArray[i];
        }
        return newMyArray;
    }

    public ArrList clone() {
        ArrList result = new ArrList<E>();
        result.myArray = arrClone();
        result.capacity = capacity;
        result.currentQuantity = currentQuantity;
        return result;
    }

    @Override
    public void add(int index, Object o) {
        if (index <= capacity - 1 && index <= currentQuantity) {
            if (capacity - 1 > currentQuantity && index < currentQuantity) {
                for (int i = capacity - 1; i > index; i--) {
                    myArray[i] = myArray[i - 1];
                }
                myArray[index] = o;
                currentQuantity++;
            }
            if (capacity - 1 > currentQuantity && index == currentQuantity) {
                myArray[index] = o;
                currentQuantity++;
            }
            if (capacity - 1 == currentQuantity && index == currentQuantity) {
                myArray[index] = o;
                extendArr();
                currentQuantity++;
            }
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public E get(int index) {
        if (index <= currentQuantity) {
            return (E) myArray[index];
        }
        throw new IndexOutOfBoundsException("Index out of Bounds Exception");
    }

    @Override
    public void set(int index, Object o) {
        if (index <= currentQuantity) {
            myArray[index] = o;
            return;
        }
        throw new IndexOutOfBoundsException("Index out of Bounds Exception");
    }

    @Override
    public int length() {
        return currentQuantity;
    }

    @Override
    public boolean contains(Object o) {
        if (!(currentQuantity > 0)) {
            return false;
        }
        for (Object ob : myArray) {
            if (ob.equals(o)) ;
            return true;
        }
        return false;
    }

    @Override
    public void clear() {
        myArray = new Object[8];
        currentQuantity = 0;
        capacity = 8;
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < currentQuantity; i++) {
            if (myArray[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void remove(int index) {

        if (index <= currentQuantity) {
            for (int i = index; i < currentQuantity; i++) {
                myArray[i] = myArray[i + 1];
            }
            myArray[currentQuantity] = null;
            currentQuantity--;
            return;
        }
        throw new IndexOutOfBoundsException("Index out of Bounds Exception");

    }

    @Override
    public void remove(Object o) {
        int index = indexOf(o);
        remove(index);
    }

}
