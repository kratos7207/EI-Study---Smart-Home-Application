
public class Trigger {

    private String condition;
    private String operator;
    private int value;
    private String action;

    public Trigger(String condition, String operator, int value, String action) {
        this.condition = condition;
        this.operator = operator;
        this.value = value;
        this.action = action;
    }

    public String toString() {
        return "{condition: " + condition + " " + operator + " " + value + ", action: " + action + "}";
    }
}
