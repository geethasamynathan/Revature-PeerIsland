public class OverlodingDemo {
    public static void main(String[]  args)
    {
        AttendanceService attendance=new AttendanceService();
        attendance.markAttendance(103);
        attendance.markAttendance(109,"20-03-2026");
        attendance.markAttendance(129,"18-03-2026","Second Shift");
    }

}
