package pl.edu.zut.wi.demoweb;

public class Person {
    private String firstName;
    private String familyName;
    private int index;
    public Person(String firstName, String familyName){
        this.firstName = firstName;
        this.familyName = familyName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
