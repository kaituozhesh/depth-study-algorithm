package net.ityizhan.algorithm.basic.class1;

/**
 * @ClassName : Code01PrintBinary
 * @Description : 打印32位数的二进制表示
 * @Author : 骚豪 : https://www.ityizhan.net
 * @Date: 2021-06-22 20:10
 * @Version: 1.0.0
 */
public class Code01PrintBinary {

    public static void print(int num) {
        for (int i = 31; i >= 0; i--) {
            // 1. &运算：都是两位都是1得1，其余情况都是0
            // 2. 1 << 左移 i 位那对应的二进制第 i 位为 1,其余位都是0
            // 3. 拿num二进制表示的每一位做 &运算只要不等于0，那这一位就是1
            // 如：num二进制=0010101100, i = 5; 0010101100 & 0000010000 = 00000'0'0000 所以第5位为0
            // 如：num二进制=0010101100, i = 4; 0010101100 & 0000001000 = 000000'1'000 所以第4位为1
            System.out.print((num & (1 << i)) == 0 ? "0" : "1");
        }
        System.out.println();
    }

    /**
     * 先把Main方法运行起来  对照结果看注释
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("打印32位数的二进制表示：");
        int num = 12312546;
        print(num);
        System.out.println();


        System.out.println("<< 左移运算：");
        // <<：左移 二进制数整体向左移动一位 空出来的位用0补齐
        // 2^4  2^3  2^2  2^1  2^0 每左移一位 乘2
        //  0    0    0    0    1
        int test = 1;
        System.out.print("test:" + (test) + "\tbinary：");
        print(test);
        System.out.print("test:" + (test << 1) + "\tbinary：");
        print(test << 1);
        System.out.print("test:" + (test << 2) + "\tbinary：");
        print(test << 2);
        System.out.print("test:" + (test << 5) + "\tbinary：");
        print(test << 5);
        System.out.println();

        System.out.println("原码、反码、补码：");
        // 4 + 5    = 0000 0100 + 0000 0101 = 0000 1001
        // 5 - 4    = 0000 0101 - 0000 0100 = 0000 0001
        // 5 + (-4) = 0000 0101 + 1111 1100 = 0000 0001
        // 5 - (-4) = 0000 0101 - 1111 1100 =
        // 负数二进制：绝对值 取反 + 1
        // 如：-5： 5 = 0000 0101 取反 = 1111 1010 + 1 = 1111 1010 + 0000 0001 = 1111 1011
        print(-5);

        // 原码：最高位为符号位,0：表示正数 1：表示负数,其余为表示数值大小。即正数只需要按照其绝对值转成二进制即可，而负数按照绝对值转为二进制后最高位补1，称为原码
        // 反码：正数：反码是其本身，负数：符号位除外，其余位取反 注：反码通常是由原码求补码、补码求原码的过度码
        // 补码：补码是计算机把减法运算转化为加法运算的关键编码。正数：补码是其本身，负数：补码是其反码 + 1.
        // 重：在计算机中数值一律用补码来表示和存储。原因如下
        //  1. 使用补码，可以将符号位和数值域统一处理。
        //  2. 加法和减法可以统一处理
        //  3. 补码与原码相互转换，其运算过程是相同的，不需要额外的硬件电路
        System.out.println();

        System.out.println("位运算：");
        // 位运算
        print(4);
        print(5);
        // | : 或运算   ：只要有一个为1就为1
        System.out.print("4 | 5\tbinary：");
        print(4 | 5);
        // & : 与运算   ：两者都为1才为1
        System.out.print("4 & 5\tbinary：");
        print(4 & 5);
        // ^ : 异或运算  ：相同为0，不同为1
        System.out.print("4 ^ 5\tbinary：");
        print(4 ^ 5);

        System.out.println();
        System.out.println(">>：带符号右移动、>>>：不带符号右移：");
        // 右移
        // >> 带符号右移：不管右移几位都用符号位补充
        // >>> 不带符号右移：不管右移几位都用0补充
        print(5 >> 2);
        print(5 >>> 2);
        print(-5 >> 2);
        print(-5 >>> 2);
    }

}
