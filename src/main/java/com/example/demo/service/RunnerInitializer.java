package com.example.demo.service;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import com.example.demo.config.LunaConfig;

@Component("commandline")
public class RunnerInitializer {
    
    @Autowired
    LunaConfig lunaConfig;

    @Value("${Chrystoki.config.file.path}")
    private String chrystokiFilePath;

    public void initialize() {
        String filepath = chrystokiFilePath;
        try {
            lunaConfig.writeConfigToFile(filepath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}