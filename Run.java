import java.io.File;
import java.lang.reflect.Field;

import net.minecraft.client.Minecraft;

public class Run
{
    public static void main(String[] args)
    {
    	System.setProperty("java.library.path", new File("natives").getAbsolutePath());
        System.setProperty("org.lwjgl.librarypath", new File("natives").getAbsolutePath());
        try
        {
            Field f = Minecraft.class.getDeclaredField("minecraftDir");
            Field.setAccessible(new Field[] { f }, true);
            f.set(null, new File("."));
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return;
        }

        Minecraft.main(args);
    }
}