package my.test.Cubies.gl;

import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;

import my.test.Cubies.gl.GLCubie;
import my.test.Cubies.model.Cubie;
import my.test.Cubies.model.CubieLabel;

public class GLEdgeCubie extends GLCubie {
    public GLEdgeCubie (Cubie cubie) {
        super (cubie);
    }

    @Override
    public void drawCubie (GL10 gl) {
        super.drawCubie (gl);
    }

    @Override
    public void translate (GL10 gl) {
        final float moveTo = 2.1f;
        int orientation = mCubie.getOrientation ();
        float rotate = (float)(-orientation * 360.0 / 2);
        switch (mCubie.getLabel()) {
        case UF:
            gl.glRotatef (rotate, 0, 1, 1);
            gl.glTranslatef(0, moveTo, moveTo);
            break;
        case UL:
            gl.glRotatef (rotate, -1, 1, 0);
            gl.glTranslatef(-moveTo, moveTo, 0);
            break;
        case UR:
            gl.glRotatef (rotate, 1, 1, 0);
            gl.glTranslatef(moveTo, moveTo, 0);
            break;
        case UB:
            gl.glRotatef (rotate, 0, 1, -1);
            gl.glTranslatef(0, moveTo, -moveTo);
            break;

        case FL:
            gl.glRotatef (rotate, -1, 0, 1);
            gl.glTranslatef(-moveTo, 0, moveTo);
            break;
        case FR:
            gl.glRotatef (rotate, 1, 0, 1);
            gl.glTranslatef(moveTo, 0, moveTo);
            break;

        case BL:
            gl.glRotatef (rotate, -1, 0, -1);
            gl.glTranslatef(-moveTo, 0, -moveTo);
            break;
        case BR:
            gl.glRotatef (rotate, 1, 0, -1);
            gl.glTranslatef(moveTo, 0, -moveTo);
            break;

        case DF:
            gl.glRotatef (rotate, 0, -1, 1);
            gl.glTranslatef(0, -moveTo, moveTo);
            break;
        case DR:
            gl.glRotatef (rotate, 1, -1, 0);
            gl.glTranslatef(moveTo, -moveTo, 0);
            break;
        case DB:
            gl.glRotatef (rotate, 0, -1, -1);
            gl.glTranslatef(0, -moveTo, -moveTo);
            break;
        case DL:
            gl.glRotatef (rotate, -1, -1, 0);
            gl.glTranslatef(-moveTo, -moveTo, 0);
            break;
        }
    }

}
