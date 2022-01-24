import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-01-17
 * Time: 10:29
 */
public class BinaryTree {
    public static void main(String[] args) {
        
    }
    // 求节点个数
    int num(TreeNode root) {
        if(root == null) return 0;
        else return num(root.left) + num(root.right) + 1;
    }
    //    void getLeafNodeCount(TreeNode root) {
//        if(root == null) return 0;
//        if(root.right == null && root.left == null) {
//            count++;
//        }
//        getLeafNodeCount(root.right);
//        getLeafNodeCount(root.left);
//    }
//    int getLeafNodeCount(TreeNode root) {
//        if(root == null) return 0;
//        if(root.right == null && root.left == null) return 1;
//        return getLeafNodeCount(root.right) + getLeafNodeCount(root.left);
//    }
    // 求k层节点个数
    int size(TreeNode root, int k) {
        if(root == null || k <= 0) return 0;
        if(k == 1) return 1;
        return size(root.left, k - 1) + size(root.right, k - 1);
    }
//    int getHeight(TreeNode root) {
//        if(root == null) return 0;
//        return Math.max(getHeight(root.right) + 1, getHeight(root.left) + 1);
//    }
    // 查找节点
    TreeNode find(TreeNode root, char val) {
        if(root == null) return null;
        if(root.val == val) return root;

        TreeNode tmp = find(root.right, val);
        if(tmp != null) {
            return tmp;
        } else {
            find(root.left, val);
        }
        return null;
    }
//
//    boolean isCompleteTree(TreeNode root) {
//        if(root == null) return true;
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.offer(root);
//
//        if(queue.peek() == null) {
//
//        }
//        while(queue.peek() != null) {
//
//        }
//        boolean tmp = isCompleteTree(root.left);
//        if(tmp) {
//
//        }
//    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p != null && q == null || p == null && q != null) return false;
        if(p == null && q == null) return true;
        if(p.val != q.val) return false;
        return isSameTree(p.right, q.right) && isSameTree(p.left, q.left);
    }
    public boolean isSubTree(TreeNode p, TreeNode q) {
        if(p == null || q == null) return false;
        if(isSameTree(p,q)) {
            return true;
        }
        if(isSubtree(p.right, q)) {
            return true;
        }
        if(isSubtree(p.left, q)) {
            return true;
        }
        return false;
    }

    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return isSame(root.right, root.left);
    }
    public boolean isSame(TreeNode p, TreeNode q) {
        if(p == null || q == null) return true;
        if(p.val != q.val) return true;

        return isSame(p.left, q.right) && isSame(p.right, q.left);
    }

    public void levelIOrder(TreeNode root) {
        Queue queue = new LinkedList();
        if(root == null) return;
        else queue.offer(root);

        while(!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            System.out.println(cur.val + " ");
            if(cur.left != null) {
                levelIOrder(cur.left);
            }
            if(cur.right != null) {
                levelIOrder(cur.right);
            }
        }
    }

    boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode prev = root;
        queue.offer(root);

        while(!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if(prev == null && cur != null) {
                return false;
            }
            if(cur != null) {
                queue.offer(cur.left);
                queue.offer(cur.right);
            }
            prev = cur;
        }
        return true;
    }

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 == null) {
            return root2;
        }
        if(root2 == null) {
            return root1;
        }
        TreeNode ret = new TreeNode(root1.val + root2.val);
        ret.left = mergeTrees(root1.left, root2.left);
        ret.right = mergeTrees(root1.right, root2.right);
        return ret;
    }

    public class TestHeap {
        public int[] elem;
        public int usedSize;

        public TestHeap() {
            this.elem = new int[10];
        }

        /**
         * 向下调整函数的实现
         * @param parent 每棵树的根节点
         * @param len 每棵树的调整的结束位置  10
         */
        public void shiftDown(int parent,int len) {
            int child = 2*parent+1;
//1、最起码 是有左孩子的，至少有1个孩子
            while (child < len) {
                if(child+1 < len && elem[child] < elem[child+1]) {
                    child++;//保证当前左右孩子最大值的下标
                }


            }
        }

        public void createHeap(int[] array) {
            for (int i = 0; i < array.length; i++) {
                elem[i] = array[i];
                usedSize++;
            }
            for (int parent = (usedSize-1-1)/2; parent >= 0 ; parent--) {
//调整
                shiftDown(parent,usedSize);
            }
        }

    }
}
