package com.xinanjingsai;

import java.util.Scanner;

/**
 * Created by yuwu on 2017/5/24.
 * 问题描述:
 * Walle是个机空投的巡视机,每天的工作是尽职地巡视所在的山区,但年久失修动力不足,不能平行与爬坡,只能走下坡路。现在由你来为Walle设计巡视线,
 * 好让Walle在空投后能够巡视最多的地区。所在地区的地形的海拔高度将由一个二维数组描述，期望输出是最佳路线的长度。
 * 举个例子:
 * 1 2 3 45
 * 16 17 18 19 6
 * 15 24 25 20 7
 * 14 23 22 21 8
 * 13 12 11 10 9
 * Walle允许从某个点走向上下左右相邻四个点之一，但只能选择下坡路。在上面的例子中，一条可行的路径为24-17-16-1，但25-24-23-...-3-2-1才是这个l例子中最长的那条。
 * 解决思路:
 * 这是 道深度优先搜索的题,我们依次从每个点出发，不断向下行，统计路线长度。但是朴素
 * 的深度优先搜索因为存在大量的重复遍历，所以我们使用记忆化搜索的思路对每次统计的结果
 * 进保存，避免重复计算，提升算法执行效率。
 */
public class RobotWalk {
    private static int f[][];
    private static int a[][];
    private static int r, c;
    private static int dx[] = {1, -1, 0, 0};
    private static int dy[] = {0, 0, 1, -1};


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        r = scanner.nextInt();
        c = scanner.nextInt();
        f = new int[r + 1][c + 1];
        a = new int[r + 1][c + 1];
        int ans = -1;
        for (
                int i = 1;
                i <= r; i++)

        {
            for (int j = 1; j <= c; j++) {
                a[i][j] = scanner.nextInt();
            }
        }
        for (
                int i = 1;
                i <= r; i++)

        {
            for (int j = 1; j <= c; j++) {
                ans = max(ans, search(i, j));
            }
        }
        System.out.println(ans);
        scanner.close();
    }

    public static int max(int a, int b) {
        return a > b ? a : b;
    }

    public static int search(int x, int y) {
        if (f[x][y] != 0) {
            return f[x][y];
        }
        for (int i = 0; i < 4; i++) {
            if (x + dx[i] > 0 && x + dx[i] <= r && y + dy[i] <= c && y + dy[
                    i] > 0 && a[x][y] > a[x + dx[i]][y + dy[i]]) {
                f[x][y] = max(f[x][y], search(x + dx[i], y + dy[i]));
            }
        }
        return ++f[x][y];
    }
}

