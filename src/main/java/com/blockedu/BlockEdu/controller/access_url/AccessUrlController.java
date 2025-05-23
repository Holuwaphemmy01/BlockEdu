package com.blockedu.BlockEdu.controller.access_url;

import com.blockedu.BlockEdu.data.dtos.response.AccessUrlResponse;
import com.blockedu.BlockEdu.service.access_url.AccessUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/auth")
public class AccessUrlController {

    @Autowired
    private AccessUrlService accessUrlService;

    @GetMapping("{url}")
    public ResponseEntity<?> accessUrl(@PathVariable String url) {


//        AccessUrlResponse response = accessUrlService.accessUrl(url);
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_PDF);
//        headers.setContentDisposition(
//                ContentDisposition.inline()
//                        .filename(response.getFirstName() + response.getLastName() + ".pdf")
//                        .build()
//        );
//        headers.setCacheControl(CacheControl.noStore().getHeaderValue());
//        headers.add("X-First-Name", response.getFirstName());
//        headers.add("X-Last-Name", response.getLastName());
//        headers.add("X-Institution-Name", response.getInstitutionName());
//        headers.add("X-Institution-Motto", response.getInstitutionMotto());
//        headers.add("X-Blockchain-Address", response.getBlockChainAddress());
//
//        return ResponseEntity.ok()
//                .headers(headers)
//                .body(new ByteArrayResource(response.getContent()));
        return ResponseEntity.ok(accessUrlService.accessUrl(url));

    }
}
