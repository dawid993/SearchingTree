package com.bieniek.bst;

public class Node 
{
	private Node parent;
	private Node left;
	private Node right;
	private int key;
	
	public Node(Node parent,int key)
	{
		this.parent = parent;
		this.key = key; 
		left = null;
		right = null;
	}
	
	public Node getParent() 
	{
		return parent;
	}
	public void setParent(Node parent)
	{
		this.parent = parent;
	}
	public Node getLeft()
	{
		return left;
	}
	public void setLeft(Node left) 
	{
		this.left = left;
	}
	public Node getRight() 
	{
		return right;
	}
	public void setRight(Node right) 
	{
		this.right = right;
	}
	public int getKey() 
	{
		return key;
	}
	public void setKey(int key) 
	{
		this.key = key;
	}
}
