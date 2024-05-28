import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_2606 {

    static boolean[] visited;
    static List<List<Integer>> graph;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        visited = new boolean[n + 1];
        graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        dfs(1); //1번컴퓨터 바이러스

        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (visited[i]) {
               count++;
            }
        }
        System.out.println(count);
    }

    private static void dfs(int start) {

        visited[start] = true; // start 컴퓨터 감염
        for(int next: graph.get(start)) { //  start 컴퓨터와 연결된 컴퓨터 감염여부 확인
            if (!visited[next]) { //false일 경우 
                dfs(next);
            }
        }
    }
}