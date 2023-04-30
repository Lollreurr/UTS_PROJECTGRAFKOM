package Engine;

import org.joml.Matrix4f;

public class Projection_Kristofer {

    public float getFOV() {
        return FOV;
    }

    public void setFOV(float FOV) {
        this.FOV = FOV;
        updateProjMatrix(width, height);
    }
//bisa diganti ganti (jarak pandang 60 derajat 1000f sampai 0.01f
    private float FOV = (float) Math.toRadians(60.0f);
    private static final float Z_FAR = 1000.f;
    private static final float Z_NEAR = 0.01f;
    private int width, height;

    private Matrix4f projMatrix;

    public Projection_Kristofer(int width, int height) {
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
