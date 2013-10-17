package my.test.Cubies.gl;

import javax.microedition.khronos.egl.*;
import javax.microedition.khronos.opengles.*;
import android.opengl.*;

import java.util.HashMap;

import my.test.Cubies.gl.*;
import my.test.Cubies.model.*;


public class GLCube implements GLDrawable {
    public GLCube (Cube cube) {
        mCube = cube;
        mCubieList = new HashMap<CubieLabel, GLCubie>();

        for (Cubie cubie : mCube.getCubies()) {
            CubieLabel l = cubie.getLabel();
            switch (l.getType()) {
            case CENTER:
                mCubieList.put (l, new GLCenterCubie (cubie));
                break;
            case EDGE:
                mCubieList.put (l, new GLEdgeCubie (cubie));
                break;
            case CORNER:
                mCubieList.put (l, new GLCornerCubie (cubie));
                break;
            }
        }
        
        mPickingSquares = new GLPickingSquare[2];
        mPickingSquares[0] = new GLPickingSquareF();
        mPickingSquares[1] = new GLPickingSquareU();
    }

    @Override
    public void draw (GL10 gl) {
        gl.glFrontFace(GL10.GL_CW);
        for (GLCubie gcubie : mCubieList.values()) {
            gcubie.draw (gl);
        }
    }

    public void animate (GL10 gl, Mover m, float time) {
        float angle = 90.f * (3.0f * time * time - 2.0f * time * time * time);
        gl.glFrontFace(GL10.GL_CW);
        for (GLCubie gcubie : mCubieList.values()) {
            gl.glPushMatrix();
            if (m.isMove(gcubie.getCubie().getLabel())) {
                if (m instanceof MoverU) {
                    gl.glRotatef(angle, 0.0f, -1.0f, 0.0f);
                } else if (m instanceof MoverF) {
                    gl.glRotatef(angle, 0.0f, 0.0f, -1.0f);
                } else if (m instanceof MoverL) {
                    gl.glRotatef(angle, 1.0f, 0.0f, 0.0f);
                } else if (m instanceof MoverB) {
                    gl.glRotatef(angle, 0.0f, 0.0f, 1.0f);
                } else if (m instanceof MoverR) {
                    gl.glRotatef(angle, -1.0f, 0.0f, 0.0f);
                } else if (m instanceof MoverD) {
                    gl.glRotatef(angle, 0.0f, 1.0f, 0.0f);
                } else if (m instanceof MoverM) {
                    gl.glRotatef(angle, 1.0f, 0.0f, 0.0f);
                } else if (m instanceof MoverE) {
                    gl.glRotatef(angle, 0.0f, 1.0f, 0.0f);
                } else if (m instanceof MoverS) {
                    gl.glRotatef(angle, 0.0f, 0.0f, -1.0f);
                } 
            }
            gcubie.draw (gl);
            gl.glPopMatrix();
        }
    }

    public boolean pick (GL10 gl, float wx, float wy) {
        // Convert a window coordinate (wx, wy) to a clipping coordinate (cx, cy, cz)

        int[]   bits  = new int[16];
        int[]   view  = new int[4];
        float[] model = new float[16];
        float[] proj  = new float[16];

        gl.glGetIntegerv(GL11.GL_VIEWPORT, view, 0);
        ((GL11)gl).glGetIntegerv(GL11.GL_MODELVIEW_MATRIX_FLOAT_AS_INT_BITS_OES, bits, 0);
        for(int i = 0; i < bits.length; i++){
            model[i] = Float.intBitsToFloat(bits[i]);
        }
        ((GL11)gl).glGetIntegerv(GL11.GL_PROJECTION_MATRIX_FLOAT_AS_INT_BITS_OES, bits, 0);
        for(int i = 0; i < bits.length; i++){
            proj[i] = Float.intBitsToFloat(bits[i]);
        }

        // Calculate the clipping coordinate
        float[] cp = new float[4];
        GLU.gluUnProject(wx, wy, 0.0f, model, 0, proj, 0, view, 0, cp, 0);

        float[] eye = new float[4];
        eye[0] = 0.0f; eye[1] = 0.0f; eye[2] = 0.0f; eye[3] = 1.0f;

        float[] modelInv = new float[16];
        Matrix.invertM (modelInv, 0, model, 0);

        // Transform the clipping point and eye point with the inverted Modelview matrix
        Matrix.multiplyMV (cp,  0, modelInv, 0, cp,  0);
        Matrix.multiplyMV (eye, 0, modelInv, 0, eye, 0);
        cp [0] /= cp [3]; cp [1] /= cp [3]; cp [2] /= cp [3]; cp [3] = 1.0f;
        eye[0] /= eye[3]; eye[1] /= eye[3]; eye[2] /= eye[3]; eye[3] = 1.0f;

        // Pick a square by tracing a ray from eye through (cx, cy, cz)
        float[] pp = new float[3];
        for (GLPickingSquare ps : mPickingSquares) {
            if (ps.pick (gl, cp, eye, pp)) {
                mLastPickedSquare = ps;
                mLastPickedPoint  = pp;
            }
        }

        return false;
    }

    public Cube getCube () {
        return mCube;
    }

    private Cube mCube;
    private HashMap<CubieLabel, GLCubie> mCubieList;
    private GLPickingSquare[] mPickingSquares;
    private GLPickingSquare   mLastPickedSquare;
    private float[]           mLastPickedPoint;
}
