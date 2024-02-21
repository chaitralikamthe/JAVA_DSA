class Solution {
    //intervals[0]
    //return List<int[]>
    //intervals[i][1]<intervals[i-1][1]-> new int[]{intervals[i][0],intervals[i+1][1]}
    //intervals[i][1]<intervals[i-1][0]-> skip
    //to make above comparison first sort the
    //above cases can happen consecutively so maintain variable storing max value of intervals[i][1] to compare to each entry 
    public int[][] merge(int[][] intervals) {
        List<int[]> res= new ArrayList<>();
        Arrays.sort(intervals,(i1,i2)->Integer.compare(i1[0],i2[0]));
        int max=intervals[0][1];
        for(int i=0;i<intervals.length;i++){
            if(i>0 && intervals[i][0]<=max){
                if(intervals[i][1]<max){
                    continue;
                }
                max= intervals[i][1];
                int arr[]=new int[]{res.get(res.size()-1)[0],max};
                res.set(res.size()-1,arr);
            }
            else{
                max=intervals[i][1];
                res.add(new int[]{intervals[i][0],intervals[i][1]});
            }
        }   
        return res.toArray(new int[res.size()][]);  
    }
}