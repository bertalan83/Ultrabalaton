package hu.progmatic;

public class Contender {

    private String name;
    private int number;
    private String category;
    private String time;
    private int percentageDone;

    public Contender() {
    }

    public Contender(String line) {
        String[] parts = line.split(";");

        this.name = parts[0];
        this.number = Integer.parseInt(parts[1]);
        this.category = parts[2];
        this.time = parts[3];
        this.percentageDone = Integer.parseInt(parts[4]);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getPercentageDone() {
        return percentageDone;
    }

    public void setPercentageDone(int percentageDone) {
        this.percentageDone = percentageDone;
    }

    public double IdoOraban() {
        String[] parts = getTime().split(":");

        double hour = Integer.parseInt(parts[0]);
        double minute = Integer.parseInt(parts[1]);
        double second = Integer.parseInt(parts[2]);

        return hour + minute/60 + second/3600;
    }
}
