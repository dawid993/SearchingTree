package com.bieniek.bst;

public interface SearchTree
{
	public void insert(int insertKey);
	
	public Node find(int key);
	
	public void delete(int key);
}
