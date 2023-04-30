package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.List;

public class Rectangle_Kristofer extends Object_Kristofer {
    Float radiusX;
    Float radiusY;
    public Rectangle_Kristofer(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color, List<Float> centerPoint, Float radiusX, Float radiusY) {
        super(shaderModuleDataList, vertices, color);
        this.centerPoint = centerPoint;
        this.radiusX = radiusX;
        this.radiusY = radiusY;
        createRectangle();
        setupVAOVBO();
    }

    public double degToRad(float degree){
        return (degree * Math.PI / (float) 180);
    }
    public void createRectangle(){
        vertices.clear();
        int degree = 45;
        for(float i = 0;i<4;i++){
            double rad = degToRad(degree);
            Float x = (float) (centerPoint.get(0)+Math.cos(rad)*radiusX);
            Float y = (float) (centerPoint.get(1)+Math.sin(rad)*radiusY);
            Float z = 0.0f;
            vertices.add(new Vector3f(x,y,z));
            degree+=90;
        }
    }
}
