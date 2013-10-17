package my.test.Cubies.gl;

import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import android.view.MotionEvent;
import android.content.Context;
import android.opengl.GLSurfaceView;

import my.test.Cubies.model.Cube;
import my.test.Cubies.model.Mover;
import my.test.Cubies.model.MoverB;
import my.test.Cubies.model.MoverD;
import my.test.Cubies.model.MoverE;
import my.test.Cubies.model.MoverF;
import my.test.Cubies.model.MoverL;
import my.test.Cubies.model.MoverM;
import my.test.Cubies.model.MoverR;
import my.test.Cubies.model.MoverS;
import my.test.Cubies.model.MoverU;
import my.test.Cubies.gl.GLDrawable;
import my.test.Cubies.gl.GLCube;

import org.kociemba.twophase.*;

public class GLCubiesSurfaceView extends GLSurfaceView {

    public GLCubiesSurfaceView(Context context) {
        super(context);
        mRenderer = new GLCubiesRenderer();
        setRenderer(mRenderer);
        //setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);
    }

    @Override public boolean onTrackballEvent(MotionEvent e) {
        mRenderer.onTrackballEvent(e);
        requestRender();
        return true;
    }

    @Override public boolean onTouchEvent(MotionEvent e) {
        mRenderer.onTouchEvent(e);
        requestRender();
        return true;
    }

    /**
     * Render a cube.
     */
    private class GLCubiesRenderer implements GLSurfaceView.Renderer {
        public GLCubiesRenderer() {
            setCube (new Cube());
            mActionMode = ActionMode.NONE;
            mMover = null;
            mMoverType = 0;
        }

        public GLCubiesRenderer(Cube cube) {
            setCube (cube);
        }

        public void setCube(Cube cube) {
            mCube = new GLCube (cube);
        }

        public void onDrawFrame(GL10 gl) {
            /*
             * Usually, the first thing one might want to do is to clear
             * the screen. The most efficient way of doing this is to use
             * glClear().
             */

            gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);

            /*
             * Now we're ready to draw some 3D objects
             */

            gl.glMatrixMode(GL10.GL_MODELVIEW);
            gl.glLoadIdentity();
            gl.glTranslatef(0, 0, -23.0f);
            gl.glRotatef(mAngleX, 0, 1, 0);
            gl.glRotatef(mAngleY, 1, 0, 0);

            gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
            gl.glEnableClientState(GL10.GL_COLOR_ARRAY);

            if (mCube == null) {
                return;
            }
            if (mActionMode == ActionMode.CHECK_INSIDE) {
                if (mCube.pick(gl, mDownPosX, mDownPosY)) {
                    mActionMode = ActionMode.MOVE_CUBIES;
                } else {
                    mActionMode = ActionMode.ROTATE_CAMERA;
                }
            } 
            if (mActionMode == ActionMode.MOVE_CUBIES) {
                //mMover = mCube.
            }
/*
            if (mMover == null) {
            	switch (mMoverType) {
            	case 0:
            		mMover = new MoverB();
            		break;
            	case 1:
            		mMover = new MoverD();
            		break;
            	case 2:
            		mMover = new MoverE();
            		break;
            	case 3:
            		mMover = new MoverF();
            		break;
            	case 4:
            		mMover = new MoverL();
            		break;
            	case 5:
            		mMover = new MoverM();
            		break;
            	case 6:
            		mMover = new MoverR();
            		break;
            	case 7:
            		mMover = new MoverS();
            		break;
            	case 8:
            		mMover = new MoverU();
            		break;
            	}
            	mMoverType++;
            	if (mMoverType > 8) {
            		mMoverType = 0;
            	}
            }
*/
            if (mMover != null) {
                mCube.animate (gl, mMover, mTime);
                mTime += 0.05f;
                if (mTime > 1.0f) {
                    mTime = 0.0f;
                    mCube.getCube().move(mMover);
                    mMover = null;
                }
            } else {
                mCube.draw(gl);
            }
        }

        public void onSurfaceChanged(GL10 gl, int width, int height) {
            gl.glViewport(0, 0, width, height);

            /*
             * Set our projection matrix. This doesn't have to be done
             * each time we draw, but usually a new projection needs to
             * be set when the viewport is resized.
             */

            float ratio = (float) width / height;
            gl.glMatrixMode(GL10.GL_PROJECTION);
            gl.glLoadIdentity();
            gl.glFrustumf(-ratio, ratio, -1, 1, 3, 30);
        }

        public void onSurfaceCreated(GL10 gl, EGLConfig config) {
            /*
             * By default, OpenGL enables features that improve quality
             * but reduce performance. One might want to tweak that
             * especially on software renderer.
             */
            gl.glDisable(GL10.GL_DITHER);

            /*
             * Some one-time OpenGL initialization can be made here
             * probably based on features of this particular context
             */
             gl.glHint(GL10.GL_PERSPECTIVE_CORRECTION_HINT,
                     GL10.GL_FASTEST);


             gl.glClearColor(0, 0, 0, 1);
             gl.glEnable(GL10.GL_CULL_FACE);
             gl.glShadeModel(GL10.GL_SMOOTH);
             gl.glEnable(GL10.GL_DEPTH_TEST);
        }

        public boolean onTrackballEvent(MotionEvent e) {
            mAngleX += e.getX() * TRACKBALL_SCALE_FACTOR;
            mAngleY += e.getY() * TRACKBALL_SCALE_FACTOR;
            return true;
        }

        public boolean onTouchEvent(MotionEvent e) {
            float x = e.getX();
            float y = e.getY();
            switch (e.getAction()) {
            case MotionEvent.ACTION_MOVE:
                if (mActionMode == ActionMode.ROTATE_CAMERA) {
                    float dx = x - mPreviousX;
                    float dy = y - mPreviousY;
                    mAngleX += dx * TOUCH_SCALE_FACTOR;
                    mAngleY += dy * TOUCH_SCALE_FACTOR;
                }
                break;
            case MotionEvent.ACTION_DOWN:
                if (mActionMode == ActionMode.NONE) {
                    if (mMover == null) {
                        //mMover = new MoverU();
                        //String s = Search.solution (new String("FF"),20,5,false);
                    }
                    mActionMode = ActionMode.CHECK_INSIDE;
                    mDownPosX = x;
                    mDownPosY = y;
                }
                break;
            case MotionEvent.ACTION_UP:
                mActionMode = ActionMode.NONE;
                break;
            }
            mPreviousX = x;
            mPreviousY = y;
            return true;
        }

        private final float TOUCH_SCALE_FACTOR = 180.0f / 320;
        private final float TRACKBALL_SCALE_FACTOR = 36.0f;
        private float mPreviousX;
        private float mPreviousY;
        private float mDownPosX;
        private float mDownPosY;
        private float mAngleX;
        private float mAngleY;
        private float mTime;
        private ActionMode mActionMode;

        private GLCube mCube;
        private Mover mMover;
        private int mMoverType;

    }

    private enum ActionMode {
        NONE,
        CHECK_INSIDE,
        PICK_FACELET,
        ROTATE_CAMERA,
        MOVE_CUBIES,
   }


    private GLCubiesRenderer mRenderer;
}

