package com.java0829.condition;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportSelector implements ImportSelector {
    /**
     *
     * @param importingClassMetadata 获取当前类的注解信息
     * @return
     */
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{"com.java0829.bean.Blue","com.java0829.bean.Yellow"};
    }
}
