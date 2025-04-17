package com.blockedu.BlockEdu.service.institution.upload_credentials;

import com.blockedu.BlockEdu.data.dtos.request.UploadCredentialRequest;
import com.blockedu.BlockEdu.data.dtos.response.UploadCredentialResponse;

import java.io.IOException;

public interface UploadCredentialsService {
    UploadCredentialResponse upload(UploadCredentialRequest uploadCredentialRequest) throws IOException, InterruptedException;
}
