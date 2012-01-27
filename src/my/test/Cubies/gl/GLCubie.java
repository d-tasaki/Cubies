package my.test.Cubies.gl;

import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;

import my.test.Cubies.gl.GLDrawable;
import my.test.Cubies.gl.GLFacelet;
import my.test.Cubies.model.Cubie;
import my.test.Cubies.model.Facelet;
import my.test.Cubies.model.FaceletLabel;

public abstract class GLCubie implements GLDrawable {
    public GLCubie (Cubie cubie) {
        mCubie = cubie;
        mVertexBuffer = null;
        mColorBuffer  = null;
        mIndexBuffer  = null;

        mFaceletNum = cubie.getFaceletNum();
        mFacelets = new GLFacelet[mFaceletNum];
        Facelet[] facelets = cubie.getFacelets();
        for (int i = 0; i < mFaceletNum; i++) {
            mFacelets[i] = new GLFacelet(facelets[i]);
        }
    }

    public void draw (GL10 gl) {
        gl.glPushMatrix();
        translate (gl);
        if (mVertexBuffer == null) {
            createElement ();
        }
        drawCubie (gl);

        FaceletLabel[] flabels = mCubie.getLabel().getFaceletLabels();
        for (int i = 0; i < flabels.length; i++) {
            gl.glPushMatrix ();
            switch (flabels[i]) {
            case U:
                gl.glRotatef(-90.0f, 1, 0, 0);
                break;
            case F:
                break;
            case L:
                gl.glRotatef(-90.0f, 0, 1, 0);
                break;
            case B:
                gl.glRotatef(180.0f, 1, 0, 0);
                break;
            case R:
                gl.glRotatef(90.0f, 0, 1, 0);
                break;
            case D:
                gl.glRotatef(90.0f, 1, 0, 0);
                break;
            }
            mFacelets[i].draw(gl);
            gl.glPopMatrix();
        }
        gl.glPopMatrix();
    }

    public void drawCubie (GL10 gl) {
        gl.glVertexPointer(3, GL10.GL_FIXED, 0, mVertexBuffer);
        gl.glColorPointer(4, GL10.GL_FIXED, 0, mColorBuffer);
        gl.glDrawElements(GL10.GL_TRIANGLES, mElementNum, GL10.GL_UNSIGNED_BYTE, mIndexBuffer);
    }

    protected void createElement () {
        int one = 0x10000;
        int vertices[] = {
                -one, -one, -one,
                 one, -one, -one,
                 one,  one, -one,
                -one,  one, -one,
                -one, -one,  one,
                 one, -one,  one,
                 one,  one,  one,
                -one,  one,  one,
        };

        int colors[] = {
                 one/5,  one/5,  one/5,  one,
                 one/5,  one/5,  one/5,  one,
                 one/5,  one/5,  one/5,  one,
                 one/5,  one/5,  one/5,  one,
                 one/5,  one/5,  one/5,  one,
                 one/5,  one/5,  one/5,  one,
                 one/5,  one/5,  one/5,  one,
                 one/5,  one/5,  one/5,  one,
                 one/5,  one/5,  one/5,  one,
        };

        byte indices[] = {
                0, 4, 5,    0, 5, 1,
                1, 5, 6,    1, 6, 2,
                2, 6, 7,    2, 7, 3,
                3, 7, 4,    3, 4, 0,
                4, 7, 6,    4, 6, 5,
                3, 0, 1,    3, 1, 2
        };

        // Buffers to be passed to gl*Pointer() functions
        // must be direct, i.e., they must be placed on the
        // native heap where the garbage collector cannot
        // move them.
        //
        // Buffers with multi-byte datatypes (e.g., short, int, float)
        // must have their byte order set to native order

        ByteBuffer vbb = ByteBuffer.allocateDirect(vertices.length*4);
        vbb.order(ByteOrder.nativeOrder());
        mVertexBuffer = vbb.asIntBuffer();
        mVertexBuffer.put(vertices);
        mVertexBuffer.position(0);

        ByteBuffer cbb = ByteBuffer.allocateDirect(colors.length*4);
        cbb.order(ByteOrder.nativeOrder());
        mColorBuffer = cbb.asIntBuffer();
        mColorBuffer.put(colors);
        mColorBuffer.position(0);

        mIndexBuffer = ByteBuffer.allocateDirect(indices.length);
        mIndexBuffer.put(indices);
        mIndexBuffer.position(0);

        mElementNum = indices.length;
    }

    public Cubie getCubie () {
        return mCubie;
    }

    protected abstract void translate (GL10 gl);

    protected Cubie       mCubie;
    protected GLFacelet[] mFacelets;
    protected int         mFaceletNum;

    protected IntBuffer   mVertexBuffer;
    protected IntBuffer   mColorBuffer;
    protected ByteBuffer  mIndexBuffer;
    protected int         mElementNum;

}

