package life.jinjiang;

public class Queue<T> {
    private final LinkedList<T> data;

    public Queue() {
        data = new LinkedList<>();
    }


    public void enqueue(T data){
        this.data.insert_last(data);
    }

    public T dequeue(){
        var data = this.data.get(0);
        this.data.remove(0);
        return data;
    }
}
