import java.io.*;

public class Driver {
    public static void main(String[] args) {
        EvaluateExpressions evaluator = new EvaluateExpressions();
        
        // Get the current directory and create full file paths
        String currentDir = "/Users/chinbatorchlon/Documents/school/CS-301/lab-5";
        String inputPath = currentDir + "/expressions.txt";
        String outputPath = currentDir + "/postFixExpressions.txt";
        
        try {
            File inputFile = new File(inputPath);
            if (!inputFile.exists()) {
                System.out.println("Error: Input file not found at: " + inputPath);
                return;
            }
            
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            PrintWriter writer = new PrintWriter(outputPath);
            
            System.out.println("Reading from: " + inputPath);
            System.out.println("Writing to: " + outputPath);
            
            String line;
            while ((line = reader.readLine()) != null) {
                String postfix = evaluator.convertToPostFix(line);
                writer.println(postfix);
                
                try {
                    double result = evaluator.evaluatePostFix(postfix);
                    System.out.println(postfix + " evaluates to : " + result);
                } catch (ArithmeticException e) {
                    System.out.println(postfix + " evaluates to : Undefined (Division by zero)");
                }
            }
            
            reader.close();
            writer.close();
            
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException: " + e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
            e.printStackTrace();
        }
    }
}