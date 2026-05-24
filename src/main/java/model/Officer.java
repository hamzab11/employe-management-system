package model;

public class Officer {

    private String matricule;
    private String firstName;
    private String lastName;
    private String grade;
    private String returnDate;
    private String gunMatricule;
    private int bullets;
    private int magazines;
    private String badgeNumber;

    public Officer(
            String matricule,
            String firstName,
            String lastName,
            String grade,
            String returnDate,
            String gunMatricule,
            int bullets,
            int magazines,
            String badgeNumber
    ) {

        this.matricule = matricule;
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
        this.returnDate = returnDate;
        this.gunMatricule = gunMatricule;
        this.bullets = bullets;
        this.magazines = magazines;
        this.badgeNumber = badgeNumber;
    }

    public String getMatricule() {
        return matricule;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGrade() {
        return grade;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public String getGunMatricule() {
        return gunMatricule;
    }

    public int getBullets() {
        return bullets;
    }

    public int getMagazines() {
        return magazines;
    }

    public String getBadgeNumber() {
        return badgeNumber;
    }
}