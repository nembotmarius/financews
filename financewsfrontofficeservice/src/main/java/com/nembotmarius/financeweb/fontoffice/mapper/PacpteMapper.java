package com.nembotmarius.financeweb.fontoffice.mapper;

import com.nembotmarius.financeweb.fontoffice.entity.PacpteEntity;
import com.nembotmarius.financeweb.fontoffice.model.Pacpte;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PacpteMapper {
    PacpteMapper INSTANCE = Mappers.getMapper(PacpteMapper.class);

    // Tranformer Pacpte en PacpteEntity
    @Mappings({
            @Mapping(target="clauto", source="pacpte.clauto"),
            @Mapping(target="cpacti", source="pacpte.cpacti"),
            @Mapping(target="cpauto", source="pacpte.cpauto"),
            @Mapping(target="cpclot", source="pacpte.cpclot"),
            @Mapping(target="cpcpte", source="pacpte.cpcpte"),
            @Mapping(target="cpdacr", source="pacpte.cpdacr"),
            @Mapping(target="cpdaup", source="pacpte.cpdaup"),
            @Mapping(target="cpdeco", source="pacpte.cpdeco"),
            @Mapping(target="cpdele", source="pacpte.cpdele"),
            @Mapping(target="cpgele", source="pacpte.cpgele"),
            @Mapping(target="cpinti", source="pacpte.cpinti"),
            @Mapping(target="cpmand", source="pacpte.cpmand"),
            @Mapping(target="cpnoup", source="pacpte.cpnoup"),
            @Mapping(target="cpnsig", source="pacpte.cpnsig"),
            @Mapping(target="cpsobl", source="pacpte.cpsobl"),
            @Mapping(target="cpsold", source="pacpte.cpsold"),
            @Mapping(target="cpusde", source="pacpte.cpusde"),
            @Mapping(target="cpusup", source="pacpte.cpusup"),
            @Mapping(target="csauto", source="pacpte.csauto"),
            @Mapping(target="stauto", source="pacpte.stauto")
    })
    PacpteEntity mapModelToEntity(Pacpte pacpte);


    //Tranformer PacpteEntity en Pacpte
    @Mappings({
            @Mapping(target="clauto", source="entity.clauto"),
            @Mapping(target="cpacti", source="entity.cpacti"),
            @Mapping(target="cpauto", source="entity.cpauto"),
            @Mapping(target="cpclot", source="entity.cpclot"),
            @Mapping(target="cpcpte", source="entity.cpcpte"),
            @Mapping(target="cpdacr", source="entity.cpdacr"),
            @Mapping(target="cpdaup", source="entity.cpdaup"),
            @Mapping(target="cpdeco", source="entity.cpdeco"),
            @Mapping(target="cpdele", source="entity.cpdele"),
            @Mapping(target="cpgele", source="entity.cpgele"),
            @Mapping(target="cpinti", source="entity.cpinti"),
            @Mapping(target="cpmand", source="entity.cpmand"),
            @Mapping(target="cpnoup", source="entity.cpnoup"),
            @Mapping(target="cpnsig", source="entity.cpnsig"),
            @Mapping(target="cpsobl", source="entity.cpsobl"),
            @Mapping(target="cpsold", source="entity.cpsold"),
            @Mapping(target="cpusde", source="entity.cpusde"),
            @Mapping(target="cpusup", source="entity.cpusup"),
            @Mapping(target="csauto", source="entity.csauto"),
            @Mapping(target="stauto", source="entity.stauto")
    })
    Pacpte mapEntityToModel(PacpteEntity entity);
}
