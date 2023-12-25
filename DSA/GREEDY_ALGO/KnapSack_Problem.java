package DSA.GREEDY_ALGO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;



class Items{
    int weight ;
    int value ;
    Items(int weight , int value){
        this.weight = weight;
        this.value = value;
    }
}
class Max_Value{
    ArrayList<Items> items = new ArrayList<>();
    int capacity;
    Max_Value(ArrayList<Items> items, int capacity){
        this.items = items;
        this.capacity = capacity;
    }

    public void max_value(){
        Comparator<Items> cmp = new Comparator<Items>() {
            @Override
            public int compare(Items o1, Items o2) {
                return (o2.value/o2.weight) - (o1.value/o1.weight);
            }
        };
        Collections.sort(items,cmp);
        int totalValue = 0;
        for(Items item : items){
            int curWeight = (int)item.weight;
            int curValue = (int)item.value;
            if(capacity-curWeight>=0){
                capacity-=curWeight;
                totalValue+=curValue;
            }else{
                double fraction = ((double)capacity/(double)curWeight);
                totalValue+=(curValue*fraction);
                capacity-=(curWeight*fraction);
                break;
            }
        }
        System.out.println("Total Value : " + totalValue);
        System.out.println("Remaining Capacity : " + capacity);

    }
}



public class KnapSack_Problem {
    public static void main(String[] args) {
        ArrayList<Items> items = new ArrayList<>();
        items.add(new Items(10,60));
        items.add(new Items(40,40));
        items.add(new Items(20,100));
        items.add(new Items(30,120));
        for(Items item : items){
            System.out.println("Weight : " + item.weight + " Value : " + item.value);
        }
        Max_Value max_value = new Max_Value(items,50);
        max_value.max_value();
    }
}
