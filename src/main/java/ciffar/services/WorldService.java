package ciffar.services;

import ciffar.graphics.Assets;
import ciffar.models.FloorTile;
import ciffar.models.ObstacleTile;
import ciffar.models.Tile;

public class WorldService {

    private int worldWidth;
    private int worldHeight;
    private Tile[][] worldGrid;

    public WorldService() {
        worldWidth = Assets.GAME_WIDTH / Assets.SPRITE_WIDTH;
        worldHeight = Assets.GAME_HEIGHT / Assets.SPRITE_HEIGHT;
        worldGrid = new Tile[worldHeight][worldWidth];
    }

    public void init(){
        generateGrid();
    }

    private void generateGrid(){
        for (int i = 0; i < worldHeight; i++){
            for (int j = 0; j < worldWidth; j++){
                if (i == 0 && j == 0) {
                    worldGrid[i][j] = new ObstacleTile(Assets.wallTopLeft);
                    continue;
                }
                if (i == worldHeight - 1 && j == 0) {
                    worldGrid[i][j] = new ObstacleTile(Assets.wallBottomLeft);
                    continue;
                }
                if (i == worldHeight - 1 && j == worldWidth - 1) {
                    worldGrid[i][j] = new ObstacleTile(Assets.wallBottomRight);
                    continue;
                }
                if (i == 0 && j == worldWidth - 1) {
                    worldGrid[i][j] = new ObstacleTile(Assets.wallTopRight);
                    continue;
                }
                if (i == 0) {
                    worldGrid[i][j] = new ObstacleTile(Assets.wallTop);
                    continue;
                }
                if (i == worldHeight - 1) {
                    worldGrid[i][j] = new ObstacleTile(Assets.wallBottom);
                    continue;
                }
                if (j == 0) {
                    worldGrid[i][j] = new ObstacleTile(Assets.wallLeft);
                    continue;
                }
                if (j == worldWidth - 1) {
                    worldGrid[i][j] = new ObstacleTile(Assets.wallRight);
                    continue;
                }
                worldGrid[i][j] = new FloorTile(Assets.interior[(int) (Math.random() * 4)]);
            }
        }
    }

    public Tile[][] getWorldGrid() {
        return worldGrid;
    }

    public int getWorldWidth() {
        return worldWidth;
    }

    public int getWorldHeight() {
        return worldHeight;
    }
}