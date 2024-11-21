

public class IntNode
{
   private int sequenceNumber;
   private int data;
   private IntNode link;   

   
   // Precondition:
   // Postcondition: All instance variables of the IntNode class are initialized in order.
   public IntNode(int initialsequenceNumber, int initialdata, IntNode initialLink)
   {
        this.sequenceNumber= initialsequenceNumber;
        this.data = initialdata;
        this.link = initialLink;
   }

   
   // Precondition: This instance of the IntNode class exists.
   // In other words, the object whose method is activated exists as a node in the linked list. 
   // Postcondition: A new node with attributes item and data is created. Item serves as sequenceNumber.
   // The new node is added to the linked list at a position that comes immediately after the node whose method is activated.
   public void addNodeAfter(int item, int data)   
   {
       this.link = new IntNode(item, data, this.link);
   }
   
   
   // Precondition: This instance of the IntNode class exists.
   // In other words, the object whose method is activated exists as a node in the linked list. 
   // Postcondition: The specific node, which comes immediately after the node whose method is activated, 
   // is removed from the linked list.
   public void removeNodeAfter( )   
   {
      if(this.link != null) {
         this.link = this.link.link;
      } else{
         System.out.println("There is no node after to be removed so did not perfrom removeNodeData.");
      }
      
   } 
   
   
   // Precondition: This instance of the IntNode class exists.
   // Postcondition: The sequenceNumber of this node is returned.
   public int getsequenceNumber( )   
   {
       return this.sequenceNumber;
   }
   
  
   // Precondition: This instance of the IntNode class exists.
   // Postcondition: The link of this node is returned.
   public IntNode getLink( )
   {       
       return this.link;
   } 
    
   
   // Precondition: The linked list contains at least one element.
   // Postcondition: The (sequence number, data) pairs of each node in the linked list, starting with the head,
   // are displayed on the monitor. 
   public void displayNodeData(IntNode head)
   {
       if(head != null) {
         while(this != null) {

            IntNode slidelink = this;

            System.out.println("(" + slidelink.sequenceNumber +", " + slidelink.data + ")");
            
            slidelink = this.link;
         }


       }else {
         System.out.println("Linked list does not contain atleast one element and could not perform displayNodeData.");
       }
   }
   
   
   // Precondition: The head of the linked list is different than null, and its sequenceNumber is different than target.
   // Postcondition: The link to the specific node, which comes before the node whose sequenceNumber is equal to target, 
   // is returned. If the linked list does not contain a node with sequenceNumber equal to target, then null is returned.   
   public IntNode findPrevious(IntNode head, int target)
   {
	    // Implement me.
      

   }

   
   // Precondition: The head of the linked list is different than null, and its sequenceNumber is smaller than target.
   // Postcondition: The link to the specific node, which comes before the node that is the first in the linked list 
   // to have a sequenceNumber greater than target, is returned. 
   // If no such node is found, the link to the last node in the linked list is returned. 
   public IntNode locatePredecessor(IntNode head, int target)
   {
	    // Implement me.
   }
  
}
           