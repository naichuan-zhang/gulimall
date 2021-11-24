package io.renren.modules.oss.cloud;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.sign.Credentials;

import java.io.InputStream;

/**
 * 腾讯云存储
 *
 * @author 张乃川
 * @date 2021/11/24 14:31
 */
public class QcloudCloudStorageService extends CloudStorageService {

    private COSClient client;

    public QcloudCloudStorageService(CloudStorageConfig config) {
        this.config = config;
        init();
    }

    private void init() {
        Credentials credentials = new Credentials(config.getQcloudAppId(), config.getQcloudSecretId(),
                config.getQcloudSecretKey());
    }

    @Override
    public String upload(byte[] data, String path) {
        // TODO
        return null;
    }

    @Override
    public String uploadSuffix(byte[] data, String suffix) {
        return null;
    }

    @Override
    public String upload(InputStream inputStream, String path) {
        return null;
    }

    @Override
    public String uploadSuffix(InputStream inputStream, String suffix) {
        return null;
    }
}
