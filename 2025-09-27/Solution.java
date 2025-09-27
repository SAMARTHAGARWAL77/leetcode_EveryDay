class Solution {
    public double largestTriangleArea(int[][] points) {
    int ans = 0;
    int n = points.length;
    for(int i=0;i<n;i++)
    {
        for(int j= i+1;j<n;j++)
        {
            for(int k=j+1;k<n;k++)
            {
              Integer x1 = points[i][0]; 
              Integer x2 = points[j][0];
              Integer x3 = points[k][0];
              Integer y1 = points[i][1]; 
              Integer y2 = points[j][1];
              Integer y3 = points[k][1];
              Integer area = x1*(y2-y3) + x2*(y3-y1) + x3*(y1-y2);
              ans = Math.max(ans,Math.abs(area));  
            }
            
        }
    }   
    return ans*1.0/2.0; 
    }
}