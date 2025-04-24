package com.blockedu.BlockEdu.service.student.generate;

import com.blockedu.BlockEdu.data.dtos.request.StudentGenerateUrlRequest;

public interface GenerateUrl {
    String generateUrl(StudentGenerateUrlRequest request);
}
