package B_B80_Generics;

public class PrintItem<T>  {
    T item;

    public PrintItem(T item) {
        this.item = item;
    }

    public void print() {
        System.out.println(item);
    }
}
