public class List<T> implements Seq<T> {
    public Node first;
    public Node last;
    public Node current;
    public int sizeOfList;

    //unnessesary initiation of listsize to zero
    public List() {
        sizeOfList = 0;
    }


    /// Inserts an element at the back of a list

    public void append(T element){
        Node elementToAppend = new Node(element);
        if(sizeOfList ==0){
            this.first = elementToAppend;
            this.last  = elementToAppend;
            this.current = elementToAppend;
            sizeOfList++;
        }else if(sizeOfList>=1){
            this.last.next = elementToAppend;
            this.last = elementToAppend;
            this.current=elementToAppend;
            sizeOfList++;
        }else{
            System.out.println("Error, can't insert into list");
        }
    }

        /// Inserts an element at the front of a list
    //Lyckades sabba denna när ajg höll på att fixa rotate, och tiden är nu slut...
    /*
    public void prepend(T element){
        Node elementToAppend = new Node(element);
        if(sizeOfList ==0){
            this.first = elementToAppend;
            this.last  = elementToAppend;
            this.current = elementToAppend;
            sizeOfList++;
        }else if(sizeOfList==1){
            this.first.next = first;
            this.last = this.first;

            this.first = elementToAppend;
            sizeOfList++;
        }else if(sizeOfList>=1){
            this.first.next= first;
            this.first = elementToAppend;
            this.current = elementToAppend;
            sizeOfList++;
        }
        else{
        System.out.println("Error, can't insert into list");
        }
    }
    */
    public void prepend(T element) {
        Node elementToAppend = new Node(element);
        elementToAppend.next = this.first;
        this.first = elementToAppend;
        this.sizeOfList++;
    }
    /// Removes the first occurrence of an element from the list
    /*
    public void remove(T element){

        if(this.first == null){
            System.out.println("ERROR::: Removing from empty list");
        }else if(sizeOfList == 1){
            this.first = null;
            this.current = null;
            this.last = null;
            this.sizeOfList=0;
        }else{
            for (int i = 0; i < sizeOfList; i++) {
                Node elementToCheck = new Node(element);

                if (elementToCheck.contains.equals(this)) {
                    this.current = elementToCheck.next;
                    elementToCheck.previous = this.current;
                    sizeOfList--;
                    break;
                }
            }
        }
    }
    */
    public void remove(T element) {
        Node currentNode = this.first;
        Node previousNode = this.first;
        /*
        System.out.println("First node in remove is: "+currentNode.contains);
        System.out.println("Second node in remove is: "+currentNode.next.contains);
        System.out.println("third node in remove is: "+currentNode.next.next.contains);
        System.out.println("Current element is: "+element);
        */
        while (!(currentNode.contains.equals(element))){
            if(currentNode.next == null){
                System.out.println("Did not find that element: " +element);
                return;
            }else {
                previousNode = currentNode;
                currentNode = currentNode.next;
            }
        }
        if(currentNode.contains.equals(this.first.contains)){
            this.first = first.next;
            this.last = first.next;
        }else{
            System.out.println("Found your element "+element);
            previousNode.next = currentNode.next;
            if(previousNode.next == null){
                this.last = previousNode;
            }
            System.out.println("new last element is: "+ this.last.contains);
        }
        System.out.println("Just checking we got here");
        sizeOfList--;
    }
    public boolean contains(T element){
        if(this.first == null) {
            System.out.println("ERROR::: Checking on an empty list");
        }else if(element.equals(first.contains)){
            System.out.println("Found " +element+" in the fist spot.");
            return true;
        }
        else{
            Node elementToCheck = this.first;
            while(elementToCheck != null){
                if(elementToCheck.contains.equals(element)) {
                    System.out.println("Found element: " + element);
                    return true;
                }
                elementToCheck = elementToCheck.next;
            }
        }
        return false;
    }
    /*
    public boolean contains(T element) {
        Node elementToFind= this.first;
        //System.out.println("first item is: "+elementToFind.contains);
        if(elementToFind != null){
            while(!elementToFind.equals(element)){
                if(elementToFind.next == null){
                    System.out.println("Did not find " + element + " in the list");
                    return false;
                }else{
                    elementToFind = elementToFind.next;
                }

            }
        }else{
            System.out.println("ERROR: Empty linked list");
            return false;

        }
        return true;

    }
    */
    public int size(){
        return sizeOfList;
    }
    /// Returns the ith element in the list
    public T get(int index){
        int size = sizeOfList;
        if(index > size){
            System.out.println("Sorry, your input was larger than the list, try again");
        }else {
            for (int i = 0; i < size; i++) {
                if (index == 0) {
                    return this.first();
                } else if (index == sizeOfList) {
                    return this.last();
                } else if (index == i) {
                    return this.first.next.contains;
                } else {
                    continue;
                }
            }
        }
        return null;
    }
    public T first(){
        return this.first.contains;
    }
    public T last(){
        return this.last.contains;
    }
    public T current(){
        return this.current.contains;
    }
    /// Removes the first elemnet in the list and inserts it last
    public void rotate(){
        //System.out.println(last.contains+" :test");
        this.last.next = first;
        this.last = first;
        //System.out.println(last.contains+" :test");
        //System.out.println(first.contains+" :test");
        this.first = this.first.next;
        //this.first.next= first;
       // System.out.println(first.contains+" :test");
       // System.out.println("whole test");
       // System.out.println(first.contains+" :test ");
       // System.out.println(first.next.contains+" :test");
       // System.out.println(first.next.next.contains+" :test");
       // System.out.println(last.contains+" :test");






        /*
        this.first.next = first;
        System.out.println(first+" :test");

        /*
        this.first.next = this.first;
        this.first = this.last.next;
        */
    }

    public void display(){
        Node test = first;
        System.out.println("just new line for debugging");
        while(test != null){
            test.display();
            test = test.next;
        }
    }
    public class Node{
        public Node next;
        public Node previous;
        public T contains;

        /* The the link/node constructor*/
        public Node(T contains) {
            this.contains = contains;
        }

        /*Override to_string, just for debugging purpose */
        @Override
        public String toString() {
            return "T";
        }

        /*Diplay of content of the Node/link, mostly for debugging*/
        public void display() {
            System.out.println("The current content of this node is: "+ this.contains);
        }
    /*
        @Override
        public boolean equals(T obj) {
            if (this == obj){
                return true;
            }else{
                return false;
            }

        }
    */
    }

}
