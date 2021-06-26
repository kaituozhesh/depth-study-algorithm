package net.ityizhan.algorithm.structure.S_01_array;

/**
 * @ClassName : Main
 * @Description :
 * @Author : 骚豪 程序驿站: https://www.ityizhan.net
 * @Date: 2021-06-26 11:02
 * @Version: 1.0.0
 */
public class Main {
    public static void main(String[] args) {
        DynamicArray<Integer> array = new DynamicArray<>(10);
        for (int i = 0; i < 10; i++) {
            array.addLast(i);
        }
        System.out.println(array);
        array.removeLast();
        System.out.println(array);
        array.removeElement(4);
        System.out.println(array);
        array.addLast(9);
        array.addLast(9);
        array.addLast(9);
        System.out.println(array);
        array.removeAllElement(9);
        array.removeLast();
        array.removeLast();
        array.removeLast();
        System.out.println(array);
    }
}
