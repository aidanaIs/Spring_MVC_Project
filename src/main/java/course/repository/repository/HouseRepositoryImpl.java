package course.repository.repository;

import course.Exceptions.MyException;
import course.entity.House;
import course.entity.enums.HouseType;
import course.repository.HouseRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
//@RequiredArgsConstructor

public class HouseRepositoryImpl implements HouseRepository {
    @PersistenceContext
    private final EntityManager entityManager;


    @Autowired
    public HouseRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public void saveHouse(House house) {
        entityManager.persist(house);
    }

    @Override
    public List<House> getAllHouses() {
        return entityManager.createQuery("from House h", House.class).getResultList() ;
    }

    @Override
    public House getHouseById(Long id) {
        try {
            House house = entityManager.find(House.class, id);
            if (house.getId().equals(id)) {
                return house;
            } else {
                throw new MyException("House with "+id+" this id is not found!");
            }
        } catch (MyException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void updateHouseById(Long id, House house) {
        try {
            House asHouse = entityManager.find(House.class, id);

            if (asHouse.getId().equals(id)) {
                asHouse.setHouseType(house.getHouseType());
                asHouse.setCountry(house.getCountry());
                asHouse.setAddress(house.getAddress());
                asHouse.setAgency(house.getAgency());
                asHouse.setImage(house.getImage());
                asHouse.setPrice(house.getPrice());
                asHouse.setRoom(house.getRoom());
                asHouse.setDescription(house.getDescription());
                asHouse.setBooking(house.getBooking());

                asHouse.setAgency(house.getAgency());
                entityManager.merge(house);
            } else {
                throw new MyException("House with "+id+" this id is not found!");

            }
        } catch (MyException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void deleteHouseById(Long id) {
        try{
            House house = entityManager.find(House.class, id);
            if (house.getId().equals(id)) {
                entityManager.remove(house);
            } else {
                throw new MyException("House with "+id+" this id is not found!");
            }
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
    }

    //implement later
    @Override
    public List<House> getBookedHouses() {
        return entityManager.createQuery("select h from House h where h.isBooked", House.class).getResultList();
    }

    //implement later

    @Override
    public List<House> sortHouseByHouseType(HouseType houseType) {
        return entityManager.createQuery("select h from House h where h.houseType=:houseType", House.class).setParameter("houseType", houseType).getResultList();
    }
}
