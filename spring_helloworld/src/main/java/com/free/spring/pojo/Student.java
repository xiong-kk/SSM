package com.free.spring.pojo;

/**
 * @author free
 * @create 2023-06-05-16:11
 */
public class Student implements Persion{
    private Integer sid;
    private String sname;
    private Integer age;
    private String gender;

    private Clazz clazz;
    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        //System.out.println("生命周期2：依赖注入");
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Clazz getClazz() {
        return clazz;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }

    public Student(Integer sid, String sname, Integer age, String gender) {
        this.sid = sid;
        this.sname = sname;
        this.age = age;
        this.gender = gender;

    }

    public Student() {
        //System.out.println("生命周期1：实例化");
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", clazz=" + clazz +
                '}';
    }

    public void init(){
        System.out.println("生命周期3：初始化");
    }
    public void destroy(){
        System.out.println("生命周期4：销毁");
    }
}
