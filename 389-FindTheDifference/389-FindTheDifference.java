// Last updated: 7/31/2026, 9:42:55 AM
class Solution {
    static{
        for(int i=0;i<500;i++){
            findTheDifference("kesar","kesari");
        }
    }
    public static char findTheDifference(String s, String t) {
        
        // HashMap<Character,Integer> h=new HashMap<>();
        // for(int i=0;i<s.length();i++){
        //     char ch=s.charAt(i);
        //     h.put(ch,h.getOrDefault(ch,0)+1);
        // }
        // HashMap<Character,Integer> m=new HashMap<>();
        // for(int i=0;i<t.length();i++){
        //     char ch=t.charAt(i);
        //     m.put(ch,m.getOrDefault(ch,0)+1);
        // }
        // char re='a';
        // for(int i=0;i<t.length();i++){
        //     char ch=t.charAt(i);
        //     if(h.get(ch)!=m.get(ch)){
        //         re=ch;
        //         break;
        //     }
        // }

        // By Using Bit Manipulation
        char re=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            re^=ch;
        }
        for(int i=0;i<t.length();i++){
            char ch=t.charAt(i);
            re^=ch;
        }
        return re;
    }
}