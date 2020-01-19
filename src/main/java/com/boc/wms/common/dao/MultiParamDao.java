package com.boc.wms.common.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.boc.mapper.MultiParamMapper;
import com.boc.wms.common.domain.MultiParamDb;
import com.boc.wms.common.domain.MultiParamEntity;
import com.boc.wms.common.domain.mapstruct.MultiParamConvertor;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

@Repository
public class MultiParamDao {

    @Resource
    private MultiParamMapper multiParamMapper;

    public List<MultiParamEntity> listMultiParamByCodeList(List<String> codeList){
        QueryWrapper wrapper = new QueryWrapper<MultiParamDb>();
        wrapper.in("code",codeList);
        List<MultiParamDb> multiParamList = multiParamMapper.selectList(wrapper);
        if(CollectionUtils.isEmpty(multiParamList)){
            return Collections.EMPTY_LIST;
        }
        return MultiParamConvertor.INSTANCE.multiParamDbList2EntityList(multiParamList);
    }
}
