
public class Pakistani_Universities {

    String Uni_Name;
    int world_rank;
    int asia_rank;
    int pakistan_rank;
    String city;
    String province;
    long Nubr_publication;
    static boolean b = true;

    Pakistani_Universities(String uni_name, int world_rank, int asia_rank, int pakistan_rank, String city,
            String province, int Nubr_publication) {
        this.Uni_Name = uni_name;
        this.world_rank = world_rank;
        this.asia_rank = asia_rank;
        this.pakistan_rank = pakistan_rank;
        this.city = city;
        this.province = province;
        this.Nubr_publication = Nubr_publication;
    }

    public String toString() {
        if (b)
            System.out.println(String.format("%-10s%-40s%-20s%-20s%-20s%-20s%s", " Keys : ", " University Name ",
                    " World Rank ", " Asia Rank ", "Pak-Rank", " City ", " Province ", " number Publication "));
        b = false;
        return "[ " + this.Uni_Name + "] [" + this.world_rank + "] [" + this.asia_rank
                + "] [" + this.pakistan_rank + "] [" + this.city
                + "] [" + this.province + "] [" + this.Nubr_publication + " ]";

        // return String.format("%-40s%-20s%-20s%-20s%-20s%-20s%s", this.Uni_Name,
        // this.world_rank, this.asia_rank,
        // this.pakistan_rank, this.city, this.province, this.Nubr_publication);

    }

}
