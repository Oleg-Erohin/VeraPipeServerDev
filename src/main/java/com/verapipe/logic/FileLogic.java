package com.verapipe.logic;

import com.verapipe.consts.Consts;
import com.verapipe.dal.IFileDal;
import com.verapipe.dto.File;
import com.verapipe.entities.FileEntity;
import com.verapipe.enums.ErrorType;
import com.verapipe.enums.FileExtension;
import com.verapipe.exceptions.ApplicationException;
import org.apache.tika.Tika;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Service
public class FileLogic {
    private IFileDal fileDal;

    @Autowired
    public FileLogic(IFileDal fileDal) {
        this.fileDal = fileDal;
    }

    public int add(File file) throws Exception {
        validations(file);
        FileEntity fileEntity = new FileEntity(file);
        try {
            fileEntity = this.fileDal.save(fileEntity);
        } catch (Exception e) {
//          TODO throw new ApplicationException
            throw new Exception(e.getMessage());
        }
        int addedFileId = fileEntity.getId();
        return addedFileId;
    }

    public void update(File file) throws Exception {
        validations(file);
        FileEntity sentFileEntity = new FileEntity(file);
        FileEntity receivedFileEntity;
        try {
            receivedFileEntity = this.fileDal.save(sentFileEntity);
        } catch (Exception e) {
//          TODO throw new ApplicationException
            throw new Exception(e.getMessage());
        }
        // Validate sent entity and return entity from DB are equals
        if (!sentFileEntity.equals(receivedFileEntity)) {
//            TODO throw new ApplicationException
            throw new Exception();
        }
    }

    public void delete(int id) throws Exception {
        if (!isFileExist(id)) {
//            TODO throw new ApplicationException
        }
        try {
            this.fileDal.deleteById(id);
        } catch (Exception e) {
//            TODO throw new ApplicationException
            throw new Exception(e.getMessage());
        }
    }

    public File getById(int id) throws Exception {
        Optional<FileEntity> fileEntity;
        try {
            fileEntity = this.fileDal.findById(id);
        } catch (Exception e) {
//            TODO throw new ApplicationException
            throw new Exception(e.getMessage());
        }
        if (fileEntity.isEmpty()) {
//            TODO throw new ApplicationException
            throw new Exception("File not found");
        }
        File file = new File(fileEntity.get());
        return file;
    }

    public List<File> getAll() throws Exception {
        Iterable<FileEntity> fileEntities = this.fileDal.findAll();
        List<File> files = new ArrayList<>();
        // Check if the findAll method returned a value
        if (!fileEntities.iterator().hasNext()) {
//          TODO throw new ApplicationException
            throw new Exception("File list is empty");
        }
        // Convert Iterable to List
        for (FileEntity fileEntity : fileEntities
        ) {
            File file = new File(fileEntity);
            files.add(file);
        }
        return files;
    }


    private void validations(File file) throws Exception {
//        validateFileType(file.getFileType());
//        validateResourceName(file.getResourceName());
//        validateRevision(file.getRevision());
        validateFile(file.getFile());
    }

    private void validateFile(byte[] file) throws ApplicationException {
        validateFileMaxSize(file);
        validateFileExtension(file, FileExtension.PDF);
    }

    public static void validateFileMaxSize(byte[] file) throws ApplicationException {
        int fileSize = file.length;
        if (fileSize > Consts.bytesIn20MB){
            throw new ApplicationException(ErrorType.FILE_SIZE_EXCEED_MAX_SIZE);
        }
    }

    public static void validateFileExtension(byte[] file, FileExtension requireFileExtension) throws ApplicationException {
        String fileExtension = findFileType(file);
        if (!fileExtension.equals(requireFileExtension.getFileExtension())){
            throw new ApplicationException(ErrorType.FILE_EXTENSION_IS_NOT_ALLOWED);
        }
    }

    private static String findFileType(byte[] file) {
        String fileBase64Code =  Base64.getEncoder().encodeToString(file);
        String fileExtension = new Tika().detect(fileBase64Code);
        return fileExtension;
    }

    private boolean isFileExist(int id) {
        return this.fileDal.existsById(id);
    }
}
