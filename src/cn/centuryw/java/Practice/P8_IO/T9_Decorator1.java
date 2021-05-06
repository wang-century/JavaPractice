package cn.centuryw.java.Practice.P8_IO;

import org.junit.Test;

/**
 * @author centuryw
 * @version 1.0
 * @description: T1:实现对声音的放大功能
 * @date 2021/4/30 下午12:14
 */
public class T9_Decorator1 {
    /**
     * @description:  实现对声音的放大功能
     * @return: void
     * @author centuryw
     * @date: 2021/4/30 下午12:20
     */
    @Test
    public void T1(){
        Person p = new Person();
        p.say();
        Amplifier amplifier = new Amplifier(p);
        amplifier.say();
    }
}

interface Say{
    void say();
}

class Person implements Say{
    private int voiceLevel = 10;    // 分贝

    public int getVoiceLevel() {
        return voiceLevel;
    }

    public void setVoiceLevel(int voiceLevel) {
        this.voiceLevel = voiceLevel;
    }

    @Override
    public void say() {
        System.out.println("人的声音为:"+voiceLevel);
    }
}
/**
 * @description: 声音放大器
 * @author centuryw
 * @date: 2021/4/30 下午12:20
 */
class Amplifier implements Say{
    private Person person;

    Amplifier(Person p){
        person = p;
    }

    @Override
    public void say() {
        System.out.println("人的声音为:"+person.getVoiceLevel()*100);
        System.out.println("噪音..");
    }
}