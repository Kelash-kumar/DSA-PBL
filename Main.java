import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Stack_Universities su1 = new Stack_Universities();
        Stack_Universities su2 = new Stack_Universities();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your choice ");
        System.out.println(
                " 1. Top n University by publication \n 2. Bottom n University by publication \n 3. Top n University by PakRank \n 4. bottom n University by PakRank");
        int input = sc.nextInt();

        switch (input) {
            case 1: {
                System.out.println("Enter the n number to search");
                int n = sc.nextInt();
                su1.Top_N_University_by_Publication(n);
               break;
            }
            case 2: {
                System.out.println("Enter the n number to search");
                int n = sc.nextInt();
                su1.Bottom_N_universities_by_publication(n);
                break;
            }
            case 3: {
                System.out.println("Enter the n number to search");
                int n = sc.nextInt();
                su2.Top_N_University_by_PakRank(n);
                break;
            }
            case 4: {
                System.out.println("Enter the n number to search");
                int n = sc.nextInt();
                su2.Bottom_N_universities_by_rank(n);
                break;
            }
            default: {
                System.out.println("not exist");
                break;
            }
        }

    }
}
