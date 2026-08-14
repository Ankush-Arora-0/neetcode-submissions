class Solution {
public:
    uint32_t reverseBits(uint32_t n) {
        uint32_t temp = n;
        uint32_t ans = 0u;
        
        int idx = 0;
        while(idx<32){
            uint32_t last = temp&1;
            temp = temp>>1;
            ans = ans|(last<<31-idx);
            idx++;
        }
        return ans;
    }
};
