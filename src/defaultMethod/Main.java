package defaultMethod;

public class Main {
    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        myClass.defaultMethod();
        myClass.otherMethod();

        MyClass2 myClass2 = new MyClass2();
        myClass2.defaultMethod();
        myClass2.otherMethod();
    }
}
