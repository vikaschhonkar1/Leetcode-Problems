//{ Driver Code Starts
import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}


class GfG {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
                
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    static void deletetree( Node root)
{
    if(root == null)
    return;
    deletetree(root.left);
    deletetree(root.right);
    root.left=null;
    root.right=null;
}
    static void printInorder(Node root){
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
    
	public static void main (String[] args) throws IOException {
	        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
	        while(t-- > 0){
	            String s= br.readLine();
	            Node root = buildTree(s);
	            
	            Tree tr=new Tree();
	            ArrayList<Integer> A=new ArrayList<Integer>();
	            tr.serialize(root, A);
	            deletetree(root);
	            root = null;
	            
	            Node getRoot=tr.deSerialize(A);
	            printInorder(getRoot);
	            System.out.println();
	        }
	}
}
// } Driver Code Ends


/*Complete the given function
Node is as follows:
class Tree{
	int data;
	Tree left,right;
	Tree(int d){
		data=d;
		left=right=null;
	}
}*/

class Tree {
    
    public Node getrightMostNode(Node node, Node curr){
        while(node.right != null && node.right != curr) node = node.right;
        return node;
    }
    
    public void serialize(Node root, ArrayList<Integer> A){
        Node curr = root;
        while(curr != null) {
            Node leftNode = curr.left;
            if(leftNode == null) {
                A.add(curr.data);
                curr = curr.right;
            } else {
                Node rightMostNode = getrightMostNode(leftNode, curr);
                if(rightMostNode.right == null) {
                    rightMostNode.right = curr;
                    curr = curr.left;
                } else {
                    rightMostNode.right = null;
                    A.add(curr.data);
                    curr = curr.right;
                }
            }
        }
    }

    public Node constructTreeFromInOrder(ArrayList<Integer> A, int si, int ei) {
        if(si>ei) return null;
                
        int mid = (si + ei) / 2;
        Node root = new Node(A.get(mid));
        root.left = constructTreeFromInOrder(A, si, mid - 1);
        root.right = constructTreeFromInOrder(A, mid + 1, ei);
        return root;
    }
    
    public Node deSerialize(ArrayList<Integer> A) {
        return constructTreeFromInOrder(A, 0, A.size() - 1);
    }
};