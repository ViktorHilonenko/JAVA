package ua.training;

/*
Задание 1
1.	Написать программу, которая получает из командной строки сначала слово “Hello”, потом слово “Java!”. Другие вводы игнорировать с соответствующим комментарием в командной строке.
2.	Из этих слов собирается предложение и выводится на экран.
3.	Должен быть применен паттерн MVC.
*/

public class Main {
    public static void main(String[] args) {
        //Init
        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(model, view);

        //Run
        controller.processUserInput();
    }
}
