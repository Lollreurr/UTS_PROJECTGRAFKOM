package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.List;

public class TubeBlockDragon extends OvalBlockDragon{

    float radiusZ;
    List<Integer> index;
    int ibo;

    public TubeBlockDragon(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color, Vector3f centerPoint,
                           float rX, float rY, float rZ) {
        super(shaderModuleDataList, vertices, color, centerPoint, rX, rY);
        this.radiusZ = rZ;
        createTube();
        setupVAOVBO();
    }

    public void createTube(){
        vertices.clear();
        float x,y1, y2,z = 0;
        for (double i = 0; i < 360; i += 360 / 360) {
            x = (float) (centerPoint.x + radiusX * Math.cos(i));
            y1 = (centerPoint.y + (radiusY / 2));
            y2 = (centerPoint.y - (radiusY / 2));
            z = (float) (centerPoint.z + radiusZ * Math.sin(i));
            vertices.add(new Vector3f(x,y1,z));
            vertices.add(new Vector3f(x,y2,z));
        }

        for (int i=0; i<360; i+= 360/360){
            vertices.add(vertices.get(i));
            vertices.add(vertices.get(i+360));
        }
    }

//    public void draw() {
//        drawSetup();
//        // Draw the vertices
//        //optional
//        glDrawArrays(GL_TRIANGLES, 0,
//                vertices.size());
//    }
}
