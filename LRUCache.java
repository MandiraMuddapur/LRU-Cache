import java.util.HashMap;

public class LRUCache {

    class Node{
        int key, value;
        Node next,prev;
        public Node(int key, int value)
        {
            this.key=key;
            this.value=value;

        }
    }

    int capacity;
    Node head;
    Node tail;
    HashMap<Integer,Node> mp;
    LRUCache(int capacity)
    {
        this.capacity=capacity;
        head=new Node(0,0);
        tail=new Node(0,0);
        head.next=tail;
        tail.prev=head;
        mp = new HashMap<>();
        
    }

    public int get(int key)
    {
        if(!mp.containsKey(key))
        {
            return -1;
        }

        Node node= mp.get(key);
        remove(node);
        insertToFront(node);
        return node.value;
    }

    public void put(int key, int value)
    {
        if(mp.containsKey(key))
        {
            remove(mp.get(key));
        }
        Node node= new Node(key,value);
        insertToFront(node);
        mp.put(key,node);
        {
            if(mp.size()>capacity)
            {
                Node lru = tail.prev;
                remove(lru);
                mp.remove(lru.key);
            }
        }
        

    }

    public void remove(Node node)
    {
        Node nextNode= node.next;
        Node prevNode=node.prev;

        nextNode.prev=prevNode;
        prevNode.next=nextNode;
    }

    public void insertToFront(Node node)
    {
        Node nextNode=head.next;
        head.next=node;
        node.prev=head;
        node.next=nextNode;
        nextNode.prev=node;
    }
    
}
