import java.util.Arrays;
import java.util.Comparator;

class Stack_Universities {
    Stack_Universities(){        
        ReadCsvFile.ReadCvs_File();
    }

    static String[][] university_stack_publication_array = new String[100][2];
    static String[][] university_stack_rank_array = new String[100][2];
    private static Node top;
    private static int size;

    static class Node {
        Object data;
        Node next;

        Node(Object obj, Node next) {
            this.data = obj;
            this.next = next;
        }
    }

    public int size() {
        return size;
    }

    public static void push(Object obj) {
        top = new Node(obj, top);
        size++;
    }

    public Object pop() {
        if (size == 0)
            return "null";
        Object olObject = top.data;
        top = top.next;
        size--;
        return olObject;
    }

    public Object peek() {
        if (size == 0)
            return "null";
        return top.data;
    }

    public void Add_uni_obj_into_stack_by_numberOfPublication() {

        // Arrays.sort(Stack_Universities.university_stack_publication_array,
        // Comparator.comparingInt(q -> q[1]));

        Arrays.sort(university_stack_publication_array,
                Comparator.comparingInt((String[] q) -> Integer.parseInt(q[1])));
        for (int j = 0; j < university_stack_publication_array.length; j++) {
            this.push(university_stack_publication_array[j][0]);
            // System.out.print(university_stack_publication_array[j][0] + " = ");
            // System.out.println(university_stack_publication_array[j][1]);
        }
    }

    public void Add_uni_obj_into_stack_by_PakRanked() {

        // Arrays.sort(Stack_Universities.university_stack_publication_array,
        // Comparator.comparingInt(q -> q[1]));

        Arrays.sort(university_stack_rank_array,
                Comparator.comparingInt((String[] q) -> Integer.parseInt(q[1])).reversed());
        for (int j = 0; j < 100; j++) {
            this.push(university_stack_rank_array[j][0]);
            // System.out.print(university_stack_rank_array[j][0] + " = ");
            // System.out.println(university_stack_rank_array[j][1]);
        }
    }

    public void Top_N_University_by_Publication(int n) {
        int i = 0;
        this.Add_uni_obj_into_stack_by_numberOfPublication();
        while (i < n) {
            System.out.println(this.peek() + " " + ReadCsvFile.pakis_univ_HashTable.get(this.pop()));
            i++;
        }
    }

    public void Top_N_University_by_PakRank(int n) {
        int i = 0;
        this.Add_uni_obj_into_stack_by_PakRanked();
        while (i < n) {
            System.out.println(this.peek() + " = " + ReadCsvFile.pakis_univ_HashTable.get(this.pop()).toString());
            i++;
        }
    }

    public void Bottom_N_universities_by_publication(int n) {
        int i = 0;
        this.Add_uni_obj_into_stack_by_numberOfPublication();
        this.reverse_LinkedStack();
        while (i < n) {
            System.out.println(this.peek() + " " + ReadCsvFile.pakis_univ_HashTable.get(this.pop()));
            i++;
        }
    }

    public void Bottom_N_universities_by_rank(int n) {
        int i = 0;
        while (i < n) {
            System.out.println(university_stack_rank_array[i][0] + " "
                    + ReadCsvFile.pakis_univ_HashTable.get(university_stack_rank_array[i][0]));
            i++;
        }
    }

    private void reverse_LinkedStack() {
        Node prev = null;
        Node current = top;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        top = prev;

    }

    // public static void main(String[] args) {
    //     Stack_Universities su1 = new Stack_Universities();
    //     Stack_Universities su2 = new Stack_Universities();
    //     // su1.Add_uni_obj_into_stack_by_numberOfPublication();
    //     // su1.Add_uni_obj_into_stack_by_PakRanked();
    //     // su1.Top_N_University_by_PakRank(5);

    //     System.out.println("top 5 publication");
    //     su2.Top_N_University_by_Publication(5);
    //     System.out.println("===========");
    //     System.out.println("bottom 5 publication");
    //     su1.Bottom_N_universities_by_publication(5);

    //     System.out.println("\n=======================\n");
    //     System.out.println("top 5 rank");
    //     su1.Top_N_University_by_PakRank(5);
    //     System.out.println("===========");
    //     System.out.println("bottom 5 rank");
    //     su1.Bottom_N_universities_by_rank(5);

    // }
}
