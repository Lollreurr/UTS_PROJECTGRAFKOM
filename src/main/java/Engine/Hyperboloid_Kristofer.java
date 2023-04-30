package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.ArrayList;
import java.util.List;

public class Hyperboloid_Kristofer extends Object_Kristofer {
    List<Float> centerPoint;
    Float radiusX;
    Float radiusY;
    float radiusZ;
    public Hyperboloid_Kristofer(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color, List<Float> centerPoint, Float radiusX, Float radiusY, Float radiusZ) {
        super(shaderModuleDataList, vertices, color);
        this.centerPoint = centerPoint;
        this.radiusX = radiusX;
        this.radiusY = radiusY;
        this.radiusZ = radiusZ;
        createHyperboloid1();
        setupVAOVBO();
    }
    public void createHyperboloid1(){
        ArrayList<Vector3f> temp = new ArrayList<>();
        for(double v = -Math.PI/2; v<= Math.PI/2; v+=Math.PI/100){
            for(double u = -Math.PI; u<= Math.PI; u+=Math.PI/100){
                float x = 0.5f * (float)(1/Math.cos(v) * Math.cos(u));
                float z = 0.5f * (float)(1/Math.cos(v) * Math.sin(u));
                float y = 0.5f * (float)(Math.tan(v));
                temp.add(new Vector3f(x,y,z));
            }
        }
        vertices = temp;
        setupVAOVBO();
//        ArrayList<Vector3f> temp = new ArrayList<>();
//        for(double v = -Math.PI/2; v<= Math.PI/2; v+=Math.PI/60){
//            for(double u = -Math.PI; u<= Math.PI; u+=Math.PI/60){
//                float x = -radiusX * (float)(v * Math.sin(u)/Math.cos(u));
//                float y = radiusY * (float)(v * 1/ Math.cos(u));
//                float z = -radiusZ * (float)(v*v);
//                temp.add(new Vector3f(x,y,z));
//            }
        }
//        ArrayList<Vector3f> temp = new ArrayList<>();
//        for(double v = -Math.PI/2; v<= Math.PI/2; v+=Math.PI/100){
//            for(double u = -Math.PI; u<= Math.PI; u+=Math.PI/100){
//                float x = 0.5f * (float)(1/Math.cos(v) * Math.cos(u));
//                float z = 0.5f * (float)(1/Math.cos(v) * Math.sin(u));
//                float y = 0.5f * (float)(Math.tan(v));
//                temp.add(new Vector3f(x,y,z));
//            }
//        }
//        vertices = temp;
//        setupVAOVBO();
//    }
    public void createEllipticParaboloid() {
        ArrayList<Vector3f> temp = new ArrayList<>();
        for (double v = -0.5; v <= 0.5; v += 0.05) {
            for (double u = -0.5; u <= 0.5; u += 0.05) {
                double x = u;
                double y = v;
                double z = u * u + v * v;
                temp.add(new Vector3f((float)x, (float)y, (float)z));
            }
        }
        vertices = temp;
        setupVAOVBO();
    }
    public void createHyperboloidParaboloid() {
        ArrayList<Vector3f> temp = new ArrayList<>();
        for (double v = -0.5; v <= 0.5; v += 0.05) {
            for (double u = -0.5; u <= 0.5; u += 0.05) {
                double x = u;
                double y = v;
                double z = u * u - v * v;
                temp.add(new Vector3f((float)x, (float)y, (float)z));
            }
        }
        vertices = temp;
        setupVAOVBO();
    }
}
