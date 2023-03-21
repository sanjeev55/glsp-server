package org.eclipse.glsp.example.javaemf.launch;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;;
import org.eclipse.glsp.server.protocol.*;
import org.eclipse.glsp.server.session.ClientSession;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

/**
 * Create by @author Sanjeev on 3/21/2023 for project org.eclipse.glsp.example.javaemf
 */
public class NewGLSPServer extends DefaultGLSPServer {
    private static Logger LOGGER = LogManager.getLogger(DefaultGLSPServer.class);

    protected CompletableFuture<InitializeResult> initialized;

    protected Map<String, ClientSession> clientSessions;
    protected Set<GLSPServerListener> serverConnectionListeners;

    public NewGLSPServer() {
        initialized = new CompletableFuture<>();
        serverConnectionListeners = new LinkedHashSet<>();
        clientSessions = new HashMap<>();

        System.out.println("This is new default glsp server");
    }

    @Override
    public CompletableFuture<Void> initializeClientSession(final InitializeClientSessionParameters params) {
        LOGGER.info("Initializing client session with the following params:\n" + params);
        System.out.println("Initializing client session with the following params:\n" + params);
        File file = new File("e:/Work/Personal-Project/glsp-examples/project-templates/java-emf-theia/glsp-client/workspace/user1/test.txt");
        file.getParentFile().mkdirs();
        try {
            FileWriter writer = new FileWriter(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("This is the source URI:"+ params.getClientSessionId());
        return super.initializeClientSession(params);
    }
}
