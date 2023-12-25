package DSA.Divide_Conqueror_ALGO;

import java.util.ArrayList;

// Zero Knapsack
// --> in this algo we have to find the maximum profit we can get by taking the
// --> items in the knapsack such that the weight of the knapsack is less than or equal to the capacity of the knapsack
// --> we cannot take the fraction of the items

class Item{
    int profit;
    int weight;
    Item(int profit , int weight){
        this.profit = profit;
        this.weight = weight;
    }
}
class Z_One_KnapSack{
    ArrayList<Item> items = new ArrayList<>();
    int capacity;
    Z_One_KnapSack(int capacity , ArrayList<Item> items){
        this.items = items;
        this.capacity = capacity;
    }
    private int knapSack(ArrayList<Item>  items, int capacity , int index){
        if(capacity<=0 || index>=items.size()) return 0;
        int profit1 = 0;
        int profit2 = 0;
        // profit 1 means we are taking the current item
        // profit 2 means we are not taking the current item
        if(items.get(index).weight<=capacity){
            profit1 = items.get(index).profit + knapSack(items,capacity-items.get(index).weight,index+1);
            profit2 =  knapSack(items,capacity,index+1);
        }
        return Math.max(profit1,profit2);
    }

    public void knapSack(){
        for(Item item : items){
            System.out.println("Profit : " + item.profit + " Weight : " + item.weight);
        }
        System.out.println();
        System.out.println("Capacity : " + capacity);
        System.out.println("Max Profit : "+ knapSack(items,capacity,0));

    }
}

public class Zero_Knapsack {
    public static void main(String[] args) {
        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item(60,10));
        items.add(new Item(40,40));
        items.add(new Item(100,20));
        items.add(new Item(120,30));
        int capacity = 70;
        Z_One_KnapSack z = new Z_One_KnapSack(capacity, items);
        z.knapSack();
    }
}
