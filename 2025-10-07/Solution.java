class Solution {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int []ans = new int[n];
        HashMap<Integer,Integer> lakeMap = new HashMap<>();
        TreeSet<Integer> drylake = new TreeSet<>();
        for(int i = 0; i < n; i++)
        {
            if(rains[i] == 0)
            {
                drylake.add(i);
                ans[i] = 1;
            }
            else
            {
                int lake = rains[i];
                ans[i] = -1;
                if(lakeMap.containsKey(lake))
                {
                    int lastRainDay = lakeMap.get(lake);
                    Integer dryday = drylake.higher(lastRainDay);
                    if(dryday == null)
                    return new int[0];
                    ans[dryday] = lake;
                    drylake.remove(dryday);
                }
                lakeMap.put(lake,i);
            }

        }
        return ans;
    }
}