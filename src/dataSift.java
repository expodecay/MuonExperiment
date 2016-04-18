import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by Rick on 4/17/2016.
 */
public class dataSift {
    public static void main(String[] args) throws IOException {
        Scanner in = null;
        PrintWriter out = null;
        String line = null;
        String [] token = null;
        int i, n, lineNumber = 0;
        if(args.length < 2){
            System.out.println("Usage: FileCopy <input file> <output file>");
            System.exit(1);
        }
        in = new Scanner(new File(args[0]));
        out = new PrintWriter(new FileWriter(args[1]));
        while( in.hasNextLine() ){
            line = in.nextLine().trim();
            token = line.split("\\s+");
            // print out tokens
            n = token.length;
            for(i=0; i<n; i++){
                if(Integer.parseInt(token[i]) < 40000)
                    out.println(token[i]);

            }
        }
        in.close();
        out.close();
    }
}
