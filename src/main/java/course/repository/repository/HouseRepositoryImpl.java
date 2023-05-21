package course.repository.repository;

import course.entity.House;
import course.repository.HouseRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
@RequiredArgsConstructor

public class HouseRepositoryImpl implements HouseRepository {
    private final EntityManager entityManager;

    @Override
    public void saveHouse(House house) {
    entityManager.persist(house);
    }

    @Override
    public List<House> getAllHouses() {
        return null;
    }

    @Override
    public House getHouseById(Long id) {
        return null;
    }

    @Override
    public void updateHouseById(Long id, House house) {

    }

    @Override
    public void deleteHouseById(Long id) {

    }

    @Override
    public List<House> getBookedHouses() {
        return null;
    }

    @Override
    public List<House> sortHouseByHouseType(String ascOrDesc) {
        return null;
    }
}
