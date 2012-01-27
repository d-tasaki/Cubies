package my.test.Cubies.model;

import java.util.HashMap;

import my.test.Cubies.model.CubieLabel;

public class MoverR extends my.test.Cubies.model.Mover {
    public MoverR () {
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
            sMoveToList.put      (CubieLabel.R, CubieLabel.R);
            sOrientationList.put (CubieLabel.R, 1);
            sMoveToList.put      (CubieLabel.D, CubieLabel.D); // No changes
            sOrientationList.put (CubieLabel.D, 0);

            sMoveToList.put      (CubieLabel.UF, CubieLabel.UF); // No changes
            sOrientationList.put (CubieLabel.UF, 0);
            sMoveToList.put      (CubieLabel.UL, CubieLabel.UL); // No changes
            sOrientationList.put (CubieLabel.UL, 0);
            sMoveToList.put      (CubieLabel.UR, CubieLabel.FR);
            sOrientationList.put (CubieLabel.UR, 0);
            sMoveToList.put      (CubieLabel.UB, CubieLabel.UB); // No changes
            sOrientationList.put (CubieLabel.UB, 0);
            sMoveToList.put      (CubieLabel.FL, CubieLabel.FL); // No changes
            sOrientationList.put (CubieLabel.FL, 0);
            sMoveToList.put      (CubieLabel.BL, CubieLabel.BL); // No changes
            sOrientationList.put (CubieLabel.BL, 0);
            sMoveToList.put      (CubieLabel.BR, CubieLabel.UR);
            sOrientationList.put (CubieLabel.BR, 0);
            sMoveToList.put      (CubieLabel.FR, CubieLabel.DR);
            sOrientationList.put (CubieLabel.FR, 0);
            sMoveToList.put      (CubieLabel.DF, CubieLabel.DF); // No changes
            sOrientationList.put (CubieLabel.DF, 0);
            sMoveToList.put      (CubieLabel.DR, CubieLabel.BR);
            sOrientationList.put (CubieLabel.DR, 0);
            sMoveToList.put      (CubieLabel.DB, CubieLabel.DB); // No changes
            sOrientationList.put (CubieLabel.DB, 0);
            sMoveToList.put      (CubieLabel.DL, CubieLabel.DL); // No changes
            sOrientationList.put (CubieLabel.DL, 0);

            sMoveToList.put      (CubieLabel.UFL, CubieLabel.UFL); // No changes
            sOrientationList.put (CubieLabel.UFL, 0);
            sMoveToList.put      (CubieLabel.ULB, CubieLabel.ULB); // No changes
            sOrientationList.put (CubieLabel.ULB, 0);
            sMoveToList.put      (CubieLabel.UBR, CubieLabel.URF);
            sOrientationList.put (CubieLabel.UBR, 1);
            sMoveToList.put      (CubieLabel.URF, CubieLabel.DFR);
            sOrientationList.put (CubieLabel.URF, 2);
            sMoveToList.put      (CubieLabel.DLF, CubieLabel.DLF); // No changes
            sOrientationList.put (CubieLabel.DLF, 0);
            sMoveToList.put      (CubieLabel.DFR, CubieLabel.DRB);
            sOrientationList.put (CubieLabel.DFR, 1);
            sMoveToList.put      (CubieLabel.DRB, CubieLabel.UBR);
            sOrientationList.put (CubieLabel.DRB, 2);
            sMoveToList.put      (CubieLabel.DBL, CubieLabel.DBL); // No changes
            sOrientationList.put (CubieLabel.DBL, 0);
        }
        mMoveToList = sMoveToList;
        mOrientationList = sOrientationList;
    }

    protected static HashMap<CubieLabel, CubieLabel> sMoveToList      = null;
    protected static HashMap<CubieLabel, Integer>    sOrientationList = null;

}
