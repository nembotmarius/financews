package com.nembotmarius.financeweb.frontoffice.mapper;

import com.nembotmarius.financeweb.frontoffice.entity.CodetjEntity;
import com.nembotmarius.financeweb.frontoffice.model.Codetj;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CodetjMapper {
    CodetjMapper INSTANCE = Mappers.getMapper(CodetjMapper.class);

    // Tranformer Pacpte en PacpteEntity
    @Mappings({
            @Mapping(target="djauto", source="codetj.djauto"),
            @Mapping(target="jnauto", source="codetj.jnauto"),
            @Mapping(target="djtyco", source="codetj.djtyco"),
            @Mapping(target="djncod", source="codetj.djncod"),
            @Mapping(target="djncoc", source="codetj.djncoc"),
            @Mapping(target="djlibe", source="codetj.djlibe"),
            @Mapping(target="djmond", source="codetj.djmond"),
            @Mapping(target="djmonc", source="codetj.djmonc"),
            @Mapping(target="djdacr", source="codetj.djdacr"),
            @Mapping(target="djusup", source="codetj.djusup"),
            @Mapping(target="djdaup", source="codetj.djdaup"),
            @Mapping(target="djnoup", source="codetj.djnoup"),
            @Mapping(target="djdele", source="codetj.djdele"),
            @Mapping(target="djusde", source="codetj.djusde"),
            @Mapping(target="stauto", source="codetj.stauto"),
            @Mapping(target="cpauto", source="codetj.cpauto"),
            @Mapping(target="csauto", source="codetj.csauto"),
            @Mapping(target="cscode", source="codetj.cscode"),
            @Mapping(target="cpinti", source="codetj.cpinti"),
            @Mapping(target="cstypc", source="codetj.cstypc"),
            @Mapping(target="cslibe", source="codetj.cslibe"),
            @Mapping(target="djncoc2", source="codetj.djncoc2")
    })
    CodetjEntity mapModelToEntity(Codetj codetj);


    //Tranformer PacpteEntity en Pacpte
    @Mappings({
            @Mapping(target="djauto", source="entity.djauto"),
            @Mapping(target="jnauto", source="entity.jnauto"),
            @Mapping(target="djtyco", source="entity.djtyco"),
            @Mapping(target="djncod", source="entity.djncod"),
            @Mapping(target="djncoc", source="entity.djncoc"),
            @Mapping(target="djlibe", source="entity.djlibe"),
            @Mapping(target="djmond", source="entity.djmond"),
            @Mapping(target="djmonc", source="entity.djmonc"),
            @Mapping(target="djdacr", source="entity.djdacr"),
            @Mapping(target="djusup", source="entity.djusup"),
            @Mapping(target="djdaup", source="entity.djdaup"),
            @Mapping(target="djnoup", source="entity.djnoup"),
            @Mapping(target="djdele", source="entity.djdele"),
            @Mapping(target="djusde", source="entity.djusde"),
            @Mapping(target="stauto", source="entity.stauto"),
            @Mapping(target="cpauto", source="entity.cpauto"),
            @Mapping(target="csauto", source="entity.csauto"),
            @Mapping(target="cscode", source="entity.cscode"),
            @Mapping(target="cpinti", source="entity.cpinti"),
            @Mapping(target="cstypc", source="entity.cstypc"),
            @Mapping(target="cslibe", source="entity.cslibe"),
            @Mapping(target="djncoc2", source="entity.djncoc2")
    })


    Codetj mapEntityToModel(CodetjEntity entity);
}
