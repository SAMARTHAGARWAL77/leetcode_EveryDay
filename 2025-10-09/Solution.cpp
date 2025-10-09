#define ll long long

class Solution {
public:
    long long minTime(vector<int>& skill, vector<int>& mana) {
        int s = skill.size(), m = mana.size();
        vector<ll> pre(s + 1, 0);
        ll st = 0, end = 0;

        for (int i = 0; i < m; i++) {
            end = st;
            for (int j = 0; j < s; j++) {
                // Guard against out-of-bounds
                if (i + 1 < m) {
                    pre[j + 1] = pre[j] + (ll)skill[j] * (ll)mana[i + 1];
                }
                end += (ll)skill[j] * (ll)mana[i];
                st = max(st, end - pre[j]);
            }
        }

        return end;
    }
};
