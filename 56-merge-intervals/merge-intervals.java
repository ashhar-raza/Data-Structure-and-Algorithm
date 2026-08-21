class Solution {
    public int[][] merge(int[][] intervals) {
        
        Arrays.sort(intervals , ((a,b)->Integer.compare(a[0] , b[0])));

        List<int[]> result = new ArrayList<>();

        result.add(intervals[0]);

        for(int[] i : intervals)
        {
            int currStart = i[0];
            int currEnd = i[1];

            int[] last = result.get(result.size() - 1);
            int start = last[0]; 
            int end = last[1]; 

            if(end >= currStart )
            {
                last[1] = Math.max(end , currEnd);
            }
            else
            {
                result.add(i);
            }
        }

        return result.toArray(new int[result.size()][]);

    }
}