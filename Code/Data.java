import java.util.ArrayList;

public class Data<T> { //wrapper for arraylist
    
    private ArrayList<T> data = new ArrayList<T>();

    public void addItem(T item) {
        data.add(item);
    }

    public void removeItem(T item) {
        data.remove(item);
    }

    public boolean contains(T item) {
        for (T d : data) {
            if (item == d) {
            return true;
        }
    }
    return false;
    }
    public int length() {
        return data.size();
    }

    public T get(int i) {
        return data.get(i);
    }
    
    public void print() {
        System.out.println(data.toString());
    }

}
