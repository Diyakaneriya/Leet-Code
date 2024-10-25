#include <vector>
#include <string>
#include <algorithm>

class Solution {
public:
    std::vector<std::string> removeSubfolders(std::vector<std::string>& folder) {
        // Sort folders lexicographically
        std::sort(folder.begin(), folder.end());
        
        std::vector<std::string> result;
        for (const std::string& f : folder) {
            // If result is empty or current folder is not a subfolder of the last folder in result
            if (result.empty() || f.find(result.back() + "/") != 0) {
                result.push_back(f); // Add the folder to result
            }
        }
        
        return result;
    }
};
