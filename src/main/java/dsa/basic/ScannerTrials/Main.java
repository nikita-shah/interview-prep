package dsa.basic.ScannerTrials;

public class Main{
    public static void main(String[] args) {
        ClassB b = new ClassB();
        b.show();
        ClassB.methodA();
    }
}
 class ClassA {
     ClassA()
    {
        System.out.println("Class A constructor with no argumnets!");
    }
    protected  void show()
    {
        System.out.println("class A show");
    }

     public static void methodA() {
         System.out.println("class A method");
     }

}

class ClassB extends ClassA{
     ClassB() {
         System.out.println("Class B constructor with no arguments!");
         String record = "";
         String[] inputs = record.split(",");
     }
    public  void show()
    {
        System.out.println("class B show");
        super.show();
    }
    public static void methodA() {
        System.out.println("class B method");
    }
}
