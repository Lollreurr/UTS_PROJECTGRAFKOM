package Engine;

import org.joml.Matrix4f;

public class Projection {

    public float getFOV() {
        return FOV;
    }

    public void setFOV(float FOV) {
        this.FOV = FOV;
        updateProjMatrix(width, height);
    }

    // boleh diganti" defaultnya 60 boleh diganti ke 90
    private float FOV = (float) Math.toRadians(60.0f);

    // jarak terjauh dari kita melihat (setelah 1000 tidak terlihat)
    private static final float Z_FAR = 1000.f;

    // jarak terdekat yang bisa dilihat (dibawah 0.01 tidak terlihat)
    private static final float Z_NEAR = 0.01f;

    private int width, height;

    private Matrix4f projMatrix;

    public Projection(int width, int height) {
        projMatrix = new Matrix4f();
        updateProjMatrix(width, height);
    }

    public Matrix4f getProjMatrix() {
        return projMatrix;
    }

    public void updateProjMatrix(int width, int height) {
        this.width = width;
        this.height = height;
        projMatrix.setPerspective(FOV, (float) width / height, Z_NEAR, Z_FAR);
    }
}
