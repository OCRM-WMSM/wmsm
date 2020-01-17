package com.boc.wms.common.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.boc.common.annotation.DataSource;
import com.boc.common.enums.DataSourceEnum;
import com.boc.mapper.CommonMapper;
import com.boc.wms.common.domain.DwBocBchLvlEntity;
import com.boc.wms.common.domain.OrgTreeEntity;
import com.boc.wms.common.service.CommonService;

@Transactional
@Service
public class CommonServiceImpl implements CommonService {
	@Autowired
	private CommonMapper commonMapper;

	@DataSource(DataSourceEnum.DB1)
	@Override
	public List<OrgTreeEntity> findOrgTree(String orgNo) {
		//查询当前用户信息
		DwBocBchLvlEntity srcOrg=commonMapper.selectAllDwBocBchLvlByOrgId(orgNo);
		//查询子菜单
		List<DwBocBchLvlEntity> list = commonMapper.selectAllChildrenList(srcOrg.getItlBchIdn(),srcOrg.getItlBchLvl());
		if (list == null || list.size() == 0) {
			return Collections.emptyList();
		}
		// 返回菜单树对象
		List<OrgTreeEntity> returnList = new ArrayList<>();
		OrgTreeEntity entity = new OrgTreeEntity();
		int lvl = srcOrg.getItlBchLvl();// 级别
		String orgCode = srcOrg.getItlBchIdn();// 机构号
		entity.setOrgNo(srcOrg.getItlBchIdn());
		entity.setOrgName(srcOrg.getItlBchNme());
		;
		findTreeChildren(lvl, orgCode, list, entity);
		returnList.add(entity);

		return returnList;
	}

	/**
	 * 递归获取机构子机构
	 * 
	 * @param lvl
	 *            当前机构级别
	 * @param orgCode
	 *            当前机构号
	 * @param list
	 *            机构总列表
	 * @param entity
	 *            当前机构数实体
	 */
	private void findTreeChildren(int lvl, String orgCode, List<DwBocBchLvlEntity> list, OrgTreeEntity entity) {
		List<OrgTreeEntity> chiren = new ArrayList<>();
		for (DwBocBchLvlEntity e : list) {
			switch (lvl) {
			case 0:
				// 查找1级行
				if (e.getItlBchLvl() == 1 && e.getLvl0BchIdn().equals(orgCode)) {
					OrgTreeEntity ch = new OrgTreeEntity();
					ch.setOrgNo(e.getItlBchIdn());
					ch.setOrgName(e.getItlBchNme());
					chiren.add(ch);
					findTreeChildren(e.getItlBchLvl(), e.getItlBchIdn(), list, ch);
				}
				continue;
			case 1:
				// 查找2级行
				if (e.getItlBchLvl() == 2 && e.getLvl1BchIdn().equals(orgCode)) {
					OrgTreeEntity ch = new OrgTreeEntity();
					ch.setOrgNo(e.getItlBchIdn());
					ch.setOrgName(e.getItlBchNme());
					chiren.add(ch);
					findTreeChildren(e.getItlBchLvl(), e.getItlBchIdn(), list, ch);
				}
				continue;
			case 2:
				// 查找3级行
				if (e.getItlBchLvl() == 3 && e.getLvl2BchIdn().equals(orgCode)) {
					OrgTreeEntity ch = new OrgTreeEntity();
					ch.setOrgNo(e.getItlBchIdn());
					ch.setOrgName(e.getItlBchNme());
					chiren.add(ch);
					findTreeChildren(e.getItlBchLvl(), e.getItlBchIdn(), list, ch);
				}
				continue;
			case 3:
				if (e.getItlBchLvl() == 4 && e.getLvl3BchIdn().equals(orgCode)) {
					OrgTreeEntity ch = new OrgTreeEntity();
					ch.setOrgNo(e.getItlBchIdn());
					ch.setOrgName(e.getItlBchNme());
					chiren.add(ch);
					findTreeChildren(e.getItlBchLvl(), e.getItlBchIdn(), list, ch);
				}

				continue;
			case 4:
				if (e.getItlBchLvl() == 5 && e.getLvl4BchIdn().equals(orgCode)) {
					OrgTreeEntity ch = new OrgTreeEntity();
					ch.setOrgNo(e.getItlBchIdn());
					ch.setOrgName(e.getItlBchNme());
					chiren.add(ch);
					findTreeChildren(e.getItlBchLvl(), e.getItlBchIdn(), list, ch);
				}
				continue;
			case 5:
				if (e.getItlBchLvl() == 6 && e.getLvl5BchIdn().equals(orgCode)) {
					OrgTreeEntity ch = new OrgTreeEntity();
					ch.setOrgNo(e.getItlBchIdn());
					ch.setOrgName(e.getItlBchNme());
					chiren.add(ch);
					findTreeChildren(e.getItlBchLvl(), e.getItlBchIdn(), list, ch);
				}
				continue;
			case 6:
				OrgTreeEntity ch = new OrgTreeEntity();
				ch.setOrgNo(e.getItlBchIdn());
				ch.setOrgName(e.getItlBchNme());
				chiren.add(ch);
				continue;

			}

		}
		entity.setChildren(chiren);
	}

}
