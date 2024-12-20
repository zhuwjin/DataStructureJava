package life.jinjiang;

public class Stack<T> {
    private Array<T> array;

    public Stack() {
        array = new Array<>();
    }

    public T pop(){
        var data = array.get(array.size() - 1);
        array.remove(array.size() - 1);

        return data;
    }

    public void push(T data){
        array.insert(array.size(), data);
    }
}
