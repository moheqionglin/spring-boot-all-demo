package com.base.java;

import java.io.File;
import java.util.StringTokenizer;

/**
 * @author wanli zhou
 * @created 2018-03-06 3:26 PM.
 */
public class ClassLoaderDemo {
    private static File[] getExtDirs() {
        //加载<JAVA_HOME>/lib/ext目录中的类库
        String s = System.getProperty("java.ext.dirs");
        File[] dirs;
        if (s != null) {
            StringTokenizer st =
                    new StringTokenizer(s, File.pathSeparator);
            int count = st.countTokens();
            dirs = new File[count];
            for (int i = 0; i < count; i++) {
                dirs[i] = new File(st.nextToken());
            }
        } else {
            dirs = new File[0];
        }
        return dirs;
    }

    public static void main(String[] args) {
        File[] files = getExtDirs();
        for(File f : files){
            System.out.println(f.getAbsoluteFile());
        }
    }
}
