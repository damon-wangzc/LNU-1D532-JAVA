class A {

    String s;
    
    A (String str) {
    
    s = str;
    
    }
    
    void print() {
    
    System.out.println(s);
    
    }
    
    }
    
public class test {
    
    public static void main(String[] args) {
    
        A a = new A();
    
        a.print();
    
     }
    
    }