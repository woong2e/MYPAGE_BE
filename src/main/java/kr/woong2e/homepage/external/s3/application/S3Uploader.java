package kr.woong2e.homepage.external.s3.application;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class S3Uploader {

    private final AmazonS3 amazonS3;

    @Value("${cloud.aws.s3.bucket}")
    private String bucket;

    public String uploadTempProfileImage(MultipartFile file) throws IOException {
        String ext = getExtension(file.getOriginalFilename());
        String fileName = "profile/tmp/" + UUID.randomUUID() + ext;
        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentType(file.getContentType());
        metadata.setContentLength(file.getSize());
        amazonS3.putObject(new PutObjectRequest(bucket, fileName, file.getInputStream(), metadata)
                .withCannedAcl(CannedAccessControlList.PublicRead));
        return amazonS3.getUrl(bucket, fileName).toString();
    }

    public String moveToFinalProfileImage(String tempUrl) {
        String key = tempUrl.substring(tempUrl.indexOf("profile/tmp/"));
        String filename = key.substring("profile/tmp/".length());
        String finalKey = "profile/final/" + filename;

        amazonS3.copyObject(bucket, key, bucket, finalKey);
        amazonS3.deleteObject(bucket, key);

        return amazonS3.getUrl(bucket, finalKey).toString();
    }

    private String getExtension(String filename) {
        if (filename == null) {
            return "";
        }
        int idx = filename.lastIndexOf(".");
        return idx >= 0 ? filename.substring(idx) : "";
    }
}
