import java.util.Arrays;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
public class Tester {
    public static void main(String [] args)throws FileNotFoundException{       
        Student [] trial=new Student[10];
        int insertCounter=0;
        try {
            Scanner input = new Scanner(System.in);
            System.out.println("Enter the file name");
            String address=input.next();
            File file = new File(address);
            input = new Scanner(file);
            
            while (input.hasNextLine()) {
                String line = input.nextLine();
                String [] studentInfo= line.split(",");
                Integer id= Integer.parseInt(studentInfo[0]);                
                String name= studentInfo[1];
                int age= Integer.parseInt(studentInfo[2]);
                double gpa= Double.parseDouble(studentInfo[3]);
                trial[insertCounter]=new Student(id, name, age, gpa);
                insertCounter++;
            }
            input.close();   
            System.out.println("");
            System.out.println("Unsorted Records");
            for(int j=0;j<trial.length;j++){
                System.out.println(trial[j].getStudent());
            }
            Sorter mySort=new Sorter(trial);
            mySort.insertionSort();
            Student [] done= mySort.getArray();
            System.out.println("");
            System.out.println("Sorted Records");
            for(int j=0;j<done.length;j++){
                System.out.println(done[j].getStudent());
            }
            File outFile = new File ("output.txt");
            FileWriter fWriter = new FileWriter (outFile);
            PrintWriter pWriter = new PrintWriter (fWriter);
            for (int i=0;i<trial.length;i++){
                String line=done[i].getID()+", "+done[i].getName()+", "+done[i].getAge()+", "+done[i].getGpa();
                pWriter.println (line);
            }
            pWriter.close();
        } 
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
