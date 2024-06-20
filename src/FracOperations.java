public class FracOperations {
    //Задача 1.6.4

    public static class Fraction {
        // поля
        private final int numerator;  // числитель
        private final int denominator;  // знаменатель

        // Геттеры
        public int getNumerator() {
            return numerator;
        }

        public int getDenominator() {
            return denominator;
        }

        // Конструктор для обычной дроби
        public Fraction(int numerator, int denominator) {
            if (denominator == 0) {
                throw new IllegalArgumentException("Знаменатель не может быть 0");
            }
            int gcd = gcd(Math.abs(numerator), Math.abs(denominator));
            this.numerator = numerator / gcd;
            this.denominator = denominator / gcd;
        }

        // Приватный метод для нормализации дроби
        private Fraction normalize() {
            // Обработка отрицательных знаменателей, чтобы дробь всегда была положительной
            if (this.denominator < 0) {
                // Используем временные переменные для коррекции знаков
                int newNumerator = -this.numerator;
                int newDenominator = -this.denominator;
                return new Fraction(newNumerator, newDenominator);
            }
            // Если знаменатель положительный, возвращаем текущий объект Fraction
            return this;
        }


        // Приватный конструктор для внутреннего использования
        private Fraction(int numerator, int denominator, boolean reduce) {
            this.numerator = numerator;
            this.denominator = denominator;
        }

        // Метод для нахождения наибольшего общего делителя (НОД)
        private static int gcd(int a, int b) {
            if (b == 0) {
                return a;
            }
            // Рекурсивный вызов по алгоритму Евклида
            return gcd(b, a % b);
        }

        @Override
        public String toString() {
            return numerator + "/" + denominator;
        }

        // Метод для сложения с другой дробью
        public Fraction sum(Fraction other) {
            int newNumerator = this.numerator * other.denominator + other.numerator * this.denominator;
            int newDenominator = this.denominator * other.denominator;
            return new Fraction(newNumerator, newDenominator);
        }

        // Метод для сложения с целым числом
        public Fraction sum(int number) {
            return sum(new Fraction(number, 1));
        }

        // Метод для вычитания другой дроби
        public Fraction minus(Fraction other) {
            int newNumerator = this.numerator * other.denominator - other.numerator * this.denominator;
            int newDenominator = this.denominator * other.denominator;
            return new Fraction(newNumerator, newDenominator);
        }

        // Метод для вычитания целого числа
        public Fraction minus(int number) {
            return minus(new Fraction(number, 1));
        }

        // Метод для умножения на другую дробь
        public Fraction multiply(Fraction other) {
            int newNumerator = this.numerator * other.numerator;
            int newDenominator = this.denominator * other.denominator;
            return new Fraction(newNumerator, newDenominator);
        }

        // Метод для умножения на целое число
        public Fraction multiply(int number) {
            return multiply(new Fraction(number, 1));
        }

        // Метод для деления на другую дробь
        public Fraction div(Fraction other) {
            if (other.numerator == 0) {
                throw new IllegalArgumentException("Деление на ноль невозможно");
            }
            int newNumerator = this.numerator * other.denominator;
            int newDenominator = this.denominator * other.numerator;
            return new Fraction(newNumerator, newDenominator);
        }

        // Метод для деления на целое число
        public Fraction div(int number) {
            if (number == 0) {
                throw new IllegalArgumentException("Деление на ноль невозможно");
            }
            return div(new Fraction(number, 1));
        }
    }
}
