import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

class PayrollApplication{
    static Locale locale;//bind with a class hence class1 member value
    static ResourceBundle rb;
    static void loadBundle(){
        rb = ResourceBundle.getBundle("message", locale);

    }
    static String properCase(String name){
        //dIVygA
        String fullName="";
         String names[]= name.split("");
         for(int i=0;i<names.length;i++){
           String n= String.valueOf(names[i].charAt(0)).toUpperCase()+names[i].substring(1).toLowerCase();
        //     String val=names[i];
        //     char firstLetter=val.charAt(0);
        //    String first_capital=String.valueOf(firstLetter).toUpperCase();
        //    String remaining_name=names[i].substring(1).toLowerCase();
        //    String n=first_capital+remaining_name;
         fullName=fullName+n+"";


         }
         return fullName;
      }
      static String currencyFormat(double val){
       NumberFormat obj= NumberFormat.getCurrencyInstance(locale);//if u want $ ya rupee
                                                                    //10000.0 value is double
                                                                    //$10,000-value is string
       return obj.format(val);
      }



//making 1 function
    static void input(){

        Scanner sc=new Scanner(System.in);
        System.out.println("press 1 for english");
        System.out.println("हिंदी क लिए 2 दबाये");
        int choice=sc.nextInt();
        // Locale locale;
        if(choice==1){
            locale=new Locale("en","US");
            
            

        }
        else if(choice ==2){
            locale=new Locale("hi","IN");
            
        }else{
            System.out.println("wrong choice");
        }
        loadBundle();
        
        System.out.println(rb.getString("id.msg"));
        int id=sc.nextInt();
        System.out.println(rb.getString("name.msg"));
        String name=sc.next();
        System.out.println(rb.getString("salary.msg"));
        double basicSalary=sc.nextDouble();
       
        compute(name,basicSalary);
        sc.close();

    }
    static String dateFormat(){
        //System date
        Date date =new Date();//date object
       // DateFormat df=DateFormat.getDateInstance(DateFormat.FULL,locale);//class from java.text , full fleged date
        DateFormat df=DateFormat.getDateInstance(DateFormat.SHORT,locale);//class from java.text , full fleged date
        return df.format(date);

    }
   static void compute(String name,double basicSalary){
        double hra=basicSalary*0.50;
        double ta=basicSalary*0.40;
        double ma=basicSalary*0.25;
        double da=basicSalary*0.20;
        double pf=basicSalary*0.05;
        // print(hra,ta,ma,da,pf);
        double gs=basicSalary+hra+da+ta+ma;//gross salary
        double tax=computeTax(gs);
        double ns=gs-pf-tax;//netsalary
        print(name,gs,hra,ta,ma,da,pf,tax,ns);

    }
   static void print(String name,double gs,double hra,double ta,double ma,double da, double pf,double tax,double ns){
       // dateFormat();
       System.out.println("Today "+dateFormat()); 
       System.out.println("emp Name"+properCase(name));
        System.out.println("allowances    \t Deduction");
        System.out.println("hra "+currencyFormat(hra)+"\tpf "+currencyFormat(pf));
        System.out.println("ta  "+currencyFormat(ta));
        System.out.println("ma "+currencyFormat(ma));
        System.out.println("da "+currencyFormat(da));
        System.out.println("gs" +currencyFormat(gs));
        System.out.println("tax"+currencyFormat(tax));//for annual tax
        System.out.println("ns"+currencyFormat(ns));
        
        

    }
    static double  computeTax(double gs){
        double tax=0.0;
        double annual=gs*12;

        if(annual>500000 && annual<700000){
            return (annual*0.10)/12;
        }
        else if(annual>700000 && annual<1000000){
            return (annual*0.20)/12;

        }
          return annual;


    }
    public static void main(String[] args) {
      input();
       
       
        // //printing tha allowances(earning)
        // System.out.println("allowances");
        // System.out.println("hra "+hra);
        // System.out.println("ta  "+ta);
        // System.out.println("ma "+ma);
        // System.out.println("da "+da);
        // System.out.println("deduction");
        // System.out.println("pf "+pf);
         //printing tha allowances(earning)
        
        System.out.println("divya and miattal and this is the most favourite and most amazing course panna maia bhi jeera ");
    }
}
