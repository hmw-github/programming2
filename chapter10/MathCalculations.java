package programming2.chapter10;

@FunctionalInterface
interface MathOp {
    int calculate(int operand1, int operand2);
}

public class MathCalculations {
    private static int compute(int operand1, int operand2, 
            MathOp operator) {
    	return operator.calculate(operand1, operand2); // TODO
    }

    public static void main(String[] args) {
        // TODO: define lambdas for "add" and "mult"
        MathOp add = (o1, o2) -> o1 + o2;
        
        // variable def. with init.: <type> <name> = <init expr.>;
        
        MathOp mult = (o1, o2) -> o1 * o2;
        
        System.out.printf("%d + %d = %d\n", 3, 4, compute(3, 4, add));
        System.out.printf("%d * %d = %d\n", 3, 4, compute(3, 4, mult));
        System.out.printf("%d / %d = %d\n", 33, 4, compute(33, 4, (a, b) -> a / b));
    }
}
