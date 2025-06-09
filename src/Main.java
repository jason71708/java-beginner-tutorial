import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Main.Basic();
        ControlFlow.OptimizedMortgageCalculator();
    }

    public static void Basic() {
        int age = 30, temperature = 20; // 宣告同型別多個變數用逗號一起宣告，但實務上建議分行宣告可讀性較高
        age = 45;
        System.out.println(age);
        System.out.println("Hello World"); // Snippet: s,o,u,t <Tab>
    }

    public static void PrimitiveTypesSample() {
        byte age = 30;
        int viewsCount = 123456789;
        int viewsCount2 = 123_456_789; // 可用底線分隔位數
        long viewsCount3 = 3123456789L; // 除了宣告 long 之外還需在最後加 "L"
        double price = 99999999.99;
        float price2 = 10.99F; // 除了宣告 float 之外還需在最後加 "F"
        char letter = 'A'; // 和 JS 不同，宣告 char 必定用 single quote
        boolean isOpen = false;
    }

    public static void ReferenceTypesSample() {
        Date now = new Date();
        System.out.println(now.getTime()); // 1722505760950
    }

    public static void StringsSample() {
        String message = new String("Hello World"); // 可以被簡化
        String message2 = "Hello \"Jason\""; // 字串必定用 double quote
        String message3 = "Hello World3" + "!" + '!';
        System.out.println(message2.replace("Hello", "Hi")); // Hi "Jason"
        System.out.println(message3.endsWith("!!")); // true
        // 字串操作後一定返回新字串，不影響原字串
    }

    public static void ArraysSample() {
        int[] numbers = new int[3];
        numbers[0] = 1;
        // numbers[5] = 5; error: out of boundary
        System.out.println(numbers); // [I@38af3868 -> 陣列的記憶體位置
        System.out.println(Arrays.toString(numbers)); // [1,0,0] -> 初始值皆為 0,
        System.out.println(numbers.length); // 3

        char[] chars = new char[3];
        chars[0] = 'C';
        System.out.println(Arrays.toString(chars)); // ['C','',''] -> 初始值皆為 '',

        boolean[] booleans = new boolean[5];
        booleans[1] = true;
        System.out.println(Arrays.toString(booleans)); // [false, true, false] -> 初始值皆為 false,

        int[] numbers2 = { 3, 5, 1, 2, 4 };
        Arrays.sort(numbers2);
        System.out.println(Arrays.toString(numbers2)); // [1,2,3,4,5]
    }

    public static void Multi_DimensionalArraysSample() {
        int[][] numbers = new int[2][3];
        numbers[0][0] = 1;
        System.out.println(Arrays.toString((numbers))); // [[I@a09ee92, [I@30f39991]
        System.out.println(Arrays.deepToString((numbers))); // [[1, 0, 0], [0, 0, 0]]

        int [][] numbers2 = { { 1, 2, 3 }, { 4, 5, 6 } };
        System.out.println(Arrays.deepToString((numbers2))); // [[1, 2, 3], [4, 5, 6]]
    }

    public static void ConstantsSample() {
        final float PI = 3.14F; // constants naming convention: all capital letter
        // PI = 1; error
    }

    public static void ArithmeticExpressions() {
        int result = 10 / 3;
        System.out.println(result); // 3, because of type definition
        double result2 = (double) 10 / (double) 3;
        System.out.println(result2); // 3.3333333333333335

        int x = 1;
        int y = ++x; // increment one first, and then copy to y
        System.out.println(x); // 2
        System.out.println(y); // 2

        int x2 = 5;
        int y2 = x2--; // copy to y first, and then decrement one
        System.out.println(x2); // 4
        System.out.println(y2); // 5

        int x3 = 10;
        x3 /= 2;
        System.out.println(x3); // 5

        /*
          Order of Operators
          () -> *, / -> +, -
         */
        int output = 10 + 3 * 2;
        System.out.println(output); // 16

        int output2 = (10 + 3) * 2;
        System.out.println(output2); // 26
    }

    public static void Casting() {
        // Implicit casting
        // byte > short > int > long > float > double
        short x = 1;
        int y = x + 2; // short can convert to int
        System.out.println(y); // 3

        double x2 = 1.1;
        // int y2 = x2 + 2; error: double can not convert to int
        double y2 = x2 + 2;
        System.out.println(y2); // 3.1

        double x3 = 1.22;
        int y3 = (int)x3 + (int)2.1; // convert to int, but lose fraction
        System.out.println(y3); // 3

        String x4 = "70.99";
        float y4 = Float.parseFloat(x4) + 2;
        System.out.println(y4); // 72.99
    }

    public static void MathSample() {
        int result = Math.round(1.1F);
        System.out.println(result); // 1
        // Math.ceil, Math.floor, Math.max, Math.min..., same as JavaScript

        int result2 = (int)Math.round(Math.random() * 100);
        System.out.println(result2); // random number from 0~100
        /*
         * Because casting can lose fraction, we can use:
         */
        int result3 = (int) (Math.random() * 100);
        System.out.println(result3);

        int result4 = (int) Math.random() * 100;
        System.out.println(result4); // always 0, because Math.random() casting to int first and then multiply 100
    }

    public static void FormattingNumbers() {
        //  NumberFormat currency = new NumberFormat(); 'NumberFormat' is abstract; cannot be instantiated
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        String result = currency.format(123456.789);
        System.out.println(result); // NT$123,456.79: depends on your locale

        String result2 = NumberFormat.getPercentInstance().format(0.75); // methods chaining
        System.out.println(result2); // 75%
    }

    public static void ReadingInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("age: ");
        byte age = scanner.nextByte();
        System.out.println("You are " + age + '.');

        System.out.print("name: ");
        String name = scanner.next(); // only receive one token, if you type "Jason Zhang", only get "Jason".
        System.out.println("Hi " + name + '!');

        scanner.nextLine(); // because we only scanner one token in previous process, we need to end that line.
        System.out.print("full name: ");
        String fullName = scanner.nextLine().trim();
        System.out.println("Yo " + fullName + '!');
    }

    public static void MortgageCalculator() {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Principal: ");
        float principal = scanner.nextFloat();

        System.out.print("Annual Interest Rate: ");
        float annualInterest = scanner.nextFloat();
        double monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;

        System.out.print("Period (Years): ");
        int years = scanner.nextInt();
        int numberOfPayments = years * MONTHS_IN_YEAR;

        double mortgage = principal
                * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
        System.out.println("Mortgage: " + NumberFormat.getCurrencyInstance().format(mortgage));
    }
}

// javac Main.java 編譯成二進位檔案 -> Main.class
// java Main -> 執行 Main.class
