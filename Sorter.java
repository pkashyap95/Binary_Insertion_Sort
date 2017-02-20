import java.util.Arrays;
import java.io.File;
import java.util.Scanner;
public class Sorter {
    private Student [] trial;
    public Sorter(Student [] a){
        trial=a;
    }
    public void insertionSort(){
        int v,j,loc=0;
        Student temp;
        for(int i=1; i<trial.length; i++){
            v= trial[i].getID(); 
            temp=trial[i];
            j=i-1; 
            loc = binarySearch(trial, v, 0, j);
            while (j >= loc){
                trial[j+1] = trial[j];
                j--;
            }
            trial[j+1]=temp;
        }
    }    
    public int binarySearch(Student []a, int sel, int low, int high){
        if (high <= low)
            if (sel > a[low].getID())
                return (low + 1); 
            else 
                return low;
        int mid = (low + high)/2;
        if(sel == a[mid].getID())//if the item to be inserted is at the middle location
            return mid+1;
        else if(sel > a[mid].getID())//item to be inserted is greater than middle element insert to the left and find location
            return binarySearch(a, sel, mid+1, high);
        else
            return binarySearch(a, sel, low, mid-1);    //item to be inserted is less than middle element insert to the right and find location
    }
    public Student[] getArray(){
        return trial;
    }
}
