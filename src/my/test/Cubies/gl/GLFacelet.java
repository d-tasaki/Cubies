package my.test.Cubies.gl;

import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;

import my.test.Cubies.gl.GLDrawable;
import my.test.Cubies.model.Facelet;
import my.test.Cubies.model.FaceletLabel;

public class GLFacelet implements GLDrawable {
    public GLFacelet (Facelet facelet) {
        mFacelet = facelet;
        mVertexBuffer = null;
        mColorBuffer  = null;
        mIndexBuffer  = null;
    }

    public void draw (GL10 gl) {
        gl.glPushMatrix();
        translate (gl);
        if (mVertexBuffer == null) {
            createElement ();
        }
        drawFacelet (gl);
        gl.glPopMatrix();
    }

    public void drawFacelet (GL10 gl) {
        gl.glVertexPointer(3, GL10.GL_FIXED, 0, mVertexBuffer);
        gl.glColorPointer(4, GL10.GL_FIXED, 0, mColorBuffer);
        gl.glDrawElements(GL10.GL_TRIANGLES, mElementNum, GL10.GL_UNSIGNED_BYTE, mIndexBuffer);
    }

    protected void createElement () {
        int one = 0x10000;
        int vertices[] = {
            -one, -one, one,
             one, -one, one,
             one,  one, one,
            -one,  one, one,
        };

        int[] color = new int[4];

        switch (mFacelet.getLabel()) {
        case U:
            color[0] = one; color[1] = 0;   color[2] = 0;   color[3] = one;
            break;
        case F:
            color[0] = 0;   color[1] = one; color[2] = 0;   color[3] = one;
            break;
        case L:
            color[0] = 0;   color[1] = 0;   color[2] = one; color[3] = one;
            break;
        case B:
            color[0] = one; color[1] = one; color[2] = 0;   color[3] = one;
            break;
        case R:
            color[0] = one; color[1] = 0;   color[2] = one; color[3] = one;
            break;
        case D:
            color[0] = 0;   color[1] = one; color[2] = one; color[3] = one;
            break;
        }
            
        byte indices[] = {
            0, 2, 1,  0, 3, 2,
        };

        mElementNum = indices.length;

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
        
        ByteBuffer cbb = ByteBuffer.allocateDirect((vertices.length/3)*4*4);
        cbb.order(ByteOrder.nativeOrder());
        mColorBuffer = cbb.asIntBuffer();
        // for a front polygon
        mColorBuffer.put(color);
        mColorBuffer.put(color);
        mColorBuffer.put(color);
        mColorBuffer.put(color);
        mColorBuffer.position(0);
        
        mIndexBuffer = ByteBuffer.allocateDirect(indices.length);
        mIndexBuffer.put(indices);
        mIndexBuffer.position(0);
    }

    public void translate (GL10 gl) {
//         switch (mFacelet.getLabel()) {
//         case U:
//             gl.glRotatef(-90.0f, 1, 0, 0);
//             break;
//         case F:
//             break;
//         case L:
//             gl.glRotatef(-90.0f, 0, 1, 0);
//             break;
//         case B:
//             gl.glRotatef(180.0f, 1, 0, 0);
//             break;
//         case R:
//             gl.glRotatef(90.0f, 0, 1, 0);
//             break;
//         case D:
//             gl.glRotatef(90.0f, 1, 0, 0);
//             break;
//         }
        gl.glTranslatef(0, 0, 0.01f);
    }

    protected Facelet mFacelet;

    protected IntBuffer   mVertexBuffer;
    protected IntBuffer   mColorBuffer;
    protected ByteBuffer  mIndexBuffer;
    protected int         mElementNum;
}
