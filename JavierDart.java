/*
  Program that defines a three-dimensional array 3 x 3 x 3, 
and charge him the numbers 1 to 27.
 */
package u6_sheet6;

/**
 *
 * @author Mati
 */
public class Ejer_8 {
    public static void main(String[] args) {
        int[][][]m= new int [3][3][3];
        int num=1;
        int i,j,k;
         for ( i=0;i<m.length; i++){
             for( j=0; j<m[i].length; j++){ 
                 for(k=0; k<m[i][j].length; k++){
                     m[i][j][k]=num;
                     num++;
                 }
             }
         }
    }
}
