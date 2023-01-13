package xyz.ukrainskiys.util.tree;

import java.util.HashMap;

public class TreeNodeUtils {

	public static TreeNode treeOf(Integer ...ints) {
		if (ints.length == 0) return new TreeNode();

		HashMap<Integer, TreeNode> map = new HashMap<>();
		for (int i = 0; i < ints.length; i++) {
			map.put(i, ints[i] == null ? null : new TreeNode(ints[i]));
		}

		insert(0, map);

		return map.get(0);
	}

	private static void insert(int index, HashMap<Integer, TreeNode> map) {
		if (map.size() <= index) return;

		if (map.get(index) != null) {
			map.get(index).left = map.get(index * 2 + 1);
			map.get(index).right = map.get(index * 2 + 2);
		}

		insert(index + 1, map);
	}
}
