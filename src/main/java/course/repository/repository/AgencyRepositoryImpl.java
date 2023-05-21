package course.repository.repository;

import course.entity.Agency;
import course.repository.AgencyRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import course.Exceptions.MyException;

import java.util.List;

@Repository
@Transactional
public class AgencyRepositoryImpl implements AgencyRepository {
//remake repository

//    I - Agency дe канча house жана customer бар экенин чыгара алышыбыз керек, (саны)
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void saveAgency(Agency agency) {
        Query query = entityManager.createQuery("SELECT a FROM Agency a WHERE a.name = :name");
        query.setParameter("name", agency.getName());

        List<Agency> existingAgencies = query.getResultList();
        if (!existingAgencies.isEmpty()) {
            throw new IllegalStateException("An agency with the same name already exists.");
        }
        entityManager.persist(agency);
    }

    @Override
    public Agency getAgencyById(Long id) {
        try {
            Agency agency = entityManager.find(Agency.class, id);
            if (agency.getId().equals(id)) {
                return agency;
            } else {
                throw new MyException("Agent of this" + id + "was not found");
            }
        } catch (MyException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Agency> getAllAgencies() {
        return entityManager.createQuery("from Agency a", Agency.class).getResultList();
    }

    @Override
    public void updateAgency(Long id, Agency agency) {
        try {
            Agency agency1 = entityManager.find(Agency.class, id);
            boolean isFalse = true;
            if (agency1.getId().equals(id)) {
                agency1.setName(agency.getName());
                agency1.setCountry(agency.getCountry());
                agency1.setPhoneNumber(agency.getPhoneNumber());
                agency1.setEmail(agency.getEmail());
                agency1.setImage(agency.getImage());
                entityManager.merge(agency1);
                isFalse = false;
            } else {
                throw new MyException("Agent of this" + id + "was not found");

            }
        } catch (MyException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void deleteAgencyById(Long id) {
        try {
            Agency agency = entityManager.find(Agency.class, id);
            if (agency.getId().equals(id)) {
                entityManager.remove(agency);
            } else {
                throw new MyException("Agent of this"
                        + id + "was not found");
            }
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Agency> searchAgency(String word)  {

        return entityManager.createQuery("select u from Agency u where u.name ilike :word", Agency.class)
                .setParameter("word", "%" + word + "%")
                .getResultList();
    }
}
