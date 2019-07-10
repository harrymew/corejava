package startup;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineFactory;
import javax.script.ScriptEngineManager;
import java.util.List;

public class ScriptEngineTest {
    public static void main(String... args) throws Exception
    {
        ScriptEngineManager sem = new ScriptEngineManager();
        List<ScriptEngineFactory> enginelist = sem.getEngineFactories();
        for(ScriptEngineFactory i : enginelist) {
            System.out.println(i.getEngineName());
            System.out.println(i.getParameter("THREADING"));
        }
        ScriptEngine engine = sem.getEngineByName("nashorn");
        Object result = engine.eval("n=1");
        result = engine.eval("n+1");
        System.out.println(result);

    }
}
