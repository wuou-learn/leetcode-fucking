import java.util.*;
class Main {

    static int N = 10;
    static int [] array = new int[N];
    static boolean [] flag = new boolean[N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        dfs(0);
    }

    public static void dfs(int u) {
        if (u == N){
            for (int i = 0; i < N; i++) {
                System.out.print(array[i]+" ");
            }
            System.out.println();
        }

        for (int i = 1; i <= N; i++) {
            if (!flag[i]) {
                array[u] = i;
                flag[i] = true;
                dfs(u+1);
                flag[i] = false;
            }
        }
    }
}