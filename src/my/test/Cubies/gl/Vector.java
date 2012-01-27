package my.test.Cubies.gl;

public class Vector {

    public static void add (float[] result, int resultOffset,
                            float[] lhs,    int lhsOffset,
                            float[] rhs,    int rhsOffset) {
        result[0 + resultOffset] = lhs[0 + lhsOffset] + rhs[0 + rhsOffset];
        result[1 + resultOffset] = lhs[1 + lhsOffset] + rhs[1 + rhsOffset];
        result[2 + resultOffset] = lhs[2 + lhsOffset] + rhs[2 + rhsOffset];
    }

    public static void sub (float[] result, int resultOffset,
                            float[] lhs,    int lhsOffset,
                            float[] rhs,    int rhsOffset) {
        result[0 + resultOffset] = lhs[0 + lhsOffset] - rhs[0 + rhsOffset];
        result[1 + resultOffset] = lhs[1 + lhsOffset] - rhs[1 + rhsOffset];
        result[2 + resultOffset] = lhs[2 + lhsOffset] - rhs[2 + rhsOffset];
    }

    public static float dot (float[] lhs,    int lhsOffset,
                            float[] rhs,    int rhsOffset) {
        float ret = 0;
        ret += lhs[0 + lhsOffset] + rhs[0 + rhsOffset];
        ret += lhs[1 + lhsOffset] + rhs[1 + rhsOffset];
        ret += lhs[2 + lhsOffset] + rhs[2 + rhsOffset];

        return ret;
    }

    public static void cross (float[] result, int resultOffset,
                              float[] lhs,    int lhsOffset,
                              float[] rhs,    int rhsOffset) {
        float x1 = lhs[0 + lhsOffset];
        float y1 = lhs[1 + lhsOffset];
        float z1 = lhs[2 + lhsOffset];
        float x2 = rhs[0 + rhsOffset];
        float y2 = rhs[1 + rhsOffset];
        float z2 = rhs[2 + rhsOffset];
        result[0 + resultOffset] = z1 * y2 - y1 * z2;
        result[1 + resultOffset] = x1 * z2 - z1 * x2;
        result[2 + resultOffset] = y1 * x2 - x1 * y2;
    }
    
}
