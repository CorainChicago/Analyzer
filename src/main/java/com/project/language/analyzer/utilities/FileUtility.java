package com.project.language.analyzer.utilities;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@Component
public class FileUtility {

    private static final Logger LOGGER = LoggerFactory.getLogger(FileUtility.class);


    public HashMap<String, List<String>> readFile(String name) throws IOException {
        HashMap<String, List<String>> result = new HashMap<>();
        ClassLoader classLoader = this.getClass().getClassLoader();
        ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver(classLoader);

        Resource[] files = resourcePatternResolver.getResources("classpath:" + name + ".txt");
        for(int x = 0; x < files.length; x++){
            result.put(files[x].getFilename(), Arrays.asList(IOUtils.toString(files[x].getInputStream()).split("\\s+")));
            LOGGER.error(" result is {}", result);
        }

        return result;
    }

}
