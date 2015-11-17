package com.lx.dataStructures.charpter8DisjointSets;



public class DisjointSets {

	private int [] s;
	
	public DisjointSets(int num) {
		s = new int[num];
		for (int i = 0; i < s.length; i++) {
			s[i] = -1;
		}
	}
	
	public int find(int x){
		return s[x]<0?x:s[x];
	}
	
	/**
	 * 路径压缩查找：
	 * 			从x到根上的每一个节点（包含x）都使其父节点成为该树的根
	 * @param x
	 * @return
	 */
	public int find1(int x){
		if(s[x]<0)
			return x;
		else{
			s[x] = find1(s[x]);
			return s[x];
		}
	}
	
	/**
	 * 简单合并，将root2为root1的子树（这样做会加深树的深度）
	 * @param root1
	 * @param root2
	 */
	public void union(int root1,int root2){
		s[root2] = root1;
	}
	
	
	/**
	 * 灵巧求并
	 */
	
	/**
	 * 按高度合并，将深度较小的树作为较深树的子树，深度不会增加，只有当两棵树深度相同时，合并后树的深度加1
	 * 
	 * 根节点存放该树深度加1的负数
	 * 
	 * 参数为root表名只能按根节点合并
	 * 
	 * @param root1
	 * @param root2
	 */
	public void unionByHeight(int root1,int root2){
		if(s[root2]<s[root1]){   //root2 is deeper than root1
			s[root1] = root2;
		}else{
			if(s[root2] == s[root1])  //树高相等时，将树高加1（由于树高存的是负数，所以--）
				s[root1]--;
			s[root2] = root1;
		}
		s[root2] = root1;
	}
}
