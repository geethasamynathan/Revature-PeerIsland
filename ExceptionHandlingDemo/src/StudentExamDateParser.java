import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class StudentExamDateParser {
    public static  void  main(String[] args)
    {
        String examDate="31-02-2026";
        try{
            SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
            sdf.setLenient(false);

            Date date= sdf.parse(examDate);
            System.out.println(" Parsed Exam Date is :"+date);
        }
//        catch (ParseException e)
//        {
//            System.out.println("Invalid exam date format or invalid date entered");
//        }
        catch(Exception e)
        {
            System.out.println("Error occured "+e.getMessage());
            System.out.println("Error occured "+e.getStackTrace());
        }

    }

}
