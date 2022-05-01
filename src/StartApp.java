import java.lang.reflect.Array;
import java.util.Arrays;

public class StartApp {
    private static  float percent = 15f; // индех ЗП процент;



    public static void main(String[] args) {


        Employee[] employees = new Employee[10];
        employees[0] = new Employee(1,"Силин","Алексей","Валерьевич", 1_000_000f);
        employees[1] = new Employee(1,"Булгакова","Александра","Егоровна", 25_500f);
        employees[2] = new Employee(1,"Майорова","Арина","Тимофеевна", 80_500f);
        employees[3] = new Employee(2,"Медведева","Екатерина","Алексеевна", 25_000f);
        employees[4] = new Employee(2,"Никитин","Артур","Артёмович", 35_600f);
        employees[5] = new Employee(2,"Морозов","Филипп","Анатольевич", 8_950f);
        employees[6] = new Employee(3,"Калинина","Ирина","Викторовна", 43_200f);
        employees[7] = new Employee(3,"Мартынов","Арсений","Петрович", 76_300f);
        employees[8] = new Employee(3,"Демидова","Сифия","Данииловна", 140_800.2555f);
        employees[9] = new Employee(4,"Михеев","Алесандр","Алексеевич", 35_900f);

        //getAllEmployee(employees);        /// a. Получить список всех сотрудников;
        //getMoneyAllEmployee(employees);   /// b. Сумма затрат на зарплаты в месяц;
        //getMinMoneyEmployee(employees);   /// c. Сотрудник с минимальной зарплатой;
        //getMaxMoneyEmployee(employees);   /// d. Сотрудник с максимальной зарплатой;
        //getAverageAllEmployee(employees); /// e. Среднее значение зарплат;
        //getAllNameEmployee(employees);      /// d. Получить Ф. И. О. всех сотрудников;
        //////////////////////////////////////////////////////////////////////////////////// Повышенная сложность
        //getAllEmployee(employees); // список сотрудников ДО;
        //setUpMoney(employees);  // Индех зарплат у всех сотрудников;
        //getAllEmployee(employees); // список сотрудников ПОСЛЕ;

        getDepMinMoneyEmployee(employees,4); // Сотрудник с минимальной зарплатой;



    }

    //// Базовая сложность;

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

    /*private static void getAverageMoneyOneEmployee(Employee[] employees) {
        float max = employees[0].getMoneyName();
        float average = max / dayMonth;
        String name = "";
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getMoneyName() >= max) {
                max = employees[i].getMoneyName();
                name = employees[i].getSurName() + " " + employees[i].getName() + " " + employees[i].getMidlName();
            }
        }
        System.out.println("Средняя заработная плата сотрудника : " + name + ", составляет: " + average + " рублей.");


    }*/ /// Среднее значение ЗП сотрудника с МАКСИМАЛЬНой ЗП;
    private static void getAverageAllEmployee(Employee[] employees) {
        float allMoney = 0f;
        for (int i = 0; i < employees.length; i++) {

            allMoney += employees[i].getMoneyName();
        }
        float ave = allMoney / employees.length;
        System.out.println("Среднее значение выплат сотрудникам: "+ ave);
    }  //// e. Среднее значение зарплат;

    private static void getAllNameEmployee(Employee[] employees) {
        for (int i = 0; i < employees.length; i++) {
            String name = employees[i].getId() +" "+ employees[i].getSurName() +" "+ employees[i].getName() +" "+ employees[i].getMidlName();
            System.out.println("\nID" + name);
        }
    } ////d. Получить Ф. И. О. всех сотрудников;

    ////Повышенная сложность;
    private static void setUpMoney(Employee[] employees) {
        for (int i = 0; i < employees.length; i++) {
            float upMoney = ((employees[i].getMoneyName() / 100f) * percent) + employees[i].getMoneyName();
            employees[i].setMoneyName(upMoney);
        }
    } // Индех зарплат у всех сотрудников;

    private static void getDepMinMoneyEmployee(Employee[] employees, int department) {
        float min = employees[0].getMoneyName();
        String name = "";
        for (int i = 0; i < employees.length; i++) {
            if (department == employees[i].getDepartmentName()) {
                if (employees[i].getMoneyName() <= min) {
                    min = employees[i].getMoneyName();
                    name = employees[i].getSurName() + " " + employees[i].getName() + " " + employees[i].getMidlName();
                }
            }
        }
        System.out.println("Сотрудник с минимальной заработной платой: " + name
                            + ".\nНаходиться в отделе: " + department
                            + ".\nСумма заработной платы составляет: " + min);
    }  // Сотрудник с минимальной зарплатой;











}
