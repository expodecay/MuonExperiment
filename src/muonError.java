import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by Rick on 4/17/2016.
 */
public class muonError {
    public static void main(String[] args) throws IOException {
        Scanner in = null;
        PrintWriter out = null;
        String line = null;
        String [] token = null;
        int i, n,totalSum = 0, totaleEvents = 0;
        double avg = 0, sigma = 0, sqrDif = 0, standardError = 0;
        if(args.length < 2){
            System.out.println("Usage: FileCopy <input file> <output file>");
            System.exit(1);
        }
        in = new Scanner(new File(args[0]));
        out = new PrintWriter(new FileWriter(args[1]));
        while( in.hasNextLine() ){
            line = in.nextLine().trim();
            token = line.split("\\s+");
            n = token.length;
            for(i=0; i<n; i++){
                totalSum += Integer.parseInt(token[i]);
                totaleEvents++;
            }
        }
        avg = (double)totalSum/(double)totaleEvents;
        out.println("total Sum: " + totalSum);
        out.println("totalEvents: " + totaleEvents);
        out.println("Average: " + avg);

        in = new Scanner(new File(args[0]));
        while( in.hasNextLine() ){
            line = in.nextLine().trim();
            token = line.split("\\s+");
            n = token.length;
            for(i=0; i<n; i++){
                sqrDif += Math.pow(Integer.parseInt(token[i]) - avg, 2);
            }
        }
        out.println("sum(X_i - avg)^2: " + sqrDif);
        sqrDif = sqrDif/(double)totaleEvents;
        out.println("sqrDiff / totalEvents: " + sqrDif);
        sigma = Math.sqrt(sqrDif);
        out.println("sigma: " + sigma);
        standardError = sigma / Math.sqrt(totaleEvents);
        out.println("Standard error of mean: " + standardError);
        in.close();
        out.close();
    }
}
