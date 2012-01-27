package my.test.Cubies.model;

import my.test.Cubies.model.Cubie;

public class CenterCubie extends Cubie {

    public CenterCubie(CubieLabel label) {
        super(label);
    }

    public int getFaceletNum () {
        return FACELET_NUM;
    }

    public void rotate (int rot) {
        mOrientation += rot;
        mOrientation %= ORIENTATION_MAX;
    }

    private static final int FACELET_NUM = 1;
    private static final int ORIENTATION_MAX = 4;

}
