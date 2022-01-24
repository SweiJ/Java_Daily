import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-01-21
 * Time: 11:44
 */
public class BinaryTreeTest {
    public static void main(String[] args) {

    }
    // 前序遍历
    public static void preorder(TreeNode root) {
        if(root == null) return;
        System.out.println(root.val + " ");
        preorder(root.left);
        preorder(root.right);
    }
    // 中序遍历
    public static void midorder(TreeNode root) {
        if(root == null) return;
        preorder(root.left);
        System.out.println(root.val + " ");
        preorder(root.right);
    }
    // 后序遍历
    public static void lastorder(TreeNode root) {
        if(root == null) return;
        preorder(root.left);
        preorder(root.right);
        System.out.println(root.val + " ");
    }
    // 节点个数
    int count = 0;
    public void nodeNum(TreeNode root) {
        if(root == null) return;
        count++;
        nodeNum(root.left);
        nodeNum(root.right);
    }
    int size(TreeNode root) {
        if(root == null) return 0;
        int left = size(root.left);
        int right = size(root.right);
        return left + right + 1;
    }

    int getLeafNodeCount(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.left == null) return 1;

        return getLeafNodeCount(root.left) + getLeafNodeCount(root.right);
    }

    int getKLevelNodeCount(TreeNode root, int k) {
        if(root == null) return 0;
        if(k == 1) return 1;
            return getKLevelNodeCount(root.right, k - 1) + getKLevelNodeCount(root.left, k - 1);
    }

    // 查找结点
    TreeNode find (TreeNode root, int val) {
        if(root == null) return null;
        if(root.val == val) return root;

        TreeNode ret = find(root.left, val);
        if(ret != null) {
            return ret;
        } else
            find(root.right, val);
        return null;
    }
    // 是否是完全二叉树
    boolean isCompleteTree(TreeNode root) {
        if(root == null) return true;
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        boolean flag = false;

        while(!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if(cur != null) {
                flag = false;
                queue.offer(root.left);
                queue.offer(root.right);
            } esle {
                flag = true;
            }
        }
        if(!flag)
            return false;
        else
            return true;
    }

    int getHeight(TreeNode root) {
        if(root == null) return 0;

        int left = getHeight(root.left);
        int right = getHeight(root.right);
        if(Math.abs(left - right) > 1) return -1;
        return left > right ? left + 1 : right + 1;
    }
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;

        return getHeight(root) >= 0;
    }
    // 优化之后的判断是否为平衡二叉树
    int getHeight(TreeNode root) {
        if(root == null) return 0;

        int left = getHeight(root.left);
        int right = getHeight(root.right);

        if(left >= 0 && right >= 0 && Math.abs(left - right) <= 1)
            return Math.max(left + 1, right + 1);
        else
            return -1;
    }
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        return getHeight(root) >= 0;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if(root == null) return ret;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            while(size != 0) {
                TreeNode cur = queue.poll();
                list.add(cur.val);
                if(cur.left != null) {
                    queue.offer(cur.left);
                }
                if(cur.right != null) {
                    queue.offer(cur.right);
                }
                size--;
            }
            ret.add(list);
        }
        return ret;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        if(root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left != null && right != null)
            return root;
        else if(left != null)
            return left;
        else
            return right;
    }

    public int preIndex = 0;
    public TreeNode createTreeByPandI(int[] preorder, int[] inorder,int inbegin, int inend) {
        if(inbegin > inend) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preIndex]);
        int rootIndex = findIndexOfI(inorder, inbegin,inend,preorder[preIndex]);
        if(rootIndex == -1) {
            return null;
        }
        preIndex++;
        root.left = createTreeByPandI(preorder, inorder, inbegin, rootIndex - 1);
        root.right = createTreeByPandI(preorder, inorder, rootIndex + 1, inend);
        return root;
    }
    private int findIndexOfI(int[] inorder, int inbegin, int inend, int key) {
        for (int i = inbegin; i <= inend; i++) {
            if(inorder[i] == key) {
                return i;
            }
        }
        return -1;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null) return null;
        return createTreeByPandI(preorder,inorder,0,inorder.length - 1);
    }


    public void treetostr(TreeNode root, StringBuffer sb) {
        if(root == null) return;
        sb.append(root.val);
        if(root.left != null) {
            sb.append("(");
            treetostr(root.left,sb);
            sb.append(")");

        } else {
            if(root.right == null) {
                return;
            } else {
                sb.append("()");
            }
        }
        if(root.right == null) {
            return;
        } else {
            sb.append("(");
            treetostr(root.right, sb);
            sb.append(")");
        }
    }
    public String tree2str(TreeNode root) {
        if(root == null) return null;
        StringBuffer sb = new StringBuffer();
        treetostr(root, sb);
        return sb.toString();
    }
}
