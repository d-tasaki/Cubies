package my.test.Cubies.model;

import java.util.HashMap;

import my.test.Cubies.model.CubieLabel;

public class MoverD extends my.test.Cubies.model.Mover {
    public MoverD () {
        super ();
        if (sMoveToList == null) {
            sMoveToList      = new HashMap<CubieLabel, CubieLabel>();
            sOrientationList = new HashMap<CubieLabel, Integer>();

            sMoveToList.put      (CubieLabel.U, CubieLabel.U); // No changes
            sOrientationList.put (CubieLabel.U, 0);
            sMoveToList.put      (CubieLabel.F, CubieLabel.F); // No changes
            sOrientationList.put (CubieLabel.F, 0);
            sMoveToList.put      (CubieLabel.L, CubieLabel.L); // No changes
            sOrientationList.put (CubieLabel.L, 0);
            sMoveToList.put      (CubieLabel.B, CubieLabel.B); // No changes
            sOrientationList.put (CubieLabel.B, 0);
            sMoveToList.put      (CubieLabel.R, CubieLabel.R); // No changes
            sOrientationList.put (CubieLabel.R, 0);
            sMoveToList.put      (CubieLabel.D, CubieLabel.D);
            sOrientationList.put (CubieLabel.D, 1);

            sMoveToList.put      (CubieLabel.UF, CubieLabel.UF); // No changes
            sOrientationList.put (CubieLabel.UF, 0);
            sMoveToList.put      (CubieLabel.UL, CubieLabel.UL); // No changes
            sOrientationList.put (CubieLabel.UL, 0);
            sMoveToList.put      (CubieLabel.UR, CubieLabel.UR); // No changes
            sOrientationList.put (CubieLabel.UR, 0);
            sMoveToList.put      (CubieLabel.UB, CubieLabel.UB); // No changes
            sOrientationList.put (CubieLabel.UB, 0);
            sMoveToList.put      (CubieLabel.FL, CubieLabel.FL); // No changes
            sOrientationList.put (CubieLabel.FL, 0);
            sMoveToList.put      (CubieLabel.BL, CubieLabel.BL); // No changes
            sOrientationList.put (CubieLabel.BL, 0);
            sMoveToList.put      (CubieLabel.BR, CubieLabel.BR); // No changes
            sOrientationList.put (CubieLabel.BR, 0);
            sMoveToList.put      (CubieLabel.FR, CubieLabel.FR); // No changes
            sOrientationList.put (CubieLabel.FR, 0);
            sMoveToList.put      (CubieLabel.DF, CubieLabel.DL);
            sOrientationList.put (CubieLabel.DF, 0);
            sMoveToList.put      (CubieLabel.DR, CubieLabel.DF);
            sOrientationList.put (CubieLabel.DR, 0);
            sMoveToList.put      (CubieLabel.DB, CubieLabel.DR);
            sOrientationList.put (CubieLabel.DB, 0);
            sMoveToList.put      (CubieLabel.DL, CubieLabel.DB);
            sOrientationList.put (CubieLabel.DL, 0);

            sMoveToList.put      (CubieLabel.UFL, CubieLabel.UFL); // No changes
            sOrientationList.put (CubieLabel.UFL, 0);
            sMoveToList.put      (CubieLabel.ULB, CubieLabel.ULB); // No changes
            sOrientationList.put (CubieLabel.ULB, 0);
            sMoveToList.put      (CubieLabel.UBR, CubieLabel.UBR); // No changes
            sOrientationList.put (CubieLabel.UBR, 0);
            sMoveToList.put      (CubieLabel.URF, CubieLabel.URF); // No changes
            sOrientationList.put (CubieLabel.URF, 0);
            sMoveToList.put      (CubieLabel.DLF, CubieLabel.DBL);
            sOrientationList.put (CubieLabel.DLF, 0);
            sMoveToList.put      (CubieLabel.DFR, CubieLabel.DLF);
            sOrientationList.put (CubieLabel.DFR, 0);
            sMoveToList.put      (CubieLabel.DRB, CubieLabel.DFR);
            sOrientationList.put (CubieLabel.DRB, 0);
            sMoveToList.put      (CubieLabel.DBL, CubieLabel.DRB);
            sOrientationList.put (CubieLabel.DBL, 0);
        }
        mMoveToList = sMoveToList;
        mOrientationList = sOrientationList;
    }

    protected static HashMap<CubieLabel, CubieLabel> sMoveToList      = null;
    protected static HashMap<CubieLabel, Integer>    sOrientationList = null;

}
