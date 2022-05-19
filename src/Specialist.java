public class Specialist extends  Thread{

    private static final long ANSWER = 1000;
    private final  TelephoneStation telephoneStation;

    public Specialist (String name, TelephoneStation telephoneStation) {
        super(name);
        this.telephoneStation = telephoneStation;
    }

    @Override
    public void run() {
        while (!isInterrupted())
            try {
                Call call;
                call = telephoneStation.get();
                if (null != call) {
                    System.out.println("Специалист " + Thread.currentThread().getName() + " ответил на звонок!");
                    Thread.sleep(ANSWER);
                }
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
    }
}
