package lesson5;

public class Personal {
private String fio;
private String post;
private String email;
private String phone;
private int salary;
private int age;

public Personal(String fio, String post, String email, String phone, int salary, int age){
    this.fio = fio;
    this.post = post;
    this.email =email;
    this.phone = phone;
    this.salary = salary;
    this.age = age;
}

public void output()
{System.out.println("ФИО: " + fio);
    System.out.println("Должность: " + post);
    System.out.println("E-mail: " + email);
    System.out.println("Телефон: " + phone);
    System.out.println("Зарплата: " + salary);
    System.out.println("Возраст: " + age);
    System.out.println();
}

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
