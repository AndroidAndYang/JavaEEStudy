package com.seabig.util;

import com.seabig.exception.MyException;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;
import java.util.UUID;

/**
 * @author: YJZ
 * data: 2018/4/11.
 * des: 文件上传工具类
 */
public class FileUpload {

    public static void load(HttpServletRequest req) {
        // 使用Apache FileUpload工具
        // Check that we have a file upload request
        boolean isMultipart = ServletFileUpload.isMultipartContent(req);
        System.out.println(isMultipart);
        // Create a factory for disk-based file items
        DiskFileItemFactory factory = new DiskFileItemFactory();
        // Create a new file upload handler
        ServletFileUpload upload = new ServletFileUpload(factory);
        // 限制上传的文件大小,2M
        upload.setFileSizeMax(1024 * 1024 * 2);
        // 限制总的文件大小,3M
        upload.setSizeMax(1024 * 1024 * 3);
        // Parse the request
        try {
            List<FileItem> items = upload.parseRequest(req);
            for (FileItem fileItem : items) {
                // 获取请求参数名
                String fieldName = fileItem.getFieldName();
                // 普通表单控件提交（非上传控件）
                if (fileItem.isFormField()) {
                    // 获取输入的值
                    String value = fileItem.getString("UTF-8");
                    System.out.println(fieldName + " = " + value);
                } else {
                    // 获取文件类型
                    String contentType = fileItem.getContentType();
                    // 判断文件类型
                    if (!contentType.startsWith("image/")) {
                        throw new MyException("不支持该类型");
                    }
                    System.out.println("contentType = " + contentType);
                    // 判断是否在内存中，上传大于默认值会缓存到临时目录中
                    boolean inMemory = fileItem.isInMemory();
                    System.out.println("inMemory =" + inMemory);
                    // 获取绝对路径
                    String realPath = req.getSession().getServletContext().getRealPath("/upload");
                    System.out.println(realPath);
                    // 使用UUID生成一个随机数
                    UUID uuid = UUID.randomUUID();
                    // 获取文件后缀名
                    String extension = FilenameUtils.getExtension(fileItem.getName());
                    System.out.println("extension" + extension);
                    File file = new File(realPath, uuid + "." + extension);
                    fileItem.write(file);
                }
            }
        } catch (FileUploadBase.FileSizeLimitExceededException e) {
            throw new MyException("上传的图片过大");
        } catch (MyException e) {
            throw e;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
