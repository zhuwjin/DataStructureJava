package life.jinjiang;

import java.util.Iterator;


/**
 * 顺序表结构，加入了提前分配容量的设计
 * @param <T> 数据类型
 */
public class Array<T> implements Iterable<T> {
    private T[] data;  //数据
    private int size;  //数据个数
    private int capacity; //容量

    public Array() {
        this.size = 0;
        this.capacity = 0;
    }

    /**
     * @return 返回元素的个数
     */
    public int size() {
        return size;
    }


    /**
     * @return 返回容量
     */
    public int capacity() {
        return capacity;
    }


    /**
     * @param index 下标
     * @return 返回下标处的元素
     * @exception IndexOutOfBoundsException 若index < 0 || index >= size() 抛出此异常
     */
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        return data[index];
    }


    /**
     * 插入元素，在插入位置之后的元素会向后移动
     * @param index 要插入的下标
     * @param value 要插入的元素
     */
    @SuppressWarnings("unchecked")
    public void insert(int index, T value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (size == capacity) {
            //如果容量不足，将容量扩充2倍
            if (capacity == 0) {
                capacity = 1;
            } else {
                capacity *= 2;
            }


            T[] newData = (T[]) new Object[capacity];
            if (data != null) {
                //若原来有内容，将其复制
                System.arraycopy(data, 0, newData, 0, size);
            }

            data = newData;
        }

        //在插入下标后的元素向后移动
        for (int i = size - 1; i >= index; i -= 1) {
            data[i + 1] = data[i];
        }

        //将下标处的元素设为要设置的元素
        data[index] = value;
        size += 1;
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayIterator();
    }

    private class ArrayIterator implements Iterator<T> {
        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < size();
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new IndexOutOfBoundsException();
            }
            return data[index++];
        }
    }
}
