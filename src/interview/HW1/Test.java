package interview.HW1;

public class Test {

    private String title;
    private Integer number;
    private Boolean lie;

    public Test() {
    }

    public String getTitle() {
        return title;
    }

    public Test setTitle(String title) {
        this.title = title;
        return this;
    }

    public Integer getNumber() {
        return number;
    }

    public Test setNumber(Integer number) {
        this.number = number;
        return this;
    }

    public Boolean getLie() {
        return lie;
    }

    public Test setLie(Boolean lie) {
        this.lie = lie;
        return this;
    }


    @Override
    public String toString() {
        return "Test{" +
                "title='" + title + '\'' +
                ", number=" + number +
                ", lie=" + lie +
                '}';
    }
}
