package ru.vladiev.model;

import ru.vladiev.io.DataDestination;
import ru.vladiev.io.DataSource;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * Author: Aleksey Vladiev (Avladiev2@gmail.com)
 */
public class Generator {
    private final DataSource source;
    private final DataDestination destination;

    public Generator(final DataSource source, final DataDestination destination) {
        this.source = source;
        this.destination = destination;
    }

    public void generate() {
        final ScriptEngine jsEngine = new ScriptEngineManager().getEngineByName("JavaScript");
        try {
            defineScriptFunction(jsEngine);
            invokeScriptFunction(jsEngine);
        } catch (ScriptException e) {
            throw new RuntimeException(e);
        }
    }

    private void defineScriptFunction(final ScriptEngine engine) throws ScriptException {
        final int[] sizes = source.getSizes();
        final StringBuilder sb = new StringBuilder();

        sb.append("function generate() { \n ").append(
                "var a = new Array(" + sizes.length + ");\n"
        ).append("var kol =0;\n");
        for (int i = 0; i < sizes.length; i++) {
            sb.append("for( a[" + i + "] = 1; a[" + i + "] <= " + sizes[i] + "; a[" + i + "]++  )\n");
        }
        sb.append("if (kol == b){ return; } else { kol++; destination.put( a.join(' ') );\n }\n");
        sb.append("}");
        engine.put("b", source.getB());
        engine.put("destination", destination);
        engine.eval(sb.toString());
    }


    private void invokeScriptFunction(ScriptEngine jsEngine)
            throws ScriptException {
        jsEngine.eval("generate()");
    }

}
