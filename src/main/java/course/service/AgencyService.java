package course.service;

import course.Exceptions.MyException;
import course.entity.Agency;

import java.util.List;

public interface AgencyService {
    void saveAgency(Agency agency);
    Agency getAgencyById(Long id);
    List<Agency> getAllAgencies();
    void updateAgency(Long id, Agency agency);
    void deleteAgencyById(Long id);
    List<Agency> searchAgency(String word);
}
