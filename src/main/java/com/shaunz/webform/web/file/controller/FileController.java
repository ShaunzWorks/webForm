package com.shaunz.webform.web.file.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;

import com.shaunz.framework.common.auditlogs.ShaunzAuditLog;
import com.shaunz.framework.common.utils.IArrayListUtil;
import com.shaunz.framework.common.utils.IStringUtil;
import com.shaunz.framework.common.utils.MultipartFileUtil;
import com.shaunz.framework.core.YgdrasilConst;
import com.shaunz.framework.web.base.BaseController;
import com.shaunz.webform.web.image.entity.Image;

@Controller
public class FileController extends BaseController{
	private static String[] IMAGE_SUBFIX = {"png","bmp","dib","jpg","jpeg","jpe","jfif","gif","notify()","tiff"};
	@RequestMapping(value="/file/image_lst.html",method=RequestMethod.GET)
	public String imagePage(){
		return "file/image_lst";
	}
	@RequestMapping(value="/file/document_lst.html",method=RequestMethod.GET)
	public String docPage(){
		return "file/document_lst";
	}
	
	@RequestMapping(value="/file/imageLst",method=RequestMethod.GET)
	@ResponseBody
	public String imageLst(String path){
		List<Map<String, String>> imageLst = null;
		String webRootPath = ((HttpServletRequest)request).getServletContext().getRealPath("/");
		String imageDir = webRootPath+YgdrasilConst.CUSTOMER_IMAGE_PATH+(path.equals("/")?"":path);
		File imageFolder = new File(imageDir);
		if(imageFolder.exists()){
			imageLst = listFilesForFolder(imageFolder,webRootPath,path);
		}
		return convertToJsonString(imageLst);
	}
	
	@RequestMapping(value="/file/image",method=RequestMethod.POST)
	@ResponseBody
	public String uploadImage(MultipartFile file,String fileNm,String path,Locale locale){
		String imageUrl = null;
		boolean flag = false;
		try {
			if(file != null){
				if(IStringUtil.isBlank(fileNm)){
					fileNm = "img_"+new Date().getTime();
				}
				String webRootDir = ((HttpServletRequest)request).getServletContext().getRealPath("/");
				imageUrl = MultipartFileUtil.uploadFileReNmIfExist(file, webRootDir, YgdrasilConst.CUSTOMER_IMAGE_PATH,fileNm);
				if(IStringUtil.notBlank(imageUrl)){
					flag = true;
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return formSubmitResult(flag, "common.addMsg", new Object[]{messageSource.getMessage("image.title", null, locale),imageUrl}
				, locale);
	}
	
	@RequestMapping(value = "/file/image", method = RequestMethod.GET)
    @ResponseBody
    public void downloadImage(String fileNms,String path,HttpServletResponse response) throws Exception {
		String webRootPath = ((HttpServletRequest)request).getServletContext().getRealPath("/");
		String imageDir = webRootPath+YgdrasilConst.CUSTOMER_IMAGE_PATH+(path.equals("/")?"":path);
		String[] fileNmArr = fileNms.split(",");
		List<File> images = new ArrayList<File>();
		if(!IArrayListUtil.isBlankArray(fileNmArr)){
			for (int i = 0; i < fileNmArr.length; i++) {
				String imagePath = imageDir+fileNmArr;
				File image = new File(imagePath);
				if(image.exists()){
					images.add(image);
				}
			}
		}
		
		try {
			File outputFile = new File(webRootPath+YgdrasilConst.CUSTOMER_DOWNLOAD_TMP_FOLDER+"download_"+new Date().getTime()+".zip");
			if(images.size() ==1){
				outputFile = images.get(0);
			} else if(images.size() > 1){
				MultipartFileUtil.zipFile(images, outputFile);
			}
            String mimeType = ((HttpServletRequest)request).getServletContext().getMimeType(outputFile.getPath());
            
            if (mimeType == null) {
                mimeType = "application/octet-stream";
            }

            response.setContentType(mimeType);
            response.addHeader("Content-Disposition", "attachment; filename=" + outputFile.getName());
            response.setContentLength((int) outputFile.length());

            OutputStream os = response.getOutputStream();
            FileInputStream fis = new FileInputStream(outputFile);
            byte[] buffer = new byte[4096];
            int b = -1;

            while ((b = fis.read(buffer)) != -1) {
                os.write(buffer, 0, b);
            }

            fis.close();
            os.close();
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }
	
	private List<Map<String, String>> listFilesForFolder(File folder,String webRootPath,String folderPath){
		List<Map<String, String>> imageLst = new ArrayList<Map<String,String>>();
		for (final File fileEntry : folder.listFiles()) {
			Map<String, String> fileProfile = new HashMap<String, String>();
			fileProfile.put("url", "/"+fileEntry.getPath().replace(webRootPath, ""));
			fileProfile.put("name", fileEntry.getName());
			fileProfile.put("value", fileEntry.getName());
			fileProfile.put("folderPath", folderPath);
	        if (fileEntry.isDirectory()) {
	        	fileProfile.put("type", "folder");
	        } else {
	        	fileProfile.put("type", "file");
	        }
	        imageLst.add(fileProfile);
	    }
		return imageLst;
	}
	
	
}
