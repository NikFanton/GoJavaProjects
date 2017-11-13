public class RunnableInfo {

    public static Runnable runnable = new Runnable() {
        @Override
        public void run() {
            System.out.println("Name:    " + Thread.currentThread().getName());
            System.out.println("ID:      " + Thread.currentThread().getId());
            System.out.println("is main: " + Thread.currentThread().getName().equals("main"));
            System.out.println("------------------------");
        }
    };

    public static void initThread() {
        new Thread(runnable).start();
        new Thread(runnable).start();
        new Thread(runnable).start();
    }

    public static void main(String[] args) {
        runnable.run();
        new Thread(runnable).start();
        RunnableInfo.initThread();
    }
}
