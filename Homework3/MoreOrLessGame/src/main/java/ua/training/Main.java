package ua.training;

/*
Задание 3

Исправить/заново написать MVC – игровую программу “Угадай число” по TDD:

Комментарий:
конструкцию изменил под уточненные требования после пояснений "Заказчика",
слегка отрефакторил код контроллера и вью, логику модели удалил, и дальше по TDD
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
