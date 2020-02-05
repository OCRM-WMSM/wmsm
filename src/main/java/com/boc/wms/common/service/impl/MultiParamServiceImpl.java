package com.boc.wms.common.service.impl;

import com.boc.wms.common.dao.MultiOpDao;
import com.boc.wms.common.dao.MultiParamDao;
import com.boc.wms.common.domain.MultParamOpEntity;
import com.boc.wms.common.domain.MultiParamEntity;
import com.boc.wms.common.domain.ParamEntity;
import com.boc.wms.common.service.MultiParamService;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MultiParamServiceImpl implements MultiParamService {

    @Resource
    private MultiParamDao multiParamDao;

    @Resource
    private MultiOpDao multiOpDao;

    @Override
    public List<ParamEntity> listMultiParamByCodeList(List<String> codeList) {
        if (CollectionUtils.isEmpty(codeList)) {
            return Collections.EMPTY_LIST;
        }
        List<MultiParamEntity> multiParamList = multiParamDao.listMultiParamByCodeList(codeList);
        if (CollectionUtils.isEmpty(multiParamList)) {
            return Collections.EMPTY_LIST;
        }

        List<Integer> seqMultList = multiParamList.stream().map(MultiParamEntity::getSeqMult).collect(Collectors.toList());
        List<MultParamOpEntity> paramOpEntityList = multiOpDao.listMultiOpEntityByseqMultList(seqMultList);
        if (CollectionUtils.isEmpty(paramOpEntityList)) {
            return Collections.EMPTY_LIST;
        }
        List<ParamEntity> paramEntityList = Lists.newArrayList();
        for (MultiParamEntity multiParamEntity : multiParamList) {
            List<MultParamOpEntity> multParamOpEntityList = paramOpEntityList.stream().filter(t -> t.getSeqMult().equals(multiParamEntity.getSeqMult())).collect(Collectors.toList());
            ParamEntity paramEntity = new ParamEntity(multiParamEntity, multParamOpEntityList);
            paramEntityList.add(paramEntity);
        }

        return paramEntityList;
    }
}
