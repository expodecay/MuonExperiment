/**
 * Created by Rick on 4/17/2016.
 */
public class delete {
    public static void main(String[] args) {
        int[] a ={12,55,74,79,90};
        int n = 5;
        double avg = 0, sqrdif = 0;
        for(int i = 0; i<a.length; i++){
            avg += a[i];
        }
        avg = avg/n;
        System.out.println("Average:" + avg);

        for(int i = 0; i<a.length; i++){
            sqrdif += Math.pow(a[i]-avg, 2);
        }
        sqrdif = sqrdif/n;
        sqrdif = Math.sqrt(sqrdif);

        System.out.println("sqrdiff: " + sqrdif);
    }
}
