package service;

import Entity.AdminEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import dao.AdminDao;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.Marshaller;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class AdminServiceImp implements AdminService{

    @Autowired
    private AdminDao adminDao;

    @Transactional
    @Override
    public long save(AdminEntity admin) {
        return adminDao.save(admin);
    }

    @Override
    public AdminEntity get(long id) {
        return adminDao.get(id);
    }

    @Override
    public List<AdminEntity> list() {
        return adminDao.list();
    }
    @Transactional
    @Override
    public void update(long id, AdminEntity admin) {
        adminDao.update(id, admin);
    }

    @Transactional
    @Override
    public void delete(long id) {
        adminDao.delete(id);
    }
}
