public class Employee {
    private String name;            // Имя сотрудника;
    private String surName;         // Фамилия сотрудника;
    private String midlName;        // Отчество сотрудника;
    private float moneyName;         // Зарплата сотрудника;
    private int departmentName;     // Отдел сотрудника;
    private int id = 0;             // id сотрудника;
    private static int count;       // счетчик сотрудников;




    public Employee(int departmentName,String surName, String name,String midlName,float moneyName) {
        this.departmentName = departmentName;
        this.surName = surName;
        this.name = name;
        this.midlName = midlName;
        this.moneyName = moneyName;
        count++;
        this.id = count;
    }

    public String getName() {
        return name;
    }

    public String getSurName() {
        return surName;
    }

    public String getMidlName() {
        return midlName;
    }

    public float getMoneyName() {
        return moneyName;
    }

    public int getDepartmentName() {
        return departmentName;
    }

    public int getId() {
        return id;
    }


    public void setMoneyName(float moneyName) {
        this.moneyName = moneyName;
    }

    public void setDepartmentName(int departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public String toString() {
        return "\"" + "ID-" + id + "\" " + "Информация о сотруднике: Отдел-" + departmentName+ " " + surName + " "  + name + " " + midlName + "."
        +"Заработная плата сотрудника: " + moneyName + " рублей.";

    }
}
