package ua.training;

public class Model {
    private String strHello = "";
    private String strJava = "";

    public void setStrHello(String value) {
        this.strHello = value;
    }

    public String getStrHello() {
        return this.strHello;
    }

    public void setStrJava(String value) {
        this.strJava = value;
    }

    public String getStrJava() {
        return this.strJava;
    }

    public String getResSentence() {
        if("".equals(this.strHello) || "".equals(this.strJava)) {
            return View.IMPROPER_USE;
        }

        StringBuilder sb = new StringBuilder();

        sb.append(this.strHello);
        sb.append(" ");
        sb.append(this.strJava);

        return sb.toString();
    }

}
