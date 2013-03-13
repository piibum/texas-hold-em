package GUI;

import org.newdawn.slick.*;

public class Game extends BasicGame {

    Image poyta = null;
    Image[] kasikortti = {null, null};
    float[] kortinX = {290, 400};
    float[] kortinY = {400, 400};
    float scale = 1;

    public Game() {
        super("Texas Hold'em");
    }

    @Override
    public void init(GameContainer gc)
            throws SlickException {
        poyta = new Image("images/pokeripoyta.png");
        kasikortti[0] = new Image("images/card_38_1.png");
        kasikortti[1] = new Image("images/card_51_1.png");
    }

    @Override
    public void update(GameContainer gc, int delta)
            throws SlickException {
        Input input = gc.getInput();

        if (input.isKeyDown(Input.KEY_A)) {
            kasikortti[0].rotate(-0.2f * delta);
        }

        if (input.isKeyDown(Input.KEY_D)) {
            kasikortti[0].rotate(0.2f * delta);
        }

        if (input.isKeyDown(Input.KEY_W)) {
            float hip = 0.4f * delta;

            float rotation = kasikortti[0].getRotation();

            kortinX[0] += hip * Math.sin(Math.toRadians(rotation));
            kortinY[0] -= hip * Math.cos(Math.toRadians(rotation));
        }

        if (input.isKeyDown(Input.KEY_2)) {
            scale += (scale >= 5.0f) ? 0 : 0.1f;
            kasikortti[0].setCenterOfRotation(kasikortti[0].getWidth() / 2.0f * scale, kasikortti[0].getHeight() / 2.0f * scale);
        }
        if (input.isKeyDown(Input.KEY_1)) {
            scale -= (scale <= 1.0f) ? 0 : 0.1f;
            kasikortti[0].setCenterOfRotation(kasikortti[0].getWidth() / 2.0f * scale, kasikortti[0].getHeight() / 2.0f * scale);
        } 
    }

    public void render(GameContainer gc, Graphics g)
            throws SlickException {
        poyta.draw(0, 0);
        for (int i = 0; i < 2; i++) {
            kasikortti[i].draw(kortinX[i], kortinY[i], scale);
        }
    }

    public static void main(String[] args)
            throws SlickException {
        AppGameContainer app =
                new AppGameContainer(new Game());

        app.setDisplayMode(800, 600, false);
        app.start();
    }
}