package interview.HW2;

public interface MyList<E> {
    public void add(E e);
    public void add(int index, E e);
    public E get(int index);
    public void set(int index, E e);
    public int length();
    public boolean contains(E e);
    public void clear();
    public int indexOf(E e);
    public void remove(int index);
    public void remove(E e);

}
