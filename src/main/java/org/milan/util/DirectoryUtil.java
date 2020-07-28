package org.milan.util;

import org.milan.LinuxSimulator;
import org.milan.bean.DirectoryNode;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Utility class to store directories related data which can be used in {@link LinuxSimulator}
 *
 * @author Milan Rathod
 */
public final class DirectoryUtil {

    private static DirectoryNode<String> root = null;

    private static DirectoryNode<String> currentDirectory = null;

    private DirectoryUtil() {

    }

    public static void initialize() {

        if (root == null) {
            root = ootbDirectories();
            currentDirectory = root;
        }

    }

    public static DirectoryNode<String> ootbDirectories() {
        DirectoryNode<String> root = new DirectoryNode<>("test");
        DirectoryNode<String> child1 = root.addChild("test1");
        DirectoryNode<String> child2 = root.addChild("test2");

        child1.addChild("test11");
        child2.addChild("test21");

        return root;
    }

    public static DirectoryNode<String> listDirectories() {
        return currentDirectory;
    }

    public static String changeDirectory(String directory) {
        DirectoryNode<String> newDirectory = new DirectoryNode<>(directory);

        AtomicBoolean found = new AtomicBoolean(false);

        currentDirectory.getChildren().forEach(directoryNode -> {
            if (directoryNode.toString().equals(newDirectory.toString())) {
                currentDirectory = directoryNode;
                found.set(true);
            }
        });
        if (found.get()) {
            return currentDirectory.toString();
        }
        return "Invalid directory specified.";
    }

}
