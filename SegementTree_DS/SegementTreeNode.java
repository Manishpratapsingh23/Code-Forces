package SegementTree_DS;

public class SegementTreeNode {
    int start;
    int end;
    int sum;

    SegementTreeNode left, right;
    public SegementTreeNode(int start, int end){
        this.start = start;
        this.end = end;
        this.sum = 0;
        this.left = null;
        this.right = null;
    }
}
