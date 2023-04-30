package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.List;

public class OvalBlockDragon extends ObjectBlockDragon{
    //index buffer object || element buffer object

    float radiusX;
    float radiusY;
    Vector3f centerPoint;

    public OvalBlockDragon(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color, Vector3f centerPoint, float rX, float rY) {
        super(shaderModuleDataList, vertices, color);
        this.radiusX = rX;
        this.radiusY = rY;
        this.centerPoint = centerPoint;
        float x, y, z = 0;
        for (double i = 0; i < 360; i += 360 / 360) {
            x = (float) (centerPoint.x + rX * Math.cos(i));
            y = (float) (centerPoint.y + rY * Math.sin(i));
            this.vertices.add(new Vector3f(x, y, z));
        }
        setupVAOVBO();
    }

//    public void draw() {
//        drawSetup();
//        // Draw the vertices
//        //optional
//        glDrawArrays(GL_POLYGON, 0,
//                vertices.size());
//    }
}