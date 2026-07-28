class Solution {
    public boolean isValid(int i,int j, int n,int m){
        if(i<0||i>=n || j<0||j>=m) return false;
        return true;
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        boolean[][] visP = new boolean[n][m];
        boolean[][] visA = new boolean[n][m];
        int[][] visMain = new int[n][m];
        
        for(int i=0;i<m;i++){
            Queue<int[]> q = new LinkedList<>();
            if(!visP[0][i]){
                q.offer(new int[]{0,i});
                visP[0][i] = true;
                visMain[0][i]++;
                while(!q.isEmpty()){
                    int cell[] = q.poll();
                    int r= cell[0];
                    int c = cell[1];

                    if(isValid(r+1,c,n,m)){
                        if(!visP[r+1][c]){
                            if(heights[r][c]<=heights[r+1][c]){
                                visP[r+1][c]=true;
                                visMain[r+1][c]++;
                                q.offer(new int[]{r+1,c});
                            }
                        }
                    }
                     if(isValid(r-1,c,n,m)){
                        if(!visP[r-1][c]){
                            if(heights[r][c]<=heights[r-1][c]){
                                visP[r-1][c]=true;
                                visMain[r-1][c]++;
                                q.offer(new int[]{r-1,c});
                            }
                        }
                    }
                     if(isValid(r,c+1,n,m)){
                        if(!visP[r][c+1]){
                            if(heights[r][c]<=heights[r][c+1]){
                                visP[r][c+1]=true;
                                visMain[r][c+1]++;
                                q.offer(new int[]{r,c+1});
                            }
                        }
                    }
                     if(isValid(r,c-1,n,m)){
                        if(!visP[r][c-1]){
                            if(heights[r][c]<=heights[r][c-1]){
                                visP[r][c-1]=true;
                                visMain[r][c-1]++;
                                q.offer(new int[]{r,c-1});
                            }
                        }
                    }
                }
            }
        }
        for(int i=0;i<n;i++){
            Queue<int[]> q = new LinkedList<>();
            if(!visP[i][0]){
                q.offer(new int[]{i,0});
                visP[i][0] = true;
                visMain[i][0]++;
                while(!q.isEmpty()){
                    int cell[] = q.poll();
                    int r= cell[0];
                    int c = cell[1];

                    if(isValid(r+1,c,n,m)){
                        if(!visP[r+1][c]){
                            if(heights[r][c]<=heights[r+1][c]){
                                visP[r+1][c]=true;
                                visMain[r+1][c]++;
                                q.offer(new int[]{r+1,c});
                            }
                        }
                    }
                     if(isValid(r-1,c,n,m)){
                        if(!visP[r-1][c]){
                            if(heights[r][c]<=heights[r-1][c]){
                                visP[r-1][c]=true;
                                visMain[r-1][c]++;
                                q.offer(new int[]{r-1,c});
                            }
                        }
                    }
                     if(isValid(r,c+1,n,m)){
                        if(!visP[r][c+1]){
                            if(heights[r][c]<=heights[r][c+1]){
                                visP[r][c+1]=true;
                                visMain[r][c+1]++;
                                q.offer(new int[]{r,c+1});
                            }
                        }
                    }
                     if(isValid(r,c-1,n,m)){
                        if(!visP[r][c-1]){
                            if(heights[r][c]<=heights[r][c-1]){
                                visP[r][c-1]=true;
                                visMain[r][c-1]++;
                                q.offer(new int[]{r,c-1});
                            }
                        }
                    }
                }
            }
        }
        for(int i=0;i<m;i++){
            Queue<int[]> q = new LinkedList<>();
            if(!visA[n-1][i]){
                q.offer(new int[]{n-1,i});
                visA[n-1][i] = true;
                visMain[n-1][i]++;
                while(!q.isEmpty()){
                    int cell[] = q.poll();
                    int r= cell[0];
                    int c = cell[1];

                    if(isValid(r+1,c,n,m)){
                        if(!visA[r+1][c]){
                            if(heights[r][c]<=heights[r+1][c]){
                                visA[r+1][c]=true;
                                visMain[r+1][c]++;
                                q.offer(new int[]{r+1,c});
                            }
                        }
                    }
                     if(isValid(r-1,c,n,m)){
                        if(!visA[r-1][c]){
                            if(heights[r][c]<=heights[r-1][c]){
                                visA[r-1][c]=true;
                                visMain[r-1][c]++;
                                q.offer(new int[]{r-1,c});
                            }
                        }
                    }
                     if(isValid(r,c+1,n,m)){
                        if(!visA[r][c+1]){
                            if(heights[r][c]<=heights[r][c+1]){
                                visA[r][c+1]=true;
                                visMain[r][c+1]++;
                                q.offer(new int[]{r,c+1});
                            }
                        }
                    }
                     if(isValid(r,c-1,n,m)){
                        if(!visA[r][c-1]){
                            if(heights[r][c]<=heights[r][c-1]){
                                visA[r][c-1]=true;
                                visMain[r][c-1]++;
                                q.offer(new int[]{r,c-1});
                            }
                        }
                    }
                }
            }
        }
        for(int i=0;i<n;i++){
            Queue<int[]> q = new LinkedList<>();
            if(!visA[i][m-1]){
                q.offer(new int[]{i,m-1});
                visA[i][m-1] = true;
                visMain[i][m-1]++;
                while(!q.isEmpty()){
                    int cell[] = q.poll();
                    int r= cell[0];
                    int c = cell[1];

                    if(isValid(r+1,c,n,m)){
                        if(!visA[r+1][c]){
                            if(heights[r][c]<=heights[r+1][c]){
                                visA[r+1][c]=true;
                                visMain[r+1][c]++;
                                q.offer(new int[]{r+1,c});
                            }
                        }
                    }
                     if(isValid(r-1,c,n,m)){
                        if(!visA[r-1][c]){
                            if(heights[r][c]<=heights[r-1][c]){
                                visA[r-1][c]=true;
                                visMain[r-1][c]++;
                                q.offer(new int[]{r-1,c});
                            }
                        }
                    }
                     if(isValid(r,c+1,n,m)){
                        if(!visA[r][c+1]){
                            if(heights[r][c]<=heights[r][c+1]){
                                visA[r][c+1]=true;
                                visMain[r][c+1]++;
                                q.offer(new int[]{r,c+1});
                            }
                        }
                    }
                     if(isValid(r,c-1,n,m)){
                        if(!visA[r][c-1]){
                            if(heights[r][c]<=heights[r][c-1]){
                                visA[r][c-1]=true;
                                visMain[r][c-1]++;
                                q.offer(new int[]{r,c-1});
                            }
                        }
                    }
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(visMain[i][j]==2){
                    ans.add(new ArrayList<>(List.of(i,j)));
                }
            }
        }
        return ans;
    }
}
