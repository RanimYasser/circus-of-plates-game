package CircusOfPlatesGame;

import Shapes.ConstantsFactory;
import Shapes.ConstantsNames;
import Shapes.SpecialShape;
import Shapes.SpecialShapeFactory;
import Shapes.SpecialShapeName;
import java.util.Collections;

public class HardGameWorld extends GameWorld {

    public HardGameWorld(int width, int height) {
        super(width, height);
    }

    @Override
    public void setGame() {
        SoundPlayer.playSoundBackground("circusMusic.WAV");
        createShapes();
        constants.add(background);
        controllable.add(ClownObject.getClownInstance());
        constants.add(new ConstantsFactory().ConstantsCreator(ConstantsNames.LIVES, 5, 10, this));
        constants.add(new ConstantsFactory().ConstantsCreator(ConstantsNames.LIVES, 45, 10, this));
        constants.add(new ConstantsFactory().ConstantsCreator(ConstantsNames.LIVES, 85, 10, this));
        for (int i = 0; i < 5; i++) {
            SpecialShape specialShape1 = (SpecialShape) new SpecialShapeFactory().SpecialShapeCreator(SpecialShapeName.BOMB, (int)(Math.random()*getWidth()), (int)((Math.random()*(getHeight()/2))*-1));
            resolveIntersection(specialShape1);
            moveable.add(specialShape1);
            SpecialShape specialShape2 = (SpecialShape) new SpecialShapeFactory().SpecialShapeCreator(SpecialShapeName.SHOCK, (int)(Math.random()*getWidth()), (int)((Math.random()*(getHeight()/2))*-1));
            resolveIntersection(specialShape2);
            moveable.add(specialShape2);
        }
        SpecialShape specialShape3 = (SpecialShape) new SpecialShapeFactory().SpecialShapeCreator(SpecialShapeName.STAR,(int)(Math.random()*getWidth()), (int)((Math.random()*(getHeight()/2))*-1));
      resolveIntersection(specialShape3);
        moveable.add(specialShape3);
        Collections.shuffle(moveable);
        startState = new StartClownState(this);
        stopState = new StopClownState(this);
    }
}
