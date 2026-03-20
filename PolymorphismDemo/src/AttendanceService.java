public class AttendanceService {

    public void markAttendance(int empId)
    {
        System.out.println("Attendance marked for the Employee Id : "+empId + "for today");
    }
    public void markAttendance(int empId, String date)
    {
        System.out.println(" Attendance marked for Employee Id : "+empId +" on Data : "+date);
    }

    public void markAttendance(int empId, String date,String shift)
    {
        System.out.println("Attendance marked for Empoyee Id "+empId + "on date : "+date + "for shift: "+shift);
    }


}
