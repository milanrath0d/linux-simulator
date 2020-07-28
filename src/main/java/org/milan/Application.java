package org.milan;

import org.milan.util.DirectoryUtil;
import org.springframework.shell.Bootstrap;

import java.io.IOException;

/**
 * Startup class
 */
public class Application {
    public static void main(String[] args) throws IOException {
        DirectoryUtil.initialize();
        Bootstrap.main(args);
    }
}
