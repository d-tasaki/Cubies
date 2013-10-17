package my.test.Cubies.gl;

import javax.microedition.khronos.opengles.GL10;

import my.test.Cubies.gl.Vector;

public class GLPickingSquare {
    public GLPickingSquare () {
        mVertices = new float[4][3];
        mVectors  = new float[4][3];
        mNormal   = new float[3];
    }

    public boolean pick (GL10 gl, float[] cp, float[] eye, float[] pp) {
        // ray is a vector from eye to clipping point
        float[] ray = new float[3];
        Vector.sub (ray, 0, cp, 0, eye, 0);

        if (Vector.dot (ray, 0, mNormal, 0) < 0.0f) {
            return false;
        }

        float t = ((Vector.dot(mVertices[0], 0, mNormal, 0) -
                    Vector.dot(eye,          0, mNormal, 0)) /
                   (Vector.dot(ray,          0, mNormal, 0)));
        
        if (t < 0.0f) {
            return false;
        }
        
        // pp is the picking point
        pp[0] = t * ray[0] + eye[0];
        pp[1] = t * ray[1] + eye[1];
        pp[2] = t * ray[2] + eye[2];

        float[] v = new float[3];
        // cross is a vector calulated with cross production
        float[] cross = new float[3];
        boolean isInside = true;
        for (int i = 0; i < 4; i++) {
            Vector.sub (v, 0, pp, 0, mVertices[i], 0);
            Vector.cross (cross, 0, v, 0, mVectors[i], 0);
            if (Vector.dot (cross, 0, mNormal, 0) < 0.0f) {
                isInside = false;
                break;
            }
        }

        return isInside;
    }

    protected float[][] mVertices;
    protected float[][] mVectors;
    protected float[]   mNormal;
}
