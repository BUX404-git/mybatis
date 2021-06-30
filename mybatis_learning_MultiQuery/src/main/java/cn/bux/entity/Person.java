package cn.bux.entity;

public class Person {
    private Integer id;
    private String name;
    private Integer age;
    private String cardno;//外键信息

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    //关系属性  //对象体现关系
    private Info info;//定义一个身份对象接收当前用户身份信息

    public Person(Integer id, String name, Integer age, String cardno) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.cardno = cardno;
    }

    public Person() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCardno() {
        return cardno;
    }

    public void setCardno(String cardno) {
        this.cardno = cardno;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", cardno='" + cardno + '\'' +
                '}';
    }
}
