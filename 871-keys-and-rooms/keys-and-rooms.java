class Solution {

    public static void bfs(int s, List<List<Integer>> rooms,boolean [] visit){
        Queue <Integer> q= new LinkedList<>();
        q.add(s);
        while(q.size()>0){
            int front= q.remove();
            for(int ele: rooms.get(front)){
                if(!visit[ele]){
                    visit[ele]= true;
                    q.add(ele);
                }

            }
        }

    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n= rooms.size();
        boolean [] visit= new boolean[n];
        visit[0]=true;
        bfs(0,rooms, visit);
        for(boolean ele:visit){
            if(ele==false) return false;
        }
        return true;

        
    }
}