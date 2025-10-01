import java.util.*;

class EmployeeNotFoundException extends Exception {
    EmployeeNotFoundException(String a) { super(a); }
}

class ProductNotFoundException extends Exception {
    ProductNotFoundException(String a) { super(a); }
}

public class Main {
    static HashMap<Integer,String> a=new HashMap<>();
    static HashMap<String,Double> b=new HashMap<>();
    public static void main(String[] args) {
        Scanner c=new Scanner(System.in);
        while(true){
            System.out.println("1.Add Employee");
            System.out.println("2.Get Employee by ID");
            System.out.println("3.Show Employees");
            System.out.println("4.Add Product");
            System.out.println("5.Apply Discount");
            System.out.println("6.Show Products");
            System.out.println("7.Exit");
            int d=c.nextInt(); c.nextLine();
            try{
                if(d==1){
                    System.out.println("Enter ID:");
                    int e=c.nextInt();c.nextLine();
                    System.out.println("Enter Name:");
                    String f=c.nextLine();
                    a.put(e,f);
                }
                else if(d==2){
                    System.out.println("Enter ID:");
                    int e=c.nextInt();c.nextLine();
                    if(!a.containsKey(e)) throw new EmployeeNotFoundException("Error: Employee ID not found!");
                    System.out.println("Name for ID "+e+": "+a.get(e));
                }
                else if(d==3){
                    for(Map.Entry<Integer,String> g:a.entrySet()){
                        System.out.println(g.getKey()+": "+g.getValue());
                    }
                }
                else if(d==4){
                    System.out.println("Enter Product ID:");
                    String e=c.nextLine();
                    System.out.println("Enter Price:");
                    double f=c.nextDouble();c.nextLine();
                    b.put(e,f);
                }
                else if(d==5){
                    System.out.println("Enter Product ID:");
                    String e=c.nextLine();
                    if(!b.containsKey(e)) throw new ProductNotFoundException("Error: Product ID not found!");
                    System.out.println("Enter Discount %:");
                    double f=c.nextDouble();c.nextLine();
                    if(f<0||f>100) throw new IllegalArgumentException("Error: Discount percentage must be between 0 and 100!");
                    double g=b.get(e);
                    g=g-(g*f/100);
                    b.put(e,g);
                    System.out.println("New price for "+e+": $"+g);
                }
                else if(d==6){
                    for(Map.Entry<String,Double> g:b.entrySet()){
                        System.out.println(g.getKey()+"=$"+g.getValue());
                    }
                }
                else if(d==7){
                    break;
                }
            }catch(Exception ex){
                System.out.println(ex.getMessage());
            }
        }
    }
}
