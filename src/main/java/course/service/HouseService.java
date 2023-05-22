package course.service;

import course.entity.House;
import course.entity.enums.HouseType;

import java.util.List;

public interface HouseService {
    void saveHouse(House house);
    List<House> getAllHouses();
    House getHouseById(Long id);
    void updateHouseById(Long id, House house);
    void deleteHouseById(Long id);
    List<House> getBookedHouses();
    List<House> sortHouseByHouseType(HouseType houseType);
}
