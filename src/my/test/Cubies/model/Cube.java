package my.test.Cubies.model;

import java.util.HashMap;
import java.util.Collection;

import my.test.Cubies.model.Cubie;
import my.test.Cubies.model.CubieLabel;


public class Cube {
    public Cube () {
        mCubieList = new HashMap<CubieLabel, Cubie>();

        for (CubieLabel l :  CubieLabel.values ()) {
            switch (l.getType()) {
             case CENTER:
                 mCubieList.put (l, new CenterCubie(l));
                 break;
            case EDGE:
                mCubieList.put (l, new EdgeCubie(l));
                break;
            case CORNER:
                mCubieList.put (l, new CornerCubie(l));
                break;
            }
        }
    }

    public void move (Mover m) {
        HashMap<CubieLabel, Cubie> list = new HashMap<CubieLabel, Cubie> (mCubieList);
        for (CubieLabel l : CubieLabel.values()) {
            CubieLabel moveToLabel = m.getMoveLabel (l);
            Cubie moveToCubie = list.get (moveToLabel);
            if (moveToCubie == null) {
                continue;
            }
            int rotate = m.getRotate (l);
            moveToCubie.setLabel (l);        
            moveToCubie.rotate (rotate);     
            mCubieList.put (l, moveToCubie); 
        }
    }

    public Cubie getCubie (CubieLabel label) {
        return mCubieList.get (label);
    }

    public Collection<Cubie> getCubies () {
        return mCubieList.values();
    }

    private HashMap<CubieLabel, Cubie> mCubieList;

}
