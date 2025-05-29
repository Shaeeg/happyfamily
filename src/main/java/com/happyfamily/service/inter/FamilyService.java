package com.happyfamily.service.inter;

import com.happyfamily.model.Family;

import java.util.List;

public interface FamilyService {
     List<Family> getAllFamilies();

     Family getFamilyByIndex(int index);

     boolean deleteFamily(int index);

     boolean deleteFamily(Family family);

     void saveFamily(Family family);
}
