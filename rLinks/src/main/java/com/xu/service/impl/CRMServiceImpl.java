package com.xu.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.xu.dao.CrmDao;
import com.xu.model.Building;
import com.xu.model.House;
import com.xu.model.Project;
import com.xu.service.CRMService;

@Service
public class CRMServiceImpl implements CRMService {
	private CrmDao dao = null;
	
	public CrmDao getDao() {
		return dao;
	}

	public void setDao(CrmDao dao) {
		this.dao = dao;
	}

	@Override
	public List<String> getHouseOwnerContacts(String houseCode) {
		return dao.getHouseOwnerContacts(houseCode);
	}

	@Override
	public List<Project> getProjectsByCityCode(String city) {
		return dao.getProjectsByCityCode(city);
	}

	@Override
	public List<Building> getBuildingsByProjectCode(String projectCode) {
		return dao.getBuildingsByProjectId(projectCode);
	}

	@Override
	public List<House> getHousesByBuildingCode(String buildingCode) {
		return dao.getHousesByBuildingCode(buildingCode);
	}

	@Override
	public String getOwnerCodeByHouseCodeAndPhone(String houseCode, String phone) {
		return dao.getOwnerIdByHouseCodeAndPhone(houseCode, phone);
	}

	@Override
	public boolean validateOwnerNameAndCerNo(String customerCode, String name, String cerno) {
		return dao.validateOwnerNameAndCerNo(customerCode, name, cerno);
	}

}
