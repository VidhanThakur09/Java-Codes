public class Doublell {
    public class Node{
        int data;
        Node next;
        Node prev;
        public Node(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
    public static Node head;
    public static Node tail;
    public static Node prev;
    public static int size;

    // public static void printdll(){
        
    //     if(head == null){
    //         System.out.println("ll is emplty");
    //         return;
    //     }
    //     Node temp = head;

    //     while(temp!=null){
    //         System.out.print(temp.data+" -->");
    //         temp=temp.next;
    //     }
    //     System.out.println("null");
    // }

    // public void addfirst(int data){
    //     Node newNode = new Node(data);
    //     size++;
    //     if(head == null){
    //         head=tail=newNode;
    //         return;
    //     }
    //     newNode.next = head;
    //     head.prev = newNode;
    //     head = newNode;
    // }

    // public void addlast(int data){
    //     Node newNode = new Node(data);
    //     size++;
    //     if(head == null){
    //         head=tail=newNode;
    //         return;
    //     }
    //     tail.next = newNode;
    //     newNode.prev = tail;
    //     tail = newNode;
    // }
    // public int removefirst(){
    //     Node newNode = head;
    //     if(head == null){
    //         System.out.print("empty");
    //         return -1;
    //     }else if(size==1){
    //         int var = head.data;
    //         size = 0;
    //         head = tail = null;
    //         return var;
    //     }
    //     int var = head.data;
    //     head = head.next;
    //     head.prev = null;
    //     size--;
    //     return var;
    // }
    // public int removelast(){
    //     if(head == null){
    //         System.out.print("empty");
    //         return -1;
    //     }else if (size == 1){
    //         int var = tail.data;
    //         size = 0;
    //         head = tail = null;
    //         return var;
    //     }
    //     Node temp = head;
    //     for(int i = 0;i<size-2;i++){
    //         temp = temp.next;
    //     }
    //     int var = tail.data;
    //     tail = temp;
    //     temp.next = null;
    //     tail.prev = temp.prev;
    //     size--;
    //     return var;
    // }
    // public void reversedll(){
    //     Node curr = head;
    //     Node prev = null;
    //     Node next;
        
    //     while(curr!= null){
    //         next = curr.next;
    //         curr.next = prev;
    //         curr.prev = next;

    //         prev = curr;
    //         curr = next;
    //     }
    //     head = prev;
    // }

    public void printDLL(){
        if(head==null){
            System.out.println("empty");
        }
        Node temp = head;
        while(temp!=null){
            System.out.println(temp.data);
            temp = temp.next;
        }
        System.out.println("null");
    }
    public void addFirst(int data){
        Node NewNode = new Node (data);
        if(head == null){
            head = tail = NewNode;size++;
        }
        size++;
        NewNode.next = head;
        head.prev = NewNode;
        head = NewNode;

    }
    public void addLast(int data){
        Node newNode = new Node ( data);
        if(head == null){
            head = tail = newNode; size++;
        }
        size++;
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }
    public int removeFirst(){
        if(size == 0){
            return-1;
        }
        if( size == 1){
            int val = head.data;
            head = head.next; size=0;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        head.prev = null;
        return val;
    }
    public int removeLast(){
        if(size==0){
            return -1;
        }
        if( size == 1){
            int val = head.data;
            head = head.next; size=0;
            return val;
        }
        Node temp = head;
        for(int i = 0;i<size-2;i++){
            temp = temp.next;
        }
        int val = tail.data;
        tail = temp;
        temp.next = null;
        tail.prev = temp.prev;
        size--;
        return val; 
        
    }
    public void reverseDLL(){
        Node curr = head; Node prev = null;Node next;
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr.prev = next;
            curr = next;

        }
    }




    public static void main(String arg[]){
        Doublell dll = new Doublell();
        
        

    }
}

