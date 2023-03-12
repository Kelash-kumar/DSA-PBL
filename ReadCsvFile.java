import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

  class  ReadCsvFile {

  static  Pakistani_Universities[] pakis_univrsty_Obj = new Pakistani_Universities[100];// array which store the 100 object of pakistani universites
   static String[] Universities = new String[100];  // this array file store the data from csv file
    public static Hashtable<String, Pakistani_Universities> pakis_univ_HashTable = new Hashtable<>();  // hashtable use for storing the key and object of pakistani unverites


public static void ReadCvs_File() {
    
    try (BufferedReader bf = new BufferedReader(
        new FileReader("C:/Users/kelas//Desktop/DSA-PBL/Top 100 Unis of Pakistan.csv"))) {  //reading the csv file of universities data;
      BufferedReader brr = new BufferedReader(new FileReader("C:/Users/kelas/Desktop/DSA-PBL/Universities keys.txt"));  //reading the txt file of universities keys

      String line = "";// for csv
      String keys = "";
      int i = 0;
      while ((line = bf.readLine()) != null) {
        try {
          keys = brr.readLine(); //for keys

          Universities = line.split(","); // string array of universities;

        } catch (Exception e) {}

        String Uni_Name = Universities[0];
        int world_rank = Integer.parseInt(Universities[1]);
        int asia_rank = Integer.parseInt(Universities[2]);
        int pakistan_rank = Integer.parseInt(Universities[3]);
        String city = Universities[4];
        String province = Universities[5];
        int Nubr_publication = Integer.parseInt(Universities[6]);


        pakis_univrsty_Obj[i] = new Pakistani_Universities(Uni_Name, world_rank, asia_rank,
            pakistan_rank, city, province, Nubr_publication);  // creating the pakistani universities object;

        
        pakis_univ_HashTable.put(keys, pakis_univrsty_Obj[i]);
        
      }

      // end with creating object of uiversity and also put to hashtable ;
    
      
    int a = 0;
    for (Map.Entry m : pakis_univ_HashTable.entrySet()) {
      // System.out.println(m.getKey()+" = "+m.getValue().toString());
           Stack_Universities.university_stack_publication_array[a][0] = m.getKey().toString();
           Stack_Universities.university_stack_publication_array[a][1] = String
          .valueOf(pakis_univ_HashTable.get(m.getKey()).Nubr_publication);
          Stack_Universities.university_stack_rank_array[a][0] = m.getKey().toString();
          Stack_Universities.university_stack_rank_array[a][1] = String
          .valueOf(pakis_univ_HashTable.get(m.getKey()).pakistan_rank);
      a++;
    }

    // array which store in order of ranking:
    // int t=0;
    // for (Map.Entry m : pakis_univ_HashTable.entrySet()) {
    //   // System.out.println(m.getKey()+" = "+m.getValue().toString());
    //  t++;
    // }


// now we make the sorted array with number of publications:
    // Arrays.sort(Stack_Universities.university_stack_publication_array,
    //     Comparator.comparingInt((String[] q) -> Integer.parseInt(q[1])).reversed());
    // // for (int j = 0; j < 100; j++) {
    // //   System.out.print(Stack_Universities.university_stack_publication_array[j][0] + " = ");
    // //   System.out.println(Stack_Universities.university_stack_publication_array[j][1]);
    // // }

    } catch (IOException e) {

      e.printStackTrace();
    }


}

// public static void Add_uni_obj_to_stack(){
// ReadCvs_File();
//     // Arrays.sort(Stack_Universities.university_stack_publication_array, Comparator.comparingInt(q -> q[1]));

// Arrays.sort(Stack_Universities.university_stack_publication_array,
//         Comparator.comparingInt((String[] q) -> Integer.parseInt(q[1])));
//     for (int j = 0; j < 100; j++) {
//       Stack_Universities.push(Stack_Universities.university_stack_publication_array[j][0]);
//       System.out.print(Stack_Universities.university_stack_publication_array[j][0] + " = ");
//       System.out.println(Stack_Universities.university_stack_publication_array[j][1]);
//     }
// }

// public static void Add_uni_obj_to_stack_in_rank(){
//   // ReadCvs_File();
//   // Arrays.sort(Stack_Universities.university_stack_publication_array, Comparator.comparingInt(q -> q[1]));

// Arrays.sort(Stack_Universities.university_stack_rank_array,
//       Comparator.comparingInt((String[] q) -> Integer.parseInt(q[1])));
//   for (int j = 0; j < 100; j++) {
//     Stack_Universities.push(Stack_Universities.university_stack_rank_array[j][0]);
//     // System.out.print(Stack_Universities.university_stack_rank_array[j][0] + " = ");
//     // System.out.println(Stack_Universities.university_stack_rank_array[j][1]);
} 

// }
  // }
