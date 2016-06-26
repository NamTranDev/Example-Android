package com.example.namtran.baitap;

import java.io.File;
import java.io.FilenameFilter;

/**
 * Created by Nam Tran on 8/17/2015.
 */
public class ExtensionsNameFilter implements FilenameFilter {
    public static final String[] IMAGE_FILTER = new String[]{".png", ".jpg", ".bmp"};
    String[] mExtensions;

    public ExtensionsNameFilter(String[] extensions) {
        mExtensions = extensions;
    }

    @Override
    public boolean accept(File dir, String filename) {
        String lowercaseName = filename.toLowerCase();
        for (String ext : mExtensions) {
            if (lowercaseName.endsWith(ext)) {
                return true;
            }
        }
        return false;
    }
}
