package com.blockedu.BlockEdu.mapper;

import com.blockedu.BlockEdu.data.dtos.response.InstitutionLoginResponse;
import com.blockedu.BlockEdu.data.models.Institution;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface InstitutionLoginMap {

    InstitutionLoginMap INSTANCE = Mappers.getMapper(InstitutionLoginMap.class);
    InstitutionLoginResponse toResponse (Institution institution);



}
