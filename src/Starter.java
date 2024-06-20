public class Starter {
    //Задача 1.6.4

    public static void main(String[] intArgs) {
        FracOperations.Fraction fraction1 = new FracOperations.Fraction(3, 4);
        FracOperations.Fraction fraction2 = new FracOperations.Fraction(2, 5);
        FracOperations.Fraction fraction3 = new FracOperations.Fraction(5, 7);

        // Пример сложения
        FracOperations.Fraction resultAdd = fraction1.sum(fraction2);
        System.out.println(fraction1 + " + " + fraction2 + " = " + resultAdd);  // Ожидаемый вывод: 23/20

        // Пример вычитания
        FracOperations.Fraction resultSubtract = fraction1.minus(fraction2);
        System.out.println(fraction1 + " - " + fraction2 + " = " + resultSubtract);  // Ожидаемый вывод: 7/20

        // Пример умножения
        FracOperations.Fraction resultMultiply = fraction1.multiply(fraction2);
        System.out.println(fraction1 + " * " + fraction2 + " = " + resultMultiply);  // Ожидаемый вывод: 3/10

        // Пример деления
        FracOperations.Fraction resultDivide = fraction1.div(fraction2);
        System.out.println(fraction1 + " / " + fraction2 + " = " + resultDivide);  // Ожидаемый вывод: 15/8

        int intArg = 5;

        // Пример сложения с целым числом
        FracOperations.Fraction resultAddInt = fraction1.sum(intArg);
        System.out.println(fraction1 + " + " + intArg + " = " + resultAddInt);  // Ожидаемый вывод: 23/4

        // Пример вычитания целого числа
        FracOperations.Fraction resultSubtractInt = fraction1.minus(intArg);
        System.out.println(fraction1 + " - " + intArg + " = " + resultSubtractInt);  // Ожидаемый вывод: -17/4

        // Пример умножения на целое число
        FracOperations.Fraction resultMultiplyInt = fraction1.multiply(intArg);
        System.out.println(fraction1 + " * " + intArg + " = " + resultMultiplyInt);  // Ожидаемый вывод: 15/4

        // Пример деления на целое число
        FracOperations.Fraction resultDivideInt = fraction1.div(intArg);
        System.out.println(fraction1 + " / " + intArg + " = " + resultDivideInt);  // Ожидаемый вывод: 3/20

        // Посчитать f1.sum(f2).div(f3).minus(5)
        FracOperations.Fraction result = calculateExpression(fraction1, fraction2, fraction3, intArg);
        System.out.println(fraction1 + " + " + fraction2 + " / " + fraction3 + " - " + intArg + " = " + result); // Ожидаемый вывод: -369/100

    }

    public static FracOperations.Fraction calculateExpression(FracOperations.Fraction fraction1, FracOperations.Fraction fraction2,
                                                              FracOperations.Fraction fraction3, int intArg) {
        FracOperations.Fraction divResult = fraction2.div(fraction3);
        FracOperations.Fraction minusResult = divResult.minus(intArg);
        FracOperations.Fraction sumResult = fraction1.sum(minusResult);

        return sumResult;
    }

}
