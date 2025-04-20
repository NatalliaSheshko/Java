package jaxb.test;

import jaxb.model.Department;
import jaxb.model.Employee;
import jaxb.model.Organization;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class TestExample {

    //private static final String XML_FILE = "dept-info.xml";
    private static final String XML_FILE = "org-dept-info.xml";

    public static void main(String[] args) {

        Employee emp1 = new Employee("E01", "Tom", null);
        Employee emp2 = new Employee("E02", "Mary", "E01");
        Employee emp3 = new Employee("E03", "John", null);

        List<Employee> list = new ArrayList<Employee>();
        list.add(emp1);
        list.add(emp2);
        list.add(emp3);

        Department dept1 = new Department("D01", "ACCOUNTING", "NEW YORK");
        Department dept2 = new Department("D02", "TESTING", "NEW YORK");
        List<Department> list1 = new ArrayList<Department>();
        list1.add(dept1);
        list1.add(dept2);
        dept1.setEmployees(list);
        dept2.setEmployees(list);

        Organization organization = new Organization(1, "New organization", 123456789);
        List<Organization> list2 = new ArrayList<Organization>();
        list2.add(organization);

        organization.setDepartments(list1);
        try {
            // create JAXB context and instantiate marshaller
            JAXBContext context = JAXBContext.newInstance(Organization.class);

            // (1) Marshaller : Java Object to XML content.
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            m.marshal(organization, System.out);

            // Write to File
            File outFile = new File(XML_FILE);
            m.marshal(organization, outFile);

            System.err.println("Write to file: " + outFile.getAbsolutePath());
// (2) Unmarshaller : Read XML content to Java Object.
            Unmarshaller um = context.createUnmarshaller();

            // XML file create before.


            //Organization deptFromFile1 = (Organization) um.unmarshal(new FileReader(XML_FILE));
            Organization orgFromFile = (Organization) um.unmarshal(new FileReader(XML_FILE));
            List<Department> depts = orgFromFile.getDepartments();
            for (Department dept : depts) {
                System.out.println("Department: " + dept.getDeptNo());

                List<Employee> emps = dept.getEmployees();
                for (Employee emp : emps) {
                    System.out.println("Employee: " + emp.getEmpName());
                }
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}

