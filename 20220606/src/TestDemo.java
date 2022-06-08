import java.util.Scanner;

public class TestDemo {
    private static final int N = 20;

    private static int countBoard(char[][] board, int x, int y, char ch) {
        int[][][] direct = {
                {{0, -1}, {0, 1}}, // 横向:   左  右
                {{-1, 0}, {1, 0}}, // 竖向:   上  下
                {{-1, -1}, {1, 1}}, // 左上到右下:  左上  右下
                {{-1, 1}, {1, -1}}, // 右上到左下:  右上  左下
        };
        int ans = 0;
        for (int i = 0; i < 4; i++) { //统计单个方向相同棋子的个数
            int count = 0;
            for (int j = 0; j < 2; j++) { // 将一个大方向分成两个小方向来进行遍历
                int nx = x;
                int ny = y;
                // 朝一个方向去统计相同颜色棋子的个数
                while (nx >= 0 && nx < N && ny >= 0 && ny < N && board[nx][ny] == ch) {
                    count++;
                    nx += direct[i][j][0];
                    ny += direct[i][j][1];
                }
            }
            ans = count > ans ? count : ans;
        }
        return ans - 1; // 统计上下 分成两个方向 多了一个
    }

    private static boolean isWin(char[][] board) {
        // 对棋谱中的每个位置进行检测，如果该位置是棋子，就统计该棋子周围是否存在五子连珠
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if ('+' == board[i][j] || '*' == board[i][j]) { // 如果该位置是黑棋 或白棋
                    if (countBoard(board, i, j, board[i][j]) >= 5) { //·向(i,j)位置的4个大方向去检测，统计相同颜色棋子的最大个数
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            char[][] board = new char[20][20];
            for (int i = 0; i < N; i++) {
                String s = scanner.next();
                for (int j = 0; j < N; j++) {
                    board[i][j] = s.charAt(j);
                }
            }
            System.out.println(isWin(board) ? "Yes" : "No");
        }
    }
}
