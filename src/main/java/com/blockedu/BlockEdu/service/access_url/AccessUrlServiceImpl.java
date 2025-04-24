package com.blockedu.BlockEdu.service.access_url;

import com.blockedu.BlockEdu.data.dtos.response.AccessUrlResponse;
import com.blockedu.BlockEdu.data.models.StudentUrlData;
import com.blockedu.BlockEdu.repository.StudentUrlDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccessUrlServiceImpl implements AccessUrlService {

    @Autowired
    private StudentUrlDataRepository studentUrlDataRepository;


    @Override
    public AccessUrlResponse accessUrl(String url) {

        Optional<StudentUrlData> studentUrlData = studentUrlDataRepository.findById(url);

        if (studentUrlData.isEmpty()) throw new IllegalArgumentException("URL not found");

        AccessUrlResponse accessUrlResponse = new AccessUrlResponse();

        accessUrlResponse.setFirstName(studentUrlData.get().getFirstName());
        accessUrlResponse.setLastName(studentUrlData.get().getLastName());
        accessUrlResponse.setInstitutionName(studentUrlData.get().getInstitutionName());
        accessUrlResponse.setInstitutionMotto(studentUrlData.get().getInstitutionMotto());
        accessUrlResponse.setBlockChainAddress(studentUrlData.get().getBlockChainAddress());

       // accessUrlResponse.setCredentialsDate();


        return null;
    }
}
