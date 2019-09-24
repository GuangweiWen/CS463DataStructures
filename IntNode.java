import java.io.*;
import java.util.*;

public class IntNode{


    // Invariant of the IntNode class:
    //   1. The node's integer data is in the instance variable data.
    //   2. For the final node of a list, the link part is null.
    //      Otherwise, the link part is a reference to the
    //      next node of the list.
    public int data;
    public IntNode link;

    
    /**
     * A no-argument constructor.
     * Initialize a node with  data value 0 and link value null.
     * @author Guangwei Wen
     * @postcondition
     *   This node contains the data value 0 and link value null.
     **/  
    public IntNode(){
	data=0;
	link=null;
    }

    
    
    /**
     * A constructor with given node value and link.
     * Initialize a node with a specified data (_data) and 
     * link (_node) to the next node. 
     * Note that the _node may be a null reference, 
     * which indicates that the new node has nothing after it.
     * @author Guangwei Wen
     * @param _data
     *   the data of this new node
     * @param _node
     *   a reference to the node after this new node--this reference may be null
     *   to indicate that there is no node after this new node.
     * @postcondition
     *   This node contains the specified data (_data) 
     *   and link (_node) to the next node.
     **/  
    public IntNode(int _data,  IntNode _node){
	data=_data;
	link=_node;
    }
    

    
    /**
     * Accessor method to get the data from this node.  
     * @author Guangwei Wen 
     * @return
     *  The data from this node
     **/
    public int getData(){
	return data;
    }
    
    
    /**
     * Accessor method to get a reference to the next node after this node.
     * @author Guangwei Wen 
     * @return
     *  A reference to the node after this node (or the null reference if there
     *  is nothing after this node)
     **/
    public IntNode getLink(){
	return link;                                               
    }


    
    
    /**
     * Modification method to set the new data for this node.  
     * @author Guangwei Wen 
     * @param newData 
     *  the new data to place in this node
     * @postcondition
     * The data of this node has been set to newData.
     **/
    public void setData(int newData){
	data=newData;
    }
    
    
    
    /**
     * Modification method to set the new link for this node. 
     * @author Guangwei Wen
     * @param newLink
     *  the new link set for this node
     * @postcondition
     * The link of this node has been set to newLink.
     **/
    public void setLink(IntNode newLink){
	link=newLink;                                             
    } 


    
    public static String toString;
    /**
     * A toString method to return all the data as a string in the linked list
     *  starting from the node that activates this method.
     * @author Guangwei Wen
     * @return
     *  A String toString will be returned which contains all the data 
     *  in the linked list starting from the node that activates this method.
     **/
    public String toString(){
	IntNode cursor=null;
	String tempString=null;
	int icount=0;
	for(cursor=link;cursor!=null;cursor=cursor.link){
	    if (icount==0){
		toString=Integer.toString(cursor.data);
		tempString=toString;	    
	    }else{
		toString=(tempString+"->"+cursor.data);
		tempString=toString;
	    }
	    icount++;
	}
	return toString;
    }


    
    /**
     * Modification method to add a node after the node which activate this method. 
     * @author Guangwei Wen
     * @param newdata
     *  the new link set for this node
     * @postcondition
     *  a node is added after the node which activate this method without 
     *  changing nodes after this node.
     **/
    public void addNodeAfterThis(int newdata){
	IntNode newNode = new IntNode();
	newNode.setData(newdata);
	newNode.setLink(this.getLink());
	this.setLink(newNode);
    }
    

    /**
     * Modification method to remove a node after the node which activate this method. 
     * @author Guangwei Wen
     * @postcondition
     *  a node is removed after the node which activate this method without 
     *  changing nodes after this node.
     **/
    public void removedNodeAfterThis(){
	this.setLink(this.link.link);
    }


    
    public static int listLength;
    /**
     * A method to get the number of nodes in the list starting from a given node.
     * @author Guangwei Wen
     * @param head
     * head is the node where the counting starts from in linked list.
     * @return
     *  A integer number listLength will be returned which contains
     *  number of nodes in the list starting from a given node.
     **/
    public int listLength(IntNode head){
	IntNode cursor=null;
	listLength=0;
	for(cursor=head.link;cursor!=null;cursor=cursor.link){
	    listLength++;
	}
	return listLength;
    }

    public static boolean search;
    /**
     * A method to search whether a linked list starting 
     * with a given node head contains a given value data.
     * @author Guangwei Wen
     * @precondition
     * node head is not null
     * @param head
     * head is the node where the search starts from in the linked list.
     * @param data
     * the value to be searched in the linked list.
     * @return
     *  A boolean variable search will be returned
     *  if the data exists in the linked list, search is true,
     *  if not, search is false
     **/
    public boolean search(IntNode head, int data){
	if (head!=null){
	    IntNode cursor=null;
	    search=false;
	    for(cursor=head.link;cursor!=null;cursor=cursor.link){
		if (cursor.data==data){
		    search=true;
		    break;
		}
	    }
	}
	return search;
    }
    




   
}
