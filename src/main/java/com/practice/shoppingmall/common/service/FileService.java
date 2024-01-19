package com.practice.shoppingmall.common.service;

import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.util.UUID;

@Service
@Log
public class FileService {

    public String uploadFile(String uploadPath, String originalFileName, byte[] fileData) throws Exception{
        UUID uuid = UUID.randomUUID(); //랜덤 식별자 생성.

        String extension = originalFileName.substring(originalFileName.lastIndexOf("."));
        String saveFileName = uuid.toString()+extension;

        String fileUploadFullUrl = uploadPath+"/"+saveFileName;

        // 바이트 단위의 출력을 내보내는 클래스,
        // 생성자로 파일이 저장될 위치와 파일의 이름을 넘겨파일 파일에 쓸 출력스트림 만듦
        FileOutputStream fos =new FileOutputStream(fileUploadFullUrl);
        fos.write(fileData); // 파일 출력 스트림에 입력
        fos.close();

        return saveFileName; //업로드된 파일 이름을 반환.
    }

    public void deleteFile(String filePath) throws Exception{
        File deleteFile = new File(filePath);

        if(deleteFile.exists()){
            boolean delete = deleteFile.delete();
            if(delete)
                log.info("파일을 삭제하였습니다.");
        }
        else{
            log.info("파일이 존재하지않습니다.");
        }
    }
}
