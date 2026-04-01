public class WithThreadDemo {
    public static void main(String[] args){
       InvoiceThread t1=new InvoiceThread();
       SMSThread t2=new SMSThread();
       StatusThread t3= new StatusThread();
        t1.setName("Invoice- thread");
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

class InvoiceThread extends   Thread{
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

class SMSThread extends Thread{
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

class StatusThread extends Thread{
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