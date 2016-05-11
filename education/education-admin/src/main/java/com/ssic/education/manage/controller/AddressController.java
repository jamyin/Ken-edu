package com.ssic.education.manage.controller;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssic.education.admin.pageModel.Json;
import com.ssic.education.admin.service.UserServiceI;
import com.ssic.test.common.dto.AddressDto;
import com.ssic.test.common.dto.ProjectDto;
import com.ssic.test.common.pageModel.Tree;
import com.ssic.test.common.pojo.Address;
import com.ssic.test.common.service.IAddressService;
import com.ssic.util.StringUtils;

/**
 * 
 */

/**
 * <p>
 * Title: AddressController
 * </p>
 * <p>
 * Description: 区域controller
 * </p>
 * <p>
 * Copyright (c) 2015
 * </p>
 * <p>
 * Company: 上海天坊信息科技有限公司
 * </p>
 * 
 * @author 刘博
 * @date 2015年8月11日 上午10:46:32
 * @version 1.0
 *          <p>
 *          修改人：刘博
 *          </p>
 *          <p>
 *          修改时间：2015年8月11日 上午10:46:32
 *          </p>
 *          <p>
 *          修改备注：
 *          </p>
 */
@Controller
@RequestMapping("/addressController")
public class AddressController {
	@Autowired
	private IAddressService addressService;
	@Autowired
	private UserServiceI userServiceI;

	/**
	 * 跳转到区域管理页面
	 * 
	 * @return
	 */
	@RequestMapping("/manager")
	public String manager() {
		return "education/address/address";
	}

	@RequestMapping("/tree")
	@ResponseBody
	public List<Tree> tree(String addressId, HttpSession session) {
		// 获取用户拥有的项目权限
		List<ProjectDto> listProject = userServiceI
				.getProjectBySession(session);
		String projId = "";
		if (!CollectionUtils.isEmpty(listProject)) {
			if (listProject.size() > 1) {// 超管
				projId = null;
			} else {
				projId = listProject.get(0).getId();
			}
		}
		return addressService.tree(addressId, projId);
	}

	@RequestMapping("/treeGrid")
	@ResponseBody
	public List<AddressDto> treeGrid(AddressDto addressDto, HttpSession session) {
		// 获取用户拥有的项目权限
		List<ProjectDto> listProject = userServiceI
				.getProjectBySession(session);
		if (!CollectionUtils.isEmpty(listProject)) {
			if (listProject.size() > 1) {// 超管
				addressDto.setProjId(null);
			} else {
				addressDto.setProjId(listProject.get(0).getId());
			}
		}
		return addressService.treeGrid(addressDto);
	}

	/**
	 * 跳转到添加区域页面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/addPage")
	public String addPage(HttpServletRequest request) {

		AddressDto u = new AddressDto();
		u.setId(UUID.randomUUID().toString());
		request.setAttribute("addressDto", u);
		return "education/address/addressAdd";
	}

	/**
	 * 添加区域
	 * 
	 * @return
	 */
	@RequestMapping("/add")
	@ResponseBody
	public Json add(AddressDto addressDto, HttpSession session) {
		// 获取用户拥有的项目权限
		List<ProjectDto> listProject = userServiceI
				.getProjectBySession(session);
		if (!CollectionUtils.isEmpty(listProject)) {
			if (listProject.size() > 1) {// 超管
				addressDto.setProjId(null);
			} else {
				addressDto.setProjId(listProject.get(0).getId());
			}
		}
		Json j = new Json();
		// 如果不是超管角色，且修改的区域父节点为空，才进行根节点的校验
		if (!StringUtils.isEmpty(addressDto.getProjId())
				&& StringUtils.isEmpty(addressDto.getPid())) {
			AddressDto dto = addressService.validAddressRootExists(addressDto);
			if (dto != null) {
				j.setSuccess(false);
				j.setMsg("根节点区域是唯一的，添加失败!");
				return j;
			}
		}
		AddressDto tempDept = new AddressDto();
		tempDept.setAddressName(addressDto.getAddressName());
		tempDept.setStat(1);
		tempDept.setProjId(addressDto.getProjId());
		int counts = addressService.vailAddressName(tempDept);
		if (counts > 0) {
			j.setSuccess(false);
			j.setMsg("区域名称已存在");
			return j;
		}
		try {
			if (!StringUtils.isEmpty(addressDto.getPid())) {
				AddressDto pardDto = addressService.findById(addressDto
						.getPid());
				addressDto.setParentCode(pardDto.getAddressCode());
			}

			addressDto.setStat(1);
			addressDto.setCreateTime(new Date());
			addressService.setAddressCode(addressDto);
			addressService.insert(addressDto);
			j.setSuccess(true);
			j.setMsg("添加区域成功！");
			j.setObj(addressDto);
		} catch (Exception e) {
			// e.printStackTrace();
			j.setMsg(e.getMessage());
		}
		return j;
	}

	/**
	 * 跳转到区域编辑页面
	 * 
	 * @return
	 */
	@RequestMapping("/editPage")
	public String editPage(HttpServletRequest request, String id) {

		AddressDto r = addressService.findById(id);
		r.setPid(r.getParentId());
		request.setAttribute("addressDto", r);
		return "education/address/addressEdit";
	}

	/**
	 * 编辑区域
	 * 
	 * @param resource
	 * @return
	 */
	@RequestMapping("/edit")
	@ResponseBody
	public Json edit(AddressDto addressDto, HttpSession session) {

		// 获取用户拥有的项目权限
		List<ProjectDto> listProject = userServiceI
				.getProjectBySession(session);
		if (!CollectionUtils.isEmpty(listProject)) {
			if (listProject.size() > 1) {// 超管
				addressDto.setProjId(null);
			} else {
				addressDto.setProjId(listProject.get(0).getId());
			}
		}
		Json j = new Json();
		AddressDto tempDept = new AddressDto();
		tempDept.setAddressName(addressDto.getAddressName());
		tempDept.setId(addressDto.getId());
		tempDept.setPid(addressDto.getPid());
		tempDept.setStat(1);
		int counts = addressService.vailAddressName(tempDept);

		if (counts > 0) {
			j.setSuccess(false);
			j.setMsg("区域已存在,请重新修改，亲.");
			return j;
		}
		// 如果不是超管角色，且修改的区域父节点为空，才进行根节点的校验
		if (!StringUtils.isEmpty(addressDto.getProjId())
				&& StringUtils.isEmpty(addressDto.getPid())) {
			// 如果添加的部门的没有父节点,则去数据库查找有没有一条父节点为空的记录，有的话，则提示不能添加。根节点只能有一个.
			AddressDto dto = addressService.validAddressRootExists(addressDto);
			if (dto != null) {
				j.setSuccess(false);
				j.setMsg("区域根节点是唯一的，修改无效!");
				return j;
			}
		}
		AddressDto dd = addressService.findById(addressDto.getId());
		if (!StringUtils.isEmpty(dd.getPid())
				&& (!dd.getPid().equals(addressDto.getPid()))) {
			addressService.setAddressCode(addressDto);
		}
		if (!StringUtils.isEmpty(dd.getPid())
				&& !StringUtils.isEmpty(addressDto.getPid())
				&& !dd.getPid().equals(addressDto.getPid())) {// 如果当前区域的父节点发生改变，则区域编码也要更改;
			addressService.setAddressCode(addressDto);
		}
		addressDto.setCreateTime(dd.getCreateTime());
		addressService.update(addressDto);
		j.setSuccess(true);
		j.setMsg("编辑成功！");
		return j;
	}

	/**
	 * 删除区域
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public Json delete(String id) {
		Json j = new Json();
		List<AddressDto> addressList = addressService
				.findChildListByParentId(id);

		// 部门子集合是否存在用户判断;
		if (!CollectionUtils.isEmpty(addressList)) {
			j.setSuccess(false);
			j.setMsg("删除失败,该区域下还有子区域,不能删除!");
			return j;

		}
		// 删除区域
		Address address = addressService.findAddressById(id);
		AddressDto tempDept = new AddressDto();
		tempDept.setId(id);
		addressService.setAddressCode(tempDept);
		tempDept.setAddressCode(address.getAddressCode());
		tempDept.setAddressName(address.getAddressName());
		tempDept.setCreateTime(address.getCreateTime());
		if (!StringUtils.isEmpty(address.getParentId())) {
			tempDept.setParentId(address.getParentId());
		}
		tempDept.setProjId(address.getProjId());
		addressService.delete(tempDept);

		j.setMsg("删除成功！");
		j.setSuccess(true);
		return j;
	}

}
