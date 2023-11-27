package bathroom;

public class Main {
    public static void main(String[] args) {

        Bathroom bathroom = new Bathroom();

        Thread guest1 = new Thread(new TaskNumber1(bathroom), "Convidado 01");

        Thread guest2 = new Thread(new TaskNumber2(bathroom), "Convidado 02");

        Thread guest3 = new Thread(new TaskNumber1(bathroom), "Convidado 03");

        Thread guest4 = new Thread(new TaskNumber2(bathroom), "Convidado 04");

        

        guest1.start();
        guest2.start();
        guest3.start();
        guest4.start();
    }
}
