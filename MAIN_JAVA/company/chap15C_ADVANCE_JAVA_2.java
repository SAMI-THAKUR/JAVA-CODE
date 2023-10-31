package MAIN_JAVA.company;
import java.io.*;
import java.util.*;

/**
 * this is my advance java code
 * **/
class MYGENERIC< T1 , T2>
{
    int value;
    private T1 t ;
    private  T2 t2 ;

    public MYGENERIC(int value , T1 t , T2 t2)
    {
        this.value = value;
        this.t2 =t2 ;
        this.t = t;
    }

    public T1 getT() {
        return t;
    }

    public void setT(T1 t) {
        this.t = t;
    }

    public T2 getT2() {
        return t2;
    }

    public void setT2(T2 t2) {
        this.t2 = t2;
    }


}
public class chap15C_ADVANCE_JAVA_2 {
    interface ano
    {
        void meth1(int a);
        //        void meth2();
    }


    public static void main(String[] args) throws FileNotFoundException {


        // @@  ANONYMOUS CLASS @@  //
        ano an = new ano() {
            @Override
            public void meth1(int a) {
                System.out.println("THIS IS CALLED THROUGH ANONYMOUS CLASS " + a);
            }

//            @Override
//            public void meth2() {
//                System.out.println("i am meth2");
//            }
        };
        an.meth1(14);

        //  @@  LAMBDA EXPRESSION  @@  //
        // This is used to call interface with single method
        ano LA = (int a)->{
            System.out.println("THIS IS CALLED THROUGH LAMBDA CLASS " + a);
        };
        LA.meth1(12);

        // @@ GENERICS @@ //
        // similar to templates in C++ //

        ArrayList arl = new ArrayList();
        arl.add(14);
        arl.add(16);
        arl.add("SAMI");
        arl.add("a");

        int a = (int) arl.get(1);
        System.out.println(a);
        System.out.println(arl.get(3));

        MYGENERIC<String , Integer> mg = new MYGENERIC<>(23 , "hi guys ",22);
        String str = mg.getT();
        int i = mg.getT2();
        System.out.println(str + i + mg.value);




        //  @@  FILE HANDLING  @@  //
        //    --> creating file
        File fw =  new File("SAMI.txt");
        try {
            fw.createNewFile();

        }catch (Exception e)
        {
            System.out.println("unable to create file");
            e.printStackTrace();
        }

        //   --> write in file
        try {
            FileWriter fw1 = new FileWriter("SAMI.txt");
            fw1.write("this is my first class ");

            fw1.write("\n hi guys how are u my name sami ");
            fw1.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // --> READING A FILE CLASS
        File myFile = new File("SAMI.txt");
        try {

            Scanner sc1 = new Scanner(myFile);
            while(sc1.hasNextLine()){
                String line = sc1.nextLine();
                System.out.println(line);
            }
            sc1.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

           // ANOTHER WAY OF READING FILE //
        try {
            FileReader fr = new FileReader("SAMI@.txt");
            int data = fr.read();
            while (data!=-1)
            {
                System.out.print((char)data);
                data = fr.read();
            }
            fr.close();
        }
        catch (Exception e)
        {
            System.out.println(e);
        }


        // --> deleting a file
        if (myFile.delete())
        {
            System.out.println( myFile.getName() + " file is deleted");
        }
        else
        {
            System.out.println("error 101");
        }



    }

}
