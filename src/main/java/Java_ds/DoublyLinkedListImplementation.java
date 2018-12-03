package Java_ds;
import java.util.Scanner;

//Creator class of Doubly Linked List nodes
class DoublyNode
{
    int data;
    DoublyNode next;
    DoublyNode prev;

    public DoublyNode(int a)
    {
        data = a;
        next = null;
        prev = null;
    }
}



//Doubly Linked List construction and defining its methods

class DoublyLinkedList
{
    DoublyNode head = null;
    DoublyNode tail = null;
    int size = 0;


    public void addAtStart(int a)

    // Add a node at the beginning of the List

    {
        DoublyNode n = new DoublyNode(a);

        // creating the node object

        if(size == 0)
        {
            head = n;
            tail = n;
        }

        else
        {
            n.next = head;
            head.prev = n;
            head =n;

        }
        size++;
    }


    public void addAtEnd(int a)

    {
        //Add a node at the end of the List

        DoublyNode n = new DoublyNode(a);

        if(size == 0)
        {
            head = n;
            tail = n;
        }

        else
        {
            tail.next = n;
            n.prev = tail;
            tail =n;
        }
        size++;
    }

    public DoublyNode deletefirst()

    {
        //Delete a node at the beginning of the List

        if(head == null)
        {
            head = null;
            return head;

        }
        else if(head.next == null)
        {
            head = null;
            return head;

        }
        else
        {
            DoublyNode curr = head;
            curr = curr.next;
            head.next = null;
            curr.prev = null;
            head = curr;
            return head;
        }
    }
    public DoublyNode deletelast()

    {
        //Delete a node at the end of the List

        if(head == null )
        {
            tail = null;
            return tail;

        }
        else if(head.next == null)
        {
            tail = null;
            head = null;
            return tail;
        }

        else
        {

            DoublyNode curr = tail;
            curr = tail.prev;
            curr.next = null;
            tail.prev = null;
            tail = curr;
            return tail;
        }

    }

    public int deletespec(int a)

    {
        //Delete a specific node of the List

        if(head == null)
        {

            return -1;
        }

        else
        {
            DoublyNode curr = head;

            while(curr != null)

            {
                if(curr.data == a)
                {
                    if(curr == head)
                    {
                        deletefirst();
                    }
                    else if(curr == tail)
                    {
                        deletelast();
                    }
                    else
                    {
                        curr.prev.next = curr.next;
                        curr.next.prev = curr.prev;
                        curr.next = null;
                        curr.prev = null;
                    }
                    return 1;
                }

                curr = curr.next;
            }
            return 0;

        }
    }


    public void display()

    {
        //Display the linked list

        DoublyNode currnode = head;

        if(currnode == null)
        {
            System.out.println("null");
            System.out.println("List is empty now :p");

        }

        else if (currnode.next == null)
        {
            System.out.print("Linked List : ");
            //System.out.print("-> "+currnode.prev);
            System.out.print("-> "+currnode.data);
            //System.out.print("-> "+currnode.next);
        }

        else
        {
            System.out.print("Linked List : ");

            while(currnode != null)
            {

                //System.out.print("-> "+currnode.prev);

                System.out.print("-> "+currnode.data);
                //System.out.print("-> "+currnode.next);
                //System.out.println();
                currnode = currnode.next;
            }
        }


    }


}
public class DoublyLinkedListImplementation

{
    //Main class for Doubly Linked List Implimentation

    public static void main(String[] args)

    {
        int size,data;
        DoublyLinkedList l = new DoublyLinkedList();

        //To get user input

        Scanner input = new Scanner(System.in);
        System.out.println("Enter the size of the LinkedList");
        size = input.nextInt();

        System.out.println("Enter the elements of the LinkedList");
        for(int i=0;i<size;i++)
        {
            data = input.nextInt();
            l.addAtEnd(data);
        }

        l.display();

        DoublyNode checkhead = l.deletefirst();

        System.out.println('\n');
        System.out.println("After deleting first node");
        l.display();

        if(checkhead != null)
        {
            DoublyNode checktail = l.deletelast();
            System.out.println('\n');
            System.out.println("After deleting last node");
            l.display(); //
            System.out.println();

            if(checkhead != null && checktail != null)
            {
                System.out.println("Enter the node to be deleted");
                int a = input.nextInt();
                int deleted = l.deletespec(a);

                if(deleted != 0)
                {
                    System.out.println();
                    System.out.println("After deleting spec node");
                    l.display();
                    System.out.println();

                }
                else
                {
                    //System.out.println();
                    System.out.println("No such Node in the Linked List");
                }
            }
        }

    }
}