
public class orderedListApp {
    public static void main (String[] args) {
        orderedList <Integer> integerList = new orderedList<>();
    
        integerList = add(integerList, 2);
        integerList = add(integerList, 3);
        integerList = add(integerList, 4);
        integerList = add(integerList, 1);
        length(integerList);
        
        printFirst(integerList);
        printLast(integerList);
        integerList = deleteFirst(integerList);
        integerList = deleteLast(integerList);
        
        printFirst(integerList);
        printLast(integerList);
        length(integerList);

    }

    public static <T extends Comparable<T>> orderedList<T> add(orderedList<T> orderedList, T data) {
        if (data == null) {
            throw new IllegalArgumentException("Data cannot be null.");
        }
    
        orderedList<T> temp = new orderedList<T>(data);
        if (orderedList == null || orderedList.getData() == null || data.compareTo(orderedList.getData()) < 0) {
            temp.setNext(orderedList);
            System.out.println("added " + temp.getData());
            return temp;
        }
    
        orderedList<T> current = orderedList;
        while (current.getNext() != null && current.getNext().getData() != null && data.compareTo(current.getNext().getData()) >= 0) {
            current = current.getNext();
        }
        temp.setNext(current.getNext());
        current.setNext(temp);
        System.out.println("added " + temp.getData());
        return orderedList;
    }
    
    public static <T extends Comparable<T>> orderedList<T> deleteFirst(orderedList<T> orderedList) {
        if (orderedList == null) {
            return orderedList;
        }
        System.out.println("deleted " + orderedList.getData());
        return orderedList.getNext();
    }

    public static <T extends Comparable<T>> orderedList<T> deleteLast(orderedList<T> orderedList) {
        if (orderedList == null) {
            return null; 
        }
    
        orderedList <T> current = orderedList;
        while (current.getNext().getNext() != null) {
            current = current.getNext();
        }
        current.setNext(null);
        System.out.println("deleted " + current.getData());
        return orderedList;
    }
    public static <T extends Comparable<T>> void length(orderedList<T> orderedList) {
        if (orderedList == null) {
            System.out.println("0");
        }
        int count = 0;
        orderedList <T> current = orderedList;
        while (current.getNext() != null) {
            current = current.getNext();
            count++;
        }
        System.out.println("count is " + count);
    }

    public static <T extends Comparable<T>> void printFirst(orderedList<T> orderedList) {
        if (orderedList == null) {
            System.out.println("List is empty");
            return;
        }
        System.out.println(orderedList.getData());
    }

    public static <T extends Comparable<T>> void printLast(orderedList<T> orderedList) {
        if (orderedList == null || orderedList.getData() == null) {
            System.out.println("List is empty");
        }
        orderedList<T> current = orderedList;
        while (current.getNext().getNext() != null) {
            current = current.getNext();
        }
        System.out.println(current.getData());
    }
    
}