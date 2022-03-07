package server;
//1. * Создать три потока, каждый из которых выводит определенную букву (A, B и C) 5
// раз (порядок – ABСABСABС). Используйте wait/notify/notifyAll.
public class HM_4_test {
     private static int order= 0;
     private static Object mon = new Object();

    public static void main(String[] args) {

        new Thread (()-> {
            for (int i = 0; i <=5; i++){
                synchronized (mon) {
                    try {
                        while (order != 0){
                            mon.wait();
                        }
                        System.out.println("A");
                        Thread.sleep(150);
                        order=1;
                        mon.notifyAll();
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
           }).start();

        new Thread (()-> {
            for (int i = 0; i <=5; i++){
                synchronized (mon) {
                    try {
                        while (order != 1){
                            mon.wait();
                        }
                        System.out.println("В");
                        Thread.sleep(150);
                        order=2;
                        mon.notifyAll();
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        new Thread (()-> {
            for (int i = 0; i <=5; i++){
                synchronized (mon) {
                    try {
                        while (order != 2){
                            mon.wait();
                        }
                        System.out.println("С");
                        Thread.sleep(150);
                        order=0;
                        mon.notifyAll();
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        }
    }

