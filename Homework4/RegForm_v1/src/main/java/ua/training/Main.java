package ua.training;

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
