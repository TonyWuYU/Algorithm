package com.didi;

import java.util.Scanner;

/**
 * Created by yuwu on 2017/5/5.
 * 进制转换问题,输入一位十进制数字,载输入一位数字,表示需要转成的进制数,最终输出转换结果
 * 例如:
 * 输入: 223123 4
 * 输出: 312132103
 * 解题思路:弄清楚进制转换的本质,由十进制入手,一步步解决问题。
 */
public class Jinzhi {
    public static void main(String[] args) {
        new Jinzhi().run();
    }

    public void run() {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        int tmp;
        int res = M;
        int resTmp = 0;
        while (res > 0) {
            resTmp++;
            res = res / N;
        }
        int[] para = new int[resTmp];
        res = M;
        while (res != 0) {
            tmp = res;
            resTmp = 0;
            while (res > 0) {
                resTmp++;
                res = res / N;
            }
            res = tmp - (tmp / (int) Math.pow(N, resTmp - 1)) * (int) Math.pow(N, resTmp - 1);
            if (resTmp - 1 >= 0) {
                para[resTmp - 1] = tmp / (int) Math.pow(N, resTmp - 1);
            }
        }

        for (int i = para.length - 1; i >= 0; i--) {
            if (para[i] <= 9) {
                System.out.print(para[i]);
            } else {
                switch (para[i]) {
                    case 10:
                        System.out.print('A');
                        break;
                    case 11:
                        System.out.print('B');
                        break;
                    case 12:
                        System.out.print('C');
                        break;
                    case 13:
                        System.out.print('D');
                        break;
                    case 14:
                        System.out.print('E');
                        break;
                    case 15:
                        System.out.print('F');
                        break;
                    case 16:
                        System.out.print('G');
                        break;
                    default:
                        break;
                }
            }

        }

    }
}
