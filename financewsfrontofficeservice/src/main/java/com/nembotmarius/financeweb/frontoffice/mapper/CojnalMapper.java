package com.nembotmarius.financeweb.frontoffice.mapper;

import com.nembotmarius.financeweb.frontoffice.entity.CojnalEntity;
import com.nembotmarius.financeweb.frontoffice.model.Cojnal;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CojnalMapper {
    CojnalMapper INSTANCE = Mappers.getMapper(CojnalMapper.class);

    // Tranformer Pacpte en PacpteEntity
    @Mappings({
            @Mapping(target="jnauto", source="cojnal.jnauto"),
            @Mapping(target="stauto", source="cojnal.stauto"),
            @Mapping(target="joauto", source="cojnal.joauto"),
            @Mapping(target="jndamv", source="cojnal.jndamv"),
            @Mapping(target="jndasa", source="cojnal.jndasa"),
            @Mapping(target="jndava", source="cojnal.jndava"),
            @Mapping(target="jnmoti", source="cojnal.jnmoti"),
            @Mapping(target="jnstat", source="cojnal.jnstat"),
            @Mapping(target="jnsrct", source="cojnal.jnsrct"),
            @Mapping(target="jnsrca", source="cojnal.jnsrca"),
            @Mapping(target="jndacr", source="cojnal.jndacr"),
            @Mapping(target="jnusup", source="cojnal.jnusup"),
            @Mapping(target="jndaup", source="cojnal.jndaup"),
            @Mapping(target="jnnoup", source="cojnal.jnnoup"),
            @Mapping(target="jndele", source="cojnal.jndele"),
            @Mapping(target="jnusde", source="cojnal.jnusde")
    })
    CojnalEntity mapModelToEntity(Cojnal cojnal);


    //Tranformer PacpteEntity en Pacpte
    @Mappings({
            @Mapping(target="jnauto", source="entity.jnauto"),
            @Mapping(target="stauto", source="entity.stauto"),
            @Mapping(target="joauto", source="entity.joauto"),
            @Mapping(target="jndamv", source="entity.jndamv"),
            @Mapping(target="jndasa", source="entity.jndasa"),
            @Mapping(target="jndava", source="entity.jndava"),
            @Mapping(target="jnmoti", source="entity.jnmoti"),
            @Mapping(target="jnstat", source="entity.jnstat"),
            @Mapping(target="jnsrct", source="entity.jnsrct"),
            @Mapping(target="jnsrca", source="entity.jnsrca"),
            @Mapping(target="jndacr", source="entity.jndacr"),
            @Mapping(target="jnusup", source="entity.jnusup"),
            @Mapping(target="jndaup", source="entity.jndaup"),
            @Mapping(target="jnnoup", source="entity.jnnoup"),
            @Mapping(target="jndele", source="entity.jndele"),
            @Mapping(target="jnusde", source="entity.jnusde")
    })


    Cojnal mapEntityToModel(CojnalEntity entity);
}
