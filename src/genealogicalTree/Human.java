package genealogicalTree;
import java.io.Serializable;
import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Human
 */
public class Human implements Serializable, Comparable<Human> {
    private String name;
    private String gender;
    private Calendar birthDate;
    private Calendar deadDate;
    private Human father;
    private Human mother;
    private ArrayList<Human> children;

    public Human(String name, String gender, int day, int month, int year){
        this.name = name;
        this.gender = gender;
        this.birthDate = new GregorianCalendar(year, month-1, day);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }
    
    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getDeadDate() {
        return deadDate.get(Calendar.YEAR);
    }

    public void setDeadDate(int day, int month, int year) {
        this.deadDate = new GregorianCalendar(year, month-1, day);
    }
    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public Integer getBirthDate() {
        return birthDate.get(Calendar.YEAR);
    }

    public void setBirthDate(Calendar birthDate) {
        this.birthDate = birthDate;
    }

    public void addParents(Human father, Human mother){
        this.father = father;
        this.mother = mother;
    }

    public void addChild(Human human){
        this.children = new ArrayList<>();
        children.add(human);
    }

    public void addDeadDate(Calendar deadDate){
        this.deadDate = deadDate;
    }
    
    public void printChildren(){
        if (!children.isEmpty()){
            System.out.print("Дети " + name + ":");
            for (Human child : children) {
                System.out.print(" " + child.getName());
            }
        }
        else{
            System.out.println("У " + name + " детей нет.");
        }
    }

    public void printParrents(){
        System.out.print("Имя отца" + father.getName());
        System.out.print("Имя матери" + mother.getName());
    }

    public void printMember(){
        System.out.println("Имя: " + name);
        System.out.println("Пол: " + gender);
        System.out.println("Дата рождения: " + birthDate.get(Calendar.DAY_OF_MONTH) + "." + birthDate.get(Calendar.MONTH) + "." + birthDate.get(Calendar.YEAR));
        if (deadDate != null){
            System.out.println("Дата смерти: " + deadDate.get(Calendar.DAY_OF_MONTH) + "." + deadDate.get(Calendar.MONTH + 1) + "." + deadDate.get(Calendar.YEAR));
        }
        if (father != null){
            System.out.println("Отец: " + father.getName());
            System.out.println("Мать: " + mother.getName());
        }
        if (children != null){
            System.out.print("Дети:");
            for (Human child : children) {
                System.out.print(" " + child.getName());
            }
            System.out.println();
        }
        System.out.println("_______________________");
    }
    
    @Override
    public int compareTo(Human o) {
        return name.compareTo(o.name);
    }
}