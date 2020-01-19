package com.boc.wms.common.domain.mapstruct;

import com.boc.wms.common.domain.MultParamOpEntity;
import com.boc.wms.common.domain.MultiOpDb;
import com.boc.wms.common.domain.MultiParamDb;
import com.boc.wms.common.domain.MultiParamEntity;
import com.google.common.collect.Lists;
import io.jsonwebtoken.lang.Collections;

import java.util.List;
import java.util.stream.Collectors;

public class MultiParamDecorateConvertor implements MultiParamConvertor{

    private final MultiParamConvertor delegate;

    public MultiParamDecorateConvertor(MultiParamConvertor delegate) {
        this.delegate = delegate;
    }


    @Override
    public MultParamOpEntity multiOpDb2OpEntity(MultiOpDb multiOpDb) {
        return delegate.multiOpDb2OpEntity(multiOpDb);
    }

    @Override
    public List<MultParamOpEntity> multiOpDbList2OpEntityList(List<MultiOpDb> multiOpDbList) {
        if(Collections.isEmpty(multiOpDbList)){
            return Lists.newArrayList();
        }
        return multiOpDbList.stream().map(t->this.multiOpDb2OpEntity(t)).collect(Collectors.toList());
    }

    @Override
    public MultiParamEntity multiParamDb2Entity(MultiParamDb multiParam) {
        return delegate.multiParamDb2Entity(multiParam);
    }

    @Override
    public List<MultiParamEntity> multiParamDbList2EntityList(List<MultiParamDb> multiParamList) {
        if(Collections.isEmpty(multiParamList)){
            return Lists.newArrayList();
        }
        return multiParamList.stream().map(t->this.multiParamDb2Entity(t)).collect(Collectors.toList());
    }
}
