class Solution {

    public String encode(List<String> strs) {
        if(strs.isEmpty()) return "";
        StringBuilder sb = new StringBuilder();
        for(String s : strs){
            sb.append(s.length()).append("#").append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        if(str.length() == 0) return new ArrayList<>();
        List<String> list = new ArrayList<>();
        int i = 0;
        while(i < str.length()){
            int j = i;
            while(j < str.length() && str.charAt(j) != '#') j++;
            int len = Integer.parseInt(str.substring(i, j));

            int start = j + 1;
            int end = start + len;
            String s = str.substring(start, end);
            list.add(s);
            i = end;
        }
        return list;
    }
}
