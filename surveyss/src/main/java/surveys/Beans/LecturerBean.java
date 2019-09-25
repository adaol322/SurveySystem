package surveys.Beans;

import surveys.DTO.LecturersDTO;
import surveys.Entities.Lecturers;
import surveys.Utility.DTOMapper;
import surveys.Utility.Result;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class LecturerBean {
    @PersistenceContext(name = "lecturers")
    private EntityManager entityManager;

    @Inject
    DTOMapper dtoMapper;

    public List<LecturersDTO> readAll() {
        Query query = entityManager.createQuery("select x from Lecturers x", Lecturers.class);
        List<Lecturers> list = query.getResultList();
        return list.stream()
                .map(dtoMapper::mapToLecturersDTO).collect(Collectors.toList());
    }

    public Lecturers find(Long id) {
        return entityManager.find(Lecturers.class, id);
    }

    public Result edit(LecturersDTO lecturersDTO){
        Lecturers lecturers;
        try{
            lecturers = find(lecturersDTO.getIdLecturers());
        } catch(Exception ex){
            return Result.FAILURE;
        }
        lecturers.setName(lecturersDTO.getName());
        lecturers.setSurname(lecturersDTO.getSurname());
        entityManager.merge(lecturers);
        return Result.SUCCESS;
    }

    public Result delete(Long id){
        Lecturers lecturers;
        try{
            lecturers = find(id);
            entityManager.remove(lecturers);
            return Result.SUCCESS;
        } catch(Exception ex){
            return Result.FAILURE;
        }
    }

    public void create(LecturersDTO lecturersDTO){
//        if(!lecturersDTO.validate().isValid())
//            return Result.FAILURE;
        Lecturers lecturers = new Lecturers();
        lecturers.setName(lecturersDTO.getName());
        lecturers.setSurname(lecturersDTO.getSurname());
        entityManager.persist(lecturers);
//        return Result.SUCCESS;
    }
}
