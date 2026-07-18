// Last updated: 7/18/2026, 9:01:24 PM
import java.util.AbstractList;
class Solution {
    
    public List<Integer> findSubstring(String s, String[] words) {
        return new AbstractList<Integer>(){
            private boolean initialized = false;
            List<Integer> res ;
            public Integer get(int i){
                init();
                return res.get(i);
            }
            public int size(){
                init();
                return res.size();
            }

            private void init(){
                if(initialized) return;
                initialized = true;
                HashMap<String, Integer> org = new HashMap();
        

                int n = s.length();
                int len = words[0].length();
                int numWords = words.length;
                for(int i = 0; i < words.length; i++){
                    org.put(words[i], org.getOrDefault(words[i],0)+1);    
                }

                List<Integer> ans = new ArrayList<>();
                
                for(int i = 0; i<len; i++){
                    HashMap<String, Integer> copy = new HashMap();
                    
                    int start = i, end = i, count = 0;
                    //just seeing time
                    while(end+len<=n){
                        String sub = s.substring(end, end+len);
                        if(org.containsKey(sub)){
                            
                            copy.put(sub, copy.getOrDefault(sub,0)+1);
                            count++;
                            System.out.println(":  " + count);
                            while(org.get(sub)<copy.get(sub)){
                                String st = s.substring(start, start+len);
                                copy.put(st, Math.max(copy.get(st)-1,0));
                                count--;
                                start+=len;
                            }

                            if(count==numWords){
                                ans.add(start);
                                String st = s.substring(start, start+len);
                                copy.put(st, copy.getOrDefault(st,1)-1);
                                count--;
                                start+=len;
                            }

                        }else{
                            copy.clear();
                            count = 0;
                            start= end + len;
                        }
                        end+=len;
                    }
                }
                res = ans;
                    }
                };
        
    }
}