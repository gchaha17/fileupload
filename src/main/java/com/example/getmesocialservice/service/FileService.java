package com.example.getmesocialservice.service;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.S3Object;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@Service
public class FileService {


    public boolean upload(MultipartFile file) {


        BasicAWSCredentials crd=new BasicAWSCredentials("AKIAQWMNIRPKG6LLYN5U","hJMN0r4UoEUjkLS3zLir6Ed5f61Zp3dSs1gcc4EL");
        final AmazonS3 s3= AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(crd)).withRegion(Regions.US_WEST_2).build();
        try {
            ObjectMetadata o1=new ObjectMetadata();
            o1.setContentLength(file.getSize());
o1.setContentType(file.getContentType());




            s3.putObject("gcassi6",file.getOriginalFilename(),file.getInputStream(),o1);

            return true;

        }

catch(AmazonServiceException | IOException e)
{

    return false;
}



    }

    public S3Object getFile(String key)
    {
        BasicAWSCredentials crd=new BasicAWSCredentials("AKIAQWMNIRPKG6LLYN5U","hJMN0r4UoEUjkLS3zLir6Ed5f61Zp3dSs1gcc4EL");
        final AmazonS3 s3= AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(crd)).withRegion(Regions.US_WEST_2).build();
      return s3.getObject("gcassi6",key);
    }

    public void deleteFile(String key)
    {
        BasicAWSCredentials crd=new BasicAWSCredentials("AKIAQWMNIRPKG6LLYN5U","hJMN0r4UoEUjkLS3zLir6Ed5f61Zp3dSs1gcc4EL");
        final AmazonS3 s3= AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(crd)).withRegion(Regions.US_WEST_2).build();
        s3.deleteObject("gcassi6",key);
    }


    }

