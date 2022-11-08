import java.util.*;
import java.io.*;
/**
 * Write a description of class MakeADriver here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MakeADriver
{
    //PrintWriter output;
    private String[] imports = new String[5]; // 5 imports from the class to go into the driver
    private String[][] methods = new String[50][18]; // 50 methods storing 1 name, 1 return type, and up to 8 parameters with their types
    // methods = { { method return type, method name} , ... };
    private String[][] paramCounts = new String[25][2];
    private String nameOfClass;
    private Scanner reader;

    public MakeADriver(String filename) throws IOException{
        reader = new Scanner(new File(filename));
        getCode();
    }
    
    public void createDriver() throws IOException{
        PrintWriter pw = new PrintWriter(new File(nameOfClass + "Driver.java"));
        
        //imports
        for(int i = 0; i < imports.length && imports[i] != null; i++)
            pw.println(imports[i] + ";\n");
        pw.println("import java.util.Scanner;");
        
        // class name, main method, and some default vars
        pw.println("public class " + nameOfClass  + "Driver{\n\tpublic static void main(String[] args){");
        pw.println("\t\tScanner in = new Scanner(System.in);\n\t\tchar loopAgain;\n\t\tchar userChoice;");
        
        // variables
        
        
        pw.println("\t}\n}");
        pw.close();
    }

    private void getCode() throws IOException{
        String line;
        StringTokenizer tokenizer;
        String currentToken;

        int methodCount = 0;
        int importCount = 0;
        int iterator;

        int posFirst;
        int posLast;
        
        int dataCounts;
        while(reader.hasNext()){
            line = reader.nextLine();
            if(line.contains("public class")){ // class name
                posFirst = line.indexOf("public class ",0) + 13;
                posLast = (line.contains("{"))?line.indexOf("{",1):line.length(); // sometimes { can be on the same line or not

                nameOfClass = line.substring(posFirst,posLast);
            }else if(line.contains("import ")){
                posFirst = line.indexOf("import ",0) + 7;
                imports[importCount] = line.substring(posFirst,line.length());
            }else if(line.contains("public "+nameOfClass+"(")){ // constructors
                methods[methodCount][0] = nameOfClass;
                methods[methodCount][1] = "constructor";

                posFirst = line.indexOf("(",0) + 1;
                posLast = line.indexOf(")",0);

                currentToken = line.substring(posFirst,posLast);
                dataCounts = 0; // possible max counts of a variable among all instances of a data type
                if(currentToken.length() > 0){ // if not a blank constructor
                    tokenizer = new StringTokenizer(currentToken, ", ");
                    iterator = 2;
                    while(tokenizer.hasMoreTokens() && methods[methodCount][17] == null){ // runs while it has a next token and the last element isn't null
                        methods[methodCount][iterator] = tokenizer.nextToken(); // data type
                        methods[methodCount][iterator+1] = tokenizer.nextToken(); // variable name
                        /*
                        for(int i = 0; i < paramCounts.length; i++){
                            if(paramCounts[i][0] == null){
                                System.out.println(methods[methodCount][iterator]);
                                paramCounts[i][0] = methods[methodCount][iterator];
                                paramCounts[i][1] = "1";
                            } else if(paramCounts[i][0].equals(methods[methodCount][iterator])){
                                dataCounts++;
                                if(dataCounts > Integer.parseInt(paramCounts[i][1]))
                                    paramCounts[i][1] = dataCounts + "";
                                break;
                            }
                        }
                        dataCounts = 0;*/
                        iterator+=2;
                    }
                }else{ // blank constructor
                    methods[methodCount][2] = "empty";
                }

                methodCount++; // goes on to potential next method to add
            } else if(line.contains("public ")){ // methods
                posFirst = line.indexOf("public ",0) + 7;
                posLast = line.indexOf("(",0);

                tokenizer = new StringTokenizer( line.substring(posFirst,posLast) ); // substring containing all elements between public and (
                while(tokenizer.countTokens() > 2){ // goes through each token that isn't the return type or method name
                    tokenizer.nextToken();
                }

                methods[methodCount][0] = tokenizer.nextToken(); // the return type
                methods[methodCount][1] = tokenizer.nextToken(); // the method name

                posFirst = posLast+1;
                posLast = line.indexOf(")",0);

                currentToken = line.substring(posFirst,posLast);
                if(currentToken.length() > 0){
                    tokenizer = new StringTokenizer( currentToken , ", ");
                    iterator = 2;
                    while(tokenizer.hasMoreTokens() && methods[methodCount][17] == null){// runs while it has a next token and the last element isn't null
                        methods[methodCount][iterator] = tokenizer.nextToken(); // data type
                        methods[methodCount][iterator+1] = tokenizer.nextToken(); // variable name
                        iterator++;
                    }
                } else{
                    methods[methodCount][2] = "empty";
                }

                methodCount++; // goes on to potential next method to add
            }
        }
        
    }
}
