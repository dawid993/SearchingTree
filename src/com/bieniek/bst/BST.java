package com.bieniek.bst;

public class BST implements SearchTree
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
	
	@Override
	public void insert(int keyInsertNode)
	{		
		iterationInsert(keyInsertNode);
	}
	
	@Override
	public Node find(int key)
	{
		return findNode(root,key);
	}
	
	@Override
	public void delete(int key)
	{
		Node element = findNode(root,key);
		deleteNode(element);
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
	
	private Node findNode(Node element,int key)
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
	
	private Node findSuccesor(Node elem)
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
	
	private void deleteNode(Node elementToDelete)
	{
		if(elementToDelete == null) 
			return;
		
		Node deleteElementStrategy;
		Node sonOfElement;
		
		if(elementToDelete.getLeft() == null || elementToDelete.getRight() == null)
			deleteElementStrategy = elementToDelete;
		else
			deleteElementStrategy = findSuccesor(elementToDelete);
		
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
		
		if(deleteElementStrategy != elementToDelete)
			elementToDelete.setKey(deleteElementStrategy.getKey());
	}
	
	private Node createNode(int key,Node parent)
	{
		return new Node(parent,key);		
	}	
	
	private void iterationInsert(int insertNodeKey)
	{
		Node element = root;
		Node beforeElement = null;
		
		while(element != null)
		{
			beforeElement = element;
			if(element.getKey() < insertNodeKey)
				element = element.getRight();
			else if(element.getKey()> insertNodeKey)
				element = element.getLeft();
			else return;
		}
		
		if(beforeElement == null)
			root = createNode(insertNodeKey,null);
		else
		{
			if(beforeElement.getKey() < insertNodeKey)
				beforeElement.setRight(createNode(insertNodeKey,beforeElement));
			else if(beforeElement.getKey() > insertNodeKey)
				beforeElement.setLeft(createNode(insertNodeKey,beforeElement));
			else
				return;
				
		}
	}
	
}
