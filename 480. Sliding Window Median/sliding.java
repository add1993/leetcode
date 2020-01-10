class Solution {
    PriorityQueue<Integer> minH = new PriorityQueue<>();
    PriorityQueue<Integer> maxH = new PriorityQueue<>(1, Collections.<Integer>reverseOrder());
    
    public double[] medianSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length < k) {
            return new double[0];
        }
        int n = nums.length;
        double[] result = new double[n-k+1];
        
        for (int i = 0; i <= n; i++) {
            if (i >= k) {
                result[i - k] = getMedian();
                remove(nums[i - k]);
            }
            
            if (i < n) {
        	    addToHeap(nums[i]);
            }
        }
        
        return result;
    }
    
    public void addToHeap(int num) {
        if ((minH.size() == 0 && maxH.size() == 0)) {
            minH.offer(num);
        } else if (minH.size() > maxH.size()) {
            if  (num > minH.peek()) {
                maxH.offer(minH.poll());
                minH.offer(num);
            } else {
                maxH.offer(num);
            }
        } else if (minH.size() < maxH.size()) {
            if (num < maxH.peek()) {
                minH.offer(maxH.poll());
                maxH.offer(num);
            } else {
                minH.offer(num);
            }
        } else {
            if (num < maxH.peek()) maxH.add(num);
            else minH.add(num);    
        }
    }
    
    private void remove(int num) {
        if (!maxH.isEmpty() && maxH.peek() >= num) {
            maxH.remove(num);
        } else if (!minH.isEmpty() && minH.peek() <= num) {
            minH.remove(num);
        }
    }
    
    public double getMedian() {
        if (minH.size() == 0 && maxH.size() == 0) return 0;
        if (minH.size() > maxH.size()) return minH.peek();
        if (minH.size() < maxH.size()) return maxH.peek();
        
        return (minH.peek()*1.0 + maxH.peek()*1.0)/2.0;
    }
}