import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

  class  ReadCsvFile {
 

  static  Pakistani_Universities[] pakis_univrsty_Obj = new Pakistani_Universities[100];// array which store the 100 object of pakistani universites
   static String[] Universities = new String[100];  // this array file store the data from csv file
   static String[] UniversitiesKeys = new String[100];  // this array file store the data from csv file
    public static Hashtable<String, Pakistani_Universities> pakis_univ_HashTable = new Hashtable<>();  // hashtable use for storing the key and object of pakistani unverites


public static void ReadCvs_File() {
    
    try (BufferedReader bf = new BufferedReader(
        new FileReader("C:/Users/kelas//Desktop/DSA-PBL/Top 100 Unis of Pakistan.csv"))) {  //reading the csv file of universities data;
      BufferedReader brr = new BufferedReader(new FileReader("C:/Users/kelas/Desktop/DSA-PBL/Universities keys.txt"));  //reading the txt file of universities keys

      String line = "";// for csv
      String keys = "";
      int i = 0;
      int j=0;
      while ((line = bf.readLine()) != null) {
        try {
          keys = brr.readLine(); //for keys
            UniversitiesKeys[j]=keys.toString();
          Universities = line.split(","); // string array of universities;
j++;
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
      // adding in publication array 
           Stack_Universities.university_stack_publication_array[a][0] = m.getKey().toString();
           Stack_Universities.university_stack_publication_array[a][1] = String
          .valueOf(pakis_univ_HashTable.get(m.getKey()).Nubr_publication);
          
          //adding in pakistan rank array:
          Stack_Universities.university_stack_Pakrank_array[a][0] = m.getKey().toString();
          Stack_Universities.university_stack_Pakrank_array[a][1] = String
          .valueOf(pakis_univ_HashTable.get(m.getKey()).pakistan_rank);

          //adding in worldrank 
          Stack_Universities.university_stack_WorldRank_array[a][0] = m.getKey().toString();
          Stack_Universities.university_stack_WorldRank_array[a][1] = String
          .valueOf(pakis_univ_HashTable.get(m.getKey()).world_rank);
          
          //adding in asia rank array:
          Stack_Universities.university_stack_AsiaRank_array[a][0] = m.getKey().toString();
          Stack_Universities.university_stack_AsiaRank_array[a][1] = String
          .valueOf(pakis_univ_HashTable.get(m.getKey()).asia_rank);


         
          
      a++;
    }


    } catch (IOException e) {
      e.printStackTrace();
    }
}

public static void add_Keys_by_province(){
 
  ReadCvs_File();
  for(String s:UniversitiesKeys){
   
String provice=pakis_univ_HashTable.get(s).province.toString();
    if(provice.equalsIgnoreCase("Sindh"))
    Main.Sindh.add(s);
   else if(provice.equalsIgnoreCase("Punjab"))
    Main.Punjab.add(s);
   else if(provice.equalsIgnoreCase("Balochistan"))
    Main.Balochistan.add(s);
   else if(provice.equalsIgnoreCase("KPK"))
    Main.KPK.add(s);
  }

}
public static void main(String[] args) {
  // Stack_Universities s=new Stack_Universities();
  
  
}
} 