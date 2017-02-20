public class Student {
    private int mID;
    private double mGpa;
    private String mName; 
    private int mAge;
    public Student(int id, String name, int age, double gpa){
        mID=id;
        mName = name;
        mAge=age;
        mGpa=gpa;
    }
    public  String getName(){
        return  mName;
    }
    public  int getID(){
        return  mID;
    }
    public int getAge(){
        return mAge;
    }
    public double getGpa(){
        return mGpa;
    }  
    public String getStudent(){
        return mID+" "+mName+" "+mAge+" "+mGpa;
    }
}
