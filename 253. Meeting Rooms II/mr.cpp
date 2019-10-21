class Solution {
public:
    int minMeetingRooms(vector<vector<int>>& vec) {
        if (vec.size() < 1) return 0;
        sort(vec.begin(), vec.end(),
                  [](const std::vector<int>& a, const std::vector<int>& b) {
          return a[0] < b[0];
        });
        
        vector<vector<int>> rooms;
        for (int i = 0; i < vec.size(); i++) {
            bool found = false;
            int idx = 0;
            for (auto room : rooms) {
                if (vec[i][1] <= room[0] || vec[i][0] >= room[1]) {
                    room[0] = min(room[0], vec[i][0]);
                    room[1] = max(room[1], vec[i][1]);
                    rooms[idx] = room;
                    found = true;
                    break;
                }
                idx++;
            }
            
            if (!found) {
                rooms.push_back({vec[i][0], vec[i][1]});
            }
            
        }
        //res += flag;
        return rooms.size();
    }
};