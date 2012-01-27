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

public class GLCornerCubie extends GLCubie {
    public GLCornerCubie (Cubie cubie) {
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
        float rotate = (float)(-orientation * 360.0 / 3);
        switch (mCubie.getLabel()) {
        case UFL:
            gl.glRotatef (rotate, -1, 1, 1);
            gl.glTranslatef(-moveTo, moveTo, moveTo);
            break;
        case ULB:
            gl.glRotatef (rotate, -1, 1, -1);
            gl.glTranslatef(-moveTo, moveTo, -moveTo);
            break;
        case UBR:
            gl.glRotatef (rotate, 1, 1, -1);
            gl.glTranslatef(moveTo, moveTo, -moveTo);
            break;
        case URF:
            gl.glRotatef (rotate, 1, 1, 1);
            gl.glTranslatef(moveTo, moveTo, moveTo);
            break;

        case DLF:
            gl.glRotatef (rotate, -1, -1, 1);
            gl.glTranslatef(-moveTo, -moveTo, moveTo);
            break;
        case DFR:
            gl.glRotatef (rotate, 1, -1, 1);
            gl.glTranslatef(moveTo, -moveTo, moveTo);
            break;
        case DRB:
            gl.glRotatef (rotate, 1, -1, -1);
            gl.glTranslatef(moveTo, -moveTo, -moveTo);
            break;
        case DBL:
            gl.glRotatef (rotate, -1, -1, -1);
            gl.glTranslatef(-moveTo, -moveTo, -moveTo);
            break;
        }
    }

}
