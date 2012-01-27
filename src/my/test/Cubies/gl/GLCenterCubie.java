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

public class GLCenterCubie extends GLCubie {
    public GLCenterCubie (Cubie cubie) {
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
        float rotate = (float)(-orientation * 360.0 / 4);
        switch (mCubie.getLabel()) {
        case U:
            gl.glRotatef (rotate, 0, 1, 0);
            gl.glTranslatef(0, moveTo, 0);
            break;
        case F:
            gl.glRotatef (rotate, 0, 0, 1);
            gl.glTranslatef(0, 0, moveTo);
            break;
        case L:
            gl.glRotatef (rotate, -1, 0, 0);
            gl.glTranslatef(-moveTo, 0, 0);
            break;
        case B:
            gl.glRotatef (rotate, 0, 0, -1);
            gl.glTranslatef(0, 0, -moveTo);
            break;
        case R:
            gl.glRotatef (rotate, 1, 0, 0);
            gl.glTranslatef(moveTo, 0, 0);
            break;
        case D:
            gl.glRotatef (rotate, 0, -1, 0);
            gl.glTranslatef(0, -moveTo, 0);
            break;
        }
    }

}
