package my.test.Cubies.model;

import my.test.Cubies.model.FaceletLabel;

public class Facelet {
    public Facelet (FaceletLabel label) {
        mLabel = label;
    }

    public FaceletLabel getLabel () {
        return mLabel;
    }

    private FaceletLabel mLabel;

}
