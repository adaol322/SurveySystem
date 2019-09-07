package surveys.Beans;

import surveys.DTO.LecturersDTO;
import surveys.Entities.Lecturers;
import surveys.Utility.DTOMapper;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class LecturerBean {
    @PersistenceContext(name = "lecturers")
    private EntityManager entityManager;

    public List<Lecturers> readAll() {
        Query query = entityManager.createQuery("select x from Lecturers x", Lecturers.class);
        List<Lecturers> list = query.getResultList();
        return list;
    }

    public Lecturers find(Long id) {
        return entityManager.find(Lecturers.class, id);
    }

    public void edit(Long id){
        entityManager.createQuery("update Lecturers set name='asdf' where idLecturers=id", Lecturers.class);
    }
}
