package defaultMethod;

public class MyClass implements Interface{

    @Override
    public void defaultMethod() {
        System.out.println("My Custom Default Method");
    }

    @Override
    public void otherMethod() {
        System.out.println("Other Method");
    }
}
