package ru.krista.example;
import java.util.Scanner;

public class calculator{
    // поля класса для храннения входных данных и результата
    private int firstNum;
    private int secondNum;
    private char operation;
    private int result;

    /*Считываем выражение с консоли
    Ожидается ввод число пробел число
     */
    public void readIn(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите выражение (например, 1 + 2):");
        String input = scanner.nextLine();
        // Разбиваем строку по пробелам
        String[] tokens = input.trim().split("\\s+");
        if (tokens.length !=3){
            System.out.println("Ошибка: неверный формат ввода.");
            System.exit(1);
        }
        try{
            //Первый символ строки (первое число)
            firstNum = Integer.parseInt(tokens[0]);
            // Второй символ строки (операция)
            operation = tokens[1].charAt(0);
            //Третий символ строки (второе число)
            secondNum = Integer.parseInt(tokens[2]);
        }
        catch(NumberFormatException e){
            System.out.println("Ошибка: числа должны быть целыми");
            System.exit(1);
        }
    }
    //Выполнение расчета в зависимости от выбраной операции
    public void calculate(){
        switch(operation){
            case '+':
                result = firstNum + secondNum;
                break;
            case '-':
                result = firstNum - secondNum;
                break;
            case '*':
                result = firstNum * secondNum;
                break;
            case '/':
                if (secondNum == 0){
                    throw new ArithmeticException("Ошибка: деление на нуль невозможно.");
                }
                result = firstNum / secondNum;
                break;
            default:
                System.out.println("Ошибка: недопустимая операция.");
                System.exit(1);
        }
    }
    // Вывод результата вычисления на консоль
    public void printResult(){
        System.out.println(result);
    }
    //Метод main для запуска программы
    public static void main(String[] args){
        calculator calc = new calculator();
        calc.readIn();
        calc.calculate();
        calc.printResult();
    }
}