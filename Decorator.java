//Ref: https://www.geeksforgeeks.org/decorator-pattern/
public class Main
{
    public static interface Coffee {
        public int getPrice();
        public String getDescription();
    }
    
    public static class PlainCoffee implements Coffee {
        public int getPrice(){
            return 10;
        }
        public String getDescription(){
            return "Plain coffee.";
        }
    }
    
    public static class MilkDecorator implements Coffee {
        int price ;
        String description ;
        MilkDecorator(Coffee coffee){
            this.price = coffee.getPrice();
            this.description = coffee.getDescription();
        }
        public int getPrice(){
            return this.price + 2 ;
        }
        public String getDescription(){
            return description + " with Milk" ;
        }
    }
    
    public static class SugarDecorator implements Coffee {
        int price ;
        String description ;
        SugarDecorator(Coffee coffee){
            this.price = coffee.getPrice();
            this.description = coffee.getDescription();
        }
        public int getPrice(){
            return this.price + 3 ;
        }
        public String getDescription(){
            return description + " with Sugar" ;
        }
    }
    
	public static void main(String[] args) {
		Coffee plainCoffee = new PlainCoffee();
		System.out.println(plainCoffee.getPrice() + " # " + plainCoffee.getDescription());
		
		
		Coffee milkCoffee = new MilkDecorator(new PlainCoffee());
		System.out.println(milkCoffee.getPrice() + " # " + milkCoffee.getDescription());
		
		
		Coffee sugarCoffee = new SugarDecorator(new PlainCoffee());
		System.out.println(sugarCoffee.getPrice() + " # " + milkCoffee.getDescription());
		
		
		Coffee milkAndSugarCoffee = new SugarDecorator(new MilkDecorator(new PlainCoffee()));
		System.out.println(milkAndSugarCoffee.getPrice() + " # " + milkAndSugarCoffee.getDescription());
	}
}

/** 
*************Output****************
10 # Plain coffee.
12 # Plain coffee. with Milk
13 # Plain coffee. with Milk
15 # Plain coffee. with Milk with Sugar

*
*/
