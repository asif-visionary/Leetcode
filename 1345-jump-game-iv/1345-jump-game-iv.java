class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;
        if (n <= 1) return 0;
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.computeIfAbsent(arr[i], v -> new ArrayList<>()).add(i);
        }
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];
        q.offer(0);
        visited[0] = true;
        int steps = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int curr = q.poll();
                if (curr == n - 1) return steps;
                if (curr - 1 >= 0 && !visited[curr - 1]) {
                    visited[curr - 1] = true;
                    q.offer(curr - 1);
                }
                if (curr + 1 < n && !visited[curr + 1]) {
                    visited[curr + 1] = true;
                    q.offer(curr + 1);
                }
                if (graph.containsKey(arr[curr])) {
                    for (int nextIdx : graph.get(arr[curr])) {
                        if (!visited[nextIdx]) {
                            visited[nextIdx] = true;
                            q.offer(nextIdx);
                        }
                    }
                    graph.remove(arr[curr]); 
                }
            }
            steps++;
        }
        return -1;
    }
}