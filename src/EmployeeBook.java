import java.util.Arrays;
import java.util.Objects;

public class EmployeeBook {

    private Employee[] employees = new Employee[10];

    public void addEmployees(int departmentName,String surName, String name,String midlName,float moneyName) {
        int count = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = new Employee(departmentName,surName,name,midlName,moneyName);
                count = employees[i].getId();
                break;
            }
        }
        System.out.println("Новый сотрудник добавлен!" + "ID:"+ count);
    } // Добавление сотрудника;

    public void deleteEmployee(String surName, String name,String midlName,int id) {
        for (int i = 0; i < employees.length; i++) {
            boolean trueName = surName.equals(employees[i].getSurName()) && name.equals(employees[i].getName()) && midlName.equals(employees[i].getMidlName());
            boolean trueId = id == employees[i].getId();
            if ( trueName && trueId ) {
                int count = employees[i].getId() ;
                employees[i] = null;
                System.out.println("Сотрудник " + "ID:"+ count + " удален!");
            }else
                System.out.println("Сотрудник не найден , проверьте вводимые данные!");
        }

    } // Удаление сотрудника;

    public void setMoneyOrDeportamentOrNameEmployee(String surName, String name,String midlName,String money,String dep) {
        for (int i = 0; i < employees.length; i++) {
            boolean trueName = surName.equals(employees[i].getSurName()) && name.equals(employees[i].getName()) && midlName.equals(employees[i].getMidlName());
            if (trueName) {
                if (!Objects.equals(money, "") && !Objects.equals(dep, "")) {
                    employees[i].setDepartmentName(Integer.parseInt(dep));
                    employees[i].setMoneyName(Float.parseFloat(money));
                    break;
                } else if (Objects.equals(money, "") && !Objects.equals(dep, "")) {
                    employees[i].setDepartmentName(Integer.parseInt(dep));
                    break;
                } else if (Objects.equals(dep, "") && !Objects.equals(money, "")) {
                    employees[i].setMoneyName(Float.parseFloat(money));
                    break;
                }else
                    System.out.println("Нет изменений, проверьте вводимые данные!");
                    break;
            } else
                System.out.println("Имя сотрудника не найдено, проверьте вводимые данные!");
        }
    } /// Изменение отдела и/или зарплаты у сотрудника;


    public void getOneEmployee(String surName, String name,String midlName) {
        for (int i = 0; i < employees.length; i++) {
            boolean trueName = surName.equals(employees[i].getSurName()) && name.equals(employees[i].getName()) && midlName.equals(employees[i].getMidlName());
            if (trueName) {
                System.out.println("Данне сотрудника: " + employees[i].getSurName() +" "+ employees[i].getName() +" "+ employees[i].getMidlName() + " Отдел: "
                + employees[i].getDepartmentName() +" Зарплата: " + employees[i].getMoneyName() + " рублей.");
                break;
            }else
                System.out.println("Сотрудник не найден , проверьте вводимые данные!");
        }
    } //// Получить данные сотрудника по ФИО;


    public void getDeportametAllMane() {

        boolean sorted = false;
        Employee temp;
        while(!sorted) {
            sorted = true;
            for (int i = 0; i < employees.length-1; i++) {
                temp = employees[i];
                if (employees[i].getDepartmentName() > employees[i + 1].getDepartmentName()) {
                    temp = employees[i];
                    employees[i] = employees[i + 1];
                    employees[i + 1] = temp;
                    sorted = false;
                }
            }
        }
        getAllEmployee();
    }















    public void getAllEmployee() {

        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i]);
        }
    }  //// a. Получить список всех сотрудников;

    public void getMoneyAllEmployee() {
        float allMoney = 0f;
        for (int i = 0; i < employees.length; i++) {

            allMoney += employees[i].getMoneyName();
        }
        System.out.println("Сумма затрат на зарплаты в месяц: "+ allMoney);
    }  //// b. Сумма затрат на зарплаты в месяц;

    public void getMinMoneyEmployee() {
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

    public void getMaxMoneyEmployee() {
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

    public void getAverageAllEmployee() {
        float allMoney = 0f;
        for (int i = 0; i < employees.length; i++) {

            allMoney += employees[i].getMoneyName();
        }
        float ave = allMoney / employees.length;
        System.out.println("Среднее значение выплат сотрудникам: "+ ave);
    }  //// e. Среднее значение зарплат;

    public void getAllNameEmployee() {
        for (int i = 0; i < employees.length; i++) {
            String name = employees[i].getId() +" "+ employees[i].getSurName() +" "+ employees[i].getName() +" "+ employees[i].getMidlName();
            System.out.println("\nID" + name);
        }
    } ////d. Получить Ф. И. О. всех сотрудников;

    ////Повышенная сложность;
    public void setUpMoney(float percentAll) {
        for (int i = 0; i < employees.length; i++) {
            float upMoney = ((employees[i].getMoneyName() / 100f) * percentAll) + employees[i].getMoneyName();
            employees[i].setMoneyName(upMoney);
        }
    } // 1.Индех зарплат у всех сотрудников;

    public void getDepMinMoneyEmployee(int department) {
        float min = 0f;
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
    }  //2a. Сотрудник с минимальной зарплатой;

    public void getDepMaxMoneyEmployee(int department) {
        float max = 0f;
        String name = "";
        for (int i = 0; i < employees.length; i++) {
            if (department == employees[i].getDepartmentName()) {
                if (employees[i].getMoneyName() >= max) {
                    max = employees[i].getMoneyName();
                    name = employees[i].getSurName() + " " + employees[i].getName() + " " + employees[i].getMidlName();
                }
            }
        }
        System.out.println("Сотрудник с максимальной заработной платой: " + name
                + ".\nНаходиться в отделе: " + department
                + ".\nСумма заработной платы составляет: " + max);

    } // 2b. Сотрудник с максимальной зарплатой;

    public void getDepartmentMoney(int department) {
        float depMoney =0f;
        for (int i = 0; i < employees.length; i++) {
            if (department == employees[i].getDepartmentName()) {
                depMoney += employees[i].getMoneyName();
            }
        }
        System.out.println("Сумма затрат на зарплату по отделу: " + department
                + ".\nРавняется: " + depMoney + " рублей.");



    } //2c. Сумма затрат на зарплату по отделу;

    public void getAveDepMoney(int department) {
        int count = 0;
        float allMoneyDep = 0f;
        float average = 0f;
        for (int i = 0; i < employees.length; i++) {
            if (department == employees[i].getDepartmentName()) {
                count++;
                allMoneyDep += employees[i].getMoneyName();
            }
            average = allMoneyDep / count;
        }
        System.out.println("Средняя зарплата по отделу: " + department
                + ".\nРавняется: " + average + " рублей.");
    } // 2d. Средняя зарплата по отделу;

    public void setUpMoneyDep(int department,float percentDep) {
        for (int i = 0; i < employees.length; i++) {
            if (department == employees[i].getDepartmentName()) {
                float upMoney = ((employees[i].getMoneyName() / 100f) * percentDep) + employees[i].getMoneyName();
                employees[i].setMoneyName(upMoney);
            }
        }
    } //2e.Индех зарплат у всех сотрудников отдела;

    public void getListDeportment(int department) {
        for (int i = 0; i < employees.length; i++) {
            if (department == employees[i].getDepartmentName()) {
                String depNameAll = "\"" + "ID-" + employees[i].getId() + "\" "
                        + "Информация: " + " "
                        + employees[i].getSurName() + " "  + employees[i].getName() + " " + employees[i].getMidlName() + "."
                        +"Заработная плата сотрудника: " + employees[i].getMoneyName() + " рублей.";
                System.out.println("Сотрудник отдела: " + depNameAll);
            }
        }

    } //2f.Напечатать всех сотрудников отдела (все данные, кроме отдела);

    public void getSearchMin(float number) {
        for (int i = 0; i <employees.length; i++) {
            if (number > employees[i].getMoneyName()) {
                String nameMin = "\"" + "ID-" + employees[i].getId() + "\" "
                        + "Информация: " + " "
                        + employees[i].getSurName() + " "  + employees[i].getName() + " " + employees[i].getMidlName() + "."
                        +"Заработная плата сотрудника: " + employees[i].getMoneyName() + " рублей.";
                System.out.println("Сотрудники с зарплатой меньше введеного значения: " + nameMin);
            }
        }
    } // 3a. Сотрудники с ЗП ниже значения;


    public void getSearchMax(float number) {
        for (int i = 0; i <employees.length; i++) {
            if (number <= employees[i].getMoneyName()) {
                String nameMin = "\"" + "ID-" + employees[i].getId() + "\" "
                        + "Информация: " + " "
                        + employees[i].getSurName() + " "  + employees[i].getName() + " " + employees[i].getMidlName() + "."
                        +"Заработная плата сотрудника: " + employees[i].getMoneyName() + " рублей.";
                System.out.println("Сотрудники с зарплатой ,больше или равной введеному значению: " + nameMin);
            }
        }
    } // 3a. Сотрудники с ЗП выше значения;
}
