package com.xu.service;

import java.util.List;

import com.xu.model.Building;
import com.xu.model.House;
import com.xu.model.Project;

public interface CRMService {

	List<String> getHouseOwnerContacts(String houseCode);

	List<Project> getProjectsByCityCode(String city);

	List<Building> getBuildingsByProjectCode(String projectCode);

	List<House> getHousesByBuildingCode(String buildingCode);

	String getOwnerCodeByHouseCodeAndPhone(String houseCode, String phone);

	boolean validateOwnerNameAndCerNo(String customerCode, String name, String cerno);

}
