package course.service.serviceImpl;

import course.entity.House;
import course.entity.enums.HouseType;
import course.repository.HouseRepository;
import course.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseServiceImpl implements HouseService {

    private final HouseRepository houseRepository;

    @Autowired
    public HouseServiceImpl(HouseRepository houseRepository) {
        this.houseRepository = houseRepository;
    }

    @Override
    public void saveHouse(House house) {
        houseRepository.saveHouse(house);
    }

    @Override
    public List<House> getAllHouses() {
        return houseRepository.getAllHouses();
    }

    @Override
    public House getHouseById(Long id) {
        return houseRepository.getHouseById(id);
    }

    @Override
    public void updateHouseById(Long id, House house) {
       houseRepository.updateHouseById(id, house);
    }

    @Override
    public void deleteHouseById(Long id) {
        houseRepository.deleteHouseById(id);
    }

    @Override
    public List<House> getBookedHouses() {
        return houseRepository.getBookedHouses();
    }

    @Override
    public List<House> sortHouseByHouseType(HouseType houseType) {
        return houseRepository.sortHouseByHouseType(houseType);
    }
}
