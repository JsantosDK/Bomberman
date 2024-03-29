package ciffar.views;

import ciffar.models.EntityManager;
import ciffar.controllers.WindowController;
import ciffar.graphics.Assets;
import ciffar.views.entities.View;

import java.awt.*;

public class WindowView implements View {

    private WindowController windowController;
    private WorldView worldView;
    private EntityManager entityManager;

    public void init() {
        render();
    }

    private void render() {
        windowController.getGraphics().clearRect(0, 0, Assets.GAME_WIDTH, Assets.GAME_HEIGHT);
        windowController.getGraphics().setColor(new Color(47, 47, 46));
        windowController.getGraphics().fillRect(0, 0, Assets.GAME_WIDTH, Assets.GAME_HEIGHT);

        //Needs to be exchanged for GameState
        worldView.init();
        entityManager.init();

        windowController.getBufferStrategy().show();
        windowController.getGraphics().dispose();
    }

    public void setWindowController(WindowController windowController) {
        this.windowController = windowController;
    }

    public void setWorldView(WorldView worldView) {
        this.worldView = worldView;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

}