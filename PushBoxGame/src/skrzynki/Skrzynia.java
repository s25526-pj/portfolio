package skrzynki;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Skrzynia extends SkrzyniaMaster {

    public Skrzynia(){

        try {
            wyglad = ImageIO.read(new File("C:/Users/mkali/IdeaProjects/PushBoxGame/res/skrzynia.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
