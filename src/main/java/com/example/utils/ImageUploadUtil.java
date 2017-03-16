package com.example.utils;

import java.io.File;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONObject;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;

public class ImageUploadUtil {
	private Logger logger = Logger.getLogger(this.getClass());
	private static ImageUploadUtil instance = new ImageUploadUtil();
	// 设置好账号的ACCESS_KEY和SECRET_KEY
	private String ACCESS_KEY = "iPiq0DLxs9N44ynMRoMHFVcCxA_qTadzA4WGd0kn";
	private String SECRET_KEY = "s67OnbdvTlCGU13fMw3pvMDb3iQkDbKc_IgVd36t";
	// 要上传的空间
	private String bucketname = "south-cdn-fileserver";
	private String qiniuDomain = "https://oi2dtee1p.qnssl.com/";

	public static final String fileKey = "FILE_KEY";
	// 密钥配置
	Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
	// 创建上传对象
	UploadManager uploadManager = new UploadManager();

	public static ImageUploadUtil getInstance() {
		return instance;
	}

	// 简单上传，使用默认策略，只需要设置上传的空间名就可以了
	public String getUpToken() {
		return auth.uploadToken(bucketname);
	}

	/**
	 * 上传图片到七牛云
	 * 
	 * @param file
	 * @param fileName
	 * @return
	 */
	public String uploadImgToQiniu(File file, String fileName) {
		try {
			Response res = uploadManager.put(file, fileName, getUpToken());
			String responseStr = res.bodyString();
			// 打印返回的信息
			JSONObject jsonObject = new JSONObject();
			jsonObject = JSONObject.parseObject(responseStr);
			String imgURL = qiniuDomain + jsonObject.getString("key");
			return imgURL;
		} catch (QiniuException e) {
			Response r = e.response;
			// 请求失败时打印的异常的信息
			logger.error("error=" + r.toString());
			return null;
		} catch (Exception e) {
			logger.error("error=" + e.getMessage());
			return null;
		}
	}
}
