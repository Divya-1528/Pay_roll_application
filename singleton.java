//object sirf 1 baar banana hai
//har class mai default constructor hota hai
class Validation{
    private static Validation obj;//object k type should be private static
    private Validation(){

    }
   static Validation getInstance(){
  if(obj==null){
    obj=new Validation();
  }
  return obj;
   }//object ban rha hai with the help of function, static cheeje class k sath bind ho jati hai

}
public class singleton {
    public static void main(String[] args) {
   // Validation v=new Validation();//bracket is called constructor calling
   Validation v1 = Validation.getInstance();    
   Validation v2 = Validation.getInstance();    
   Validation v3 = Validation.getInstance(); 
   System.out.println(v1==v2&&v1==v3);   
}

    
}
