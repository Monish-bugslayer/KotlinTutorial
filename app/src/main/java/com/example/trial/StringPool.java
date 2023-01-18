package com.example.trial;

public class StringPool {
    public static void main(String args[]){
        String s1=new String("Monish");
        String s2=new String("Monish");
        String s3="Monish";
        String s4="Monish";
        
        if(s1==s2){//-> s1 and s2 are dynamically allocated in heap and they have differen objects
            System.out.println("s1 and s2 have same reference");
        }
        else{
            System.out.println("s1 and s2 dont have same reference");
        }
        if(s3==s4){//-> yes because s3 and s4 are stored in string pool and for same values they have same reference
            //no new object is created
            System.out.println("s3 and s4 have same reference");
        }
        else {
            System.out.println("s3 and s4 dont have same reference");
        }

    }
}
