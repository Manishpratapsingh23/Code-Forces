package SegementTree_DS;

public class SegementTree {
    private SegementTreeNode root;

    public SegementTree(int nums[]){
        root = buildTree(nums,0,nums.length-1);
    }

    private SegementTreeNode buildTree(int nums[], int start, int end){
        if(start>end) return null;
        SegementTreeNode node = new SegementTreeNode(start, end);
        if(start==end){
            node.sum=nums[start];
        }
        else {
            int mid = start+(end-start)/2;

            node.left = buildTree(nums, start, mid);
            node.right = buildTree(nums, mid+1, end);
            node.sum = node.left.sum+node.right.sum;
        }
        return node;
    }

    public int rangeSum(int start, int end){
        return rangeSum(root,start,end);
    }

    private int rangeSum(SegementTreeNode root, int start, int end){
        if(root==null || start>root.end || end<root.start) return 0; 

        if(start<=root.start && end>=root.end) return root.sum;

        return rangeSum(root.left, start, end) + rangeSum(root.right, start, end);
    }

    private void update(int index, int val){
        update(root,index, val);
    }

    private void update(SegementTreeNode root, int index, int val){
        if(root.start==root.end){
            root.sum=val;
        }
        else{
            int mid = root.start+(root.end-root.start)/2;
            if(index<=mid) update(root.left, index, val);
            else update(root.right, index, val);
        }
        root.sum = root.left.sum+root.right.sum;
    }


}

