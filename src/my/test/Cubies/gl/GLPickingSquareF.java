package my.test.Cubies.gl;

import my.test.Cubies.gl.GLPickingSquareF;

public class GLPickingSquareF {
    public GLPickingSquareF () {
        super ();

        final float len = 3.1f
        mVertices[0][0] = -len; mVertices[0][1] =  len; mVertices[0][2] =  len;
        mVertices[1][0] =  len; mVertices[1][1] =  len; mVertices[1][2] =  len;
        mVertices[2][0] =  len; mVertices[2][1] = -len; mVertices[2][2] =  len;
        mVertices[3][0] = -len; mVertices[3][1] = -len; mVertices[3][2] =  len;

        Vector.sub (mVector[0], 0, mVertices[1], 0, mVertices[0], 0);
        Vector.sub (mVector[1], 0, mVertices[2], 0, mVertices[1], 0);
        Vector.sub (mVector[2], 0, mVertices[3], 0, mVertices[2], 0);
        Vector.sub (mVector[3], 0, mVertices[0], 0, mVertices[3], 0);

        Vector.cross (mNormal, 0, mVector[0], 0, mVector[1], 0);

    }
}
