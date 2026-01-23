package com.atakanunlu.STLai.service.impl;

import com.atakanunlu.STLai.dto.project.FileContentResponse;
import com.atakanunlu.STLai.dto.project.FileNode;
import com.atakanunlu.STLai.service.FileService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FileServiceImpl implements FileService {
    @Override
    public List<FileNode> getFileTree(Long projectId, Long userId) {
        return List.of();
    }

    @Override
    public FileContentResponse getFileContent(Long projectId, String path, Long userId) {
        return null;
    }
}
