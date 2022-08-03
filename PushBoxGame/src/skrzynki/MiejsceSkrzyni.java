package skrzynki;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class MiejsceSkrzyni extends SkrzyniaMaster {

    public MiejsceSkrzyni(){

        try {
            wyglad = ImageIO.read(new File("C:/Users/mkali/IdeaProjects/PushBoxGame/res/klucz.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
