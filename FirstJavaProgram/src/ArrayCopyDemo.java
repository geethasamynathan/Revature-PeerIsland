import java.util.Arrays;

public class ArrayCopyDemo {
    public static void main(String[] args) {

//        //Shallow Copy
//        int[] originalCustomerIds = {1, 2, 3, 4, 5, 6, 7};
//        int[] copyOfCustomerIds = originalCustomerIds;
//        System.out.println("OriginalCustomerIDs");
//        for (int id : originalCustomerIds) {
//            System.out.print(id + "  ");
//        }
//        originalCustomerIds[1] = 200;
//        System.out.println("CopyOfCustomerIDs");
//        for (int id : copyOfCustomerIds) {
//            System.out.print(id + "  ");
//        }


//        //DeepCopy
//        int[] originalCustomerIds = {1, 2, 3, 4, 5, 6, 7};
//        int[] copyOfCustomerIds = new int[7];
//        for(int i=0;i<originalCustomerIds.length;i++)
//        {
//            copyOfCustomerIds[i]=originalCustomerIds[i];
//        }
//
//        System.out.println(" OriginalcustomerIds are");
//        for(int id:originalCustomerIds)
//        {
//            System.out.print(id+"\t");
//
//        }
//        originalCustomerIds[1]=200;
//        System.out.println(" CopyOf CustomerIds");
//        for(int id:copyOfCustomerIds)
//        {
//            System.out.print(id+"\t");
//
//        }

        //DeepCopy using System.arraycopy()

        int[] originalCustomerIds = {1, 2, 3, 4, 5, 6, 7};
        int[] copyOfCustomerIds = new int[7];

        System.arraycopy(originalCustomerIds, 0, copyOfCustomerIds, 0, originalCustomerIds.length);

        System.out.println("Original Customer Ids are");
        for (int id : originalCustomerIds) {
            System.out.print(id + "\t");
        }

        originalCustomerIds[2] = 900;
        System.out.println("After changed the value of  originalCustomerIds[2] = 900; Original Customer Ids are");
        for (int id : originalCustomerIds) {
            System.out.print(id + "\t");
        }

        System.out.println("Copyof Customer Ids are");
        for (int id : copyOfCustomerIds) {
            System.out.print(id + "\t");
        }

        //Copy Range of values from source array
        int[] destination= Arrays.copyOfRange(originalCustomerIds,0,originalCustomerIds.length-2);
        System.out.println("Destination Array lements are");
        for (int id : destination) {
            System.out.print(id + "\t");
        }
    }
}
