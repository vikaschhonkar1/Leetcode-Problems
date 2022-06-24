// { Driver Code Starts
import java.util.*;
class Node{
    int data;
    Node next;
    
    Node(int a){
        data = a;
        next = null;
    }
    
}

class LinkedList{
    
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int x=sc.nextInt();
            Node head=null;
            for(int i=0;i<n;i++)
            {int a=sc.nextInt();
            if(head==null){
                head=new Node(a);
            }
            else
                insert(head,a);
            }
        
            Solve y = new Solve();
            System.out.println(y.countTriplets(head,x));
        }
    }
    public static Node insert(Node head,int a){
        if(head==null){
            return new Node(a);
        }
        head.next=insert(head.next,a);
        return head;
    }
    
}

// } Driver Code Ends


//User function Template for Java

class Solve
{
    static int countTriplets(Node head, int x) 
    { 
        //code here.
        int count = 0;
        
        Node temp1 = head;
        Node temp2 = head;
        
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        while(temp1!=null){
            map.put(temp1.data, 1);
            temp1 = temp1.next;
        }
        
        temp1 = head;
        
        while(temp1!=null){
            int a = temp1.data;
            temp2 = temp1.next;
            while(temp2!=null){
                int b = temp2.data;
                int val = x-a-b;
                if(map.containsKey(val) && ((val>a && val>b) ||(val<a && val<b))){
                    count++;
                }
                temp2 = temp2.next;
            }
            
            temp1 = temp1.next;
        }
        
        return count/2;
    } 
}