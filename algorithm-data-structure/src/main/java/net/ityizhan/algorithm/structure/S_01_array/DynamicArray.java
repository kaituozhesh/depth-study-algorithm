package net.ityizhan.algorithm.structure.S_01_array;

/**
 * @ClassName : DynamicArray
 * @Description : 动态数组
 * @Author : 骚豪 程序驿站: https://www.ityizhan.net
 * @Date: 2021-06-26 09:52
 * @Version: 1.0.0
 */
public class DynamicArray<E> {

    /**
     * 存储数组元素
     */
    private Object[] data;

    /**
     * 记录数组元素个数
     */
    private int size;

    public DynamicArray(int capacity) {
        data = new Object[capacity];
        this.size = 0;
    }

    public DynamicArray() {
        this(10);
    }

    /**
     * 获取有效数据个数
     *
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 获取数组容量
     *
     * @return
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * 数组是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }


    /**
     * 在数组最后添加元素
     *
     * @param e
     */
    public void addLast(E e) {
        add(size, e);
    }

    /**
     * 在数组最前面添加元素
     *
     * @param e
     */
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * 添加元素导指定下标
     *
     * @param index
     * @param e
     */
    public void add(int index, E e) {
        indexRangeCheckForAdd(index);

        // 经过上次的添加数组已经满了则先进行扩容
        if (size == data.length) {
            reSize(2 * data.length);
        }

        // index及之后的元素都进行后移一位
        System.arraycopy(data, index, data, index + 1, size - index);
        data[index] = e;
        size++;
    }

    /**
     * 获取指定下标元素
     *
     * @param index
     * @return
     */
    public E get(int index) {
        indexRangeCheck(index);
        return elementData(index);
    }

    /**
     * 获取最后一个元素
     *
     * @return
     */
    public E getLast() {
        return get(size - 1);
    }

    /**
     * 获取第一个元素
     *
     * @return
     */
    public E getFirst() {
        return get(0);
    }

    /**
     * 查看元素是否存在数组中
     *
     * @param e
     * @return
     */
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (elementData(i).equals(e)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 返回指定元素在数组中的下标，有多个的情况下返回找到的第一个，没有返回-1
     *
     * @param e
     * @return
     */
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (elementData(i).equals(e)) {
                return i;
            }
        }
        return -1;
    }


    /**
     * 删除指定下标的元素
     *
     * @param index
     * @return
     */
    public E remove(int index) {
        indexRangeCheck(index);

        E ret = elementData(index);

        System.arraycopy(data, index + 1, data, index, size - 1 - index);

        size--;
        data[size] = null;
        if (size == data.length / 4 && data.length / 2 != 0) {
            reSize(data.length / 2);
        }
        return ret;
    }

    /**
     * 删除第一个元素
     *
     * @return
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * 删除最后一个元素
     *
     * @return
     */
    public E removeLast() {
        return remove(size - 1);
    }

    /**
     * 删除指定元素（只删除一个）
     *
     * @param e
     */
    public void removeElement(E e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
        }
    }

    /**
     * 删除所有指定元素
     *
     * @param e
     */
    public void removeAllElement(E e) {
        int index = find(e);
        while (index != -1) {
            remove(index);
            index = find(e);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Array: size = %d, capacity = %d", size, data.length));
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i != size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    // -----------------------private------------------

    private E elementData(int index) {
        return (E) data[index];
    }

    private void indexRangeCheck(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Add failed. Require  index >= 0 || index < size");
        }
    }

    private void indexRangeCheckForAdd(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Require  index >= 0 || index <= size");
        }
    }

    /**
     * 扩容、缩容
     *
     * @param newCapacity
     */
    private void reSize(int newCapacity) {
        Object[] newData = new Object[newCapacity];
        if (size >= 0) {
            System.arraycopy(data, 0, newData, 0, size);
        }
        data = newData;
    }


}
