package my.test.Cubies.model;

import my.test.Cubies.model.CubieLabel;
import my.test.Cubies.model.Facelet;
import my.test.Cubies.model.FaceletLabel;

public abstract class Cubie {
    public Cubie (CubieLabel label) {
        mLabel = label;
        mOrientation = 0;

        FaceletLabel[] flabels = label.getFaceletLabels();
        int num = flabels.length;
        mFacelets = new Facelet[num];
        for (int i = 0; i < num; i++) {
            mFacelets[i] = new Facelet(flabels[i]);
        }
    }

    public Facelet[] getFacelets () {
        return mFacelets;
    }

    public void setLabel (CubieLabel l) {
        mLabel = l;
    }

    public CubieLabel getLabel () {
        return mLabel;
    }

    public int getOrientation () {
        return mOrientation;
    }

    public abstract int getFaceletNum ();
    public abstract void rotate (int rot);

    protected Facelet[] mFacelets;

    protected CubieLabel mLabel;
    protected int mOrientation;

}
