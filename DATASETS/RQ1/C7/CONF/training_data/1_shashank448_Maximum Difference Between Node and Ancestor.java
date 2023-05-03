
class Solution {
    public int maxAncestorDiff(TreeNode root) {
        int ans[] = ancestor(root);
        return ans[2];
    }
    public int[] ancestor(TreeNode root){
        if(root==null)
        {
            int arr[] = new int[3];
            arr[0] = Integer.MAX_VALUE; 
            arr[1] = Integer.MIN_VALUE; 
            arr[2] = Integer.MIN_VALUE; 
            return arr;
        }
        if(root.left==null && root.right==null){
            int arr[] = new int[3];
            arr[0] = root.val; 
            arr[1] = root.val;
            arr[2] = Integer.MIN_VALUE; 
            return arr;
        }
        int lst[] = ancestor(root.left);
        int rst[] = ancestor(root.right);
        int arr[] = new int[3];
        arr[0]= Math.min(Math.min(lst[0], rst[0]), root.val);
        arr[1] = Math.max(Math.max(lst[1], rst[1]), root.val);
        int temp=0;
        if(lst[0]!=Integer.MAX_VALUE)
            temp = Math.max(temp, Math.abs(root.val-lst[0])); 
        
        if(lst[1]!=Integer.MIN_VALUE)
            temp = Math.max(temp, Math.abs(root.val-lst[1]));
            

        if(rst[0]!=Integer.MAX_VALUE)
            temp = Math.max(temp, Math.abs(root.val-rst[0]));
            
        if(rst[1]!=Integer.MIN_VALUE)
            temp = Math.max(temp, Math.abs(root.val-rst[1]));
        arr[2] = Math.max(temp, Math.max(lst[2], rst[2]));
        return arr;

            
        
    }
}
