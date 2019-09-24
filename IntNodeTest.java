public class IntNodeTest{

	public static void main(String[] args) {

	    //no argument constructor
	    IntNode head = new IntNode();
	    System.out.println("A linked list start with head has been created");
	    System.out.println("\n");


	    
	    
	    //Constructor with given data and link will be tested in the following
	    System.out.println("Start adding nodes");
	    System.out.println("...");
	    System.out.println("Constructor with give value and link will be called");
	    IntNode n1= new IntNode(12,null);
	    head.setLink(n1);
	    System.out.println("Node n1 with data 12 has benn added");
	    System.out.println("current linked list: "+head.toString());
	    System.out.println("\n");


	    //Set data and set link method will be tested in the following
	    System.out.println("Set methods will be called in the following");
	    IntNode n2=new IntNode();
	    n1.setLink(n2);
	    n2.setData(27);
	    System.out.println("Node n2 with data 27 has benn added");
	    System.out.println("current linked list: "+head.toString());
	    System.out.println("\n");

	    
	    IntNode n3=new IntNode();
	    n2.setLink(n3);
	    n3.setData(111);
	    System.out.println("Node n3 with data 111 has benn added");
	    System.out.println("current linked list: "+head.toString());
	    System.out.println("\n");

	    
	    IntNode n4=new IntNode();
	    n3.setLink(n4);
	    n4.setData(34);
	    System.out.println("Node n3 with data 34 has benn added");
	    System.out.println("current linked list: "+head.toString());
	    System.out.println("\n");

	    
	    //Get data and get link method will be tested in the following
	    System.out.println("Get data and get link testing...");
	    System.out.println("Get data from n3 node");
	    System.out.println(n3.getData());
	    System.out.println("Get link from n3 node");
	    System.out.println(n3.getLink().getData());
	    System.out.println("\n");


	    
	    //toString method will be tested in the following
	    System.out.println("toString method testing...");
	    System.out.println("head node triggers the toString method");
	    System.out.println(head.toString());
	    System.out.println("n2 node (second node) activates the toString method");
	    System.out.println(n2.toString());
	    System.out.println("\n");

	    
	    
	    //Method of adding node after the current node will be tested below
	    System.out.println("Test addNodeAfterThis...");
	    System.out.println("A node with data 20 will be added after head node");
	    head.addNodeAfterThis(20);
	    System.out.println("current linked list: "+head.toString());

	    
	    System.out.println("A node with data 31 will be added after n1 node (a node in the middle)");
	    n1.addNodeAfterThis(31);
	    System.out.println("current linked list: "+head.toString());
	    
	    
	    System.out.println("A node with data 42 will be added after n4 node (last node)");
	    n4.addNodeAfterThis(42);
	    System.out.println("current linked list: "+head.toString());
	    System.out.println("\n");



	    //Method of removing the node after the current node.
	    System.out.println("Test removeNodeAfterThis...");
	    System.out.println("Removing node after head node");
	    head.removedNodeAfterThis();
	    System.out.println("current linked list: "+head.toString());
	    System.out.println("Removing node after n4 node");
	    n4.removedNodeAfterThis();
	    System.out.println("current linked list: "+head.toString());
	    System.out.println("\n");



	    //Method of getting the number of nodes in the list
	    //starting from a given node head will be tested below.
	    System.out.println("Test listLength...");
	    System.out.println("Number of nodes starting from head node");
	    System.out.println(head.listLength(head));
	    System.out.println("Number of nodes starting from n2 node (n2 node has data of 27) ");
	    System.out.println(head.listLength(n2));
	    System.out.println("\n");


	    //Search method tested below
	    System.out.println("Test search...");
	    System.out.println("Search if 12 exit in the linked list starting with head node:");
	    System.out.println(head.search(head,12));
	    System.out.println("Search if 12 exit in the linked list starting with n1 node:");
	    System.out.println(head.search(n1,12));
	    System.out.println("Search if 40 exit in the linked list starting with head node:");
	    System.out.println(head.search(head,40));
		
		
	    
	}

}
