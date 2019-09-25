package surveys.Beans;

import surveys.DTO.SubjectsDTO;
import surveys.Entities.Subjects;
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
public class SubjectsBean {

    @Inject
    DTOMapper dtoMapper;
    @PersistenceContext(name = "subjects")
    private EntityManager entityManager;

    public void create(SubjectsDTO subjectsDTO) {
        Subjects subjects = new Subjects();
        subjects.setName(subjectsDTO.getName());
        entityManager.persist(subjects);
    }


    public List<SubjectsDTO> readAll() {
        Query query = entityManager.createQuery("select x from Subjects x", Subjects.class);
        List<Subjects> list = query.getResultList();
        return list.stream()
                .map(dtoMapper::mapToSubjectsDTO).collect(Collectors.toList());
    }

    public Subjects find(Long id) {
        return entityManager.find(Subjects.class, id);
    }

    public Result edit(SubjectsDTO subjectsDTO) {
        Subjects subjects;
        try {
            subjects = find(subjectsDTO.getIdSubjects());
        } catch (Exception ex) {
            return Result.FAILURE;
        }
        subjects.setName(subjectsDTO.getName());
        entityManager.merge(subjects);
        return Result.SUCCESS;
    }

    public Result delete(Long id) {
        Subjects subjects;
        try {
            subjects = find(id);
            entityManager.remove(subjects);
            return Result.SUCCESS;
        } catch (Exception ex) {
            return Result.FAILURE;
        }
    }
}
