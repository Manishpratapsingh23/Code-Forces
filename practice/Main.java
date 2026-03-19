

import java.util.*;

class Node {
	char data;
	Node left;
	Node right;

	public Node(char data) 
	{
		this.data = data;
	}
}

public class Main {
	static Node root;
	static int idx;

	public static Node build(String s) {
		char chr = s.charAt(idx);
		if (chr == '.') {
			return null;
		}
		Node node = new Node(chr);
		idx += 1;
		node.left = build(s);
		idx += 1;
		node.right = build(s);
//		idx+=1;
		return node;

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			String s1 = sc.next();
			String s = "";
			for (int i = 0; i < s1.length(); i++) {
				char ch = s1.charAt(i);
				if (ch == ')' || ch == '(') {
					continue;
				} else {
					s += ch;
				}
			}
			idx = 0;
			root = build(s);
			List<Character> ll = new ArrayList<>();
			dfs(root, n, 0, ll);
			Collections.sort(ll);
			if (ll.size() == 0) {
				System.out.println("Common Gandhijee!");
			} else {
				for (int i = 0; i < ll.size(); i++) {
					System.out.print(ll.get(i));
				}
				System.out.println();
			}
			
		}
	}

	private static void dfs(Node nn, int n, int i, List<Character> ll) {
		// TODO Auto-generated method stub
		if (nn == null)
			return;
		if (n == i)
			ll.add(nn.data);
		dfs(nn.left, n, i - 1, ll);
		dfs(nn.right, n, i + 1, ll);

	}

}