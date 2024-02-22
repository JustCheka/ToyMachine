package Model;

import java.util.*;

public class ToyMachine {


    List<Toy> toysInMachine = new ArrayList<>();


    public void put(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите название игрушки ");
        String name = scanner.nextLine();

        System.out.println("Введите id игрушки ");
        int index = scanner.nextInt();


        System.out.println("Введите шанс выпадния игрушки ");
        int weight = scanner.nextInt();

        System.out.println("Сколько добавить таких игрушек в автомат? ");
        int count = scanner.nextInt();

        for (int i = 0; i < count; i++) {
            Toy toy = new Toy(index, weight, name);
            toysInMachine.add(toy);
        }

    }

    private int getValues(double[] values){
        int value = 0;
        for (Toy toy: toysInMachine){
            value += toy.getWeight();
        }

        for (int i = 0; i < toysInMachine.size(); i++) {
            values[i] =  toysInMachine.get(i).getWeight() * 100d / value;
        }

        return value;
    }

    public void getToy(){

        double[] values = new double[toysInMachine.size()];
        int value = getValues(values);
        Collections.sort(toysInMachine);

        int sum = toysInMachine.getFirst().getWeight();

        Random rand = new Random();
        int choose = rand.nextInt(1, value + 1);
        for (int i = 0; i < toysInMachine.size(); i++) {
            if (sum >= choose) {
                System.out.println("Выпала игрушка: ");
                toysInMachine.get(i).printInfo();
                SaveInFile.Save(toysInMachine.get(i));
                toysInMachine.remove(i);
                System.out.println("-----------------------------");
                break;
            }
            sum += toysInMachine.get(i + 1).getWeight();
        }

    }

    public void changeWeight(int id, int newWeight){

        for (int i = 0; i < toysInMachine.size(); i++) {
            if (toysInMachine.get(i).getId() == id) {
                toysInMachine.get(i).changeWeight(newWeight);
            }
        }
    }

    public void printToys(){
        System.out.println("Игрушки в автомате: ");
        for (Toy toy: toysInMachine){
            toy.printInfo();
            System.out.println();
        }
    }
}
