package test;

public class TestThrow {
    public static void main(String[] args) {
/*
        int x = 5;
        int b = 0;

        if (b == 0) {
            throw new ArithmeticException("Деление на 0");
        }
        else {
            int result = x / b;
            System.out.println(result);
        }*/

        /*
        int age = -10;
        if(age < 0){
            throw new IllegalArgumentException("Возраст не может быть отрицательным");
        }*/

        String str = null;
        if (str == null) {
            throw new NullPointerException("Строка равна null");
        }
    }
}
