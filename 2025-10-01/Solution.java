class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
    int count = numBottles;
    while(numBottles >= numExchange)
    {
        int newNumBottles = numBottles/numExchange; 
        count += newNumBottles;
        numBottles = numBottles%numExchange + newNumBottles;
    }   
    return count; 
    }
}