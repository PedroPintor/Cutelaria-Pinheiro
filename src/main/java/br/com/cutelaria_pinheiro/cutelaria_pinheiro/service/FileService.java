package br.com.cutelaria_pinheiro.cutelaria_pinheiro.service;

import java.io.IOException;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.com.cutelaria_pinheiro.cutelaria_pinheiro.model.File;
import br.com.cutelaria_pinheiro.cutelaria_pinheiro.repository.FileRepository;

@Service
public class FileService {
    
    @Autowired
    private FileRepository fileRepository;

    public File uploadFile(MultipartFile file) throws IOException {
        File fileEntity = new File();
        fileEntity.setName(file.getOriginalFilename());
        fileEntity.setType(file.getContentType());
        fileEntity.setData(file.getBytes());
        return fileRepository.save(fileEntity);
    }

    public File getFile(UUID id) {
        return fileRepository.findById(id).orElse(null);
    }
    
}
