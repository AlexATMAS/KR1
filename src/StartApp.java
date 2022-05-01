import java.lang.reflect.Array;
import java.util.Arrays;

public class StartApp {

    //static Employee employee;

    public static void main(String[] args) {

        Employee[] employees = new Employee[10];
        employees[0] = new Employee(1,"Силин","Алексей","Валерьевич", 1_000_000f);
        employees[1] = new Employee(1,"Булгакова","Александра","Егоровна", 25_500f);
        employees[2] = new Employee(1,"Майорова","Арина","Тимофеевна", 80_500f);
        employees[3] = new Employee(2,"Медведева","Екатерина","Алексеевна", 25_000f);
        employees[4] = new Employee(2,"Никитин","Артур","Артёмович", 35_600f);
        employees[5] = new Employee(2,"Морозов","Филипп","Анатольевич", 78_950f);
        employees[6] = new Employee(3,"Калинина","Ирина","Викторовна", 43_200f);
        employees[7] = new Employee(3,"Мартынов","Арсений","Петрович", 76_300f);
        employees[8] = new Employee(3,"Демидова","Сифия","Данииловна", 140_800f);
        employees[9] = new Employee(4,"Михеев","Алесандр","Алексеевич", 35_900f);

        //getAllEmployee(employees); //// a. Получить список всех сотрудников;
        //getMoneyAllEmployee(employees); //// b. Сумма затрат на зарплаты в месяц;
        //getMinMoneyEmployee(employees); /// c. Сотрудник с минимальной зарплатой;
        //getMaxMoneyEmployee(employees); /// d. Сотрудник с максимальной зарплатой;


    }

    private static void getAllEmployee(Employee[] employees) {

        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i]);
        }
    }  //// a. Получить список всех сотрудников;

    private static void getMoneyAllEmployee(Employee[] employees) {
        float allMoney = 0f;
        for (int i = 0; i < employees.length; i++) {

            allMoney += employees[i].getMoneyName();
        }
        System.out.println("Сумма затрат на зарплаты в месяц: "+ allMoney);
    }  //// b. Сумма затрат на зарплаты в месяц;

    private static void getMinMoneyEmployee(Employee[] employees) {
        float min = employees[0].getMoneyName();
        String name = "";
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getMoneyName() <= min) {
                min = employees[i].getMoneyName();
                name = employees[i].getSurName() + " " + employees[i].getName() + " " + employees[i].getMidlName();
            }
        }
        System.out.println("Сотрудник: " + name + " ,имеет минимальную заработную плату в размере : " + min + " рублей.");
    } /// c. Сотрудник с минимальной зарплатой;

    private static void getMaxMoneyEmployee(Employee[] employees) {
        float max = employees[0].getMoneyName();
        String name = "";
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getMoneyName() >= max) {
                max = employees[i].getMoneyName();
                name = employees[i].getSurName() + " " + employees[i].getName() + " " + employees[i].getMidlName();
            }
        }
        System.out.println("Сотрудник: " + name + " ,имеет максимальную заработную плату в размере : " + max + " рублей.");
    } /// d. Сотрудник с максимальной зарплатой;








}
