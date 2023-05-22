package course.api;

import course.entity.Agency;
import course.entity.House;
import course.entity.enums.HouseType;
import course.service.HouseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/houses")
@RequiredArgsConstructor
public class HouseApi {

    private final HouseService houseService;

    @GetMapping
    public String getAllHouses(Model model){
        model.addAttribute("houses", houseService.getAllHouses());
        return "house/allHouses";
    }

    @GetMapping("/{id}")
    public String getHouseById(@PathVariable("id") Long id, Model model) {
        model.addAttribute("house", houseService.getHouseById(id));
        return "house/housePage";
    }
    @GetMapping("/new")
    public String createHouse(Model model){
        model.addAttribute("newHouse", new House());
        return "house/newHouse";
    }

    @PostMapping("/save")
    public String saveHouse(@ModelAttribute("newHouse") House house){
        houseService.saveHouse(house);
        return "redirect:/houses";
    }

    @GetMapping("/{id}/edit")
    public String updateHouse(@PathVariable("id") Long id,  Model model) {
        model.addAttribute("editHouse", houseService.getHouseById(id));
        return "house/updateHouse";
    }


    @PostMapping("/updateHouse/{id}")
    public String saveUpdate(@ModelAttribute("editHouse") House house, @PathVariable("id") Long id){
      houseService.updateHouseById(id, house);
        return "redirect:/houses";
    }

    @DeleteMapping("/{id}/delete")
    public String deleteHouse(@PathVariable("id") Long id){
        houseService.deleteHouseById(id);
        return "redirect:/houses";
    }

    @GetMapping("/bookedHouses")
        public String getBookedHouses(Model model){
        model.addAttribute("bookedHouses", houseService.getBookedHouses());
        return "house/bookedHouses";
        }

    @GetMapping("/houseType")
    public String sortHouseByType(@RequestParam("HouseType") String houseType, Model model){
        model.addAttribute("houseType",
                houseService.sortHouseByHouseType(HouseType.valueOf(houseType)));
        return "house/sortHouse";
    }




}