import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.Map;

public class ReadCvs {

  public void Universities_2DArray() {

  }

  public static Hashtable<String, Pakistani_Universities> pakis_univ_HashTable = new Hashtable<>();

  public static void main(String[] args) {

    HashTableOfUniversities hash = new HashTableOfUniversities();

    Pakistani_Universities[] pakis_univ = new Pakistani_Universities[100];
    String[] Universities = new String[100];
    try (BufferedReader bf = new BufferedReader(
        new FileReader("C:/Users/kelas//Desktop/DSA-PBL/Top 100 Unis of Pakistan.csv"))) {
      BufferedReader brr = new BufferedReader(new FileReader("C:/Users/kelas/Desktop/DSA-PBL/Universities keys.txt"));

      String line = "";
      String line2 = "";
      int i = -1;
      while ((line = bf.readLine()) != null) {
        try {
          line2 = brr.readLine();

          Universities = line.split(","); // string array.
          // System.out.print(line2 + " ");

        } catch (Exception e) {

        }

        String Uni_Name = Universities[0];
        int world_rank = Integer.parseInt(Universities[1]);
        int asia_rank = Integer.parseInt(Universities[2]);
        int pakistan_rank = Integer.parseInt(Universities[3]);
        String city = Universities[4];
        String province = Universities[5];
        int Nubr_publication = Integer.parseInt(Universities[6]);

        i++;

        pakis_univ[i] = new Pakistani_Universities(Uni_Name, world_rank, asia_rank,
            pakistan_rank, city, province, Nubr_publication);

        // System.out.println(pakis_univ[i].toString());
        hash.put(line2, pakis_univ[i]);
        pakis_univ_HashTable.put(line2, pakis_univ[i]);
      }

      // System.out.println(pakis_univ[0].Nubr_publication);

    } catch (IOException e) {

      e.printStackTrace();
    }

    int a = 0;
    for (Map.Entry m : pakis_univ_HashTable.entrySet()) {
      // System.out.println(m.getKey()+" "+m.getValue().toString());
      Stack_Universities.university_stack_publication_array[a][0] = m.getKey().toString();
      Stack_Universities.university_stack_publication_array[a][1] = String
          .valueOf(pakis_univ_HashTable.get(m.getKey()).Nubr_publication);
      a++;
    }
    // Arrays.sort(arr, Comparator.comparingInt((int[] a) -> a[1]).reversed());

    Arrays.sort(Stack_Universities.university_stack_publication_array,
        Comparator.comparingInt((String[] q) -> Integer.parseInt(q[1])).reversed());
    // Arrays.sort(arr, Comparator.comparingInt(a -> a[1]));
    for (int i = 0; i < 100; i++) {
      System.out.print(Stack_Universities.university_stack_publication_array[i][0] + " ");
      System.out.println(Stack_Universities.university_stack_publication_array[i][1]);
    }
    // System.out.println(pakis_univ_HashTable.get("MUET").Nubr_publication);
    // System.out.println(hash.get("QUAI"));
    // hash.dump();
    // for (int i = 0; i < pakis_univ.length; i++) {
    // System.out.println(pakis_univ[i].toString());
    // }
  }
}
