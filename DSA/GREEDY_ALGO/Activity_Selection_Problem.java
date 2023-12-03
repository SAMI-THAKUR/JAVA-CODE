package DSA.GREEDY_ALGO;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;



/*
*   Activity Selection Problem
*   Given N activities with their start and finish times.
*   Select the maximum number of activities that can be performed by a single person,
* */
class Activity {
    int start;
    int end;
    Activity(int start , int end){
        this.start = start;
        this.end = end;
    }
}

class Max_Activity {
    ArrayList<Activity> activities = new ArrayList<>();
    Max_Activity(ArrayList<Activity> activities){
        this.activities = activities;
    }

    public static void maxActivities(ArrayList<Activity> activities){
        Comparator<Activity> cmp = new Comparator<Activity>() {
            @Override
            public int compare(Activity o1, Activity o2) {
                return o1.end - o2.end;
            }
        };
        Collections.sort(activities,cmp); // sort by end time of activity in ArrayList
        int count = 0;
        int lastEnd = 0;
        for (Activity activity : activities) {
            if (activity.start >= lastEnd) {
                count++;
                lastEnd = activity.end;
            }
        }
        System.out.println("\t\t\t start end");
        for(Activity a : activities){
            System.out.println("Activity-"+ activities.indexOf(a) + " --> "+ a.start + "\t" + a.end);
        }
        System.out.println("Maximum Activities : " + count);
    }

}

class Activity_Selection_Problem{
    public static void main(String[] args) {
        ArrayList<Activity> activities = new ArrayList<>();
        activities.add(new Activity(1,2));
        activities.add(new Activity(3,4));
        activities.add(new Activity(0,6));
        activities.add(new Activity(5,7));
        activities.add(new Activity(8,9));
        activities.add(new Activity(5,9));
        Max_Activity.maxActivities(activities);
    }
}
