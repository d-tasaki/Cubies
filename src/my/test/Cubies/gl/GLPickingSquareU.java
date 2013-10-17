package my.test.Cubies.gl;

import javax.microedition.khronos.opengles.GL10;

import my.test.Cubies.gl.GLPickingSquareF;
import my.test.Cubies.gl.Vector;

public class GLPickingSquareU extends GLPickingSquare {
    public GLPickingSquareU () {
        super ();

        final float len = 3.1f;
        mVertices[0][0] = -len; mVertices[0][1] =  len; mVertices[0][2] = -len;
        mVertices[1][0] =  len; mVertices[1][1] =  len; mVertices[1][2] = -len;
        mVertices[2][0] =  len; mVertices[2][1] =  len; mVertices[2][2] =  len;
        mVertices[3][0] = -len; mVertices[3][1] =  len; mVertices[3][2] =  len;

        Vector.sub (mVectors[0], 0, mVertices[1], 0, mVertices[0], 0);
        Vector.sub (mVectors[1], 0, mVertices[2], 0, mVertices[1], 0);
        Vector.sub (mVectors[2], 0, mVertices[3], 0, mVertices[2], 0);
        Vector.sub (mVectors[3], 0, mVertices[0], 0, mVertices[3], 0);

        Vector.cross (mNormal, 0, mVectors[0], 0, mVectors[1], 0);

    }
}
