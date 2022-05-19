public class Main {

    public static final int SPECIALISTS = 10;

    public static void main(String[] args) {

        TelephoneStation telephoneStation = new TelephoneStation("АТС");
        telephoneStation.start();

        for (int i = 1; i <= SPECIALISTS; i++){
            new Specialist("№ " + i,telephoneStation).start();
        }

    }
}