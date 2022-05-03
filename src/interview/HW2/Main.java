package interview.HW2;

public class Main {

    public static void main(String[] args) {
        testArr();
        testLink();
    }

    private static void testLink() {
        System.out.println("----TEST LINKLIST--------\n----------------------------");
        LinkList<Main> linkList = new LinkList<>();

        Main test = new Main();

        System.out.println(linkList.length());
        linkList.add(new Main());
        System.out.println(linkList.length());
        linkList.add(new Main());
        linkList.add(new Main());
        linkList.add(new Main());
        linkList.add(new Main());
        linkList.add(new Main());
        linkList.add(2, new Main());
        linkList.add(test);
        linkList.add(new Main());
        linkList.set(2, new Main());
        System.out.println(linkList.length());
        linkList.remove(0);
        System.out.println(linkList.length());

        System.out.println(linkList.get(2));
        System.out.println(linkList.contains(test));
        System.out.println(linkList.indexOf(test));
        linkList.clear();
        System.out.println(linkList.length());
        // System.out.println(linkList.get(2)); //IndexOutOfBoundsException
        System.out.println(linkList.contains(test));
        System.out.println(linkList.indexOf(test));
    }

    static void testArr (){
        System.out.println("----TEST ARRLIST--------\n----------------------------");
        ArrList<Main> arrList2 = new ArrList<>(8);

        Main test = new Main();

        System.out.println(arrList2.length());
        arrList2.add(new Main());
        System.out.println(arrList2.length());
        arrList2.add(new Main());
        arrList2.add(new Main());
        arrList2.add(new Main());
        arrList2.add(new Main());
        arrList2.add(new Main());
        arrList2.add(2, new Main());
        arrList2.add(test);
        arrList2.add(new Main());
        arrList2.set(2, new Main());
        System.out.println(arrList2.length());
        arrList2.remove(0);
        System.out.println(arrList2.length());

        System.out.println(arrList2.get(2));
        System.out.println(arrList2.contains(test));
        System.out.println(arrList2.indexOf(test));
        arrList2.clear();
        System.out.println(arrList2.length());
        // System.out.println(arrList2.get(2)); //IndexOutOfBoundsException
        System.out.println(arrList2.contains(test));
        System.out.println(arrList2.indexOf(test));
    }

}
