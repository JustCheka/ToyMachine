package View;

import Model.ToyMachine;

import java.util.Scanner;

public class View {

    ToyMachine toyMachine = new ToyMachine();
    public void start(){
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("1 - добавить игрушки, 2 - изменить шанс выпадения игрушки, 3 - вытащить игрушку, 4 - выход");
            int choose = scanner.nextInt();

            if (choose == 1){
                toyMachine.put();
                toyMachine.printToys();
            }
            if (choose == 2) {
                toyMachine.printToys();
                System.out.println("Выберите id игрушки для изменения ");
                choose = scanner.nextInt();
                System.out.println("Выберите новый шанс ");
                int newWeight = scanner.nextInt();
                toyMachine.changeWeight(choose, newWeight);
                System.out.println();
                toyMachine.printToys();
            }
            if (choose == 3){
                toyMachine.getToy();
                toyMachine.printToys();
            }
            if (choose == 4){
                break;
            }
        }

    }
}
