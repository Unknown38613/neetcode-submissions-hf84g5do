class Solution {
    public boolean isPalindrome(String s) {
        String formatted = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        int l = 0, r = formatted.length() - 1;
        while(l <= r){
            if(formatted.charAt(l) == formatted.charAt(r)){
                l++;
                r--;
            }
            else return false;
        }
        return true;
    }
}
