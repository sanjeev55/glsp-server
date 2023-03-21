package org.eclipse.glsp.example.javaemf.launch;

import com.google.inject.Module;
import org.eclipse.emf.common.util.URI;
import org.eclipse.glsp.server.di.ServerModule;
import org.eclipse.glsp.server.features.core.model.RequestModelAction;
import org.eclipse.glsp.server.launch.SocketGLSPServerLauncher;
import org.eclipse.glsp.server.types.GLSPServerException;
import org.eclipse.glsp.server.utils.ClientOptionsUtil;

import java.nio.channels.AsynchronousSocketChannel;


/**
 * Create by @author Sanjeev on 3/21/2023 for project org.eclipse.glsp.example.javaemf
 */
public class NewGLSPServerLauncher extends SocketGLSPServerLauncher {
    public NewGLSPServerLauncher(ServerModule serverModule, Module... additionalModules) {
        super(serverModule, additionalModules);
    }

    @Override
    protected String getStartupCompleteMessage() {
        return "[GLSP-Server]: This is test Startup completed";
    }

    public void loadSourceModel(RequestModelAction action) {
        String sourceURI = (String) ClientOptionsUtil.getSourceUri(action.getOptions()).orElseThrow(() -> {
            return new GLSPServerException("No source URI given to load model!");
        });
        URI resourceURI = URI.createFileURI(sourceURI);
    }
    @Override
    protected void createClientConnection(final AsynchronousSocketChannel socketChannel) {
//        loadSourceModel(new RequestModelAction());
        super.createClientConnection(socketChannel);
    }

}
