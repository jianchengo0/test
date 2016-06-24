package com.xu.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.xu.model.Building;
import com.xu.model.House;
import com.xu.model.Project;
import com.xu.service.CRMService;

@RestController
@RequestMapping("/api/v1/crm")
public class CRMController {
	private CRMService service = null;

	public CRMService getService() {
		return service;
	}

	@Autowired
	public void setService(CRMService service) {
		this.service = service;
	}

	@InitBinder
	public void initBinder(ServletRequestDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}

	/**
	 * 通过城市编码获取该城市的所有项目
	 * 
	 * @param city
	 * @return
	 */
	@RequestMapping(value = "/city/{city}/projects", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public List<Project> getProjectsByCityCode(@PathVariable("city") String city) {
		return service.getProjectsByCityCode(city);
	}

	/**
	 * 通过项目编码获取该项目所有楼栋
	 * @param projectCode
	 * @return
	 */
	@RequestMapping(value = "/project/{projectCode}/buildings", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public List<Building> getBuildingsByProjectCode(@PathVariable("projectCode") String projectCode) {
		return service.getBuildingsByProjectCode(projectCode);
	}

	/**
	 * 通过楼栋编码获取该楼栋的所有房屋
	 * @param buildingCode
	 * @return
	 */
	@RequestMapping(value = "/building/{buildingCode}/houses", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public List<House> getHousesByBuildingCode(@PathVariable("buildingCode") String buildingCode) {
		return service.getHousesByBuildingCode(buildingCode);
	}

	/**
	 * 通过房屋编码获取业务的电话号码列表
	 * 电话号码隐藏后4位置(length-4)
	 * @param houseCode
	 * @return
	 */
	@RequestMapping(value = "/house/{houseCode}/owner/contacts", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public List<String> getHouseOwnerContacts(@PathVariable("houseCode") String houseCode) {
		return service.getHouseOwnerContacts(houseCode);
	}

	/**
	 * 根据房屋编码和电话号码判断电话号码是否属于业主的号码
	 * 若是业主的号码返回业主的ID否则返回null
	 * @param houseCode
	 * @param phone
	 * @return
	 */
	@RequestMapping(value = "/house/{houseCode}/owner/phones/contains/{phone}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public String getOwnerCodeByHouseCodeAndPhone(@PathVariable("houseCode") String houseCode, @PathVariable("phone") String phone) {
		return service.getOwnerCodeByHouseCodeAndPhone(houseCode,phone);
	}

	/**
	 * 验证业主的姓名和证件号码是否正确.
	 * @param customerCode
	 * @param name
	 * @param cerno
	 * @return
	 */
	@RequestMapping(value = "/customer/{customerCode}/name/{name}/cerno/{cerno}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public boolean validateOwnerNameAndCerNo(@PathVariable("customerCode") String customerCode, @PathVariable("name") String name,@PathVariable("cerno") String cerno) {
		return service.validateOwnerNameAndCerNo(customerCode,name,cerno);
	}
    
}
