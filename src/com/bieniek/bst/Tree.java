package com.bieniek.bst;

public class Tree
{
	private Node root;

	public Node getRoot() 
	{
		return root;
	}
	
	public void setRoot(Node root) 
	{
		this.root = root;
	}
	
	public void insertNode(int keyInsertNode)
	{		
		if(root == null)
			root = createNode(keyInsertNode, null);
		else
			recursivelyInsert(root,keyInsertNode);
	}
	
	public Node findNode(Node element,int key)
	{
		if(element == null)
			return null;
		
		if(element.getKey()>key)
			return findNode(element.getLeft(), key);
		else if(element.getKey()<key)
			return findNode(element.getRight(),key);
		else
			return element;
	}
	
	public Node findSuccesor(Node elem)
	{
		if(elem == null)
			return null;
		
		if(elem.getRight() != null)
		{
			elem=elem.getRight();
			while(elem.getLeft() != null)
				elem = elem.getLeft();
			
			return elem;
		}
		else
		{
			Node prelem;
			while(elem.getParent() != null)
			{
				prelem = elem;
				elem = elem.getParent();
					if(elem.getLeft() == prelem)
						return elem;
			}
			
			return null;
		}		
	}
	
	public void deleteNode(Node elem)
	{
		if(elem == null) 
			return;
		
		Node deleteElementStrategy;
		Node sonOfElement;
		
		if(elem.getLeft() == null || elem.getRight() == null)
			deleteElementStrategy = elem;
		else
			deleteElementStrategy = findSuccesor(elem);
		
		if(deleteElementStrategy.getLeft() != null)
			sonOfElement = deleteElementStrategy.getLeft();
		else
			sonOfElement = deleteElementStrategy.getRight();
		
		if(sonOfElement != null)
			sonOfElement.setParent(deleteElementStrategy.getParent());
		
		if(deleteElementStrategy.getParent() == null)
			root = sonOfElement;
		else
		{
			if(deleteElementStrategy == deleteElementStrategy.getParent().getLeft())
				deleteElementStrategy.getParent().setLeft(sonOfElement);
			else
				deleteElementStrategy.getParent().setRight(sonOfElement);
		}
		
		if(deleteElementStrategy != elem)
			elem.setKey(deleteElementStrategy.getKey());
	}
	public void inorder(Node v)
	{
		  if(v != null)
		  {
		    inorder(v.getLeft());      
		    System.out.println(v.getKey());
		    inorder(v.getRight());     
		  }
	}
	
	private Node createNode(int key,Node parent)
	{
		return new Node(parent,key);		
	}
	
	private void recursivelyInsert(Node beforeNode,int insertNodeKey)
	{
		if(beforeNode.getKey() < insertNodeKey)
		{
			if(beforeNode.getRight() != null)
				recursivelyInsert(beforeNode.getRight(), insertNodeKey);
			else
				beforeNode.setRight(createNode(insertNodeKey, beforeNode));
		}
		else
		{
			if(beforeNode.getLeft() != null)
				recursivelyInsert(beforeNode.getLeft(), insertNodeKey);
			else
				beforeNode.setLeft(createNode(insertNodeKey, beforeNode));
		}
	}
	
	public void iterationInsert(int insertNodeKey)
	{
		Node element = root;
		Node beforeElement = null;
		
		while(element != null)
		{
			beforeElement = element;
			if(element.getKey() < insertNodeKey)
				element = element.getRight();
			else 
				element = element.getLeft();
		}
		
		if(beforeElement == null)
			root = createNode(insertNodeKey,null);
		else
		{
			if(beforeElement.getKey() < insertNodeKey)
				beforeElement.setRight(createNode(insertNodeKey,beforeElement));
			else
				beforeElement.setLeft(createNode(insertNodeKey,beforeElement));
				
		}
	}
	
}
