package org.milan.shell;

import org.milan.shell.util.DirectoryUtils;
import org.springframework.shell.Bootstrap;

import java.io.IOException;

/**
 * Hello world!
 */
public class Application {
    public static void main(String[] args) throws IOException {
        DirectoryUtils.initialize();
        Bootstrap.main(args);

    }
}
