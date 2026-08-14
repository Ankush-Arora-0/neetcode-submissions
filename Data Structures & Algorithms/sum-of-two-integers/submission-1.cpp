class Solution {
public:
    int getSum(int a, int b) {
        uint32_t n1 = 0u;
        uint32_t n2 = 0u;
        uint32_t ans = 0u;
        uint32_t carry = 0u;
        int idx = 0;
        bool goAhead = true;
        while(idx<32 && goAhead){
            n1 = 1u<<idx;
            n1 = a&n1;
            n1 = n1>>idx;
            n2 = 1u<<idx;
            n2 = b&n2;
            n2 = n2>>idx;
            if(n1==1 && n2==1){
                if(carry==1){
                    uint32_t temp = 1u<<idx;
                    ans = ans|temp;
                }
                else{
                    carry=1;
                }
            }else if(n1!=0 || n2!=0){
                if(carry==1){
                    
                }
                else{
                    uint32_t temp = 1u<<idx;
                    ans = ans|temp;
                }
            }
            else{
                if(carry==1){
                    uint32_t temp = 1u<<idx;
                    ans = ans|temp;
                    carry=0;
                }
                // goAhead = false;
            }
            idx++;
        }
        return ans;
    }
};
