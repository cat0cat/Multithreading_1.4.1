import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class TelephoneStation extends  Thread{

    private static final int COUNT = 50; //количество вызовов
    private static final int DELAY = 1000; //задержка
    private final Queue<Call> callQueue = new ConcurrentLinkedQueue<>(); //Потокобезопасность. Быстрая неблокирующая работа
    public int number;
    public TelephoneStation(String name) {
        super(name);
    }

    public void add(Call call) {
        callQueue.add(call);
    }

    public Call get() {
        return callQueue.poll();
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= COUNT; i++) {
                add(new Call());
                System.out.println("Звонок № 000" + i + " на " + Thread.currentThread().getName() + " ожидает ответа");
                Thread.sleep(DELAY);
                number = i;
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

}
