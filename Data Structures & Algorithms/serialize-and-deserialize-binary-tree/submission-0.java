public class Codec {
    private static final String SEP = " ";
    private static final String NULL = "#";
    private int idx = 0;

    private void preorder(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append(NULL).append(SEP);
            return;
        }
        sb.append(node.val).append(SEP);
        preorder(node.left, sb);
        preorder(node.right, sb);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preorder(root, sb);
        // Avoid trailing spaces affecting consumers
        return sb.toString().trim();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty()) return null;
        String[] nodes = data.trim().split("\\s+"); // robust to multiple spaces/newlines
        idx = 0; // reset before each deserialize call
        return build(nodes);
    }

    private TreeNode build(String[] nodes) {
        if (idx >= nodes.length) return null; // safety guard
        String token = nodes[idx++];
        if (NULL.equals(token)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(token));
        root.left = build(nodes);
        root.right = build(nodes);
        return root;
    }
}