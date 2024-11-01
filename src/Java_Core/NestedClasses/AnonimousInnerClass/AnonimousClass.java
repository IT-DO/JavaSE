package Java_Core.NestedClasses.AnonimousInnerClass;

public class AnonimousClass {
    private int x = 4;
    public static void main(String[] args) {


        // Anonimous class initialize in object m
        Math m = new Math() {
        int c = 10;
        void abc(){}
        @Override
        public int doOperation(int a, int b) {
            return a + b;
        }
    };
    // // Anonimous class initialize in object m2
    Math m2 = new Math(){
        @Override
        public int doOperation(int a, int b) {
            AnonimousClass ac = new AnonimousClass();

            return a*b+ac.x;
        }
    };
        System.out.println(m.doOperation(10,2));
        System.out.println(m2.doOperation(10,2));
    }
}


interface Math {
    int doOperation(int a, int b);
}
