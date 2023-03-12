public class HashTableOfUniversities {
    

    static private class ListNode {
        Pakistani_Universities universityObject;
        String key;
        ListNode next; 
        }
        
        private ListNode[] table; 
        private int count; 

        public HashTableOfUniversities() {
        table = new ListNode[64];
        }
        
        public HashTableOfUniversities(int initialSize) {
        table = new ListNode[initialSize];
        }
        
//------------- traverse method:

        void dump() {
       
        
        for (int i = 0; i < table.length; i++) {
        // System.out.print(i + ":");
        
        ListNode list = table[i]; 
        while (list != null) {
        
        System.out.print(" (" + list.key + "," + list.universityObject + ")\n");
        
        list = list.next;
        
        }
        
       
        
        }
        
        } // end dump()
        
//--------- add method 

        public void put(String key,Pakistani_Universities universityObject) {
        
        
        
        int bucket = hash(key); 
        
        ListNode list = table[bucket]; 
        while (list != null) {
        
        
        if (list.universityObject.equals(universityObject))
        break;
        list = list.next;
        
        }
        
        
        if (list != null) {
        list.key = key;
        }
        
        else {    
        if (count >= 0.75*table.length) {
        
        resize();
    
        }
        
        ListNode newNode = new ListNode();
        
        newNode.universityObject = universityObject;
        
        newNode.key = key;
        
        newNode.next = table[bucket];
        
        table[bucket] = newNode;
        
        count++;
        
        }
        
        }
        // ----- get method:
        public Pakistani_Universities get(String key) {
        
      
        int bucket = hash(key); // At what location should the universityObject be?
        
        ListNode list = table[bucket]; // For traversing the list.
        
        while (list != null) {
        
      
        if (list.key.equals(key))
        
        return list.universityObject;
        
        list = list.next; // Move on to next node in the list.
        
        }
        
        return null;
        
        }
        
        //----------------- remove method :
        public void remove(String key) {
        int bucket = hash(key); // At what location should the universityObject be?
        
        if (table[bucket] == null) {
        return;
        
        }
        
        if (table[bucket].key.equals(key)) {
        
        table[bucket] = table[bucket].next;
        
        count--; // Remove new key of items in the table.
        
        return;
        
        }

        ListNode prev = table[bucket]; // The node that precedes
        ListNode curr = prev.next; // For traversing the list,
        while (curr != null && ! curr.universityObject.equals(key)) {
        
        curr = curr.next;
        
        prev = curr;
        
        }
        
        if (curr != null) {
        
        prev.next = curr.next;
        
        count--; // Record new key of items in the table.
        
        }
        
        }

         //---------- contains methods:
        
         public boolean containsKey(String key) {
        int bucket = hash(key); // In what location should universityObject be?
        
        ListNode list = table[bucket]; // For traversing the list.
        
        while (list != null) {
        
        if (list.key.equals(key))
        
        return true;
        
        list = list.next;
        
        }
        
        return false;
        
        }
        
        public int size() {
        return count;
        
        }
        
        private int hash(String key) {
        return (Math.abs(key.hashCode())) % table.length;
        
        }
        
/// ----- resize method :

        private void resize() {
        ListNode[] newtable = new ListNode[table.length*2];
        
        for (int i = 0; i < table.length; i++) {
        
        ListNode list = table[i]; // For traversing linked list key i.
        
        while (list != null) {
        
        
        ListNode next = list.next; // The is the next node in the list.
        
        
        int hash = (Math.abs(list.universityObject.hashCode())) % newtable.length;
        
        list.next = newtable[hash];
        
        newtable[hash] = list;
        
        list = next; // Move on to the next node in the OLD table.
        
        }
        
        }
        
        table = newtable; // Replace the table with the new table.
        
        } // end resize()
        

        //-----update method 

        // public void Update(String name,String key){
        // if (containsKey(name)){
        //     this.remove(name);
        //     this.put(name, key);
        // }else{
        //     System.out.println("key doesn't Exist");
        // }
        // }
        public static void main(String[] args) {
            
        }
        } 



