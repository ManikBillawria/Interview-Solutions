class Solution {

    public List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];
        for(int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int[] row : prerequisites) {
            int u = row[1];
            int v = row[0];
            graph[u].add(v);
        }
        return graph;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);

        int[] inDegree = new int[numCourses];
        for(int i = 0; i < numCourses; i++) {
            for(int child : graph[i]) {
                inDegree[child]++;
            }
        }

        Queue<Integer> zeroDegree = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            if(inDegree[i] == 0) {
                zeroDegree.add(i);
            }
        }

        List<Integer> topoSort = new ArrayList<>();

        while(!zeroDegree.isEmpty()) {
            int x = zeroDegree.poll();
            topoSort.add(x);

            for(int child : graph[x]) {
                inDegree[child]--;
                if(inDegree[child] == 0) {
                    zeroDegree.add(child);
                }
            }
        }

        if(topoSort.size() == numCourses) {
            return true;
        }
        return false;
    }
}