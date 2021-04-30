package P8_IO;

/**
 * @author centuryw
 * @version 1.0
 * @description: 模拟咖啡
 *  1.抽象组件：需要装饰的抽象对象（接口或抽象父类）
 *  2.具体组件：需要装饰的对象
 *  3.抽象装饰类：包含了对抽象组件的引用以及装饰者共有的方法
 *  4.具体装饰类：被装饰的对象
 *
 * @date 2021/4/30 下午12:21
 */
public class T9_Decorator2 {
    public static void main(String[] args) {
        Drink coffee = new Coffee();
        System.out.println(coffee.info()+" 花费:"+coffee.cost());
        Drink sugar = new Sugar(coffee);
        System.out.println(sugar.info()+" 花费:"+sugar.cost());
        Drink milk = new Milk(coffee);
        System.out.println(milk.info()+" 花费:"+milk.cost());
        Drink news = new Sugar(milk);
        System.out.println(news.info()+" 花费:"+news.cost());
    }



}

/**
 * @description: 抽象组件
 * @author centuryw
 * @date: 2021/4/30 下午12:24
 */
interface Drink{
    double cost();  // 费用
    String info();  // 说明
}

class Coffee implements Drink{
    private String name = "咖啡";

    @Override
    public double cost() {
        return 10;
    }

    @Override
    public String info() {
        return name;
    }
}

/**
 * @description: 抽象装饰类
 * @author centuryw
 * @date: 2021/4/30 下午12:27
 */
abstract class Decorate implements Drink{
    private Drink drink;

    public Decorate(Drink drink){
        this.drink = drink;
    }

    @Override
    public double cost() {
        return this.drink.cost();
    }

    @Override
    public String info() {
        return this.drink.info();
    }
}

/**
 * @description: 具体装饰类
 * @author centuryw
 * @date: 2021/4/30 下午12:28
 */
class Milk extends Decorate{
    public Milk(Drink drink){
        super(drink);
    }
    @Override
    public double cost(){
        return super.cost()+10;
    }

    @Override
    public String info(){
        return super.info()+"(加牛奶)";
    }
}

/**
 * @description: 具体装饰类
 * @author centuryw
 * @date: 2021/4/30 下午12:28
 */
class Sugar extends Decorate{
    public Sugar(Drink drink){
        super(drink);
    }
    @Override
    public double cost(){
        return super.cost()+2;
    }

    @Override
    public String info(){
        return super.info()+"(加糖)";
    }
}