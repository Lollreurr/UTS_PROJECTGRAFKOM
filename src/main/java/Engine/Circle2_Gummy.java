package Engine;
import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.List;


public class Circle2_Gummy extends Object2d_Gummy {
    Vector3f centerPoint;
    float radiusX;
    float radiusY;


    public Circle2_Gummy(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color, Vector3f centerPoint, float radiusX, float radiusY) {
        super(shaderModuleDataList, vertices, color);
        this.centerPoint = centerPoint;
        this.radiusX = radiusX;
        this.radiusY = radiusY;
        setupVAOVBO();
    }

    public void createCircle(){
        vertices.clear();
        for (float i = 0; i < 360; i+=0.1){
            double rad = i * Math.PI / 180.0;
            vertices.add(new Vector3f(
                    (float)(centerPoint.x + Math.cos(rad) * radiusX),
                    (float)(centerPoint.y + Math.sin(rad) * radiusY),
                    0

            ));
            }
        }

//    public void draw(){
//        drawSetup();
//        glDrawArrays(GL_TRIANGLE_FAN,0,vertices.size());
//    }


}
