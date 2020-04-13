import java.util.*;

class SlidingWindowMedian {
  
  PriorityQueue<Double> maxHeap;
  PriorityQueue<Double> minHeap;

  public SlidingWindowMedian(){
      maxHeap = new PriorityQueue<>();
      minHeap = new PriorityQueue<Double>();
  }
  
  public void insert(double val){
      if(maxHeap.isEmpty() || maxHeap.peek()>val){
          maxHeap.add(val);
      }
      else{
          minHeap.add(val);
      }

      if(maxHeap.size()-minHeap.size()>1){
          minHeap.add(maxHeap.poll());
      }
      else if(minHeap.size()>maxHeap.size())
          maxHeap.add(minHeap.poll());
  }
  
  public double findMedian(){
    if(maxHeap.size()==minHeap.size()){
      return (maxHeap.peek()+minHeap.peek())/2;
    }
      return maxHeap.peek();
  }

  public void removeAndBalanceHeap(int val){
    if(maxHeap.contains(val)){
            maxHeap.remove(val);
    }
    else
      minHeap.remove(val);

    if(maxHeap.size()<minHeap.size())
      maxHeap.add(minHeap.poll());

  }
  
  public double[] findSlidingWindowMedian(int[] nums, int k) {
    double[] result = new double[nums.length - k + 1];
    // TODO: Write your code here
    int start = 0;
    for(int end=0;end<nums.length;end++){
        insert(nums[end]);
        if(end-start>=k-1){
          result[start] = findMedian();
          removeAndBalanceHeap(nums[start]);
          start++;
        }
    }  



    return result;
  }

  public static void main(String[] args) {
    SlidingWindowMedian slidingWindowMedian = new SlidingWindowMedian();
    double[] result = slidingWindowMedian.findSlidingWindowMedian(new int[] { 1, 2, -1, 3, 5 }, 2);
    System.out.print("Sliding window medians are: ");
    for (double num : result)
      System.out.print(num + " ");
    System.out.println();

    slidingWindowMedian = new SlidingWindowMedian();
    result = slidingWindowMedian.findSlidingWindowMedian(new int[] { 1, 2, -1, 3, 5 }, 3);
    System.out.print("Sliding window medians are: ");
    for (double num : result)
      System.out.print(num + " ");
  }

}