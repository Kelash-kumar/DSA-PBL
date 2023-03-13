import java.util.Arrays;
import java.util.Comparator;

class Stack_Universities {
    Stack_Universities() {
        ReadCsvFile.ReadCvs_File();
    }

    static String[][] university_stack_publication_array = new String[100][2];
    static String[][] university_stack_WorldRank_array = new String[100][2];
    static String[][] university_stack_AsiaRank_array = new String[100][2];
    static String[][] university_stack_Pakrank_array = new String[100][2];
    static Stack_Universities sindh_Stack = new Stack_Universities();
    static Stack_Universities punjab_Stack = new Stack_Universities();
    static Stack_Universities Balochistan_Stack = new Stack_Universities();
    static Stack_Universities KPK_Stack = new Stack_Universities();

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

    public void push(Object obj) {
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
        Arrays.sort(university_stack_publication_array,
                Comparator.comparingInt((String[] q) -> Integer.parseInt(q[1])));
        for (int j = 0; j < university_stack_publication_array.length; j++) {
            this.push(university_stack_publication_array[j][0]);

        }
    }

    public void Add_uni_obj_into_stack_by_WorldRanked() {
        Arrays.sort(university_stack_WorldRank_array,
                Comparator.comparingInt((String[] q) -> Integer.parseInt(q[1])).reversed());
        for (int j = 0; j < 100; j++) {
            this.push(university_stack_WorldRank_array[j][0]);
            // System.out.print(university_stack_WorldRank_array[j][0] + " = ");
            // System.out.println(university_stack_WorldRank_array[j][1]);
        }
    }

    public void Add_uni_obj_into_stack_by_AsiaRanked() {
        Arrays.sort(university_stack_AsiaRank_array,
                Comparator.comparingInt((String[] q) -> Integer.parseInt(q[1])).reversed());
        for (int j = 0; j < 100; j++) {
            this.push(university_stack_AsiaRank_array[j][0]);
        }
    }

    public void Add_uni_obj_into_stack_by_PakRanked() {
        Arrays.sort(university_stack_Pakrank_array,
                Comparator.comparingInt((String[] q) -> Integer.parseInt(q[1])).reversed());
        for (int j = 0; j < 100; j++) {
            this.push(university_stack_Pakrank_array[j][0]);
        }
    }

    // bottom traverse:
    public void Bottom_n_UniversityBy(String orderby, int n) {
        if (orderby.equals("numberofpublication")) {
            this.Add_uni_obj_into_stack_by_numberOfPublication();
            for (int i = 0; i < n; i++)
                System.out.println(university_stack_publication_array[i][0] + " "
                        + ReadCsvFile.pakis_univ_HashTable.get(university_stack_publication_array[i][0]));
        } else if (orderby.equals("WorldRank")) {
            this.Add_uni_obj_into_stack_by_WorldRanked();
            for (int i = 0; i < n; i++)
                System.out.println(university_stack_WorldRank_array[i][0] + " "
                        + ReadCsvFile.pakis_univ_HashTable.get(university_stack_WorldRank_array[i][0]));

        } else if (orderby.equals("AsiaRank")) {
            this.Add_uni_obj_into_stack_by_AsiaRanked();
            for (int i = 0; i < n; i++)
                System.out.println(university_stack_AsiaRank_array[i][0] + " "
                        + ReadCsvFile.pakis_univ_HashTable.get(university_stack_AsiaRank_array[i][0]));

        } else if (orderby.equals("pakistanRank")) {
            this.Add_uni_obj_into_stack_by_PakRanked();
            for (int i = 0; i < n; i++)
                System.out.println(university_stack_Pakrank_array[i][0] + " "
                        + ReadCsvFile.pakis_univ_HashTable.get(university_stack_Pakrank_array[i][0]));
        }

    }

    // top traverse:
    public void Top_n_UniversityBy(String orderby, int n) {

        if (orderby.equals("numberofpublication")) {
            this.Add_uni_obj_into_stack_by_numberOfPublication();
            for (int i = 0; i < n; i++)
                System.out.println(this.peek() + " " + ReadCsvFile.pakis_univ_HashTable.get(this.pop().toString()));
        }

        else if (orderby.equals("WorldRank")) {
            this.Add_uni_obj_into_stack_by_WorldRanked();
            for (int i = 0; i < n; i++)
                System.out.println(this.peek() + " = " + ReadCsvFile.pakis_univ_HashTable.get(this.pop()).toString());

        } else if (orderby.equals("AsiaRank")) {
            this.Add_uni_obj_into_stack_by_AsiaRanked();
            for (int i = 0; i < n; i++)
                System.out.println(this.peek() + " = " + ReadCsvFile.pakis_univ_HashTable.get(this.pop()).toString());

        } else if (orderby.equals("pakistanRank")) {
            this.Add_uni_obj_into_stack_by_PakRanked();
            for (int i = 0; i < n; i++)
                System.out.println(this.peek() + " = " + ReadCsvFile.pakis_univ_HashTable.get(this.pop()).toString());
        }

    }

    public static void Add_keys_by_province(String provience) {
        Main main = new Main();
        Arrays.sort(university_stack_publication_array,
                Comparator.comparingInt((String[] q) -> Integer.parseInt(q[1])));
        if (provience.equals("punjab")) {
            for (int j = 0; j < university_stack_publication_array.length; j++) {
                for (int i = 0; i < Main.Punjab.size(); i++) {
                    if (university_stack_publication_array[j][0].equalsIgnoreCase(Main.Punjab.get(i)))
                        punjab_Stack.push(university_stack_publication_array[j][0]);
                }

            }
        } else if (provience.equals("KPK")) {
            for (int j = 0; j < university_stack_publication_array.length; j++) {
                for (int i = 0; i < Main.KPK.size(); i++) {
                    if (university_stack_publication_array[j][0].equalsIgnoreCase(Main.KPK.get(i)))
                        KPK_Stack.push(university_stack_publication_array[j][0]);
                }

            }
        } else if (provience.equals("sindh")) {
            for (int j = 0; j < university_stack_publication_array.length; j++) {
                for (int i = 0; i < Main.Sindh.size(); i++) {
                    if (university_stack_publication_array[j][0].equalsIgnoreCase(Main.Sindh.get(i)))
                        sindh_Stack.push(university_stack_publication_array[j][0]);
                }

            }
        }

        else if (provience.equals("Balochistan")) {
            for (int j = 0; j < university_stack_publication_array.length; j++) {
                for (int i = 0; i < Main.Balochistan.size(); i++) {
                    if (university_stack_publication_array[j][0].equalsIgnoreCase(Main.Balochistan.get(i)))
                        Balochistan_Stack.push(university_stack_publication_array[j][0]);
                }

            }
        }
    }

    public void Top_n_Sindh_Universities(String province, int n) {
        Add_keys_by_province(province);
        // add_sindh();
        if (n > sindh_Stack.size()) {
            System.out.println("sorry we have only " + sindh_Stack.size() + "records");
            n = sindh_Stack.size();
        }
        for (int i = 0; i < n; i++) {
            System.out.println(
                    sindh_Stack.peek() + "  " + ReadCsvFile.pakis_univ_HashTable.get(sindh_Stack.pop()).toString());
        }

    }

    public void Top_n_Punjab_Universities(String province, int n) {
        Add_keys_by_province(province);
        if (n > punjab_Stack.size()) {
            System.out.println("sorry we have only " + punjab_Stack.size() + "records");
            n = punjab_Stack.size();
        }
        for (int i = 0; i < n; i++) {
            System.out.println(
                    punjab_Stack.peek() + "  " + ReadCsvFile.pakis_univ_HashTable.get(punjab_Stack.pop()).toString());
        }
    }

    public void Top_n_Balochistan_Universities(String province, int n) {
        Add_keys_by_province(province);
        if (n > Balochistan_Stack.size()) {
            System.out.println("sorry we have only " + Balochistan_Stack.size() + "records");
            n = Balochistan_Stack.size();
        }
        for (int i = 0; i < n; i++) {
            System.out.println(Balochistan_Stack.peek() + "  "
                    + ReadCsvFile.pakis_univ_HashTable.get(Balochistan_Stack.pop()).toString());
        }
    }

    public void Top_n_KPK_Universities(String province, int n) {
        Add_keys_by_province(province);
        if (n > KPK_Stack.size()) {
            System.out.println("sorry we have only " + KPK_Stack.size() + "records");
            n = KPK_Stack.size();
        }
        for (int i = 0; i < n; i++) {
            System.out.println(
                    KPK_Stack.peek() + "  " + ReadCsvFile.pakis_univ_HashTable.get(KPK_Stack.pop()).toString());
        }
    }

}

// public static void main(String[] args) {
// Stack_Universities s=new Stack_Universities();
// System.out.println("===============sindh");
// s. Top_n_Sindh_Universities("sindh", 10);
// // System.out.println("===============punjab");
// // s. Top_n_Sindh_Universities("punjab", 5);
// // System.out.println("===============bolichsitan");
// // s. Top_n_Sindh_Universities("Balochistan", 5);
// // System.out.println("===============kpk");
// // s.Top_n_Sindh_Universities("KPK", 5);
// // s.Top_n_Sindh_Universities();
// // Add_keys_by_province("sindh");
// // // s.Top_n_Sindh_Universities();
// // Add_keys_by_province("punjab");
// // // p.Top_n_Punjab_Universities();
// // Add_keys_by_province("Balochistan");
// // // b.Top_n_Balochistan_Universities();
// // // k.Top_n_KPK_Universities();
// // Add_keys_by_province("KPK");
// }
// public static void main(String[] args) {
// Stack_Universities ss=new Stack_Universities();
// while(sindh_Stack.size()!=0){
// System.out.println(sindh_Stack.pop());
// }
// }
// // private Node reverse_LinkedStack() {
// // Node prev = null;
// // Node current = this.top;
// // Node next = null;
// // while (current != null) {
// // next = current.next;
// // current.next = prev;
// // prev = current;
// // current = next;
// // }
// // this. top = prev;
// // return top;

// // }
// public static void main(String[] args) {
// Stack_Universities su=new Stack_Universities();
// Stack_Universities su1=new Stack_Universities();
// System.out.println("========= top=========");
// // su.Add_uni_obj_into_stack_by_WorldRanked();
// // System.out.println("========BOTTOM==========");
// su.Bottom_n_UniversityBy("numberofpublication", 5);

// }
// }

// public void Bottom_N_universities_by_publication(int n) {
// int i = 0;
// this.Add_uni_obj_into_stack_by_numberOfPublication();
// this.reverse_LinkedStack();
// while (i < n) {
// System.out.println(this.peek() + " " +
// ReadCsvFile.pakis_univ_HashTable.get(this.pop()));
// i++;
// }
// }

// public void Bottom_N_universities_by_rank(int n) {
// int i = 0;
// while (i < n) {
// System.out.println(university_stack_Pakrank_array[i][0] + " "
// +
// ReadCsvFile.pakis_univ_HashTable.get(university_stack_Pakrank_array[i][0]));
// i++;
// }
// }

// public void Top_N_University_by_Publication(int n) {
// int i = 0;
// this.Add_uni_obj_into_stack_by_numberOfPublication();
// while (i < n) {
// System.out.println(this.peek() + " " +
// ReadCsvFile.pakis_univ_HashTable.get(this.pop()));
// i++;
// }
// }

// public void Top_N_University_by_PakRank(int n) {
// int i = 0;
// this.Add_uni_obj_into_stack_by_PakRanked();
// while (i < n) {
// System.out.println(this.peek() + " = " +
// ReadCsvFile.pakis_univ_HashTable.get(this.pop()).toString());
// i++;
// }
// }
