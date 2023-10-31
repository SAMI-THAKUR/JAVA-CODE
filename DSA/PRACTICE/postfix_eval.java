package DSA.PRACTICE;
class StackE {
    int top;
    int size;
    int[] arr;

    StackE(int size) {
        this.size = size;
        arr = new int[size];
        top = -1;
    }

    public void push(int data) {
        if (top == size - 1) {
            System.out.println("Stack is full");
            return;
        }
        top++;
        arr[top] = data;
    }

    public int pop() {
        if (top == -1) {
            System.out.println("Stack is empty");
            return 0;
        }
        int temp = arr[top];
        top--;
        return temp;
    }
    public boolean isEmpty(){
        if(top==-1){
            return true;
        }
        return false;
    }
}
public class postfix_eval {
    public static int operation(int p1 , int p2 , char op){
        if(op=='+'){
            return p2+p1;
        } else if (op=='-') {
            return p2-p1;
        } else if (op=='*') {
            return p2*p1;
        } else if (op=='/') {
            return p2/p1;
        }else if (op=='%'){
            return p2%p1;
        } else if (op=='^') {
            return (int) Math.pow(p2,p1);
        }

        return -1;
    }
    public static int eval(String eq){
        StackE s = new StackE(10);
        for(int i=0 ; i<eq.length() ; i++){
           if(eq.charAt(i)>=48 && eq.charAt(i)<=57){
               s.push(eq.charAt(i)-'0');
           }
           else {
               int p1 = s.pop();
               int p2 = s.pop();
               int op = operation(p1,p2,eq.charAt(i));
               s.push(op);
           }
        }
        return (s.pop());
    }
    public static void main(String[] args) {
        System.out.println(eval("322^+"));


    }
}
