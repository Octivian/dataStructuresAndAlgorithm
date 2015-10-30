package com.lx.dataStructures.charpter4Tree.practice;

import java.io.File;

public class ListAllInDirectory10 {
	
	public static void main(String[] args) {
		ListAllInDirectory10 L = new ListAllInDirectory10();
		File f = new File("E:\\workspace\\jz_dsp\\WebContent");
		L.list(f);
	}

	public void list(File f) {
		list(f, 0);
	}

	private void list(File f, int depth) {
		printName(f,depth);
		 if(f.isDirectory()){
			 File [] files = f.listFiles();
			 for (File i : files)
			 list(i, depth+1);
		 }
	}

	void printName(File f, int depth) {
		String name = f.getName();
		for (int i = 0; i < depth; i++)
			System.out.print("	");
		if (f.isDirectory())
			System.out.println("Dir: " + name);
		else
			System.out.println(f.getName() + "?" + f.length());
	}
}
