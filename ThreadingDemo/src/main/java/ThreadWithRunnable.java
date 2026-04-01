public class ThreadWithRunnable {

        public static void main(String[] args){
            InvoiceThread1 invoiceTask=new InvoiceThread1();
            SMSThread1 smsTask=new SMSThread1();
            StatusThread1 statusTask= new StatusThread1();
           Thread t1= new Thread(invoiceTask,"Invoice-Task");
            Thread t2= new Thread(smsTask,"SMS -Task");
            Thread t3= new Thread(statusTask,"Status-Task");
            t2.setName("SMS - thread");
            t3.setName("Status- Thread");

            t1.start();
            try{
                t1.join();
            }catch(InterruptedException e){
                e.printStackTrace();
            }

            t2.start();
            try{
                t2.join();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            t3.start();
            try{
                t3.join();
            }catch(InterruptedException e){
                e.printStackTrace();
            }

        }
    }

    class InvoiceThread1 implements  Runnable{
        public void run(){
            for(int i=1;i<=5;i++){
                System.out.println(Thread.currentThread().getName() + "Printing invoice page " +i);
                try{
                    Thread.sleep(2000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
            System.out.println("Invoice is Printing");
        }
    }

    class SMSThread1 implements Runnable{
        public void run(){
            for(int i=1;i<=5;i++){
                System.out.println(Thread.currentThread().getName() + "Sending SMS  " +i);
                try{
                    Thread.sleep(500);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
            System.out.println(" SMS Sent Succesfully");
        }
    }

    class StatusThread1 implements  Runnable{
        public void run(){
            for(int i=1;i<=5;i++){
                System.out.println(Thread.currentThread().getName() + "Updating status " +i);
                try{
                    Thread.sleep(1000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }

            System.out.println("Delivery Status updated ");
        }
    }

