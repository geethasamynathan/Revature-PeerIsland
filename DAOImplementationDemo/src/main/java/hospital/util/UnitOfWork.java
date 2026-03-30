package hospital.util;

import java.sql.Connection;

public class UnitOfWork implements  AutoCloseable{

    private final Connection conn;
    public UnitOfWork() throws Exception{
        conn=DBConection.getConnection();
        conn.setAutoCommit(false);

    }

    public  Connection getConnection(){
        return  conn;
    }
    public void commit() throws Exception{
        conn.commit();
    }

    public void  rollback(){
        try {
            conn.rollback();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    @Override
    public void close()  {
    try{
        conn.setAutoCommit(true);
        conn.close();
    }catch (Exception e){
        e.printStackTrace();
    }
    }
}
