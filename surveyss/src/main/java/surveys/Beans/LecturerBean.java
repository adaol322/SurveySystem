package surveys.Beans;

import surveys.DTO.LecturersDTO;
import surveys.DTO.LecturersDetailsDTO;
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

    public Result edit(LecturersDetailsDTO lecturersDetailsDTO){
        Lecturers lecturers;
        try{
            lecturers = find(lecturersDetailsDTO.getIdLecturers());
        } catch(Exception ex){
            return Result.FAILURE;
        }
        lecturers.setName(lecturersDetailsDTO.getName());
        lecturers.setSurname(lecturersDetailsDTO.getSurname());
        lecturers.setPhone(lecturersDetailsDTO.getPhone());
        lecturers.setEmail(lecturersDetailsDTO.getEmail());
        lecturers.setTitle(lecturersDetailsDTO.getTitle());
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

    public void create(LecturersDetailsDTO lecturersDetailsDTO){
        Lecturers lecturers = new Lecturers();
        lecturers.setName(lecturersDetailsDTO.getName());
        lecturers.setSurname(lecturersDetailsDTO.getSurname());
        lecturers.setPhone(lecturersDetailsDTO.getPhone());
        lecturers.setEmail(lecturersDetailsDTO.getEmail());
        lecturers.setTitle(lecturersDetailsDTO.getTitle());
        entityManager.persist(lecturers);
    }
}
