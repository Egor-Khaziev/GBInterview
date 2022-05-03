package interview.HW2;

public class LinkList<E> implements MyList {

    Element first;
    Element last;
    int capacity;

    {
        capacity = 0;
    }

    @Override
    public void add(Object o) {
        if (first != null) {
            Element newElement = new Element(o, capacity);
            last.next = newElement;
            last = newElement;
            capacity++;
        } else {
            first = new Element(o, capacity);
            last = first;
            capacity++;
        }
    }

    @Override
    public void add(int index, Object o) {

        Element newElement = new Element(o, capacity);
        Element temp;

        if (index <= capacity-1) {
            if (index == capacity-1) {
                add(o);
                capacity++;
            } else {
                if (index != 0) {
                    Element prev = searching(index - 1);
                    newElement = prev.next;
                    temp = prev.next;
                    prev.next = newElement;
                    capacity++;
                } else {
                    newElement.next = first;
                    temp = first;
                    first = newElement;
                }

                while (temp.index+1 < capacity-1 ) {
                    temp.index++;
                    temp = temp.next;
                }
            }

        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public E get(int index) {
        return (E) searching(index).currentObject;
    }

    private Element searching(int index) {
        Element element = first;
        while (element.index <= index) {
            element = element.next;
        }
        return element;
    }

    @Override
    public void set(int index, Object o) {
        Element element = searching(index);
        element.currentObject = o;
    }

    @Override
    public int length() {
        return capacity;
    }

    @Override
    public boolean contains(Object o) {
        if(capacity>0) {
            Element temp = first;
            while (true) {
                if (temp.currentObject.equals(o)) {
                    return true;
                }
                if (temp.next == null) {
                    return false;
                }
                temp = temp.next;
            }
        }
        return false;
    }


    @Override
    public void clear() {
        first = null;
        last = null;
        capacity = 0;
    }

    @Override
    public int indexOf(Object o) {
        if(first == null){
            return -1;
        }
        Element temp = first;
        while (true){
            if(temp.currentObject.equals(o)){
                return temp.index;
            }
            if(temp.next==null){
                return -1;
            }
            temp = temp.next;
        }
    }

    @Override
    public void remove(int index) {
        if(index <= capacity-1) {
            Element temp;
            if (index == 0) {
                first = first.next;
                temp = first;
            } else {
                temp = searching(index - 1);
                temp.next = temp.next.next;
            }
            while (temp.next != null) {
                temp.index--;
                temp = temp.next;
            }
            capacity--;
        }
    }

    @Override
    public void remove(Object o) {
        Element temp = first;
        while (true){
            if(temp.equals(o)){
                temp.next = temp.next.next;
                break;
            }
            if(temp.next==null){
                throw new RuntimeException("Not Found");
            }
            temp = temp.next;
        }
    }

    private class Element {
        private int index;
        private Element next;
        private Object currentObject;

        private Element(Object currentObject, int index) {
            this.currentObject = currentObject;
            this.index = index;
        }
    }
}
