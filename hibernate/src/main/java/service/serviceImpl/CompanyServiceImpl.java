package service.serviceImpl;

import dao.CompanyDao;
import dao.daoImpl.CompanyDaoImpl;
import entity.Company;
import entity.Person;
import exception.ShowException;
import org.hibernate.HibernateError;
import org.hibernate.Session;
import org.hibernate.Transaction;
import service.CompanyService;
import sessionFactory.SessionFactoryImpl;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class CompanyServiceImpl implements CompanyService {

    CompanyDao companyDao = new CompanyDaoImpl();

    public CompanyServiceImpl() {}

    @Override
    public boolean addCompany(Company company) {
        boolean isAdded = false;
        try {
            companyDao.addCompany(company);
            isAdded = true;
        }
        catch (HibernateError e) {
            ShowException.showNotice(e);
        }
        return isAdded;
    }

    @Override
    public boolean updateCompany(Company company) {
        boolean isUpdated = false;
        try {
            if (companyDao.updateCompany(company))
                isUpdated = true;
        }
        catch (HibernateError e) {
            ShowException.showNotice(e);
        }
        return isUpdated;
    }

    @Override
    public boolean deleteCompany(int id) {
        boolean isDeleted = false;
        try {
            if (companyDao.deleteCompany(id))
                isDeleted = true;
        }
        catch (HibernateError e) {
            ShowException.showNotice(e);
        }
        return isDeleted;
    }

    @Override
    public List<Company> showCompanies() {
        List<Company> company = null;
        try {
            company = companyDao.showCompanies();
        }
        catch (HibernateError e) {
            ShowException.showNotice(e);
        }
        return company;
    }

    @Override
    public Company findCompanyById(int id) {
        System.out.println("Это ДЗ");
        //return company;
        return null;
    }

    @Override
    public Company findCompanyByName(String name) {
        Company company = null;
        try {
            company = companyDao.findCompanyByName(name);
        }
        catch (NoClassDefFoundError e) {
            System.out.println("Exception: " + e);
        }
        return company;
    }
}

