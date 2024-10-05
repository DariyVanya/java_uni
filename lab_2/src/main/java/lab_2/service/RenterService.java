package lab_2.service;

import lab_2.Renter;

import java.util.List;
import java.util.stream.Collectors;

public class RenterService {
    private final List<Renter> renters;

    public RenterService(List<Renter> renter) {
        this.renters = renter;
    }

    public List<Renter> findByFirstName (String firstName){
        return renters.stream()
                .filter(renter -> renter.getFirstName().equals(firstName))
                .collect(Collectors.toList());
    }

    public List<Renter> findByDocumentID (String docID){
        return renters.stream()
                .filter(renter -> renter.getDocumentId().equals(docID))
                .collect(Collectors.toList());
    }

    public List<Renter> findParticularlyByDocumentID (String docID){
        return renters.stream()
                .filter(renter -> renter.getDocumentId().contains(docID))
                .collect(Collectors.toList());
    }

    public List<Renter> findByDriverLicense (String license){
        return renters.stream()
                .filter(renter -> renter.getDriverLicense().equals(license))
                .collect(Collectors.toList());
    }

    public List<Renter> findParticularlyByDriverLicense (String license){
        return renters.stream()
                .filter(renter -> renter.getDriverLicense().contains(license))
                .collect(Collectors.toList());
    }
}
