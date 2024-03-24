package DSA.DIVIDE_CONQ;

/*
*   House Robber Problem
*   Given a list of non-negative integers representing the amount of money of each house,
*   determine the maximum amount of money you can rob tonight without alerting the police.
*   The robber can not rob two adjacent houses at the same time else the police will be alerted.
* */


class Robber{
    int [] houses;
    Robber(int [] houses){
        this.houses = houses;
    }
    public int maxRob(int n){
        if(n<0){
            return 0;
        }
        int rob = houses[n] + maxRob(n-2);
        int notRob = maxRob(n-1);
        return Math.max(rob,notRob);
    }

    public void findMax(){
        int max = maxRob(houses.length-1);
        System.out.println("Maximum amount that can be robbed="+max);
    }
}


public class House_Robber {
    public static void main(String[] args) {
        int [] houses = {1,2,3,1,5,6,7,8,9,10};
        for(int i=0 ; i<houses.length ; i++){
            System.out.print("house " + i + " : " + houses[i] + "\n");
        }
        Robber robber = new Robber(houses);
        robber.findMax();
    }
}
