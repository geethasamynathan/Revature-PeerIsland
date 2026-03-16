public class MultiDimensionalArrayDemo {
    public static void main(String[] args) {
        int[][] studentMarks = {
                {10, 20, 30},
                {50, 60, 70},
                {700}
        };
        System.out.println("Length of the First Row" + studentMarks[0].length);
        System.out.println("Length of the First Row" + studentMarks[1].length);
        System.out.println("Length of the First Row" + studentMarks[2].length);


//        for (int i = 0; i < studentMarks.length; i++) {
//            for (int j = 0; j < studentMarks[i].length; j++) {
//                System.out.print(studentMarks[i][j] + "\t");
//            }
//            System.out.println();
//        }

        for (int[] rowArray:studentMarks)
        {
           for(int data:rowArray)
            {
                System.out.print(data+"   ");
            }
            System.out.println();

        }
    }
}
