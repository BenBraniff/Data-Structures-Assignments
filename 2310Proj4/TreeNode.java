//Ben Braniff
public class TreeNode {

	private String computerName;

	private int[] malwareAnalyses; // This instance variable belongs to detector work that lies outside the scope of the project.

	private TreeNode parent; 

	private TreeNode leftChild;

	private TreeNode rightChild;
	
	
	// Precondition: None.
	// Postcondition: A new node is created for a computer in the large enterprise network, 
	//                and its instance variables are initialized.
	//
	public TreeNode(String computerNameValue, TreeNode parentValue, TreeNode leftChildValue, TreeNode rightChildValue)
	{
		this.computerName = computerNameValue;
		this.parent = parentValue;
		this.leftChild = leftChildValue;
		this.rightChild = rightChildValue;
	}
	
	
	// Precondition: currentNode is an existent node in the binary search tree.
	// Postcondition: newNode is inserted in the binary search tree.  
	//                The revised tree satisfies the binary search tree property.
	//
	public void insertNewNode(TreeNode currentNode, TreeNode newNode)   
	{
		TreeNode nodeY = null;
		TreeNode nodeX = currentNode;

		while(nodeX != null) {
			nodeY = nodeX;
			if(newNode.computerName.compareToIgnoreCase(nodeX.computerName) < 0){
				nodeX = nodeX.leftChild;
			}else {
				nodeX = nodeX.rightChild;
			}	
		}
		newNode.parent = nodeY;
		
		if(nodeY == null) {
			currentNode = newNode;
		}else if(newNode.computerName.compareToIgnoreCase(nodeY.computerName) < 0) {
			nodeY.leftChild = newNode;
		}else {
			nodeY.rightChild = newNode;
		}
	}
	
	
	// Precondition: currentNode is an existent node in the binary search tree.
	// Postcondition: The tree is walked in order to display the keys of its nodes.  
	//                The walk starts at currentNode.
	//
	public void analyzeInOrder(TreeNode currentNode)   
	{
		if(currentNode != null) {
			analyzeInOrder(currentNode.leftChild);
			System.out.println(currentNode.computerName);
			analyzeInOrder(currentNode.rightChild);
		}
	}

	
	// Precondition: currentNode is an existent node in the binary search tree.
	// Postcondition: The tree is walked in pre-order to display the keys of its nodes.  
	//                The walk starts at currentNode.
	//               
	public void analyzeInPreOrder(TreeNode currentNode)   
	{
		if(currentNode != null) {
			System.out.println(currentNode.computerName);
			analyzeInPreOrder(currentNode.leftChild);
			analyzeInPreOrder(currentNode.rightChild);
		}
	}
	
	
	// Precondition: currentNode is an existent node in the binary search tree.
	// Postcondition: The tree is walked in post-order to display the keys of its nodes.  
	//                The walk starts at currentNode.
	//               
	public void analyzeInPostOrder(TreeNode currentNode)   
	{
		if(currentNode != null) {
			analyzeInPostOrder(currentNode.leftChild);
			analyzeInPostOrder(currentNode.rightChild);
			System.out.println(currentNode.computerName);
		}
	}
	
}
