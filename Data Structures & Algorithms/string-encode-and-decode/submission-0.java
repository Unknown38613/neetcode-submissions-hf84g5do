class Solution {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        // Using StringBuilder for efficiency
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            // Prefix each string with its length and a separator
            sb.append(s.length()).append('#').append(s);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            // 1) Parse the length up to the separator '#'
            int j = i;
            while (j < str.length() && str.charAt(j) != '#') {
                j++;
            }
            // Safety: malformed input (no '#')
            if (j == str.length()) {
                throw new IllegalArgumentException("Invalid encoded string: missing '#'");
            }

            int len = Integer.parseInt(str.substring(i, j)); // digits [i..j)
            // 2) Read the next 'len' characters as the string
            int start = j + 1;
            int end = start + len;
            if (end > str.length()) {
                throw new IllegalArgumentException("Invalid encoded string: length overruns input");
            }
            String s = str.substring(start, end);
            result.add(s);

            // 3) Advance pointer
            i = end;
        }
        return result;
    }
}