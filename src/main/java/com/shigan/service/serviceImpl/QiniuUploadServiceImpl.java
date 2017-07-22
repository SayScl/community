package com.shigan.service.serviceImpl;

import com.qiniu.util.Auth;
import com.shigan.service.QiniuUploadService;
import org.springframework.stereotype.Service;

/**
 * Created by Rico on 2017/6/29.
 */
@Service
public class QiniuUploadServiceImpl implements QiniuUploadService {


    private static  final String ACCESS_KEY = "1db_2JahIEHWQDKjLW0_kQK7oWXS954LgoFXmgV5";
    private static final String SECRET_KEY = "dKuMlE29o6IztUrPJC8gv7EmlTgTEKapbH4yoYmM";
    private static final String BUCKET_NAME = "community";
    private Auth auth;

    public QiniuUploadServiceImpl() {
        this.auth = Auth.create(ACCESS_KEY, SECRET_KEY);
    }


    @Override
    public String getUploadToken() {
        return auth.uploadToken(BUCKET_NAME);
    }
}
