package P6_Exception;

import org.junit.Test;

public class TestException {
    @Test
    /**
     * 自定义异常测试
     */
    public void UserDefinedException(){
        Person person = new Person();
        person.setAge(-1);
    }

}

class Person{
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age<0){
            throw new AgeException("年龄不能小于0");
        }
        this.age = age;
    }
}


/**
 * 编写自定义异常类
 */
class AgeException extends RuntimeException{
    public AgeException(){
    }
    public AgeException(String message){
        super(message);
    }
}