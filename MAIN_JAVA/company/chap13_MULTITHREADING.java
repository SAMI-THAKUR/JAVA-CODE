package MAIN_JAVA.company;

           //  @@ creating thread bt extending thread class  @@  //
class mythread extends Thread
{
    @Override
public void run()
{  int i=0;

        System.out.println("my thread is running");
        System.out.println("I am happy");
}
}
  class mythread2 extends Thread
    {
    @Override
    public void run()
    {

            System.out.println("my thread 2 is running");
            System.out.println("I am sad");


    }
}

          //   @@  CREATING THREAD MY IMPLEMENTING RUNNABLE INTERFACE  @@  //
//  USING RUNNABLE INTERFACE IS SLIGHTLY LONG
class mythread3 implements Runnable
{
    public void run()
    {
        System.out.println("thread3 through runnable interface");
    }
}
class mythread4 implements Runnable
{
    public void run()
    {
        System.out.println("thread4 through runnable interface");
    }

}

class mythread5 extends Thread
{
    public mythread5(String name)
    {
super(name);
    }
    public void run()
    {
        System.out.println("i am a thread");
        System.out.println("id of thread my5 is "+ getId());   // will print ID bof the thread
        System.out.println("name of thread my5 is "+ getName());   // will print name of the thread
    }

}

class mythread6 extends Thread
{
    mythread6(String name)
    {
        super(name);
    }
    public void run() {
        while (true)
        {
            System.out.println("setting priorities " + getName());
    }
    }
}

class mythread7 extends Thread
{
    public void run()
    {
        int i=0;
        while (i<5) {

            try {
                Thread.sleep(4000);   // this make the function to sleep for 2000 milliseconds
                System.out.println("methods in thread " + getName());

            }
            catch (InterruptedException e)
            {
                System.out.println("thread is interupted");
            }

            i++;

        }
    }
}


public class chap13_MULTITHREADING {
    public static void main(String[] args) {
       mythread my1 = new mythread();
        mythread2 my2 = new mythread2();
        mythread3 my3 = new mythread3();    //  my3 is like a bullet and t1 is gun and start fires bullet from gun
        Thread t1 = new Thread(my3);
        mythread4 my4 = new mythread4();       //  my4 is like a bullet and t1 is gun and start fires bullet from gun
        Thread t2 = new Thread(my4);
        mythread5 my5 = new mythread5("SAMI");


        mythread6 my6A = new mythread6("sami 1");
       mythread6 my6B = new mythread6("sami 2");
       mythread6 my6C = new mythread6("sami 3");
       mythread6 my6D = new mythread6("sami 4");

        mythread7 my7A = new mythread7();
        mythread7 my7B = new mythread7();




     //   my1.start();    //  calling thread extended class this will give some time to my1 and some time to my2
     //   my2.start();   //  threading uses concurrency principle  ****

     //   t1.start();  // thread using runnable interface
    //    t2.start();

     //   my5.start();   // thread constructor


        //    SETTING PRIORITIES   //
        // priority means how many times a function is called in infinite loop in a thread //
        my6A.setPriority(Thread.MAX_PRIORITY);
        my6B.setPriority(Thread.MIN_PRIORITY);
        my6C.setPriority(Thread.MIN_PRIORITY);
        my6D.setPriority(Thread.NORM_PRIORITY);

//        my6A.start();
//        my6B.start();
//        my6C.start();
//        my6D.start();

        my7A.start();
        my7A.interrupt();
//        try {
//           my7A.join();   //  this method runs the second function only after complete execution of first function
//        }
//       catch (Exception e)
//      {
//          System.out.println(e);
//     }
     //   my7B.start();








    }
}
