package jaxb.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "organization")
@XmlAccessorType(XmlAccessType.FIELD)

public class Organization {
    private Integer id;
    private String name;
    private Integer inn;

    @XmlElementWrapper(name = "departments")
    @XmlElement(name = "department")
    private List<Department> departments;

    public Organization(){

    }

    public Organization(Integer id, String name, Integer inn) {
        this.id = id;
        this.name = name;
        this.inn = inn;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getInn() {
        return inn;
    }

    public void setInn(Integer inn) {
        this.inn = inn;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }


    public List<Employee> getEmployees() {
        return null;
    }

    /*public void setDepartments(List<Employee> list) {
        this.departments = departments;
    }*/
}
