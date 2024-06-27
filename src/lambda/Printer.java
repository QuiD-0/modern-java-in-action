package lambda;

@FunctionalInterface
public interface Printer {
    void print(String message);

    class StandardPrinter implements Printer {
        @Override
        public void print(String message) {
            System.out.println(message);
        }
    }

    class ErrorPrinter implements Printer {
        @Override
        public void print(String message) {
            System.err.println(message);
        }
    }
}
