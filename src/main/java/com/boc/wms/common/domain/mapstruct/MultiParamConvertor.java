package com.boc.wms.common.domain.mapstruct;

import com.boc.wms.common.domain.MultParamOpEntity;
import com.boc.wms.common.domain.MultiOpDb;
import com.boc.wms.common.domain.MultiParamDb;
import com.boc.wms.common.domain.MultiParamEntity;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper()
@DecoratedWith(MultiParamDecorateConvertor.class)
public interface MultiParamConvertor {
    MultiParamConvertor INSTANCE = Mappers.getMapper(MultiParamConvertor.class);

    MultParamOpEntity  multiOpDb2OpEntity(MultiOpDb multiOpDbList);

    List<MultParamOpEntity> multiOpDbList2OpEntityList(List<MultiOpDb> multiOpDbList);

    MultiParamEntity multiParamDb2Entity(MultiParamDb multiParam);

    List<MultiParamEntity> multiParamDbList2EntityList(List<MultiParamDb> multiParamList);
}
