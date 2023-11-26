package DSA.GREEDY_ALGO;

class Changes{
    int coins[] = {1,2,5,10,20,50,100,500,1000};
    int coin = 0;
    void Changes(int amount){
        int n = coins.length;
        for(int i=n-1 ; i>=0 ; i--){
            while(amount>=coins[i]){
                amount-=coins[i];
                System.out.print(coins[i] + " ");
                coin ++;
            }
        }
        System.out.println("\nTotal Coins : " + coin);
    }
}




public class Coin_Change_Problem {
    public static void main(String[] args) {
        Changes changes = new Changes();
        changes.Changes(70);
    }
}
 