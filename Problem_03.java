public class Problem_03 {
    public static String performance() {
      
        String x = "", y = "";
      Stack_Universities. Add_keys_by_province("sindh");
        int punjabPub = 0, sindhPub = 0, balPub = 0, kpkPub = 0, ajkPub = 0, gilgitPub = 0;
        for (int i = 1; i <= Stack_Universities.sindh_Stack.size(); i++)
        sindhPub += (ReadCsvFile.pakis_univ_HashTable.get(Stack_Universities.sindh_Stack.pop())).Nubr_publication;
        
        Stack_Universities. Add_keys_by_province("punjab");
        for (int i = 1; i <= Stack_Universities.punjab_Stack.size(); i++)
        punjabPub += (ReadCsvFile.pakis_univ_HashTable.get(Stack_Universities.punjab_Stack.pop())).Nubr_publication;
        
        Stack_Universities.  Add_keys_by_province("Balochistan");
        for (int i = 1; i <= Stack_Universities.Balochistan_Stack.size(); i++)
        balPub += (ReadCsvFile.pakis_univ_HashTable.get(Stack_Universities.Balochistan_Stack.pop())).Nubr_publication;
        
        Stack_Universities. Add_keys_by_province("KPK");
        for (int i = 1; i <= Stack_Universities.KPK_Stack.size(); i++)
        kpkPub += (ReadCsvFile.pakis_univ_HashTable.get(Stack_Universities.KPK_Stack.pop())).Nubr_publication;
        
        Stack_Universities.  Add_keys_by_province("AJK");
        for (int i = 1; i <= Stack_Universities.AJK_Stack.size(); i++)
            ajkPub += (ReadCsvFile.pakis_univ_HashTable.get(Stack_Universities.AJK_Stack.pop())).Nubr_publication;
            
            Stack_Universities.   Add_keys_by_province("Gilgit Biltistan");
            for (int i = 1; i <= Stack_Universities.GilgitB_Stack.size(); i++)
            gilgitPub += (ReadCsvFile.pakis_univ_HashTable.get(Stack_Universities.GilgitB_Stack.pop())).Nubr_publication;

        double avg1 = (double) sindhPub / Stack_Universities.sindh_Stack.size();
        double avg2 = (double) punjabPub / Stack_Universities.punjab_Stack.size();
        double avg3 = (double) balPub / Stack_Universities.Balochistan_Stack.size();
        double avg4 = (double) kpkPub / Stack_Universities.KPK_Stack.size();
        double avg5 = (double) ajkPub / Stack_Universities.AJK_Stack.size();
        double avg6 = (double) gilgitPub / Stack_Universities.GilgitB_Stack.size();
        double best, worst;
        best = Math.max(avg1, avg2);
        best = Math.max(best, avg3);
        best = Math.max(best, avg4);
        best = Math.max(best, avg5);
        best = Math.max(best, avg6);
        worst = Math.min(avg1, avg2);
        worst = Math.min(worst, avg3);
        worst = Math.min(worst, avg4);
        worst = Math.min(worst, avg5);
        worst = Math.min(worst, avg6);
        if (best == avg1)
            x = "Sindh";
        else if (best == avg2)
            x = "Punjab";
        else if (best == avg3)
            x = "Balochistan";
        else if (best == avg4)
            x = "KPK";
        else if (best == avg5)
            x = "AJK";
        else if (best == avg6)
            x = "Gilgit";
        if (worst == avg1)
            y = "Sindh";
        else if (worst == avg2)
            y = "Punjab";
        else if (worst == avg3)
            y = "Balochistan";
        else if (worst == avg4)
            y = "KPK";
        else if (worst == avg5)
            y = "AJK";
        else if (worst == avg6)
            y = "Gilgit";

        return "Best Province: " + x + "\n Worst Province: " + y;
    }


}
