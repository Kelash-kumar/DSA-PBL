import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    Main() {
        ReadCsvFile.add_Keys_by_province();
    }

    static ArrayList<String> Sindh = new ArrayList<>();
    static ArrayList<String> Punjab = new ArrayList<>();
    static ArrayList<String> Balochistan = new ArrayList<>();
    static ArrayList<String> KPK = new ArrayList<>();

    public static void main(String[] args) {
        // Main main=new Main();

        Stack_Universities su = new Stack_Universities();
        Stack_Universities su1 = new Stack_Universities();
        Scanner sc = new Scanner(System.in);
        System.out.println("\n\n\n == >  Enter your choice <== ");
        System.out.println(
                " 1. search A university by providing (key) \n 2.  Top n universties with orderby \n 3. Bottom n University with orderBy   \n 4. Top universities by province ");
        int input = sc.nextInt();

        switch (input) {
            case 1: {
                System.out.println("Enter the KEY of university you searched for :");
                String str = sc.nextLine();
                str = sc.nextLine();
                System.out.println(
                        ReadCsvFile.pakis_univ_HashTable.get(str).toString());
                break;
            }

            case 2: {
                System.out.println("Enter (n)  HowMany TOP  University data You Searched :");
                int i = sc.nextInt();
                System.out.println("Enter on what basis : your choice");
                System.out.println(" 1. numberofpublication \n 2. pakistan Rank \n 3. Word rank \n 4. Asia Rank");
                int orderby = sc.nextInt();

                switch (orderby) {
                    case 1: {
                        su.Top_n_UniversityBy("numberofpublication", i);
                        break;
                    }
                    case 2: {
                        su.Top_n_UniversityBy("pakistanRank", i);
                        break;
                    }
                    case 3: {
                        su.Top_n_UniversityBy("WorldRank", i);
                        break;
                    }
                    case 4: {
                        su.Top_n_UniversityBy("AsiaRank", i);
                        break;
                    }
                    default: {
                        System.out.println("wrong input ");
                        break;
                    }
                }

            }
                break;

            case 3: {
                System.out.println("Enter (n)  HowMany Bottom  University data You Searched :");
                int i = sc.nextInt();
                System.out.println("Enter on what basis : your choice");
                System.out.println(" 1. numberofpublication \n 2. pakistan Rank \n 3. Word rank \n 4. Asia Rank");
                int orderby = sc.nextInt();

                switch (orderby) {
                    case 1: {
                        su.Bottom_n_UniversityBy("numberofpublication", i);
                        break;
                    }
                    case 2: {
                        su.Bottom_n_UniversityBy("pakistanRank", i);
                        break;
                    }
                    case 3: {
                        su.Bottom_n_UniversityBy("WorldRank", i);
                        break;
                    }
                    case 4: {
                        su.Bottom_n_UniversityBy("AsiaRank", i);
                        break;
                    }
                    default: {
                        System.out.println("wrong input ");
                        break;
                    }
                }
                break;
            }
            case 4: {
                System.out.println("Enter (n)  HowMany Top  University data You Searched by provinced wise :");
                int i = sc.nextInt();
                System.out.println("Enter on what province basis : your choice");
                System.out.println(" 1. Sindh \n 2. Punjab \n 3. Balochistan \n 4. KPK");
                int orderby = sc.nextInt();

                switch (orderby) {
                    case 1: {
                        su.Top_n_Sindh_Universities("sindh", i);
                        break;
                    }
                    case 2: {
                        su.Top_n_Punjab_Universities("punjab", i);
                        break;
                    }
                    case 3: {
                        su.Top_n_Balochistan_Universities("Balochistan", i);
                        break;
                    }
                    case 4: {
                        su.Top_n_KPK_Universities("KPK", i);
                        break;
                    }
                    default: {
                        System.out.println("wrong input ");
                        break;
                    }
                }

                break;
            }

            default: {
                System.out.println("not exist");
                break;
            }
        }

    }
}
