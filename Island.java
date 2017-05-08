package NiukeAcm;

import java.util.Scanner;

/**
 * Created by TonyWu on 2017/5/8.
 * 4 5
 * 11000
 * 11000
 * 00100
 * 00011
 * 问题：岛屿问题
 * 问题描述：0代表海洋，1代表陆地，相邻的陆地相连形成岛屿（斜的不算），问在给予的矩阵中有多少个岛屿？
 * 输入：
 * 5 5
 10011
 01000
 10011
 10011
 11001
 * 输出：
 * 5
 * 解决思路：dfs（深度优先算法），递归思路，以种子点（即值为1的点）代入，递归把周边值为1的点去除，去除完成后，即把整个岛屿去掉，count加1.
 */
public class Island {
    static int[][] para;
    static int N;
    static int M;

    public static void main(String[] args) {
        new Island().run();
    }

    public void run() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        sc.nextLine();
        String temp;
        para = new int[N][M];
        for (int i = 0; i < N; i++) {
            temp = sc.nextLine();
            for (int j = 0; j < M; j++) {
                para[i][j] = Integer.parseInt(String.valueOf(temp.charAt(j)));
            }
        }

        int tmp;
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                tmp = para[i][j];
                if (tmp == 1) {
                    dfs(para, i, j);
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    public static void dfs(int[][] map, int x, int y) {
        if (map[x][y] == 0) {
            return;
        }
        if (map[x][y] == 1) {
            map[x][y] = 0;
        }
        if (x + 1 < map.length) {
            dfs(map, x + 1, y);
        }
        if (y + 1 < map[x].length) {
            dfs(map, x, y + 1);
        }
        if (x - 1 >= 0) {
            dfs(map, x - 1, y);
        }
        if (y - 1 >= 0) {
            dfs(map, x, y - 1);
        }
    }
}
