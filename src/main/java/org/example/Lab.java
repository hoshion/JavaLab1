package org.example;

public class Lab {
    public final int cardNumber = 1130;

    private final int C2 = cardNumber % 2; // 0
    private final int C3 = cardNumber % 3; // 2
    private final int C5 = cardNumber % 5; // 0

    public Lab() {}

    public double calc(long a, long b, long n, long m) {
        try {
            Operator op1 = this.getFirstOperator(this.C2);
            Operator op2 = this.getSecondOperator(this.C5);

            double sum = 0;
            for (long i = a; i <= n; i++) {
                double innerSum = 0;
                for (long j = b; j <= m; j++) {
                    double shared = this.makeOperation(i, j, op2);
                    double divider = this.makeOperation(i, this.C3, op1);
                    innerSum += shared / divider;
                }
                sum += innerSum;
            }

            return sum;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        return 0;
    }

    public Operator getFirstOperator(int number) throws Exception {
        return switch (number) {
            case 0 -> Operator.PLUS;
            case 1 -> Operator.MINUS;
            default -> throw new Exception("Wrong reminder for the first operator");
        };
    }

    public Operator getSecondOperator(int number) throws Exception {
        return switch (number) {
            case 0 -> Operator.MULTIPLY;
            case 1 -> Operator.DIVIDE;
            case 2 -> Operator.REMINDER;
            case 3 -> Operator.PLUS;
            case 4 -> Operator.MINUS;
            default -> throw new Exception("Wrong reminder for the second operator");
        };
    }

    public double makeOperation(long a, long b, Operator op) {
        return switch (op) {
            case PLUS -> (double)(a + b);
            case MINUS -> (double)(a - b);
            case DIVIDE -> (double)(a) / (double)(b);
            case MULTIPLY -> (double)(a) * (double)(b);
            case REMINDER -> (double)(a) % (double)(b);
        };
    }
}
