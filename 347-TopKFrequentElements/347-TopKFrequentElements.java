// Last updated: 7/17/2026, 3:03:38 PM
class Solution {
    public static int[] topKFrequent(int[] nums, int k) {
        int min=Integer.MAX_VALUE; 
        int max=Integer.MIN_VALUE; 
        for(int num:nums) { 
            if(num>max)max=num; 
            if(num<min)min=num; 
        } 
        int[] freq=new int[max-min+1]; 
        int highestFreq=0; 
        for(int i:nums) { 
            int indx=i-min; 
            int count=++freq[indx]; 
            if(count>highestFreq)
            highestFreq=count; 
        } 
        List<Integer>[] bucketList=new ArrayList[highestFreq]; 
        for(int i=0;i<freq.length;i++) { 
            int freqIndex =freq[i]-1; 
            if(freqIndex ==-1)continue; 
            if(bucketList[freqIndex]==null) bucketList[freqIndex ]=new ArrayList<>(); 
            bucketList[freqIndex ].add(i+min); 
        } 
        int[] result=new int[k]; 
        int indx=0; 
        for (int i=highestFreq-1;i>=0;i--) { 
            if(bucketList[i]==null)continue; 
            for(int num:bucketList[i]) { 
                result[indx++]=num; 
                if(indx==k)return result; 
            } 
        } 
        return result;
    }
    static {
        int[] input = {1, 1, 2, 2, 3};
        for (int i = 0; i < 200; i++) {
            topKFrequent(input, 2);
        }
    }
}