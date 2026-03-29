class Solution {
    public boolean isPalindrome(String s) {
        String formatted = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        StringBuilder sb = new StringBuilder(formatted);
        return sb.toString().equals(sb.reverse().toString());
    }
}
