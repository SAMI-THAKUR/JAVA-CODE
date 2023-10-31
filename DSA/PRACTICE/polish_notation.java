package DSA.PRACTICE;

class StackC{
    int top;
    int size;
    char [] arr;
    StackC(int size){
        this.size = size;
        arr = new char[size];
        top = -1;
    }
    public void push(char data){
        if(top==size-1){
            System.out.println("Stack is full");
            return;
        }
        top++;
        arr[top] = data;
    }
    public char pop(){
        if(top==-1){
            System.out.println("Stack is empty");
            return '0';
        }
        char temp = arr[top];
        top--;
        return temp;
    }
    public char peek(){
        if(top==-1){
            System.out.println("Stack is empty");
            return '0';
        }
        return arr[top];
    }
    public boolean isEmpty(){
        if(top==-1){
            return true;
        }
        return false;
    }
    public boolean isFull(){
        if(top==size-1){
            return true;
        }
        return false;
    }
    public void display(){
        for(int i=0;i<=top;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println("");
    }
}

public class polish_notation {
    public static int precedence(char c){
        if(c=='+' || c=='-'){
            return  1;
        }
        else if(c=='*' || c=='/' || c=='%' ){
            return 2;
        }
        else if(c=='^'){
            return 3;
        }
        else if(c=='(' || c==')'){
            return -1;
        }
        return -1;
    }
    public static String infix_postfix(String s){
        s = s + ")";
        StackC s2 = new StackC(15);
        s2.push('(');
        String ans = "";
        char c []  = s.toCharArray();
        for(int i=0 ; i<c.length ; i++) {
            // adding element to ans string if it is a operand or character //
            if ((c[i] >= 'a' && c[i] <= 'z') || (c[i] >= 'A' && c[i] <= 'Z')) {
                ans = ans + c[i];
            } else if (c[i] == '(') {      /// left paranthesis added //
                s2.push(c[i]);
            } else if (c[i] == ')') {         /// if  right paranthesis pop //
                char r = s2.peek();
                while (r != '(') {
                    ans = ans + s2.pop();
                    r = s2.peek();
                }
                s2.pop();
            } else if (c[i] == '+' || c[i] == '-' || c[i] == '*' || c[i] == '/' || c[i]=='^' || c[i]=='%') {
                if (precedence(c[i]) > precedence(s2.peek())) {
                    s2.push(c[i]);
                } else if (precedence(c[i]) <= precedence(s2.peek())) {
                    while (precedence(c[i]) <= precedence(s2.peek())) {
                        ans = ans + s2.pop();
                    }
                    s2.push(c[i]);
                }
            }
        }
         return ans ;
    }

    public static StringBuilder infix_prefix(String s){
        String c = "(" + s;
        StackC s3 = new StackC(15);
        s3.push(')');
        String ans = "";
        char p [] = c.toCharArray();
        for (int i=p.length-1 ; i>=0; i--) {
           if ((p[i]>='a' && p[i]<='z') || (p[i]>='A' && p[i]<='Z')){
               ans = ans + p[i];
           }else if (p[i]==')') {      /// right paranthesis added //
               s3.push(p[i]);
           }else if(p[i]=='('){         /// if  left paranthesis pop //
               char r = s3.peek() ;
               while (r!=')'){
                   ans = ans + s3.pop();
                   r = s3.peek();
               }
               s3.pop();
           }else{
               if(precedence(p[i])>=precedence(s3.peek())){
                   s3.push(p[i]);
               }
               else if (precedence(p[i])<precedence(s3.peek())){
                   while (precedence(p[i])<precedence(s3.peek())){
                       ans = ans + s3.pop();
                   }
                   s3.push(p[i]);
               }
           }
        }
        StringBuilder ans1 = new StringBuilder();
        ans1.append(ans);
        return ans1.reverse();
    }
    public static void main(String[] args) {
        String eq = "(a+b)*c/d%e^(f-g)";
        String eq2 = "p+q^d-e/f";
        String eq3 = "K+L-M*N+(O^P)*W/U/V*T+Q";
        System.out.println("Infix");
        System.out.println(eq3);
        System.out.println("Postfix");
        System.out.println(infix_postfix(eq3));
        System.out.println("Prefix");
        System.out.println(infix_prefix(eq3));

    }
}
