package Model;

public class Toy implements Comparable<Toy>{
    private int id;
    private String name;
    private int weight;

    public Toy(int id, int weight, String name){
        this.id = id;
        this.weight = weight;
        this.name = name;
    }

    public void printInfo(){
        System.out.printf("id = %d, Название игрушки = %s,  частота выпадения = %d\n", id, name,  weight);
    }

    public int getWeight(){
        return weight;
    }

    public void changeWeight(int weight){
        this.weight = weight;
    }

    public int getId(){
        return id;
    }

    public String getIdAndName(){
        return String.format("id = %d, название игрушки = %s\n", id, name);
    }

    @Override
    public int compareTo(Toy o) {
        return (this.weight - o.weight);
    }
}
