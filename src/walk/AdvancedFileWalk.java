/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package walk;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

/**
 *
 * @author MWIGO-JON-MARK
 */
public class AdvancedFileWalk
{
    public void getRegularFiles(String dir)
    {
        var dirName = dir;
        
        try(Stream<Path> paths = Files.walk(Paths.get(dirName), Integer.MAX_VALUE))
        {
            paths.filter(Files::isRegularFile).forEach(System.out::println);
        }
        catch(IOException ex)
        {
            Logger.getLogger(AdvancedFileWalk.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void getDirectories(String dir)
    {
        var dirName = dir;
        
        try(Stream<Path> paths = Files.walk(Paths.get(dirName), Integer.MAX_VALUE))
        {
            paths.filter(Files::isDirectory).forEach(System.out::println);
        }
        catch(IOException ex)
        {
            Logger.getLogger(AdvancedFileWalk.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void getFileByExtension(String dir, String extension)
    {
        var dirName = dir;
        
        try(Stream<Path> paths = Files.walk(Paths.get(dirName), Integer.MAX_VALUE))
        {
            paths.map(path -> path.toString()).filter(f -> f.endsWith(extension)).forEach(System.out::println);
        } catch (IOException ex) {
            Logger.getLogger(AdvancedFileWalk.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
