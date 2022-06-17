/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package walkFileTree;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MWIGO-JON-MARK
 */
public class AdvancedWalkFileTree
{
    public void getFileByExtension(String dir, String extension)
    {
        try {
            Path startDir = Paths.get(dir);
            Files.walkFileTree(startDir, new FindFilesVisitor());
        } catch (IOException ex) {
            Logger.getLogger(AdvancedWalkFileTree.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

class FindFilesVisitor extends SimpleFileVisitor<Path>
{
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs, String extension)
    {
        if(file.toString().endsWith(extension))
        {
            System.out.println(file.getFileName());
        }
        return FileVisitResult.CONTINUE;
    }
}
