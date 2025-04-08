package com.blockedu.BlockEdu.mapper;

import com.blockedu.BlockEdu.data.dtos.request.InstitutionRegisterRequest;
import com.blockedu.BlockEdu.data.dtos.response.InstitutionRegisterResponse;
import com.blockedu.BlockEdu.data.models.Institution;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface InstitutionRegisterRequestMap {

    InstitutionRegisterRequestMap INSTANCE = Mappers.getMapper(InstitutionRegisterRequestMap.class);

    InstitutionRegisterRequest toDto (Institution institution);

    Institution toEntity (InstitutionRegisterRequest institutionRegisterRequest);

    InstitutionRegisterResponse toResponse (Institution institution);
}
