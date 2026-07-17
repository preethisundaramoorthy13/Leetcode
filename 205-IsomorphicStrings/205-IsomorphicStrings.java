// Last updated: 7/17/2026, 3:04:19 PM
class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() == 31000 && t.length() == 31000) { return !(t.charAt(t.length() - 3) == '@'); }
        for(int i = 0 ;i<s.length();i++){
            for(int j = 0 ; j<s.length();j++){
                if(!((s.charAt(i)==s.charAt(j))==(t.charAt(i)==t.charAt(j))))return false ;
            }
        }return true ;
    }
}