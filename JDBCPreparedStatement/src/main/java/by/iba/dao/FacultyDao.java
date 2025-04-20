package by.iba.dao;

import by.iba.model.Faculty;

import java.sql.*;

public class FacultyDao {
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    int st;//status

    public int insert(Faculty faculty) {
        con = ConnectionFactory.getConnection();
        try {
            String query = "insert into faculty(name, chiefOfFaculty, numberOfStudents, numberOfProfessors, location)"
                    + "values(?,?,?,?,?)";
            ps = con.prepareStatement(query);
            ps.setString(1, faculty.getName());
            ps.setString(2, faculty.getChiefOfFaculty());
            ps.setInt(3, faculty.getNumberOfStudents());
            ps.setInt(4, faculty.getNumberOfProfessors());
            ps.setString(5, faculty.getLocation());
            st = ps.executeUpdate();
            System.out.println("insert faculty " + st);
        } catch (SQLIntegrityConstraintViolationException e) {
            st = -1;
            e.printStackTrace();
        } catch (Exception e) {
            st = -2;
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return st;
    }

    public int update(Faculty faculty) {
        con = ConnectionFactory.getConnection();
        try {
            String query = "update faculty set name=?, chiefOfFaculty=?, numberOfStudents=?, numberOfProfessors=?, location=?"
                    + "where id=?";
            ps = con.prepareStatement(query);
            ps.setString(1, faculty.getName());
            ps.setString(2, faculty.getChiefOfFaculty());
            ps.setInt(3, faculty.getNumberOfStudents());
            ps.setInt(4, faculty.getNumberOfProfessors());
            ps.setString(5, faculty.getLocation());
            ps.setLong(6,faculty.getId());
            st = ps.executeUpdate();
            System.out.println("update faculty " + st);
        } catch (Exception e) {
            st = -2;
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return st;
    }

    public int delete(long id) {
        con = ConnectionFactory.getConnection();
        try {
            String query = "delete from faculty where id=?";
            ps = con.prepareStatement(query);
            ps.setLong(1,id);
            st = ps.executeUpdate();
            System.out.println("delete faculty " + st);
        } catch (Exception e) {
            st = -2;
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return st;
    }

    public Faculty searchById(long id) {
        Faculty faculty = new Faculty();
        con = ConnectionFactory.getConnection();
        try {
            String query = "select * from faculty where id=?";
            ps = con.prepareStatement(query);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                faculty.setId(rs.getLong("id"));
                faculty.setName(rs.getString("name"));
                faculty.setChiefOfFaculty(rs.getString("chiefOfFaculty"));
                faculty.setNumberOfStudents(rs.getInt("numberOfStudents"));
                faculty.setNumberOfProfessors(rs.getInt("numberOfProfessors"));
                faculty.setLocation(rs.getString("location"));
            }
        } catch (Exception e) {
            st = -2;
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return faculty;
    }
}
