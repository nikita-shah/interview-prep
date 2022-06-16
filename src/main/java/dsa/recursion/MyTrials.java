package dsa.recursion;


public class MyTrials {

    public static int count = 0;

    /*
    takeaway ->if you want some change to a variable to persist across recursive push and pop
    make the change to a gloabal variable not local
    even if the local variable is a pass by reference,
    variable value in the current functions value gets stored in the call stack during push
    and the same value that was stored in push get retrieved in pop,
    so in the mean while if you changed the value in some depth of call it would not reflect after the depth
     */
    public static void tryRecInputValues(Integer A, int a)
    {
        count++;
        if(A==5||a==5)
            return;
        System.out.println("Before rec  : A : "+A+" a : "+a +" count : "+count);
        tryRecInputValues(A+1,a+1);
        System.out.println("After recursive t : A : "+A+" a : "+a+" count : "+count);
    }

    /*
takeaway -> same Integer and i when changed inside an object get reflected through recursion.
so object is always passed by reference.
 */
    public static void tryRecObj(Info i)
    {

        if(i.A==5)
            return;
        System.out.println("Before rec i : A : "+i.A+" a : "+i.a +" count : "+count);
        i.a = i.a-1;
        i.A = i.A-1;
        tryRecObj(i);
        System.out.println("After recursive i : A : "+i.A+" a : "+i.a+" count : "+count);
    }

    /*
      Integer are not really passed by reference, it is passed by value.
      just like int.. why ... read more.
     */
    public static void tryPassByRefByVAl(Integer A, int a)
    {
        A=A-1;
        a=a-1;
        System.out.println("Inside tryPassByRefByVAl A : "+A+" a: "+a);
    }

    public static void main(String args[])
    {
        tryRecInputValues(1,1);

        Integer A = 10;
        int a = 10;
        tryPassByRefByVAl(A,a);
        System.out.println("after func call tryPassByRefByVAl  A : "+A+" a : "+a);

        Info i = new Info(A,a);
        tryPassByObj(i);
        System.out.println("after tryPassByObj A : "+i.A+" a : "+i.a);

        tryRecObj(i);
    }

    public static void tryPassByObj(Info i)
    {
      i.a = i.a -1;
      i.A = i.A -1;
      System.out.println("In tryPassByObj A : "+i.A+" a: "+i.a);
    }
}

class Info{
    int a ;
    Integer A;
    Info(Integer A,int a)
    {
        this.a = a;
        this.A = A;
    }
}
