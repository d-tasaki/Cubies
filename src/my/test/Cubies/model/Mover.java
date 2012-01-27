package my.test.Cubies.model;

import java.util.HashMap;

public class Mover {
    public Mover () {
        mMoveToList = null;
        mOrientationList = null;
    }

    public CubieLabel getMoveLabel (CubieLabel l) {
        return mMoveToList.get (l);
    }

    public int getRotate (CubieLabel l) {
        return mOrientationList.get (l);
    }

    public boolean isMove (CubieLabel l) {
        if (getMoveLabel(l) != l) {
            return true;
        } else if (getRotate(l) != 0) {
            return true;
        }

        return false;
    }

    public void unitize () {
        if (mMoveToList == null) {
            mMoveToList      = new HashMap<CubieLabel, CubieLabel>();
            mOrientationList = new HashMap<CubieLabel, Integer>();
        }

        mMoveToList.put      (CubieLabel.U, CubieLabel.U); // No changes
        mOrientationList.put (CubieLabel.U, 0);
        mMoveToList.put      (CubieLabel.F, CubieLabel.F); // No changes
        mOrientationList.put (CubieLabel.F, 0);
        mMoveToList.put      (CubieLabel.L, CubieLabel.L); // No changes
        mOrientationList.put (CubieLabel.L, 0);
        mMoveToList.put      (CubieLabel.B, CubieLabel.B); // No changes
        mOrientationList.put (CubieLabel.B, 0);
        mMoveToList.put      (CubieLabel.R, CubieLabel.R); // No changes
        mOrientationList.put (CubieLabel.R, 0);
        mMoveToList.put      (CubieLabel.D, CubieLabel.D); // No changes
        mOrientationList.put (CubieLabel.D, 0);

        mMoveToList.put      (CubieLabel.UF, CubieLabel.UF); // No changes
        mOrientationList.put (CubieLabel.UF, 0);
        mMoveToList.put      (CubieLabel.UL, CubieLabel.UL); // No changes
        mOrientationList.put (CubieLabel.UL, 0);
        mMoveToList.put      (CubieLabel.UR, CubieLabel.UR); // No changes
        mOrientationList.put (CubieLabel.UR, 0);
        mMoveToList.put      (CubieLabel.UB, CubieLabel.UB); // No changes
        mOrientationList.put (CubieLabel.UB, 0);
        mMoveToList.put      (CubieLabel.FL, CubieLabel.FL); // No changes
        mOrientationList.put (CubieLabel.FL, 0);
        mMoveToList.put      (CubieLabel.BL, CubieLabel.BL); // No changes
        mOrientationList.put (CubieLabel.BL, 0);
        mMoveToList.put      (CubieLabel.BR, CubieLabel.BR); // No changes
        mOrientationList.put (CubieLabel.BR, 0);
        mMoveToList.put      (CubieLabel.FR, CubieLabel.FR); // No changes
        mOrientationList.put (CubieLabel.FR, 0);
        mMoveToList.put      (CubieLabel.DF, CubieLabel.DF); // No changes
        mOrientationList.put (CubieLabel.DF, 0);
        mMoveToList.put      (CubieLabel.DR, CubieLabel.DR); // No changes
        mOrientationList.put (CubieLabel.DR, 0);
        mMoveToList.put      (CubieLabel.DB, CubieLabel.DB); // No changes
        mOrientationList.put (CubieLabel.DB, 0);
        mMoveToList.put      (CubieLabel.DL, CubieLabel.DL); // No changes
        mOrientationList.put (CubieLabel.DL, 0);

        mMoveToList.put      (CubieLabel.UFL, CubieLabel.UFL); // No changes
        mOrientationList.put (CubieLabel.UFL, 0);
        mMoveToList.put      (CubieLabel.ULB, CubieLabel.ULB); // No changes
        mOrientationList.put (CubieLabel.ULB, 0);
        mMoveToList.put      (CubieLabel.UBR, CubieLabel.UBR); // No changes
        mOrientationList.put (CubieLabel.UBR, 0);
        mMoveToList.put      (CubieLabel.URF, CubieLabel.URF); // No changes
        mOrientationList.put (CubieLabel.URF, 0);
        mMoveToList.put      (CubieLabel.DLF, CubieLabel.DLF); // No changes
        mOrientationList.put (CubieLabel.DLF, 0);
        mMoveToList.put      (CubieLabel.DFR, CubieLabel.DFR); // No changes
        mOrientationList.put (CubieLabel.DFR, 0);
        mMoveToList.put      (CubieLabel.DRB, CubieLabel.DRB); // No changes
        mOrientationList.put (CubieLabel.DRB, 0);
        mMoveToList.put      (CubieLabel.DBL, CubieLabel.DBL); // No changes
        mOrientationList.put (CubieLabel.DBL, 0);
    }

    protected HashMap<CubieLabel, CubieLabel> mMoveToList;
    protected HashMap<CubieLabel, Integer>    mOrientationList;
}
