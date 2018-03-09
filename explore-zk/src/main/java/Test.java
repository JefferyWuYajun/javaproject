/**
 * @author wyj40124
 * @version Id: Test, v 0.1 2018/3/2 11:12 wyj40124 Exp $
 */
public class Test {
    public static void main(String[] args) {
        int result;

        result = foo();
        System.out.println(result); /////////2

        result = bar();
        System.out.println(result); /////////2
    }

    @SuppressWarnings("finally")
    public static int foo() {
        try {
            int a = 5 / 0;
            return 10;
        } catch (Exception e) {
            return 1;
        } finally {
            return 2;
        }

    }

    @SuppressWarnings("finally")
    public static int bar() {
        try {
            return 3;
        } finally {
            return 4;
        }
    }
}