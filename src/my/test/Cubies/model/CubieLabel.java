package my.test.Cubies.model;

import my.test.Cubies.model.CubieLabelType;
import my.test.Cubies.model.FaceletLabel;

/**
 * Cubie's label
 * refer to http://www.geocities.jp/cubealgo/page/theq22/
 * 
 *                            /-----/-----/-----/   |-----+-----+-----+
 *                           / ULB / UB  / UBR /  / |     |     |     |
 *                          /-----/-----/-----/  /| |-----+-----+-----+
 *                         / UL  / U   / UR  /  / | | BR  | B   + BL  |
 *                        /-----/-----/-----/  /|/| |-----+-----+-----+
 *                       / UFL / UF  / URF /  / | | |     |     |     |
 *                      /-----/-----/-----/  /|/|/| |-----+-----+-----+
 * |-----|-----|-----| |-----|-----|-----|  | |R| |
 * |     |     |     | |     |     |     |  |/|/|/
 * |-----+-----+-----| |-----+-----+-----|  | | /
 * |     | L   |     | | FL  | F   | FR  |  |/|/
 * |-----+-----+-----| |-----+-----+-----|  | /
 * |     |     |     | |     |     |     |  |/
 * |-----|-----|-----| |-----|-----|-----|
 *                     |-----|-----|-----|
 *                     | DLF | DF  | DFR |
 *                     |-----+-----+-----|
 *                     | DL  | D   | DR  |
 *                     |-----+-----+-----|
 *                     | DBL | DB  | DRB |
 *                     |-----|-----|-----|
 *  
 *  
 * @author chick
 *
 */
public enum CubieLabel {

    // for Center
    U,
    F,
    L,
    B,
    R,
    D,

    // for Edge
    UF,
    UL,
    UR,
    UB,
    FL,
    BL,
    BR,
    FR,
    DF,
    DR,
    DB,
    DL,

    // for Corner
    UFL,
    ULB,
    UBR,
    URF,
    DLF,
    DFR,
    DRB,
    DBL;

    public CubieLabelType getType () {
        switch (toString().length()) {
        case 1:
            return CubieLabelType.CENTER;
        case 2:
            return CubieLabelType.EDGE;
        case 3:
            return CubieLabelType.CORNER;
        default:
            return CubieLabelType.UNKNOWN;
        }
    }

    public FaceletLabel[] getFaceletLabels () {
        String str = toString();
        int len = toString().length();
        FaceletLabel[] ret = new FaceletLabel[len];
        for (int i = 0; i < len; i++) {
            switch (str.charAt(i)) {
            case 'U':
                ret[i] = FaceletLabel.U;
                break;
            case 'F':
                ret[i] = FaceletLabel.F;
                break;
            case 'L':
                ret[i] = FaceletLabel.L;
                break;
            case 'B':
                ret[i] = FaceletLabel.B;
                break;
            case 'R':
                ret[i] = FaceletLabel.R;
                break;
            case 'D':
                ret[i] = FaceletLabel.D;
                break;
            }
        }
        return ret;
    }

}
