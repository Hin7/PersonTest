/*
* Решение задачи по второму занятию школы Java-программистов
*
* @version 1.0 05.11.2019
* @author Hin7
 */


public class Person {
    private final boolean man; // пол
    private final String name; // имя
    private Person spouse;     // супруг

    public Person(boolean man, String name) {
        this.man = man;
        this.name = name;
    }

    /**
     * This method checks gender of persons. If genders are not equal - tries to marry.
     * If one of them has another spouse - execute divorce(sets spouse = null for husband and wife. Example: if both persons have spouses - then divorce will set 4 spouse to null) and then executes marry().
     *
     * @param person - new husband/wife for this person.
     * @return - returns true if this person has another gender than passed person and they are not husband and wife, false otherwise
     */
    public boolean marry(Person person) {
        if (man == person.man) return false;
        if (spouse == person) return false;
        if (person.spouse != null) person.divorce();
        if(spouse != null) divorce();
        person.spouse = this;
        this.spouse = person;
        return true;
    }

    /**
     * Sets spouse = null if spouse is not null
     * @return true - if person status has been changed
     */
    public boolean divorce(){
        if(spouse == null) return false;
        spouse.spouse = null;
        spouse = null;
        return true;
    }

    public String getName() {
        return name;
    }

    boolean isMarried(){
        return spouse != null;
    }

    public boolean isMan() {
        return man;
    }

    @Override
    public String toString() {
        String result;
        if(man){
            result = name + " " + "мужчина " + (spouse == null ? "холост" : ("женат на " + spouse.name));
        } else {
            result = name + " " + "женщина " + (spouse == null ? "не замужем" : ("замужем за " + spouse.name));
        }
        return result;
    }
}
