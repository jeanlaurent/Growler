package net.morlhon.growl;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import com.google.common.io.Resources;

/**
 * Sends growl notification through AppleScript.
 * 
 * @author Jean-Laurent de Morlhon
 */
public class Growler
{
    private static final String APPLESCRIPT = "AppleScript";

    private ScriptEngine appleScript;

    public Growler()
    {
        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        appleScript = scriptEngineManager.getEngineByName(APPLESCRIPT);
        appleScript.put("javax_script_function", "growl");
    }

    public void growl(String title, String message, String applicationName)
    {
        appleScript.put(javax.script.ScriptEngine.ARGV, Arrays.asList(title, message, applicationName));
        try
        {
            appleScript.eval(new InputStreamReader(Resources.getResource("growl.applescript").openStream()));
        }
        catch (ScriptException se)
        {
            throw new RuntimeException(se.getMessage());
        }
        catch (IOException ioe)
        {
            throw new RuntimeException("Could not load script : " + ioe.getMessage());
        }
    }
}
