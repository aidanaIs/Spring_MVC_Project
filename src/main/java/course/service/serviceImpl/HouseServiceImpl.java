package course.service.serviceImpl;

import course.entity.House;
import course.service.HouseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseServiceImpl implements HouseService {
    @Override
    public void saveHouse(House house) {

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
