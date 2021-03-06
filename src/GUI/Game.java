package GUI;
import java.awt.Font;
import org.newdawn.slick.*;
public class Game extends BasicGame {

    Image check = null;
    Image fold = null;
    Image raise = null;
    Image dealer_sign = null;
    Image poyta = null;
    Image[] kasikortti = {null, null};
    Image vastustajankortti = null;
    float[] kortinX = {290, 400};
    float[] kortinY = {400, 400};
    float scale = 1;
    Font font;
    TrueTypeFont heronChipit;
    TrueTypeFont muut;

    public Game() {
        super("Texas Hold'em");
    }

    @Override
    public void init(GameContainer gc)
            throws SlickException {
        raise = new Image ("images/raise.png");
        fold = new Image ("images/fold.png");
        check = new Image ("images/check.png");
        dealer_sign = new Image ("images/dealer_sign.png");
        poyta = new Image("images/pokeripoyta.png");
        kasikortti[0] = new Image("images/card_38.png");
        kasikortti[1] = new Image("images/card_51.png");
        vastustajankortti = new Image ("images/card_back.png");
        font = new Font("Verdana", Font.BOLD, 40);
        heronChipit = new TrueTypeFont(font, true);
        font = new Font("Verdana", Font.PLAIN, 15);
        muut = new TrueTypeFont(font, true);
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
       heronChipit.drawString(350, 545, "10000");
       vastustajankortti.draw(50,250);
       vastustajankortti.draw(105,250);
       vastustajankortti.draw(350,50);
       vastustajankortti.draw(405,50);
       vastustajankortti.draw(650,250);
       vastustajankortti.draw(705,250);
       dealer_sign.draw(110,330);
       muut.drawString ( 450,145, "$ 50");
       muut.drawString ( 650,345, "$ 100");
       check.draw(700,700);
       fold.draw(700,800);
       raise.draw(700,900);
    }

    public static void main(String[] args)
            throws SlickException {
        AppGameContainer app =
                new AppGameContainer(new Game());

        app.setDisplayMode(800, 600, false);
        app.start();
    }
}