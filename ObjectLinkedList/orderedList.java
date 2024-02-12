public class orderedList <T extends Comparable <T>>{
    private T data;
    private orderedList<T> next;

    public orderedList (T data) {
        this.data = data;
        next = null;
    }

    public orderedList () {
        this.data = null;
        next = null;
    }

    public T getData () {
        return data;
    }

    public void setData (T data) {
        this.data = data;
    }

    public orderedList<T> getNext () {
        return next;
    }

    public void setNext (orderedList<T> next) {
        this.next = next;
    }
}