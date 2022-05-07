import java.lang.reflect.Array;
import java.util.Arrays;

public class StartApp {
    private static  float percent = 15f; // индех ЗП процент;
    private static  float percentDep = 5f; // индех отдела ЗП процент;

    static EmployeeBook employeeBook = new EmployeeBook();



    public static void main(String[] args) {
        employeeBook.addEmployees(1,"Силин","Алексей","Валерьевич", 250_000f);
        employeeBook.addEmployees(3,"Булгакова","Александра","Егоровна", 25_500f);
        employeeBook.addEmployees(1,"Майорова","Арина","Тимофеевна", 80_500f);
        employeeBook.addEmployees(2,"Медведева","Екатерина","Алексеевна", 25_000f);
        employeeBook.addEmployees(2,"Никитин","Артур","Артёмович", 35_600f);
        employeeBook.addEmployees(2,"Морозов","Филипп","Анатольевич", 8_950f);
        employeeBook.addEmployees(3,"Калинина","Ирина","Викторовна", 43_200f);
        employeeBook.addEmployees(1,"Мартынов","Арсений","Петрович", 76_300f);
        employeeBook.addEmployees(3,"Демидова","Сифия","Данииловна", 140_800.2555f);
        employeeBook.addEmployees(1,"Михеев","Алесандр","Алексеевич", 35_900f);



        employeeBook.getOneEmployee("Силин","Алексей","Валерьевич");
        employeeBook.setMoneyOrDeportamentOrNameEmployee("Силин","Алексей","Валерьевич","500","5");
        employeeBook.getOneEmployee("Силин","Алексей","Валерьевич");


        employeeBook.getDeportametAllMane();

        employeeBook.getAllEmployee();
        employeeBook.deleteEmployee("Силин","Алексей","Валерьевич",1);
        employeeBook.getAllEmployee();









    }




}
