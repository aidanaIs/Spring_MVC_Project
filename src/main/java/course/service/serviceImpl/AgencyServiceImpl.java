package course.service.serviceImpl;

import course.Exceptions.MyException;
import course.entity.Agency;
import course.repository.AgencyRepository;
import course.service.AgencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgencyServiceImpl implements AgencyService {

    private final AgencyRepository agencyRepository;

    @Autowired
    public AgencyServiceImpl(AgencyRepository agencyRepository) {
        this.agencyRepository = agencyRepository;
    }

    @Override
    public void saveAgency(Agency agency) {
     agencyRepository.saveAgency(agency);
    }

    @Override
    public Agency getAgencyById(Long id) {
        return agencyRepository.getAgencyById(id);
    }

    @Override
    public List<Agency> getAllAgencies() {
        return agencyRepository.getAllAgencies();
    }

    @Override
    public void updateAgency(Long id, Agency agency) {
        agencyRepository.updateAgency(id, agency);
    }

    @Override
    public void deleteAgencyById(Long id) {
     agencyRepository.deleteAgencyById(id);
    }

    @Override
    public List<Agency> searchAgency(String word) {
        return agencyRepository.searchAgency(word);
    }

    @Override
    public Long getTotalHouseCount() {
        return agencyRepository.getTotalHouseCount();
    }

    @Override
    public Long getTotalCustomerCount() {
        return agencyRepository.getTotalCustomerCount();
    }
}
