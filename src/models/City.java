package models;

import java.util.List;

public class City {
     private String name;
     private List<String> demandedGoods;

     public City(String name, List<String> demandedGoods){
         this.name = name;
         this.demandedGoods = demandedGoods;
     }

    public String getName() {
        return name;
    }

    public List<String> getDemandedGoods() {
        return demandedGoods;
    }
}
