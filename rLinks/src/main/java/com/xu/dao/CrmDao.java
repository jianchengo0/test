package com.xu.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xu.model.Building;
import com.xu.model.House;
import com.xu.model.Project;

public interface CrmDao {
	List<String> getHouseOwnerContacts(String houseCode);

	List<Project> getProjectsByCityCode(String cityCode);

	List<Building> getBuildingsByProjectId(String projectId);

	List<House> getHousesByBuildingCode(String buildingCode);
	
	List<String> getOwnerPhonesByHouseCode(String houseId);

	String getOwnerIdByHouseCodeAndPhone(@Param(value="houseId")String houseId, @Param(value="phone")String phone);

	boolean validateOwnerNameAndCerNo(@Param(value="customerId")String customerId, @Param(value="name")String name,@Param(value="cerno") String cerno);
}
