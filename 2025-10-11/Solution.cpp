class Solution {
public:
    long long solve(int i, vector<int> &power, map<int,int>& mp, vector<long long>& dp)
    {
        int n = power.size();
        if (i >= n) return 0;

        if (dp[i] != -1) {
            return dp[i];
        }

        auto it = lower_bound(power.begin(), power.end(), power[i] + 3);
        int index = it - power.begin();

        long long pick = 1LL * power[i] * mp[power[i]] + solve(index, power, mp, dp);
        long long skip = solve(i + 1, power, mp, dp);

        return dp[i] = max(skip, pick);
    }

    long long maximumTotalDamage(vector<int>& power) {
        map<int, int> mpp;
        for (int i : power) {
            mpp[i]++;
        }

        vector<int> uniquePower;
        for (auto& i : mpp) {
            uniquePower.push_back(i.first);
        }

        int n = uniquePower.size();
        vector<long long> dp(n, -1);

        return solve(0, uniquePower, mpp, dp);
    }
};
