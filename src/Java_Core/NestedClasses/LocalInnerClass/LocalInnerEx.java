package Java_Core.NestedClasses.LocalInnerClass;

public class LocalInnerEx {

}

class Math{
    public void getResult(){
        class Division{
            private int divided;
            private int divisor;

            public int getDivided() {
                return divided;
            }

            public void setDivided(int divided) {
                this.divided = divided;
            }

            public int getDivisor() {
                return divisor;
            }

            public void setDivisor(int divisor) {
                this.divisor = divisor;
            }

           public double getQuotient() {
               return divided/divisor;
           }

            public double remainderOfTheDivision() {
                return divided%divisor;
            }
          }

        Division division = new Division();
        division.setDivided(21);
        division.setDivisor(3);
        System.out.println("Делимое " + division.getDivided());
        System.out.println("Делитель " + division.getDivisor());
        System.out.println("Частное " + division.getQuotient());
        System.out.println("Остаток от деления " + division.remainderOfTheDivision());

        }
   }

