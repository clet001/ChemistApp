package ng.ourChemist.services;

import ng.ourChemist.models.DispensedDrug;

import java.util.List;

public interface ChemistService {
    String addDrug(String name, String brand, int price);
    String updateDrug(int id, String name, String brand,int price );
    String deleteDrug(int id);
    String dispenseDrugs(List<DispensedDrug> dispenses);
}
