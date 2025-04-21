package com.blockedu.BlockEdu.service.student.download_credentials;

import com.blockedu.BlockEdu.data.dtos.request.DownloadCredentialsRequest;
import com.blockedu.BlockEdu.data.dtos.response.DownloadCredentialsResponse;

public interface DownloadCredentials {

    DownloadCredentialsResponse download(DownloadCredentialsRequest request);
}
