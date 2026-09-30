# Adding a new file in the TestBranch

# This is one of  contest problem solution
import java.util.*;

public class Hackathon_Leaderboard {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        ArrayList<ArrayList<Integer>> adj =
                new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        int[] indegree = new int[n + 1];

        // Take input
        for (int i = 0; i < m; i++) {

            int a = sc.nextInt();
            int b = sc.nextInt();

            // a finished above b
            adj.get(a).add(b);

            indegree[b]++;
        }

        // Teams which currently have no team before them
        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= n; i++) {

            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        ArrayList<Integer> ranking = new ArrayList<>();

        boolean multiple = false;

        while (!q.isEmpty()) {

            // More than one possible team
            if (q.size() > 1) {
                multiple = true;
            }

            int team = q.poll();

            ranking.add(team);

            // Remove this team from the graph
            for (int next : adj.get(team)) {

                indegree[next]--;

                if (indegree[next] == 0) {
                    q.add(next);
                }
            }
        }

        // Not all teams were processed
        if (ranking.size() != n) {

            System.out.println("CONTRADICTION");
        }

        // DAG but more than one possible ranking
        else if (multiple) {

            System.out.println("MULTIPLE");
        }

        // Exactly one possible ranking
        else {

            System.out.println("UNIQUE");

            for (int team : ranking) {
                System.out.print(team + " ");
            }

            System.out.println();
        }

        sc.close();
    }
}
