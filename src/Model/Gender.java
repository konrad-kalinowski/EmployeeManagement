package Model;

public class Gender {

    private final String gender;
    private final int retirementAge;

    public Gender(String gender, int retirementAge) {
        this.gender = gender;
        this.retirementAge = retirementAge;
    }

    public String getGender() {
        return gender;
    }

    public int getRetirementAge() {
        return retirementAge;
    }
}
