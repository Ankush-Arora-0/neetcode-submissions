class MedianFinder {
    PriorityQueue<Integer> lpq;
    PriorityQueue<Integer> rpq;
    public MedianFinder() {
        lpq = new PriorityQueue<>(Collections.reverseOrder());
        rpq = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(rpq.isEmpty()){
            rpq.offer(num);
        }
        // else if(lpq.isEmpty()){
        //     lpq.offer(num);
        // }
        else{
            if(num>rpq.peek()){
                rpq.offer(num);
            }
            else{
                lpq.offer(num);
            }
            int sizeDiff = lpq.size()-rpq.size();
            // System.out.println(sizeDiff);
            if(sizeDiff<-1){
                lpq.offer(rpq.poll());
            }
            else if(sizeDiff>1){
                rpq.offer(lpq.poll());
            }
        }
    }
    
    public double findMedian() {
        // System.out.println(lpq);
        // System.out.println(rpq);
        int size = lpq.size()+rpq.size();
        if(size%2==0){
            int f = lpq.peek();
            int s = rpq.peek();
            double median = (f+s)/2.0;
            
            return median;
        }
        else{
            if(lpq.size()>rpq.size()){
                int f = lpq.peek();
                return (double) f;

            }
            else{
                int f = rpq.peek();
                return (double) f;
            }
        }
    }
}
