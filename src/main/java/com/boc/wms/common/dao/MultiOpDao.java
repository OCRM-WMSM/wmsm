package com.boc.wms.common.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.boc.mapper.MultiOpMapper;
import com.boc.wms.common.domain.MultParamOpEntity;
import com.boc.wms.common.domain.MultiOpDb;
import com.boc.wms.common.domain.mapstruct.MultiParamConvertor;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class MultiOpDao {

    @Resource
    private MultiOpMapper multiOpMapper;

    public List<MultParamOpEntity> listMultiOpEntityByseqMultList(List<Integer> seqMultList) {
        QueryWrapper wrapper = new QueryWrapper<MultiOpDb>();
        wrapper.in("seq_mult",seqMultList);
        wrapper.orderByAsc("seq");
        List<MultiOpDb> multiOpDbList = multiOpMapper.selectList(wrapper);
        return MultiParamConvertor.INSTANCE.multiOpDbList2OpEntityList(multiOpDbList);
    }
}
