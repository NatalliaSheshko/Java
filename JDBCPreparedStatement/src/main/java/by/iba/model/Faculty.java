package by.iba.model;

public class Faculty {

    private long id;
    private String name;
    private String chiefOfFaculty;
    private Integer numberOfStudents;
    private Integer numberOfProfessors;
    private String location;

    public Faculty(){
    }

    public Faculty(String name, String chiefOfFaculty, Integer numberOfStudents, Integer numberOfProfessors, String location){
        this.name = name;
        this.chiefOfFaculty = chiefOfFaculty;
        this.numberOfStudents = numberOfStudents;
        this.numberOfProfessors = numberOfProfessors;
        this.location = location;
    }

    public Faculty(long id, String name, String chiefOfFaculty, Integer numberOfStudents, Integer numberOfProfessors, String location){
        this.id = id;
        this.name = name;
        this.chiefOfFaculty = chiefOfFaculty;
        this.numberOfStudents = numberOfStudents;
        this.numberOfProfessors = numberOfProfessors;
        this.location = location;
    }

    @Override
    public String toString(){
        return "Faculty: " + "id = " + id + ", name = " + name + ", chiefOfFaculty = " + chiefOfFaculty + ", numberOfStudents = " + numberOfStudents + ", numberOfProfessors = " + numberOfProfessors + ", location = " + location + "}";
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getChiefOfFaculty() {
        return chiefOfFaculty;
    }

    public void setChiefOfFaculty(String chiefOfFaculty) {
        this.chiefOfFaculty = chiefOfFaculty;
    }

    public Integer getNumberOfStudents() {
        return numberOfStudents;
    }

    public void setNumberOfStudents(Integer numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
    }

    public Integer getNumberOfProfessors() {
        return numberOfProfessors;
    }

    public void setNumberOfProfessors(Integer numberOfProfessors) {
        this.numberOfProfessors = numberOfProfessors;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
