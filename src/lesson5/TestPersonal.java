package lesson5;

public class TestPersonal {
    public static void main(String[] args) {
        Personal person[] = new Personal[5];
        person[0] = new Personal("Иванов Иван Иванович", "Дворник", "ivanov@mail.ru", "+7 -111-111-11-11", 20000, 50);
        person[1] = new Personal("Петров Петр Петрович", "Клерк", "petrov@mail.ru", "+7-222-222-22-22", 30000, 30);
        person[2] = new Personal("Федоров Федор Федорович", "Тестировщик", "fedorov@mail.ru", "+7-333-333-33-33", 40000, 20);
        person[3] = new Personal("Кириллов Кирилл Кириллович", "Бухгалтер", "Kirillov@mail.ru", "+7-444-444-44-44", 70000, 45);
        person[4] = new Personal("Вассерман Альберт Альбертович", "Директор", "Vasserman@mail.ru", "+7-555-555-55-55", 120000, 60);

        for (int i = 0; i < 5; i++)
            if(person[i].getAge()>40)
            person[i].output();
    }
}
