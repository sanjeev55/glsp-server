package org.eclipse.glsp.example.javaemf.launch;


import com.google.inject.Module;
import org.eclipse.glsp.server.di.DiagramModule;
import org.eclipse.glsp.server.di.ServerModule;
import org.eclipse.glsp.server.protocol.GLSPServer;

import java.util.HashMap;
import java.util.Map;

/**
 * Create by @author Sanjeev on 3/21/2023 for project org.eclipse.glsp.example.javaemf
 */
public class NewServerModule extends ServerModule {

    public static final String DIAGRAM_MODULES = "Diagram_Modules";
    private final Map<String, Module> diagramModules = new HashMap<>();

    /**
     * Configure a new {@link DiagramModule} for this server. A diagram module represents the base configuration artifact
     * for configuring a diagram-language-specific client session injector. The diagram type provided
     * {@link DiagramModule#getDiagramType()} is used to retrieve the correct diagram module when the {@link GLSPServer}
     * initialises a new client session.
     * The given diagram module and all (optional) additional modules will be combined to one merged module. If bindings
     * of the additional modules are conflicting with the binding in the base diagram module the original binding will be
     * overwritten. The merged module is stored in a map using its diagram type as key.
     *
     * @param diagramModule The base diagram module
     * @param mixinModules  Additional modules
     * @return The server module itself. This enables a builder-pattern like chaining of multiple diagram configuration
     *         calls.
     */

    @Override
    public ServerModule configureDiagramModule(final DiagramModule diagramModule, final Module... mixinModules) {
        return super.configureDiagramModule(diagramModule, mixinModules);
    }

    /**
     * Bind the configured diagram modules map using a named annotation with the {@link ServerModule#DIAGRAM_MODULES}
     * constant.
     *
     * Example injection:
     *
     * <pre>
     * &#64;inject
     * &#64;inject(ServerModule.DIAGRAM_MODULES)
     * private Map&#60;String, Module&#62; diagramModules;
     * </pre>
     */

    @Override
    protected Class<? extends GLSPServer> bindGLSPServer() {
        return NewGLSPServer.class;
    }

}
