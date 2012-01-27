package my.test.Cubies.model;

public class CornerCubie extends my.test.Cubies.model.Cubie {

    public CornerCubie(CubieLabel label) {
        super(label);
    }

    public int getFaceletNum () {
        return FACELET_NUM;
    }

    public void rotate (int rot) {
        mOrientation += rot;
        mOrientation %= ORIENTATION_MAX;
    }

    private static final int FACELET_NUM = 3;
    private static final int ORIENTATION_MAX = 3;

}
